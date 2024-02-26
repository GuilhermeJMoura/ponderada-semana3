import React from "react";
import { useState } from "react";
import "./styles.scss";
import ModalDetails from "../ModalDetails";
import { deleteProduct } from "../../services/removeProduct";
import { createCompra } from "../../services/postComprar";

interface ProductProps {
  product: {
    id_produto: number;
    name: string;
    price: number;
    description: string;
    size: number;
    color: string;
  };

}

const ProductContainer: React.FC<ProductProps> = ({ product }) => {
  const [modalOpen, setModalOpen] = useState(false);

  // useEffect(() => {
  //   const fetchProducts = async () => {
  //     try {
  //       const data = await getProducts();
  //       setProducts(data);
  //     } catch (error) {
  //       console.error("Erro ao buscar produtos", error);
  //     }
  //   };
  
  //   fetchProducts();
  // }, []);

  const handleOpenModal = () => {
    setModalOpen(true);
  };

  const handleCloseModal = () => {
    setModalOpen(false);
  };
  const handleCompra = async (idProduto: any) => {
    try{
        const formData = {
            idProduto,
            idUsuario: 3
        };
        console.log(formData);
        await createCompra(formData);
    } catch (error) {
        console.log("Erro ao criar produto", error);
    }
  }

  return (
    <>
    <div className="main">
      <div className="box-image"></div>
      <div className="box-content">
        <h2 className="title">{product.name}</h2>
        <h3 className="price">R$ {product.price}</h3>

        <div className="button-container">
          <button className="btn-details" onClick={handleOpenModal}>Detalhes</button>
          <button className="btn-buy" onClick={() => handleCompra(product.id_produto)}>Comprar</button>
        </div>
      </div>
    </div>

    <ModalDetails isOpen={modalOpen} onClose={handleCloseModal} product={product} onDelete={deleteProduct}>
    </ModalDetails>
    </>
  );
};

export default ProductContainer;
