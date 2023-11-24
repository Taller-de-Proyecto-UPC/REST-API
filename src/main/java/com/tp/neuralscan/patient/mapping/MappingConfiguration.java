package com.tp.neuralscan.patient.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("patientMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public PatientMapper patientMapper() {
        return new PatientMapper();
    }
    @Bean
    public ReportMapper reportMapper () {
        return new ReportMapper();
    }
    @Bean
    public ImageMapper imageMapper () {
        return new ImageMapper();
    }

}
