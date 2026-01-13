package com.proteccion.requests.service.interfaces;

import com.proteccion.requests.dto.CreateUserDTO;
import com.proteccion.requests.dto.UserDTO;

import java.util.List;

public interface IUserService {

    /**
     * Create a new user.
     *
     * @param dto the user data
     * @return the created user
     */
    UserDTO create(CreateUserDTO dto);

    /**
     * Get all users.
     *
     * @return list of all users
     */
    List<UserDTO> findAll();

    /**
     * Get a user by ID.
     *
     * @param id the user ID
     * @return the user
     */
    UserDTO findById(Long id);


}
