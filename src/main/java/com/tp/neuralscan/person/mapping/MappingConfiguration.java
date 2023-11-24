package com.tp.neuralscan.person.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("personMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public PersonMapper personMapper() {
        return new PersonMapper();
    }
    @Bean
    public UserMapper userMapper () {
        return new UserMapper();
    }

}
