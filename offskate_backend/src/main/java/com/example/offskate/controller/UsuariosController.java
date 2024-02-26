package com.example.offskate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.offskate.dto.UsuariosDTO;
import com.example.offskate.service.UsuariosService;

/**
 * Controller class for managing PJ contracts.
 */
@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://184.73.70.240")           
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    /**
     * Retrieves all PJ contracts.
     *
     * @return A list of all PJ contracts.
     */
    @GetMapping()
    public List<UsuariosDTO> getUsuarios() {
        return usuariosService.getUsuarios();
    }

    /**
     * Retrieves a PJ contract by their ID.
     *
     * @param id The ID of the contract to retrieve.
     * @return The retrieved contract.
     */
    @GetMapping("/{id_usuario}")
    public ResponseEntity<UsuariosDTO>getUsuariobyId(@PathVariable("id_usuario") Integer id) {
        UsuariosDTO usuariosPJ = usuariosService.getUsuariobyId(id);
        return ResponseEntity.ok(usuariosPJ);
    }

    /**
     * Creates a new PJ contract.
     *
     * @param usuariosPJDTO The DTO of the contract to create.
     * @return The created contract.
     */
    @PostMapping()
    @ResponseBody
    public ResponseEntity<UsuariosDTO> createUsuario(@RequestBody UsuariosDTO usuariosPJDTO) {
        UsuariosDTO createUsuarioPJ = usuariosService.createUsuario(usuariosPJDTO);

        return ResponseEntity.ok(createUsuarioPJ);
    }

    /**
     * Updates an existing PJ contract.
     *
     * @param id The ID of the contract to update.
     * @param usuariosPJDTO The DTO of the contract to update.
     * @return The updated contract.
     */
    @PutMapping("/{id_usuario}")
    @ResponseBody
    public ResponseEntity<UsuariosDTO> updateUsuario(@PathVariable("id_usuario") Integer id_usuario,
            @RequestBody UsuariosDTO updateUsuario) {
        UsuariosDTO updateUsuarios = usuariosService.updateUsuario(updateUsuario, id_usuario);

        return ResponseEntity.ok(updateUsuarios);
    }

    /**
     * Deletes a PJ contract by their ID.
     *
     * @param id The ID of the contract to delete.
     * @return A success message if the contract was deleted.
     */
    @DeleteMapping("/{id_usuario}")
    @ResponseBody
    public String deleteUsuario(@PathVariable("id_usuario") Integer id) {
        return usuariosService.deleteUsuario(id);
    }

}