package com.chandilove.appchl.controllers;

import com.chandilove.appchl.dto.UserDTO;
import com.chandilove.appchl.dto.UserFundationDTO;
import com.chandilove.appchl.dto.UserLogin;
import com.chandilove.appchl.dto.UserPersonDTO;
import com.chandilove.appchl.infra.exceptions.ImageSizeException;
import com.chandilove.appchl.infra.exceptions.ObjectValidationException;
import com.chandilove.appchl.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/usuario")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/registro/foundation")
    public ResponseEntity<Long> createUserFundation(
            @RequestPart("image") MultipartFile file,
            @RequestPart UserFundationDTO usuario) throws ObjectValidationException, SQLException, ImageSizeException, IOException {
        Long idUsuario = userService.saveUsuarioFundacion(usuario, file);
        return ResponseEntity.ok(idUsuario);
    }

    @PostMapping("/registro")
    public ResponseEntity<Long> createUserPerson(
            @RequestPart("image") MultipartFile file,
            @RequestPart UserPersonDTO usuario) throws ObjectValidationException, SQLException, ImageSizeException, IOException {
        Long idUsuario = userService.saveUsuarioPerson(usuario, file);
        return ResponseEntity.ok(idUsuario);
    }

    @GetMapping()
    public ResponseEntity<Page<UserDTO>> buscarUsuarios(Pageable pageable){
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> buscarUsuarioPorId(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> actualizarUsuario(@PathVariable Long id, @RequestBody UserFundationDTO usuario){
        return ResponseEntity.ok(userService.updateUser(id, usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUsuario(@RequestBody UserLogin user) throws ObjectValidationException {
        UserDTO userDTO = userService.loginUser(user);
        if (userDTO != null ){
            return ResponseEntity.ok(userDTO);
        }else {
         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(userDTO);
        }

    }
}
