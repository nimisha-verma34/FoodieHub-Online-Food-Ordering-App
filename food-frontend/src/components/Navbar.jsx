import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="navbar navbar-expand-lg navbar-dark bg-orange px-4">
      <Link className="navbar-brand fw-bold" to="/">FoodieHub</Link>

      <div className="collapse navbar-collapse justify-content-end">
        <ul className="navbar-nav">
          <li className="nav-item"><Link className="nav-link" to="/">Home</Link></li>
          <li className="nav-item"><Link className="nav-link" to="/restaurants">Top Restaurants</Link></li>
          <li className="nav-item"><Link className="nav-link" to="/login">Login</Link></li>
          <li className="nav-item">
            <Link className="btn btn-light ms-2" to="/cart">Cart (0)</Link>
          </li>
        </ul>
      </div>
    </nav>
  );
}

export default Navbar;
