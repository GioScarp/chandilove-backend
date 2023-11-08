package com.chandilove.appchl.services.impl;

import com.chandilove.appchl.dto.UserDTO;
import com.chandilove.appchl.dto.UserFundationDTO;
import com.chandilove.appchl.dto.UserLogin;
import com.chandilove.appchl.dto.UserPersonDTO;
import com.chandilove.appchl.infra.exceptions.ImageSizeException;
import com.chandilove.appchl.infra.exceptions.ObjectValidationException;
import com.chandilove.appchl.infra.validator.ObjectsValidator;
import com.chandilove.appchl.mappers.UserMapper;
import com.chandilove.appchl.models.Person;
import com.chandilove.appchl.models.User;
import com.chandilove.appchl.repositories.FoundationRepository;
import com.chandilove.appchl.repositories.PersonRepository;
import com.chandilove.appchl.repositories.UserRepository;
import com.chandilove.appchl.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private ObjectsValidator<UserFundationDTO> validatorUsuario;
    private ObjectsValidator<UserPersonDTO> validatorPerson;
    private ObjectsValidator<UserLogin> validatorLogin;
    private UserRepository userRepository;
    private FoundationRepository foundationRepository;
    private PersonRepository personRepository;


    @Override
    public UserPersonDTO buscarPersona(Long id){

        Person person = personRepository.findById(id).orElseThrow();

        return UserMapper.toPersonResponse(person);
    }

    @Override
    public Long save(UserDTO dto) {
        return null;
    }

    @Override
    public Page<UserDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public UserFundationDTO findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Long saveUsuarioFundacion(UserFundationDTO usuario, MultipartFile file) throws ObjectValidationException, ImageSizeException, IOException, SQLException {
        validatorUsuario.validate(usuario);
        if(file.getSize() > 2*1024*1024){
            System.out.println("grande");
            throw new ImageSizeException(file.getOriginalFilename());
        }
        if (!file.isEmpty()){

            usuario.setFotoPerfil(file.getBytes());
        }

        User newUser = userRepository.save(UserMapper.toUserEntity(usuario));
        return foundationRepository
                .save(UserMapper.toFoundationEntity(usuario,newUser.getId())).getId();
    }

    @Override
    @Transactional
    public Long saveUsuarioPerson(UserPersonDTO usuario, MultipartFile file) throws ObjectValidationException, ImageSizeException, IOException, SQLException {
        validatorPerson.validate(usuario);
        if(file.getSize() > 2*1024*1024){
            throw new ImageSizeException(file.getOriginalFilename());
        }
        if (!file.isEmpty()){
            usuario.setFotoPerfil(file.getBytes());
        }

        User newUser = userRepository.save(UserMapper.toUserEntity(usuario));
        return personRepository
                .save(UserMapper.toPersonEntity(usuario,newUser.getId())).getId();
    }

    @Override
    public UserDTO updateUser(Long id, UserFundationDTO usuario) {
        return null;
    }

    @Override
    public UserDTO loginUser(UserLogin user) throws ObjectValidationException {
        validatorLogin.validate(user);
        User usuario = userRepository.findByEmail(user.email()).orElseThrow();
        if (usuario.getPassword().equals(user.password())) {
            return UserDTO.builder()
                    .nombreUsuario(usuario.getNombreUsuario())
                    .email(usuario.getEmail())
                    .id(usuario.getId())
                    .fotoPerfil(usuario.getFotoPerfil())
                    .build();
        }

        return null;
    }
}
