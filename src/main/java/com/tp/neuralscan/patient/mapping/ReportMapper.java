package com.tp.neuralscan.patient.mapping;


import com.tp.neuralscan.patient.dto.CreateReportResource;
import com.tp.neuralscan.patient.dto.ReportResource;
import com.tp.neuralscan.patient.dto.UpdateReportResource;
import com.tp.neuralscan.patient.model.ReportEntity;
import com.tp.neuralscan.util.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ReportMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper modelMapper;

    public ReportResource toResource(ReportEntity report) {
        return modelMapper.map(report, ReportResource.class);
    }

    public List<ReportResource> toResource(List<ReportEntity> reports) {
        return modelMapper.mapList(reports, ReportResource.class);
    }

    public ReportEntity toEntity(CreateReportResource report) {
        return modelMapper.map(report, ReportEntity.class);
    }

    public ReportEntity toEntity(UpdateReportResource report) {
        return modelMapper.map(report, ReportEntity.class);
    }
}
