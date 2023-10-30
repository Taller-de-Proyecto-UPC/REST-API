package com.tp.neuralscan.patient.service;



import com.tp.neuralscan.patient.model.ReportEntity;

import java.util.List;

public interface ReportService {

    List<ReportEntity> getAllReports();
    ReportEntity createReport(ReportEntity ReportEntity);
    ReportEntity updateReport(Long id, ReportEntity ReportEntity);
}
