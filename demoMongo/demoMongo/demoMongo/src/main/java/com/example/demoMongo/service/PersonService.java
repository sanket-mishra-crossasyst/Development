package com.example.demoMongo.service;

import com.example.demoMongo.document.PersonDocument;
import com.example.demoMongo.model.Person;
import com.example.demoMongo.model.ResponsePerson;
import com.example.demoMongo.repsitory.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Log4j2
@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public ResponsePerson createPerson(Person person) {
        ResponsePerson responsePerson=new ResponsePerson();
        PersonDocument personDocument = new PersonDocument();
        personDocument.setId(person.getId());
        personDocument.setFirstName(person.getFirstName());
        personDocument.setLastName(person.getLastName());
        personRepository.save(personDocument);
        responsePerson.setId(personDocument.getId());
        log.info("person inserted and id is " +responsePerson.getId());
        return responsePerson;
    }

    public Person getPersonById(Long id) {
       Optional<PersonDocument> optionalPersonDocument= personRepository.findById(id);
       Person person = new Person();
       if (optionalPersonDocument.isPresent())
       {
            person.setId(optionalPersonDocument.get().getId());
            person.setFirstName(optionalPersonDocument.get().getFirstName());
            person.setLastName(optionalPersonDocument.get().getLastName());
       }else {
            log.info(id +"not found");
       }
       return person;
    }

    public void deletePerson(Long id) {
        Optional<PersonDocument> optionalPersonDocument=personRepository.findById(id);
        if(optionalPersonDocument.isPresent())
        {
            personRepository.deleteById(id);
            log.info(id +"Id Deleted ");
        }else {
            log.info(id +"Id not found");
        }
    }
}

