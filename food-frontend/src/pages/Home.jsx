import "../styles/Home.css";
import { Link } from "react-router-dom";

function Home() {
  return (
    <>
      
      <section className="hero">
        <div className="container hero-inner">
          <div className="row align-items-center">
            <div className="col-md-6 hero-text">
              <h1>Delicious food — delivered fast</h1>
              <p>
                Order from nearby restaurants and get piping hot meals at your door.
              </p>
              <div className="d-flex gap-3">
                <Link to="/restaurants" className="btn btn-warning">
                  Order Now
                </Link>
                <a href="#how" className="btn btn-outline-light">
                  How it works
                </a>
              </div>
            </div>

            <div className="col-md-6">
              <div className="hero-image"></div>
            </div>
          </div>
        </div>
      </section>


      <section id="how" className="container features my-5">
        <div className="row text-center">
          <div className="col-md-4">
            <img src="https://cdn-icons-png.flaticon.com/512/3595/3595455.png" />
            <h4>Fast Delivery</h4>
            <p>Real-time tracking and quick delivery</p>
          </div>

          <div className="col-md-4">
            <img src="https://cdn-icons-png.flaticon.com/512/1046/1046784.png" />
            <h4>Top Restaurants</h4>
            <p>Carefully curated restaurants</p>
          </div>

          <div className="col-md-4">
            <img src="https://cdn-icons-png.flaticon.com/512/857/857681.png" />
            <h4>Easy Ordering</h4>
            <p>One-tap reorder & multiple payments</p>
          </div>
        </div>
      </section>

      
      <section className="container my-5">
        <h2>Popular right now</h2>

        <div className="row mt-4">
          {[
            { name: "Margherita Pizza", price: "₹299", img: "pizza" },
            { name: "Cheesy Burger", price: "₹199", img: "burger" },
            { name: "Sushi Platter", price: "₹499", img: "sushi" },
          ].map((item, i) => (
            <div className="col-md-4" key={i}>
              <div className="card shadow-sm">
                <img
                  src={`https://source.unsplash.com/600x400/?${item.img}`}
                  className="card-img-top"
                />
                <div className="card-body">
                  <h5>{item.name}</h5>
                  <p>{item.price}</p>
                  <button className="btn btn-warning btn-sm">
                    Add to cart
                  </button>
                </div>
              </div>
            </div>
          ))}
        </div>
      </section>
    </>
  );
}

export default Home;
