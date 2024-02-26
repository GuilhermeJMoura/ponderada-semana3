package com.example.offskate.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.offskate.dto.ProdutosDTO;
import com.example.offskate.service.ProdutosService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Controller class for managing PJ contracts.
 */
@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "http://184.73.70.240")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    /**
     * Retrieves all PJ contracts.
     *
     * @return A list of all PJ contracts.
     */
    @GetMapping()
    public List<ProdutosDTO> getProdutos() {
        return produtosService.getProdutos();
    }

    /**
     * Retrieves a PJ contract by their ID.
     *
     * @param id The ID of the contract to retrieve.
     * @return The retrieved contract.
     */
    @GetMapping("/{id_produto}")
    public ResponseEntity<ProdutosDTO> getProdutosbyId(@PathVariable("id_produto") Integer id_produto) {
        ProdutosDTO getProdutosbyID = produtosService.getProdutosbyId(id_produto);
        return ResponseEntity.ok(getProdutosbyID);
    }

    /**
     * Creates a new PJ contract.
     *
     * @param produtosDTO The DTO of the contract to create.
     * @return The created contract.
     */
    @PostMapping()
    @ResponseBody
    public ResponseEntity<ProdutosDTO> createProduto(@RequestBody ProdutosDTO produtosDTO) {
        ProdutosDTO createUsuarioPJ = produtosService.createProduto(produtosDTO);

        return ResponseEntity.ok(createUsuarioPJ);
    }

    /**
     * Updates an existing PJ contract.
     *
     * @param id The ID of the contract to update.
     * @param produtosDTO The DTO of the contract to update.
     * @return The updated contract.
     */
    @PutMapping("/{id_produto}")
    @ResponseBody
    public ResponseEntity<ProdutosDTO> updateProduto(@PathVariable("id_produto") Integer id,
            @RequestBody ProdutosDTO produtosDTO) {
        ProdutosDTO updateProduto = produtosService.updateProduto(produtosDTO, id);

        return ResponseEntity.ok(updateProduto);
    }

    /**
     * Deletes a PJ contract by their ID.
     *
     * @param id The ID of the contract to delete.
     * @return A success message if the contract was deleted.
     */
    @DeleteMapping("/{id_produto}")
    @ResponseBody
    public String deleteProduto(@PathVariable("id_produto") Integer id) {
        return produtosService.deleteProduto(id);
    }

}