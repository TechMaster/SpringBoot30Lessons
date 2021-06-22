package vn.techmaster.parsejson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.parsejson.model.Person;
import vn.techmaster.parsejson.repository.PersonRepository;

@RestController
@RequestMapping("/api/")
public class PersonController {
  @Autowired private PersonRepository personRepo;
  @GetMapping("people")
  public ResponseEntity<List<Person>> getAllPeople() {
    return ResponseEntity.ok().body(personRepo.getAllPeople());
  }
}
