import { useEffect, useState } from "react";
import api from "../services/api";

function Cart() {
  const [cart, setCart] = useState(null);

  useEffect(() => {
    api.get("/cart/1")
      .then(res => setCart(res.data))
      .catch(err => console.error(err));
  }, []);

  if (!cart) return <p>Loading...</p>;

  return (
    <div className="container my-5">
      <h3>Your Cart</h3>

      {cart.items.map(item => (
        <div key={item.foodItemId}>
          Food ID: {item.foodItemId} | Qty: {item.quantity} | ₹{item.price}
        </div>
      ))}
    </div>
  );
}

export default Cart;
