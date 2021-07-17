package vn.techmaster.personmanagement.repository;

import vn.techmaster.personmanagement.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonRepository {
    private List<Person> people = new ArrayList<>();

    public PersonRepository(){
        List<Person> list = List.of(
                new Person(1,"Trinh Minh Cuong","Developer",true,"1975-11-27"),
                new Person(2,"Mary Jane","Banker",false,"1980-05-24"),
                new Person(3,"Tom Sawyer","Taxi Driver",true,"1990-08-09")
        );
        for(Person person:list){
            people.add(person);
        }

    }

    public List<Person> getAll(){
        return this.people;
    }

    public Person create(Person person){
        int id;
        if (people.isEmpty()) {
            id = 1;
        } else {
            Person lastPerson = people.get(people.size() - 1);
            id = lastPerson.getId() + 1;
        }
        person.setId(id);
        people.add(person);
        return person;
    }

    public Person edit(Person person){
        get(person.getId()).ifPresent(existPerson->{
            existPerson.setName(person.getName());
            existPerson.setJob(person.getJob());
            existPerson.setGender(person.isGender());
            existPerson.setBirthDay(person.getBirthDay());
        });
        return person;
    }

    public void delete(Person person){
        deleteById(person.getId());
    }

    public Person search(String name){
        return people.stream().filter(person->person.getName().contains(name)).findAny().orElse(null);
    }


    public Optional<Person> get(int id) {
        return people.stream().filter(p -> p.getId() == id).findFirst();
    }

    public void deleteById(int id) {
        get(id).ifPresent(existed -> people.remove(existed));
    }

}
