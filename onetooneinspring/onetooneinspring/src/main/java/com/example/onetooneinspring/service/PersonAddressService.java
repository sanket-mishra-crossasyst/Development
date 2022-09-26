package com.example.onetooneinspring.service;

import com.example.onetooneinspring.entity.AddressEntity;
import com.example.onetooneinspring.entity.PersonEntity;
import com.example.onetooneinspring.mapper.AddressMapper;
import com.example.onetooneinspring.mapper.PersonMapper;
import com.example.onetooneinspring.model.Address;
import com.example.onetooneinspring.model.Person;
import com.example.onetooneinspring.model.PersonResponse;
import com.example.onetooneinspring.repository.AddressRepository;
import com.example.onetooneinspring.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class PersonAddressService {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private AddressMapper addressMapper;

    public PersonResponse createPerson(Person person) {
        Addre
        ssEntity addressEntity = new AddressEntity();
        addressEntity = addressMapper.addressToAddressEntity(person.getAddress());

        PersonEntity personEntity;
        personEntity = personMapper.personToEntity(person);
        personEntity.setAddressEntity(addressEntity);
        personRepository.save(personEntity);

        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(personEntity.getId());
        return personResponse;
    }

    public Person getPerson(Long id) {
        Optional<PersonEntity> optionalPersonEntity = personRepository.findById(id);
        Person person = new Person();
        Address address = new Address();
        if (optionalPersonEntity.isPresent()) {
            AddressEntity addressEntity = optionalPersonEntity.get().getAddressEntity();
            PersonEntity personEntity = optionalPersonEntity.get();
            person = personMapper.entityToPerson(personEntity);
            address = addressMapper.addressEntityToAddress(addressEntity);
            person.setAddress(address);
        }
        return person;
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }


    public void updatePerson(Long id, Person person) {
        Optional<PersonEntity> personEntityOptional = personRepository.findById(id);
        if (personEntityOptional.isPresent()) {
            PersonEntity personEntity = personEntityOptional.get();
            AddressEntity addressEntity = personEntity.getAddressEntity();
            personEntity.setFirstName(person.getFirstName());
            personEntity.setLastName(person.getLastName());

            addressEntity.setAddressOne(person.getAddress().getAddressOne());
            addressEntity.setAddressTwo(person.getAddress().getAddressTwo());
            addressEntity.setCity(person.getAddress().getCity());
            addressEntity.setState(person.getAddress().getState());
            addressEntity.setZipCode(person.getAddress().getZipCode());

            personEntity.setAddressEntity(addressEntity);
            personRepository.save(personEntityOptional.get());
        }
    }
}
