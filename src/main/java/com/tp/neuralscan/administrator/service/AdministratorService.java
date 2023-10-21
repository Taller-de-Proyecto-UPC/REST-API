package com.tp.neuralscan.administrator.service;



import com.tp.neuralscan.administrator.model.AdministratorEntity;

import java.util.List;

public interface AdministratorService {

    List<AdministratorEntity> getAllAdministrators();
    AdministratorEntity createAdministrator(AdministratorEntity administrator);
    AdministratorEntity updateAdministrator(Long id, AdministratorEntity administrator);
    AdministratorEntity loginAdministrator(String email, String password);

}
