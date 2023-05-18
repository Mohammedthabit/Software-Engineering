package de.tum.in.ase.eist.rest;

import de.tum.in.ase.eist.model.Person;
import de.tum.in.ase.eist.service.PersonService;
import de.tum.in.ase.eist.util.PersonSortingOptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class PersonResource {

    private final PersonService personService;

    public PersonResource(PersonService personService) {
        this.personService = personService;
    }

    // TODO Part 1: Implement the specified endpoints here
    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        if (person.getId() == null) {
            Person savePerson = personService.savePerson(person);
            return new ResponseEntity<>(savePerson, HttpStatus.OK);
        }
        return new ResponseEntity<>(person, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/persons/{personId}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable("personId") UUID personId) {
        if (!person.getId().equals(personId)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(personService.savePerson(person));
    }

    @DeleteMapping("/persons/{personId}")
    public ResponseEntity<Person> deletePerson(@PathVariable("personId") UUID personId) {
        personService.deletePerson(personId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons(@RequestParam(value = "sortField", defaultValue = "ID") PersonSortingOptions.SortField sortField,
                                      @RequestParam(value = "sortingOrder", defaultValue = "ASCENDING") PersonSortingOptions.SortingOrder sortingOrder) {
        return personService.getAllPersons(new PersonSortingOptions(sortingOrder, sortField));
    }



}
