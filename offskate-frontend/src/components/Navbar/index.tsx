import "./styles.scss";
import photoLogo from "../../assets/off-skateshop-removebg-preview.png";

const Navbar = () => {
  return (
    <nav className="navbar">
      <div className="box-logo">
        <img className="photo" src={photoLogo} alt="Foto de perfil" />
      </div>
      <div className="box-search">
        <input
          className="box-input"
          type="text"
          placeholder="Busque o que você deseja"
        />
      </div>

      <div className="box-saldo">
        <p className="color-text">Saldo: R$ 1000</p>
      </div>

      <div className="box-user">
        <img
          className="photo-user"
          src="https://cdn-icons-png.flaticon.com/512/149/149071.png"
          alt="Foto de perfil"
        />
      </div>
    </nav>
  );
};

export default Navbar;
