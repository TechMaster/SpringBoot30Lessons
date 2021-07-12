package vn.techmaster.demothymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import vn.techmaster.demothymeleaf.model.TravelType;
import vn.techmaster.demothymeleaf.repository.InMemoryRepository;
import vn.techmaster.demothymeleaf.request.TravelRequest;

@Controller
public class TravelController {
  @Autowired private InMemoryRepository repo;
  
  @GetMapping("/travel")
  public String showTravelForm(Model model) {
    model.addAttribute("countries", repo.getCountries());
    model.addAttribute("travelRequest", new TravelRequest());
    model.addAttribute("travelTypes", TravelType.values());
    return "travel";
  }

  @PostMapping("/travel")
  public String handleTravelPost(@ModelAttribute TravelRequest request, BindingResult bindingResult, Model model) {
    if (! bindingResult.hasErrors()) {
      System.out.println(request);
    }

    model.addAttribute("countries", repo.getCountries());
    model.addAttribute("travelTypes", TravelType.values());
    model.addAttribute("travelRequest", request);
    return "travel";
  }
}
