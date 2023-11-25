package com.tp.neuralscan.patient.service.impl;

import com.tp.neuralscan.patient.model.ImageEntity;
import com.tp.neuralscan.patient.repository.ImageEntityRepository;
import com.tp.neuralscan.patient.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageEntityRepository imageEntityRepository;

    @Override
    public List<ImageEntity> getAllImages() {
        return imageEntityRepository.findAll();
    }

    @Override
    public ImageEntity createImage(ImageEntity image) {
        return imageEntityRepository.save(image);
    }

    @Override
    public ImageEntity updateImage(Long id, ImageEntity image) {
        ImageEntity imageEntity = imageEntityRepository.findById(id).orElseThrow();
        imageEntity.setPath(image.getPath());
        imageEntity.setAdded(image.getAdded());
        return imageEntityRepository.save(image);
    }

    @Override
    public Optional<ResponseEntity<Object>> deleteImage(Long id) {
        return imageEntityRepository.findById(id).map(image -> {
            imageEntityRepository.delete(image);
            return ResponseEntity.ok().build();
        });
    }
}
