package com.chandilove.appchl.services.impl;

import com.chandilove.appchl.dto.PublicacionDTO;
import com.chandilove.appchl.infra.exceptions.ImageSizeException;
import com.chandilove.appchl.infra.exceptions.ObjectValidationException;
import com.chandilove.appchl.infra.validator.ObjectsValidator;
import com.chandilove.appchl.mappers.PublicacionMapper;
import com.chandilove.appchl.models.Publicaciones;
import com.chandilove.appchl.repositories.PublicacionesRepository;
import com.chandilove.appchl.services.PublicacionesService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Service
@AllArgsConstructor
public class PublicacionesServiceImpl implements PublicacionesService {

    private final PublicacionesRepository publicacionesRepository;
    private final ObjectsValidator<PublicacionDTO> validator;


    @Override
    public Long save(PublicacionDTO dto) {
        return null;
    }

    @Override
    public Page findAll(Pageable pageable) {
        return null;
    }

    @Override
    public PublicacionDTO findById(Long id) {
        return PublicacionMapper.toPublicacionResponse(publicacionesRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("publicación no encontrada")));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Long savePublicacion(PublicacionDTO publicacion, MultipartFile file) throws ObjectValidationException, ImageSizeException, IOException, SQLException {
        if(file.getSize() > 10*1024*1024){
            throw new ImageSizeException(file.getOriginalFilename());
        }
        if (!file.isEmpty()){
//            byte[] bytes = file.getBytes();
//            Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
            publicacion.setImagen(file.getBytes());
        }

        validator.validate(publicacion);
        Publicaciones newPublicacion = publicacionesRepository.save(PublicacionMapper.toEntity(publicacion));
        return publicacionesRepository
                .save(newPublicacion).getId();
    }
}
