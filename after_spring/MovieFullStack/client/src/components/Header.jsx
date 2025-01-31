import { NavLink } from "react-router";

const Header = () => {
  return (
    <header className="p-5">
      <nav className="navbar bg-base-100">
        <NavLink className="btn btn-ghost text-xl" to="/">
          Home
        </NavLink>
        <NavLink className="btn btn-ghost text-xl" to="register">
          Register book
        </NavLink>
      </nav>
    </header>
  );
};

export default Header;
