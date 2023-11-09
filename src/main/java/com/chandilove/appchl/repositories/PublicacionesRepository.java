package com.chandilove.appchl.repositories;

import com.chandilove.appchl.dto.PublicacionDTO;
import com.chandilove.appchl.models.Publicaciones;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionesRepository extends JpaRepository<Publicaciones, Long> {
    Page<Publicaciones> findByIdNotNull(Pageable pageable);

    Page<Publicaciones> findByUser_Id(Pageable pageable, Long userId);

}
