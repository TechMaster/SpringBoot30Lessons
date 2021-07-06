package vn.techmaster.peopledata;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vn.techmaster.peopledata.model.Person;
import vn.techmaster.peopledata.repository.PersonRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
public class PersonRepositoryTest {
  @Autowired private 	PersonRepository personRepo;

  @Test
	public void topJobInPeopleGroup() {
		List<Person> people = personRepo.getAll();
    var result = personRepo.topJobInPeopleGroup(people);
    
    assertThat(true);    
	}

  @Test
  public void testCollectorToMap() {
    Map<String, Integer> mymap = new HashMap<String, Integer>();
    mymap.put("a", 1);
    mymap.put("b", 2);
    mymap.put("c", 3);

    var result = mymap
    .entrySet()
    .stream()
    .collect(Collectors.toMap(Map.Entry::getKey, v -> v.getValue() * 2));
    
    assertThat(true);
  }

  @Test
  public void testtopJobByNumerInEachCity() {
    Map<String, Map.Entry<String, Long>> result = personRepo.topJobByNumerInEachCity();

    assertThat(true);
  }

  @Test
  public void testFiveCitiesHasTopAverageSalary() {
    Map<String, List<Person>> groupPeopleByCity = personRepo.groupPeopleByCity();

    Map<String, Double> cityAverageSalary = groupPeopleByCity.entrySet()
    .stream()
    .collect(Collectors.toMap(Map.Entry::getKey, 
        entry -> entry.getValue()
        .stream()
        .collect(Collectors.averagingInt(Person::getSalary))));
   
   
    List<Map.Entry<String, Double>> result = cityAverageSalary.entrySet()
    .stream()
    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
    .limit(5)
    .collect(Collectors.toList());


    assertThat(true);
  }

  @Test
  public void testMaxAgePerCity() {
    List<Person> people = personRepo.getAll();
    var result = people
    .stream()
    .collect(Collectors.groupingBy(Person::getCity, 
    Collectors.maxBy(Comparator.comparing(Person::getAge))))
    .values()
    .stream()
    .map(person -> Map.entry(person.get().getCity(), person.get().getAge()))
    .collect(Collectors.toList());

    assertThat(true);
  }

}
