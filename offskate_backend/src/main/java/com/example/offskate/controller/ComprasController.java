package com.example.offskate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.offskate.dto.ComprasDTO;
import com.example.offskate.model.entity.ProdutosEntity;
import com.example.offskate.model.entity.UsuariosEntity;
import com.example.offskate.repository.ProdutosRepository;
import com.example.offskate.repository.UsuariosRepository;
import com.example.offskate.service.ComprasService;

@RestController
@RequestMapping("/compras")
@CrossOrigin(origins = "http://184.73.70.240")
public class ComprasController {

    @Autowired
    private ComprasService compraService;

    @Autowired
    private UsuariosRepository usuarioRepository;

    @Autowired
    private ProdutosRepository produtoRepository;

    @PostMapping()
    public ResponseEntity<String> realizarCompra(@RequestBody ComprasDTO compraDTO) {
        UsuariosEntity usuario = usuarioRepository.findById(compraDTO.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        ProdutosEntity produto = produtoRepository.findById(compraDTO.getIdProduto())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        compraService.realizarCompra(usuario, produto);

        return ResponseEntity.ok("Compra realizada com sucesso");
    }
}
