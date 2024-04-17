package com.tp.neuralscan;

import com.tp.neuralscan.person.dto.PersonResource;
import com.tp.neuralscan.person.model.PersonEntity;
import com.tp.neuralscan.person.service.PersonService;
import com.tp.neuralscan.person.service.impl.PersonServiceImpl;
import org.hibernate.event.spi.PostCollectionRecreateEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NeuralScanApplicationTests {

    @Autowired
    private PersonService personService;

    @Test
    void contextLoads() {
        List<PersonEntity> allPerson =  personService.getAllPersons();
        System.out.println(allPerson);
    }

}
