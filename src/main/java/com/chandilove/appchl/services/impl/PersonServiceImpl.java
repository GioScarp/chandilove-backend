package com.chandilove.appchl.services.impl;

import com.chandilove.appchl.dto.UserPersonDTO;
import com.chandilove.appchl.mappers.UserMapper;
import com.chandilove.appchl.repositories.PersonRepository;
import com.chandilove.appchl.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public Long save(UserPersonDTO dto) {
        return null;
    }

    @Override
    public Page<UserPersonDTO> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public UserPersonDTO findById(Long id) {
        return UserMapper.toPersonResponse(personRepository.findById(id).orElseThrow());
    }

    @Override
    public void delete(Long id) {

    }
}
