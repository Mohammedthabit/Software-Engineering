package de.tum.in.ase.eist.service;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.util.PersonSortingOptions;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonService {
  	// do not change this
    private final List<Person> persons;

    public PersonService() {
        this.persons = new ArrayList<>();
    }

    public Person savePerson(Person person) {
        var optionalPerson = persons.stream().filter(existingPerson -> existingPerson.getId().equals(person.getId())).findFirst();
        if (optionalPerson.isEmpty()) {
            person.setId(UUID.randomUUID());
            persons.add(person);
            return person;
        } else {
            var existingPerson = optionalPerson.get();
            existingPerson.setFirstName(person.getFirstName());
            existingPerson.setLastName(person.getLastName());
            existingPerson.setBirthday(person.getBirthday());
            return existingPerson;
        }
    }

    public void deletePerson(UUID personId) {
        this.persons.removeIf(person -> person.getId().equals(personId));
    }

    public List<Person> getAllPersons(PersonSortingOptions sortingOptions) {

        List<Person> sortedList = new ArrayList<>(persons);
        switch (sortingOptions.getSortField()) {
            case ID:
                sortedList.sort(Comparator.comparing(Person::getId));
                break;
            case FIRST_NAME:
                sortedList.sort(Comparator.comparing(Person::getFirstName));
                break;
            case LAST_NAME:
                sortedList.sort(Comparator.comparing(Person::getLastName));
                break;
            case BIRTHDAY:
                sortedList.sort(Comparator.comparing(Person::getBirthday));
                break;
            default:
                sortedList.sort(Comparator.comparing(Person::getId));
                break;
        }

        if (sortingOptions.getSortingOrder() == PersonSortingOptions.SortingOrder.DESCENDING){
            Collections.reverse(sortedList);
        }

        return sortedList;
    }

}
