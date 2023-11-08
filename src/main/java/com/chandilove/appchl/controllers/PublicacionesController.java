package com.chandilove.appchl.controllers;

import com.chandilove.appchl.dto.PublicacionDTO;
import com.chandilove.appchl.dto.PublicancionResponseDTO;
import com.chandilove.appchl.dto.UserPersonDTO;
import com.chandilove.appchl.infra.exceptions.ImageSizeException;
import com.chandilove.appchl.infra.exceptions.ObjectValidationException;
import com.chandilove.appchl.mappers.PublicacionMapper;
import com.chandilove.appchl.services.PublicacionesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/publicaciones")
@RequiredArgsConstructor
public class PublicacionesController {

    private final PublicacionesService publicacioneService;

    @PostMapping
    public ResponseEntity<Long> crearPublicacion(
            @RequestPart("image") MultipartFile file,
            @RequestPart("info") PublicacionDTO publicacion) throws SQLException, ImageSizeException, ObjectValidationException, IOException {

        Long publicacionID = publicacioneService.savePublicacion(publicacion, file);
        return ResponseEntity.ok(publicacionID);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPublicacion(@PathVariable Long id) throws SQLException, IOException {

        PublicacionDTO publicacion = publicacioneService.findById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(PublicancionResponseDTO.builder()
                        .idUser(publicacion.getIdUser())
                        .imagen(publicacion.getImagen())
                        .build());
    }

//    @GetMapping("/imagen/{id}")
//    public ResponseEntity<?> obtenerImagenPublicacion(@PathVariable Long id) throws SQLException, IOException {
//
//        PublicacionDTO publicacion = publicacioneService.findById(id);
//        return ResponseEntity.status(HttpStatus.OK)
//                .contentType(MediaType.IMAGE_PNG)
//                .body(readBlob(publicacion.getImagen()));
//    }



    // Método para leer los bytes desde un Blob.
    private static byte[] readBlob(Blob blob) throws SQLException, IOException {
        try (InputStream inputStream = blob.getBinaryStream();
             ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            return outputStream.toByteArray();
        }
    }
}
