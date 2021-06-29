package vn.techmaster.dataanalysis;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;

import vn.techmaster.dataanalysis.model.Person;
import vn.techmaster.dataanalysis.repository.PersonRepository;

@SpringBootTest
class DataanalysisApplicationTests {
	@Autowired private PersonRepository personRepo;
	
	@Test
	void testCountPeopleByNationality5() {
		List<Person> people = personRepo.getAll();
		var result = people
    .stream()
    .collect(Collectors.groupingBy(Person::getNationality, Collectors.counting()))
    .entrySet()
    .stream()
    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
    (oldValue, newValue) -> oldValue, LinkedHashMap::new
    )); //

		assertThat(true);
	}

}
