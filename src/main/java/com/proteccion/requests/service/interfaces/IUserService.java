package com.proteccion.requests.service.interfaces;

import com.proteccion.requests.dto.CreateUserDTO;
import com.proteccion.requests.dto.UserDTO;

import java.util.List;

public interface IUserService {

    UserDTO create(CreateUserDTO dto);

    List<UserDTO> findAll();

    UserDTO findById(Long id);


}
