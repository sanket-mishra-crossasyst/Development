package com.example.demoMongo.controller;

import com.example.demoMongo.document.PersonDocument;
import com.example.demoMongo.model.Person;
import com.example.demoMongo.model.ResponsePerson;
import com.example.demoMongo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
@Autowired
    private PersonService personService;

@PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePerson> createPerson (@RequestBody Person person){
    ResponsePerson responsePerson = personService.createPerson(person);
    return new ResponseEntity<>(responsePerson, HttpStatus.OK);
}
@GetMapping(path = "/persons/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
    Person person=personService.getPersonById(id);
    return new ResponseEntity<>(person,HttpStatus.OK);
}
//@PutMapping(path = "/persons/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Void> updatePerson(@RequestBody Person person,@PathVariable Lo)

    @DeleteMapping(path = "/persons/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deletePersson(@PathVariable Long id){
    personService.deletePerson(id);
    return ResponseEntity.ok().build();
    }
}
