package com.tp.neuralscan.patient.service.impl;


import com.tp.neuralscan.doctor.model.DoctorEntity;
import com.tp.neuralscan.doctor.repository.DoctorEntityRepository;
import com.tp.neuralscan.patient.model.ImageEntity;
import com.tp.neuralscan.patient.model.PatientEntity;
import com.tp.neuralscan.patient.model.ReportEntity;
import com.tp.neuralscan.patient.repository.ImageEntityRepository;
import com.tp.neuralscan.patient.repository.PatientEntityRepository;
import com.tp.neuralscan.patient.repository.ReportEntityRepository;
import com.tp.neuralscan.patient.service.ReportService;
import com.tp.neuralscan.person.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportEntityRepository reportEntityRepository;

    @Autowired
    private ImageEntityRepository imageEntityRepository;

    @Autowired
    private PatientEntityRepository patientEntityRepository;

    @Autowired
    private DoctorEntityRepository doctorEntityRepository;

    @Override
    public List<ReportEntity> getAllReports() {
        return reportEntityRepository.findAll();
    }

    @Override
    public ReportEntity createReport(ReportEntity reportEntity, Long doctorId,Long patientId, ImageEntity imageEntity) {
        ImageEntity image = imageEntityRepository.save(imageEntity);
        reportEntity.setDoctorEntity(doctorEntityRepository.findById(doctorId).orElse(null));
        reportEntity.setImageEntity(image);
        reportEntity.setPatientEntity(patientEntityRepository.findById(patientId).orElse(null));
        return reportEntityRepository.save(reportEntity);
    }

    @Override
    public ReportEntity updateReport(Long id, ReportEntity reportEntity) {
        ReportEntity report = reportEntityRepository.findById(id).orElseThrow();
        ImageEntity image = imageEntityRepository.findById(report.getImageEntity().getId()).orElse(null);
        DoctorEntity doctor = doctorEntityRepository.findById(report.getDoctorEntity().getId()).orElse(null);
        PatientEntity patient = patientEntityRepository.findById(report.getPatientEntity().getId()).orElse(null);

        report.setSummary(reportEntity.getSummary());
        report.setDescription(reportEntity.getDescription());
        report.setComment(reportEntity.getComment());
        report.setImageEntity(image);
        report.setDoctorEntity(doctor);
        report.setPatientEntity(patient);

        return reportEntityRepository.save(report);
    }

    @Override
    public ReportEntity getReportById(Long id) {
        return reportEntityRepository.findById(id).orElse(null);
    }

    @Override
    public List<ReportEntity> getAllReportsByPatientId(Long patientId) {
        PatientEntity patient = patientEntityRepository.findById(patientId).orElse(null);

        return reportEntityRepository.findByPatientEntity(patient);
    }

    @Override
    public List<ReportEntity> getAllReportsByDoctorId(Long doctorId) {
        DoctorEntity doctor = doctorEntityRepository.findById(doctorId).orElse(null);
        return reportEntityRepository.findByDoctorEntity(doctor);
    }

}
