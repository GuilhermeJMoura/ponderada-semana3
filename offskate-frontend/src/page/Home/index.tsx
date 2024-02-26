import Navbar from "../../components/Navbar";
import ProductContainer from "../../components/ProductContainer";
import "./styles.scss";

import { getProducts } from "../../services/getProducts";
import { useEffect, useState } from "react";
import ModalCreateProduct from "../../components/ModalCreateProduct";

interface Product {
  id_produto: number;
  name: string;
  price: number;
  description: string;
  size: number;
  color: string;
}


const Home = () => {
  const [products, setProducts] = useState<Product[]>([]);
  const [modalOpenProduct, setModalOpenProduct] = useState(false);

  const handleOpenModalProduct = () => {
    setModalOpenProduct(true);
  };

  const handleCloseModalProduct = () => {
    setModalOpenProduct(false);
  };

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const data = await getProducts();
        setProducts(data);
      } catch (error) {
        console.error("Erro ao buscar produtos", error);
      }
    };

    fetchProducts();
  }, []);

  
  return (
    <>
    <div className="home">
      <Navbar />
      <div className="title-container"> 
        <h1 className="title-produtos">Produtos: </h1>
        <button className="create-product-btn" onClick={handleOpenModalProduct}>Criar Produto</button>
      </div>

      <div className="main-container">
        {products.map((product) => (
          <ProductContainer key={product.id_produto} product={product}/>
        ))}
      </div>
    </div>

    <ModalCreateProduct isOpen={modalOpenProduct} onClose={handleCloseModalProduct} />
    </>
  );
};

export default Home;
