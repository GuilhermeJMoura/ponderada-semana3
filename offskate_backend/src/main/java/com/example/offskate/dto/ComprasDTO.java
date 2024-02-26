package com.example.offskate.dto;


public class ComprasDTO {
    private Integer idCompra;

    private Integer idProduto;
    
    private Integer idUsuario;
    // Outros campos que você deseja expor, como nome do produto e nome do usuário

    // Getters e Setters
    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Métodos adicionais para lidar com a conversão de tipos ou a serialização
}
