package vn.techmaster.dataanalysis.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.dataanalysis.model.Person;
import vn.techmaster.dataanalysis.repository.PersonRepository;

@RestController
@RequestMapping("/api")
public class APIController {
  @Autowired private PersonRepository personRepo;


  @GetMapping("/people")
  public List<Person> getPeople() {
    return personRepo.getAll();
  }

  @GetMapping("/countnationality")
  public Map<String, Integer> countPeopleByNationality() {
    return personRepo.countPeopleByNationality();
  }

  @GetMapping("/countnationality2")
  public Map<String, Long> countPeopleByNationality2() {
    return personRepo.countPeopleByNationality2();
  }

  @GetMapping("/countnationality3")
  public List<Map.Entry<String, Long>> countPeopleByNationality3() {
    return personRepo.countPeopleByNationality3();
  }
  @GetMapping("/countnationality4")
  public List<Map.Entry<String, Long>> countPeopleByNationality4() {
    return personRepo.countPeopleByNationality4();
  }

  @GetMapping("/countnationality5")
  public Map<String, Long> countPeopleByNationality5() {
    return personRepo.countPeopleByNationality5();
  }
}
