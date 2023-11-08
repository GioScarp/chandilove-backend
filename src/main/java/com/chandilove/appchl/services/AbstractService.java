package com.chandilove.appchl.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface AbstractService<T> {
    Long save(T dto);
    Page<T> findAll(Pageable pageable);
    T findById(Long id);
    void delete(Long id);

}
