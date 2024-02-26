package com.example.offskate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.offskate.dto.ProdutosDTO;
import com.example.offskate.model.entity.ProdutosEntity;
import com.example.offskate.repository.ProdutosRepository;
import com.example.offskate.exception.ResourceNotFoundException;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

/**
 * Service class for managing PJ contracts.
 */
@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    /**
     * Converts a ProdutosEntity to a ProdutosDTO.
     *
     * @param ProdutosEntity The entity to convert.
     * @return The converted DTO.
     */
    private ProdutosDTO converter(ProdutosEntity ProdutosEntity) {
        ProdutosDTO result = new ProdutosDTO();
        result.setId_produto(ProdutosEntity.getId_produto());
        result.setName(ProdutosEntity.getName());
        result.setDescription(ProdutosEntity.getDescription());
        result.setPrice(ProdutosEntity.getPrice());
        result.setSize(ProdutosEntity.getSize());
        result.setColor(ProdutosEntity.getColor());
        
        return result;
    }

    /**
     * Retrieves all PJ contracts.
     *
     * @return A list of all PJ contracts.
     */
    public List<ProdutosDTO> getProdutos() {
        return produtosRepository
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
    public ProdutosDTO getProdutosbyId(Integer id_produto) {
        Optional<ProdutosEntity> produtosEntityOptional = produtosRepository.findById(id_produto);
        if (produtosEntityOptional.isPresent()) {
            ProdutosEntity ProdutosEntity = produtosEntityOptional.get();
            return converter(ProdutosEntity);
        } else {
            throw new ResourceNotFoundException("Produto não encontrado com Id: " + id_produto);
        }
    }

    /**
     * Creates a new PJ contract.
     *
     * @param ProdutosDTO The DTO of the contract to create.
     * @return The created contract.
     */
    public ProdutosDTO createProduto(ProdutosDTO produtosDTO) {
        ProdutosEntity produtosEntity = new ProdutosEntity();
        produtosEntity.setId_produto(produtosDTO.getId_produto());
        produtosEntity.setName(produtosDTO.getName());
        produtosEntity.setDescription(produtosDTO.getDescription());
        produtosEntity.setPrice(produtosDTO.getPrice());
        produtosEntity.setSize(produtosDTO.getSize());
        produtosEntity.setColor(produtosDTO.getColor());

        produtosRepository.save(produtosEntity);

        return produtosDTO;
    }

    /**
     * Updates an existing PJ contract.
     *
     * @param ProdutosDTO The DTO of the contract to update.
     * @param id The ID of the contract to update.
     * @return The updated contract.
     * @throws ResourceNotFoundException If no contract with the given ID is found.
     */
    public ProdutosDTO updateProduto(ProdutosDTO produtosDTO, Integer id_produto) {
        Optional<ProdutosEntity> produtosEntityOptional = produtosRepository.findById(id_produto);
        if (produtosEntityOptional.isPresent()) {
            ProdutosEntity produtosEntity = produtosEntityOptional.get();
            produtosEntity.setName(produtosDTO.getName());
            produtosEntity.setDescription(produtosDTO.getDescription());
            produtosEntity.setPrice(produtosDTO.getPrice());
            produtosEntity.setSize(produtosDTO.getSize());
            produtosEntity.setColor(produtosDTO.getColor());

            produtosRepository.save(produtosEntity);

            return produtosDTO;
        } else {
            throw new ResourceNotFoundException("Produto não encontrado com Id: " + id_produto);
        }
    }

    /**
     * Deletes a PJ contract by their ID.
     *
     * @param id The ID of the contract to delete.
     * @return A success message if the contract was deleted.
     * @throws ResourceNotFoundException If no contract with the given ID is found.
     */
    public String deleteProduto(@PathVariable("id_produto") Integer id) {
        Optional<ProdutosEntity> produtosEntityOptional = produtosRepository.findById(id);
        if (produtosEntityOptional.isPresent()) {
            produtosRepository.deleteById(id);
            return "Produto deletado com sucesso";
        } else {
            throw new ResourceNotFoundException("Produto não encontrado com Id: " + id);
        }
    }

}