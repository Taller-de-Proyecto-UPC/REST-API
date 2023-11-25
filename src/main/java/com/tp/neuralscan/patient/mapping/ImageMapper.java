package com.tp.neuralscan.patient.mapping;

import com.tp.neuralscan.patient.dto.CreateImageResource;
import com.tp.neuralscan.patient.dto.ImageResource;
import com.tp.neuralscan.patient.dto.UpdateImageResource;
import com.tp.neuralscan.patient.model.ImageEntity;
import com.tp.neuralscan.util.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ImageMapper implements Serializable {

    @Autowired
    private EnhancedModelMapper modelMapper;

    public ImageResource toResource(ImageEntity image) {
        return modelMapper.map(image, ImageResource.class);
    }

    public List<ImageResource> toResource(List<ImageEntity> images) {
        return modelMapper.mapList(images, ImageResource.class);
    }

    public ImageEntity toEntity(CreateImageResource image) {
        return modelMapper.map(image, ImageEntity.class);
    }

    public ImageEntity toEntity(UpdateImageResource image) {
        return modelMapper.map(image, ImageEntity.class);
    }
}
