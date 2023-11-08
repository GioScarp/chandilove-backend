package com.chandilove.appchl.repositories;

import com.chandilove.appchl.models.Publicaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionesRepository extends JpaRepository<Publicaciones, Long> {
}
