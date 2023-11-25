package com.tp.neuralscan.patient.service;



import com.tp.neuralscan.patient.model.ImageEntity;
import com.tp.neuralscan.patient.model.ReportEntity;

import java.awt.*;
import java.util.List;

public interface ReportService {

    List<ReportEntity> getAllReports();
    ReportEntity createReport(ReportEntity ReportEntity, Long doctorId, Long patientId, ImageEntity imageEntity);
    ReportEntity updateReport(Long id, ReportEntity ReportEntity);

    ReportEntity getReportById(Long id);


    List<ReportEntity> getAllReportsByPatientId(Long patientId);

    List<ReportEntity> getAllReportsByDoctorId(Long doctorId);
}
