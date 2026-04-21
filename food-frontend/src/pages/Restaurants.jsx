import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../services/api";

function Restaurants() {
  const [restaurants, setRestaurants] = useState([]);

  useEffect(() => {
    api.get("/restaurants/all")
      .then(res => setRestaurants(res.data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div className="container my-4">
      <h3 className="mb-4">Top Restaurants</h3>

      <div className="row">
        {restaurants.map(r => (
          <div className="col-md-4 mb-4" key={r.id}>
            <Link
              to={`/restaurant/${r.id}`}
              className="text-decoration-none text-dark"
            >
              <div className="card restaurant-card">
                <img
                  src={r.imgUrl}
                  className="card-img-top restaurant-img"
                  alt={r.name}
                />
                <div className="card-body">
                  <h5>{r.name}</h5>
                  <p>{r.address}</p>
                  <p>⭐ {r.rating}</p>
                </div>
              </div>
            </Link>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Restaurants;
