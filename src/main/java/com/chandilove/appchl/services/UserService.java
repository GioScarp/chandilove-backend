package com.chandilove.appchl.services;

import com.chandilove.appchl.dto.UserDTO;
import com.chandilove.appchl.dto.UserFundationDTO;
import com.chandilove.appchl.dto.UserLogin;
import com.chandilove.appchl.dto.UserPersonDTO;
import com.chandilove.appchl.infra.exceptions.ImageSizeException;
import com.chandilove.appchl.infra.exceptions.ObjectValidationException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;


public interface UserService extends AbstractService<UserDTO>{

    Long saveUsuarioFundacion(UserFundationDTO usuario, MultipartFile file) throws ObjectValidationException, ImageSizeException, IOException, SQLException;
    Long saveUsuarioPerson(UserPersonDTO usuario, MultipartFile file) throws ObjectValidationException, ImageSizeException, IOException, SQLException;

    UserDTO updateUser(Long id, UserFundationDTO usuario);

    UserDTO loginUser(UserLogin user) throws ObjectValidationException;

    UserPersonDTO buscarPersona(Long id);

}
