package com.tp.neuralscan.patient.controller;

import com.tp.neuralscan.patient.dto.CreateImageResource;
import com.tp.neuralscan.patient.dto.ImageResource;
import com.tp.neuralscan.patient.dto.UpdateImageResource;
import com.tp.neuralscan.patient.mapping.ImageMapper;
import com.tp.neuralscan.patient.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Tag(name = "Image", description = "Image API")
@RestController
@RequestMapping("/api/v1/image")
@CrossOrigin
public class ImageController {
    @Autowired
    private ImageService imageService;

    @Autowired
    private ImageMapper imageMapper;


    public static final String DIRECTORY = "C:/Users/Josmar/Documents/RM/DataSets/Dataset/Sano";

    @Operation(summary = "Get all Images", description = "Get all Images")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found all Images"),
            @ApiResponse(responseCode = "404", description = "Images not found")})
    @GetMapping
    public List<ImageResource> getAllImages() {
        return imageMapper.toResource(imageService.getAllImages());
    }

    @Operation(summary = "Create Image", description = "Create Image")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created Image"),
            @ApiResponse(responseCode = "404", description = "Image not created")})
    @PostMapping("/create")
    public ImageResource createImage(@RequestBody CreateImageResource createImageResource) {
        return imageMapper.toResource(imageService.createImage(imageMapper.toEntity(createImageResource)));
    }

    @Operation(summary = "Update Image", description = "Update Image")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated Image"),
            @ApiResponse(responseCode = "404", description = "Image not updated")})
    @PutMapping("/{id}")
    public ImageResource updateImage(@PathVariable(name = "id") Long id, @RequestBody UpdateImageResource updateImageResource) {
        return imageMapper.toResource(imageService.updateImage(id,
                imageMapper.toEntity(updateImageResource)));
    }

    @Operation(summary = "Delete Image", description = "Delete Image")
    @DeleteMapping("{id}")
    public Optional<ResponseEntity<Object>> deleteImage(@PathVariable Long id) {
        return imageService.deleteImage(id);
    }

    @PostMapping ("{imageId}/upload")
    public ResponseEntity <List<String>> uploadFiles(@PathVariable Long imageId, @RequestParam("files")List<MultipartFile> multipartFiles) throws IOException {
        List<String> filenames = new ArrayList<>();
        for (MultipartFile file : multipartFiles){
            String filename = StringUtils.cleanPath(imageId.toString()+".jpg");
            Path fileStorage = get(DIRECTORY, filename).toAbsolutePath().normalize();
            copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);
            filenames.add(filename);
        }

        return ResponseEntity.ok().body(filenames);

    }

}
