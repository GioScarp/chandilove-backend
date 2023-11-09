package com.chandilove.appchl.services;

import com.chandilove.appchl.dto.PublicacionDTO;
import com.chandilove.appchl.dto.UserFundationDTO;
import com.chandilove.appchl.infra.exceptions.ImageSizeException;
import com.chandilove.appchl.infra.exceptions.ObjectValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

public interface PublicacionesService extends AbstractService<PublicacionDTO>{

    Long savePublicacion(PublicacionDTO publicacionDTO, MultipartFile file) throws ObjectValidationException, ImageSizeException, IOException, SQLException;

    Page<PublicacionDTO> findByUsuario(Pageable pageable, Long id);
}
