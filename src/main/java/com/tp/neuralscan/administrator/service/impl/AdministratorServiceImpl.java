package com.tp.neuralscan.administrator.service.impl;


import com.tp.neuralscan.administrator.model.AdministratorEntity;
import com.tp.neuralscan.administrator.repository.AdministratorEntityRepository;
import com.tp.neuralscan.administrator.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorEntityRepository administratorEntityRepository;

    @Override
    public List<AdministratorEntity> getAllAdministrators() {
        return administratorEntityRepository.findAll();
    }

    @Override
    public AdministratorEntity createAdministrator(AdministratorEntity administratorEntity) {
        return administratorEntityRepository.save(administratorEntity);
    }

    @Override
    public AdministratorEntity updateAdministrator(Long id, AdministratorEntity administratorEntity) {
        AdministratorEntity administrator = administratorEntityRepository.findById(id).orElseThrow();
        administrator.setName(administratorEntity.getName());
        administrator.setLastName(administratorEntity.getLastName());
        administrator.setEmail(administratorEntity.getEmail());
        return administratorEntityRepository.save(administratorEntity);
    }

    @Override
    public AdministratorEntity loginAdministrator(String email, String password) {
        AdministratorEntity administratorEntity = administratorEntityRepository.findByEmailAndPassword(email, password);
        if (administratorEntity == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrator not found");
        return administratorEntity;
    }
}
