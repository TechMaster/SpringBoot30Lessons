package vn.techmaster.authen.controller;

import org.apache.commons.lang3.RandomStringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.techmaster.authen.model.Event;
import vn.techmaster.authen.model.LoginRequest;
import vn.techmaster.authen.model.Role;
import vn.techmaster.authen.model.User;
import vn.techmaster.authen.repository.EventRepository;
import vn.techmaster.authen.service.IAuthenService;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class AppController {
    @Autowired
    private IAuthenService authenService;
    @Autowired
    private EntityManager tem;

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private JavaMailSender javaMailSender;

    //Login Page
    @GetMapping("/")
    public String Login(Model model) {
        authenService.setDefault();
        model.addAttribute("loginRequest", new LoginRequest());
        return "index";
    }

    //Account information
    @GetMapping("/account/{id}")
    public String getById(@PathVariable("id") Integer id, Model model) {
        User user = authenService.findByUserId(id).get();
        if (user != null)
            model.addAttribute("user", user);
        return "account";
    }


    //Login success
    @PostMapping("/info")
    public String checkLogIn(@ModelAttribute LoginRequest request, BindingResult result, Model model) {
        if (!result.hasFieldErrors()) {
            String email = request.getEmail();
            User user = authenService.login(email);
            if (user != null) {
                if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
                    Event logIn = new Event();
                    logIn.setName("logIn");
                    user.addEvent(logIn);
                    eventRepo.save(logIn);
                    model.addAttribute("user", user);
                    boolean isAdmin = authenService.isAdmin(user.getId());
                    model.addAttribute("admin", isAdmin);
                    List<Event> sortedEvent = user.getEvents();
                    Collections.sort(sortedEvent, Comparator.comparing(e -> e.getCreateDate()));
                    Collections.reverse(sortedEvent);
                    SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YYYY --HH:mm:ss");
                    List<String> time = new ArrayList<>();
                    for (var event : sortedEvent) {
                        time.add(event.getName() + ": " + sdf.format(event.getCreateDate()));
                    }
                    model.addAttribute("time", time);
                    return "account";
                } else
                    return "index";
            } else
                return "index";

        } else
            return "index";
    }

    //Create new account page
    @GetMapping("/account")
    public String showAccountForm(Model model) {
        model.addAttribute("account", new User());

        return "account_form";
    }


    //Save a new account
    @PostMapping("/account/save")
    public String saveAccount(@ModelAttribute("user") User user, BindingResult result, HttpServletRequest request) {
        if (!result.hasFieldErrors()) {
            String email = request.getParameterValues("email")[0];
            String password = request.getParameterValues("password")[0];
            if (authenService.login(email) == null) {
                user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(12)));
                Event newAccount = new Event();
                newAccount.setName("save");
                user.addEvent(newAccount);
//                eventRepo.save(newAccount);
                authenService.createAccount(user);
            }

        }
        return "redirect:/";
    }


    //Edit form to update name and email
    @GetMapping("/account/editName/{id}")
    public String showEditNameEmail(@PathVariable("id") Integer id, Model model) {
        User account = authenService.findByUserId(id).get();
        model.addAttribute("account", account);
        return "name_form";
    }


    //Update name and email for account
    @PostMapping("/account/updateName")
    public String updateNameEmail(User user, BindingResult result) {
        if (!result.hasFieldErrors()) {
            Event update = new Event();
            update.setName("update");
            user.addEvent(update);
            eventRepo.save(update);
            authenService.updateAccount(user);
        }
        return "redirect:/";
    }

    //Edit form for account password
    @GetMapping("/account/editPassword/{id}")
    public String showEditPassword(@PathVariable("id") Integer id, Model model) {
        User account = authenService.findByUserId(id).get();
        model.addAttribute("account", account);
        return "password_form";
    }

    //Update account password
    @PostMapping("/account/updatePassword")
    public String updatePassword(User user, BindingResult result, HttpServletRequest request) {
        String newPass = request.getParameterValues("password")[0];
        if (!result.hasFieldErrors()) {
            Event update = new Event();
            update.setName("updatePassword");
            user.setPassword(BCrypt.hashpw(newPass, BCrypt.gensalt(12)));
            user.addEvent(update);
            eventRepo.save(update);
            authenService.updatePassword(user);
        }
        return "redirect:/";
    }

    //Retrieve account password from
    @GetMapping("/password")
    public String retrievePass() {

        return "passretrieve";
    }

    //Save new account password
    @PostMapping("/account/newpass")
    public String retrievePassword(HttpServletRequest request) {


        String email = request.getParameterValues("email")[0];
        User user = authenService.login(email);
        Event update = new Event();
        update.setName("retrievePassword");
        if (user != null) {

            String newpass = RandomStringUtils.randomAlphabetic(10);
            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo("quangspringboot@gmail.com");
            msg.setSubject("Testing Password");
            msg.setText(user.getFullname() + "have new pass: " + newpass);
            javaMailSender.send(msg);
            user.setPassword(BCrypt.hashpw(newpass, BCrypt.gensalt(12)));
            user.addEvent(update);
            eventRepo.save(update);
            authenService.updatePassword(user);
        }

        return "redirect:/";
    }

    //Find user email
    @GetMapping("/findUser")
    public String findUserEmail() {
        return "findEmail";
    }


    //Update role formm
    @PostMapping("/roles")
    public String userEmail(HttpServletRequest request, Model model) {
        String email = request.getParameterValues("email")[0];
        User user = authenService.login(email);
        if(user==null)
            return "findEmail";
        model.addAttribute("user", user);

        return "roles";
    }

    @GetMapping("/roles/edit/{id}")
    public String showEditRoleForm(@PathVariable("id") Integer id, Model model) {
        User user = authenService.findByUserId(id).get();
        model.addAttribute("user", user);
        List<Role> roles = (List<Role>) authenService.listRole();
        model.addAttribute("allRoles", roles);

        return "role_form";

    }


    @PostMapping("/updateRole")
    public String updateRole(User user) {
        authenService.updateRole(user);
        return "redirect:/";
    }


}
