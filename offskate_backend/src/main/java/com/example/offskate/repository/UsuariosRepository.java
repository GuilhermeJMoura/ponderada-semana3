package com.example.offskate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.offskate.model.entity.UsuariosEntity;

/**
 * Repository interface for managing PJ contracts.
 */
@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Integer> {

    /**
     * Retrieves a PJ contract by their ID.
     *
     * @param long1 The ID of the contract to retrieve.
     * @return An Optional containing the retrieved contract, or empty if no contract with the given ID is found.
     */
    Optional<UsuariosEntity> findById(Integer id_usuario);

}