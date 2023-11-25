package com.tp.neuralscan.doctor.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("doctorMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public DoctorMapper doctorMapper() {
        return new DoctorMapper();
    }


}
