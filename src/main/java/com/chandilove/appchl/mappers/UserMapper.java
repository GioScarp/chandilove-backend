package com.chandilove.appchl.mappers;

import com.chandilove.appchl.dto.UserDTO;
import com.chandilove.appchl.dto.UserFundationDTO;
import com.chandilove.appchl.dto.UserPersonDTO;
import com.chandilove.appchl.models.Foundation;
import com.chandilove.appchl.models.Person;
import com.chandilove.appchl.models.TypeUser;
import com.chandilove.appchl.models.User;
import org.springframework.web.multipart.MultipartFile;

public class UserMapper {
    public static UserDTO toLightUserResponse(User user){
        return UserDTO.builder()
                .id(user.getId())
                .nombreUsuario(user.getNombreUsuario())
                .email(user.getEmail())
                .typeUser(user.getTypeUser().getId())
                .fotoPerfil(user.getFotoPerfil())
                .build();
    }

    public static UserFundationDTO toUserFundationResponse(Foundation userFoundation){
        User user = userFoundation.getUser();
        return UserFundationDTO.builder()
                .nombreFundacion(userFoundation.getNombreFundacion())
                .ciudad(user.getCiudad())
                .telefono(user.getTelefono())
                .fotoPerfil(user.getFotoPerfil())
                .biografia(user.getBiografia())
                .nombreUsuario(user.getNombreUsuario())
                .typeUser(user.getTypeUser().getId())
                .build();
    }

    public static User toUserEntity(UserDTO userDTO){
        return User.builder()
                .nombreUsuario(userDTO.getNombreUsuario())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .biografia(userDTO.getBiografia() != null ? userDTO.getBiografia() : "")
                .telefono(userDTO.getTelefono())
                .fotoPerfil(userDTO.getFotoPerfil())
                .ciudad(userDTO.getCiudad())
                .activo(true)
                .typeUser(TypeUser.builder().id(userDTO.getTypeUser()).build())
                .build();
    }

    public static Foundation toFoundationEntity(UserFundationDTO userFundationDTO, Long idUser){
        return Foundation.builder()
                .user(User.builder().id(idUser).build())
                .nombreFundacion(userFundationDTO.getNombreFundacion())
                .direccion(userFundationDTO.getDireccion())
                .sitioWeb(userFundationDTO.getSitioWeb())
                .build();

    }

    public static Person toPersonEntity(UserPersonDTO userPersonDTO, Long idUser){
        return Person.builder()
                .user(User.builder().id(idUser).build())
                .nombre(userPersonDTO.getNombre())
                .apellido(userPersonDTO.getApellido())
                .fechaNacimiento(userPersonDTO.getFechaNacimiento())
                .gender(userPersonDTO.getGender())
                .build();
    }
}
