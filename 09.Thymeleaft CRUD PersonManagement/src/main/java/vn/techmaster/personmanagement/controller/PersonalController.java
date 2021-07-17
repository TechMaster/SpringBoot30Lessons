package vn.techmaster.personmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.techmaster.personmanagement.model.Person;
import vn.techmaster.personmanagement.repository.PersonRepository;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonalController {
    private PersonRepository personRepo;

    public PersonalController(){
        personRepo = new PersonRepository();
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/listAll")
    public String listAll(Model model) {
        List<Person> people = personRepo.getAll();

        model.addAttribute("people", people);
        return "listAll";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "personForm";
    }

    @PostMapping("/post")
    public String postInfo(@ModelAttribute("person") Person person, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            if(person.getId()>0){
                personRepo.edit(person);
            }else{
                personRepo.create(person);
            }
            model.addAttribute("people", personRepo.getAll());
            return "redirect:/listAll";
        }
        return "personForm";
    }

    @GetMapping("/person/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        Optional<Person> person = personRepo.get(id);
        if(person.isPresent()){
            model.addAttribute("person",person);
        }
        return "personForm";
    }

    @GetMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable("id") int id, Model model){
        personRepo.deleteById(id);
        model.addAttribute("people",personRepo.getAll());
        return "redirect:/listAll";
    }

    @GetMapping("/search")
    public String searchPerson(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        if(name==""){
            model.addAttribute("people",personRepo.getAll());
            return "redirect:/listAll";
        }
        else{
            Person person = personRepo.search(name);
            model.addAttribute("people",person);
            return "listAll";
        }
    }
}
