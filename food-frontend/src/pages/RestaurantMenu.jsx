import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import api from "../services/api";

import axios from "axios";

const addToCart = async (item) => {
  const userId = 1; 

  await axios.post(
    `http://localhost:8083/cart/${userId}/add`,
    {
      foodItemId: item.id,
      quantity: 1,
      price: item.price
    }
  );

  alert("Item added to cart");
};


function RestaurantMenu() {
  const { id } = useParams();
  const [items, setItems] = useState([]);

  useEffect(() => {
    api.get(`/restaurants/${id}/items`)
      .then(res => setItems(res.data))
      .catch(err => console.error(err));
  }, [id]);

  return (
    <div className="container my-4">
      <h3 className="mb-4">Menu</h3>

      <div className="row">
        {items.map(item => (
          <div className="col-md-4 mb-3" key={item.id}>
            <div className="card food-card">
              <img
                src={item.imgUrl}
                className="card-img-top food-img"
                alt={item.name}
              />
              <div className="card-body">
                <h5>{item.name}</h5>
                <p>{item.description}</p>
                <p>₹{item.price}</p>
                <button
  className="btn btn-warning"
  onClick={() => addToCart(item)}
>
  Add to Cart
</button>

              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
}

export default RestaurantMenu;
