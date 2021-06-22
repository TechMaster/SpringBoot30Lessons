package vn.techmaster.parsejson.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import vn.techmaster.parsejson.model.Person;

@Repository
public class PersonRepository {
  private ArrayList<Person> people = new ArrayList<>();
  /* Nhiệm vụ của constructor này là đọc dữ liệu từ file JSON vào một ArrayList<Person>
  */
  public PersonRepository() {
    try {
      File file = ResourceUtils.getFile("classpath:static/personsmall.json");
      ObjectMapper mapper = new ObjectMapper();
      people.addAll(mapper.readValue(file, new TypeReference<List<Person>>(){}));
      people.forEach(System.out::println);
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }    
  }

  public List<Person> getAllPeople() {
    return people;
  }
}
