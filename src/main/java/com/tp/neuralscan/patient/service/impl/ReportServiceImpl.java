package com.tp.neuralscan.patient.service.impl;


import com.tp.neuralscan.patient.model.ReportEntity;
import com.tp.neuralscan.patient.repository.ReportEntityRepository;
import com.tp.neuralscan.patient.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportEntityRepository reportEntityRepository;

    @Override
    public List<ReportEntity> getAllReports() {
        return reportEntityRepository.findAll();
    }

    @Override
    public ReportEntity createReport(ReportEntity ReportEntity) {
        return reportEntityRepository.save(ReportEntity);
    }

    @Override
    public ReportEntity updateReport(Long id, ReportEntity reportEntity) {
        ReportEntity report = reportEntityRepository.findById(id).orElseThrow();
        report.setSummary(reportEntity.getSummary());
        report.setDescription(reportEntity.getDescription());
        report.setComment(reportEntity.getComment());
        return reportEntityRepository.save(reportEntity);
    }

}
