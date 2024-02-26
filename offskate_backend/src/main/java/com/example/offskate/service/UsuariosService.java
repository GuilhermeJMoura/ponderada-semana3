package com.example.offskate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.offskate.dto.UsuariosDTO;
import com.example.offskate.model.entity.UsuariosEntity;
import com.example.offskate.repository.UsuariosRepository;
import com.example.offskate.exception.ResourceNotFoundException;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing PJ contracts.
 */
@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    /**
     * Converts a UsuariosEntity to a UsuariosDTO.
     *
     * @param UsuariosEntity The entity to convert.
     * @return The converted DTO.
     */
    private UsuariosDTO converter(UsuariosEntity UsuariosEntity) {
        UsuariosDTO result = new UsuariosDTO();
        result.setId_usuario(UsuariosEntity.getId_usuario());
        result.setName(UsuariosEntity.getName());
        result.setEmail(UsuariosEntity.getEmail());
        result.setPassword(UsuariosEntity.getPassword());
        result.setBalance(UsuariosEntity.getBalance());
        
        return result;
    }

    /**
     * Retrieves all PJ contracts.
     *
     * @return A list of all PJ contracts.
     */
    public List<UsuariosDTO> getUsuarios() {
        return usuariosRepository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());
    }

    /**
     * Retrieves a PJ contract by their ID.
     *
     * @param id The ID of the contract to retrieve.
     * @return The retrieved contract.
     * @throws ResourceNotFoundException If no contract with the given ID is found.
     */
    public UsuariosDTO getUsuariobyId(Integer id) {
        Optional<UsuariosEntity> UsuariosEntityOptional = usuariosRepository.findById(id);
        if (UsuariosEntityOptional.isPresent()) {
            UsuariosEntity UsuariosEntity = UsuariosEntityOptional.get();
            return converter(UsuariosEntity);
        } else {
            throw new ResourceNotFoundException("Usuario não encontrado com Id: " + id);
        }
    }

    /**
     * Creates a new PJ contract.
     *
     * @param UsuariosDTO The DTO of the contract to create.
     * @return The created contract.
     */
    public UsuariosDTO createUsuario(UsuariosDTO usuariosDTO) {
        UsuariosEntity usuariosEntity = new UsuariosEntity();
        usuariosEntity.setId_usuario(usuariosDTO.getId_usuario());
        usuariosEntity.setName(usuariosDTO.getName());
        usuariosEntity.setEmail(usuariosDTO.getEmail());
        usuariosEntity.setPassword(usuariosDTO.getPassword());
        usuariosEntity.setBalance(usuariosDTO.getBalance());

        usuariosRepository.save(usuariosEntity);

        return usuariosDTO;
    }

    /**
     * Updates an existing PJ contract.
     *
     * @param UsuariosDTO The DTO of the contract to update.
     * @param id The ID of the contract to update.
     * @return The updated contract.
     * @throws ResourceNotFoundException If no contract with the given ID is found.
     */
    public UsuariosDTO updateUsuario(UsuariosDTO usuariosDTO, Integer id_usuario) {
        Optional<UsuariosEntity> usuariosEntityOptional = usuariosRepository.findById(id_usuario);
        if (usuariosEntityOptional.isPresent()) {
            UsuariosEntity usuariosEntity = usuariosEntityOptional.get();            usuariosEntity.setName(usuariosDTO.getName());
            usuariosEntity.setEmail(usuariosDTO.getEmail());
            usuariosEntity.setPassword(usuariosDTO.getPassword());
            usuariosEntity.setBalance(usuariosDTO.getBalance());

            usuariosRepository.save(usuariosEntity);

            return usuariosDTO;
        } else {
            throw new ResourceNotFoundException("Usuário não encontrado com Id: " + id_usuario);
        }
    }

    /**
     * Deletes a PJ contract by their ID.
     *
     * @param id The ID of the contract to delete.
     * @return A success message if the contract was deleted.
     * @throws ResourceNotFoundException If no contract with the given ID is found.
     */
    public String deleteUsuario(@PathVariable("id_usuario") Integer id_usuario) {
        Optional<UsuariosEntity> UsuariosEntityOptional = usuariosRepository.findById(id_usuario);
        if (UsuariosEntityOptional.isPresent()) {
            usuariosRepository.deleteById(id_usuario);
            return "Usuário deletado com sucesso";
        } else {
            throw new ResourceNotFoundException("Usuário não encontrado com Id: " + id_usuario);
        }
    }

}