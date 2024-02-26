package com.example.offskate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.offskate.model.entity.ComprasEntity;
import com.example.offskate.model.entity.ProdutosEntity;
import com.example.offskate.model.entity.UsuariosEntity;
import com.example.offskate.repository.ComprasRepository;
import com.example.offskate.repository.UsuariosRepository;

@Service
public class ComprasService implements CompraInterface {

    @Autowired
    private ComprasRepository compraRepository;

    @Autowired
    private UsuariosRepository usuarioRepository;

    @Override
    public void realizarCompra(UsuariosEntity usuario, ProdutosEntity produto) {
        // Verificar se o usuário tem saldo suficiente
        if (usuario.getBalance() < produto.getPrice()) {
            throw new RuntimeException("Saldo insuficiente para realizar a compra");
        }

        // Atualizar o saldo do usuário
        usuario.setBalance(usuario.getBalance() - produto.getPrice());
        usuarioRepository.save(usuario);

        // Criar um novo registro de compra
        ComprasEntity compra = new ComprasEntity();
        compra.setProduto(produto);
        compra.setUsuario(usuario);

        // Salvar a compra no banco de dados
        compraRepository.save(compra);
    }
}

interface CompraInterface {
    void realizarCompra(UsuariosEntity usuario, ProdutosEntity produto);
}