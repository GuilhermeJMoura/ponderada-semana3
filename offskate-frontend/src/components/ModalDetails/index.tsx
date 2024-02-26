import React from "react";
import "./styles.scss";

interface ModalProps {
  isOpen: boolean;
  onClose: () => void;
  onDelete: (id_produto: number) => void;
  product: {
    id_produto: number;
    name: string;
    price: number;
    description: string;
    size: number;
    color: string;
  };
}

const ModalDetails: React.FC<ModalProps> = ({ isOpen, onClose, onDelete, product }) => {
  if (!isOpen) return null;

  return (
    <div className="modal">
      <div className="modal-content">
        <h2 className="title">{product.name}</h2>

        <h3 className="desc">Descrição: {product.description}</h3>
        <h3 className="price">Preço: {product.price}</h3>
        <h3 className="size">Tamanho: {product.size}</h3>
        <h3 className="color">Cor: {product.color}</h3>
        <div className="btn-container">
          <button className="btn-close" onClick={onClose}>
            Fechar
          </button>
          <button className="btn-delete" onClick={() => onDelete(product.id_produto)}>
            Remover
          </button>
          <button className="btn-buy">Comprar</button>
        </div>
      </div>
    </div>
  );
};

export default ModalDetails;
