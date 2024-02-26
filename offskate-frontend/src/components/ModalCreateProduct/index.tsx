import React, { useState } from "react";
import "./styles.scss";
import { createProduct } from "../../services/createProducts";

interface ModalProps {
  isOpen: boolean;
  onClose: () => void;
  childern?: React.ReactNode;
}

const ModalCreateProduct: React.FC<ModalProps> = ({ isOpen, onClose }) => {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [price, setPrice] = useState("");
  const [size, setSize] = useState("");
  const [color, setColor] = useState("");

  if (!isOpen) return null;

  const handleSubmit = async () => {
    try{
        const formData = {
            name, 
            description,
            price,
            size,
            color
        };
        await createProduct(formData);
        onClose();
    } catch (error) {
        console.log("Erro ao criar produto", error);
    }
  }

  return (
    <div className="modal">
      <div className="modal-content">
        <div className="input-container">
          <input
            className="name-product"
            placeholder="Insira o nome do produto"
            value={name}
            onChange={(e) => setName(e.target.value)}
          ></input>
          <input
            className="desc-product"
            placeholder="Insira a descrição do produto"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
          ></input>
          <input
            className="price-product"
            placeholder="Insira o preço do produto"
            value={price}
            onChange={(e) => setPrice(e.target.value)}
          ></input>
          <input
            className="size-product"
            placeholder="Insira o tamanho do produto"
            value={size}
            onChange={(e) => setSize(e.target.value)}
          ></input>
          <input
            className="color-product"
            placeholder="Insira a cor do produto"
            value={color}
            onChange={(e) => setColor(e.target.value)}
          ></input>
        </div>

        <div className="btn-container">
          <button className="btn-close-modal" onClick={onClose}>
            Fechar
          </button>
          <button className="btn-send" onClick={handleSubmit}>Criar</button>
        </div>
      </div>
    </div>
  );
};

export default ModalCreateProduct;
