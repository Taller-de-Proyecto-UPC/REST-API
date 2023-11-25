package com.tp.neuralscan.patient.service;

import com.tp.neuralscan.patient.model.ImageEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ImageService {

    List<ImageEntity> getAllImages();
    ImageEntity createImage(ImageEntity image);
    ImageEntity updateImage(Long id, ImageEntity image);
    Optional<ResponseEntity<Object>> deleteImage(Long id);

}
