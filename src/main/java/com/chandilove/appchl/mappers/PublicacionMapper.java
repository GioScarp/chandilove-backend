package com.chandilove.appchl.mappers;

import com.chandilove.appchl.dto.PublicacionDTO;
import com.chandilove.appchl.models.Publicaciones;
import com.chandilove.appchl.models.User;

public class PublicacionMapper {

    public static PublicacionDTO toPublicacionResponse(Publicaciones publicacion) {
        return PublicacionDTO.builder()
                .id(publicacion.getId())
                .fechaPublicacion(publicacion.getFechaPublicacion())
                .descripcion(publicacion.getDescripcion())
                .imagen(publicacion.getImagenPublicacion())
                .idUser(publicacion.getUser().getId())
                .build();
    }

    public static Publicaciones toEntity(PublicacionDTO publicacion){
        return Publicaciones.builder()
                .descripcion(publicacion.getDescripcion())
                .imagenPublicacion(publicacion.getImagen())
                .user(User.builder()
                        .id(publicacion.getIdUser())
                        .build())
                .build();
    }
}
