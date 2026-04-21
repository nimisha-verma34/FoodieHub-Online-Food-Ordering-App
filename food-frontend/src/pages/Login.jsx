import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import axios from "axios";

function Login() {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    username: "",
    password: "",
    role: ""
  });

  const [error, setError] = useState("");

  const handleLogin = async (e) => {
    e.preventDefault();
    setError("");

    if (!form.username || !form.password || !form.role) {
      setError("All fields are required");
      return;
    }

    try {
      const res = await axios.post(
        "http://localhost:8083/users/login",
        form,
        { headers: { "Content-Type": "application/json" } }
      );

      alert(res.data);

      // Example role-based navigation (optional)
      if (form.role === "ADMIN") {
        navigate("/admin");
      } else {
        navigate("/restaurants");
      }

    } catch {
      setError("Invalid credentials");
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center vh-100">
      <div className="card p-4 shadow" style={{ width: 350 }}>
        <h4 className="text-center mb-3">Login</h4>

        {error && <div className="alert alert-danger">{error}</div>}

        <input
          className="form-control mb-2"
          placeholder="Username"
          onChange={(e) =>
            setForm({ ...form, username: e.target.value })
          }
        />

        <input
          type="password"
          className="form-control mb-2"
          placeholder="Password"
          onChange={(e) =>
            setForm({ ...form, password: e.target.value })
          }
        />

        {/* Role Field */}
        <select
          className="form-control mb-3"
          onChange={(e) =>
            setForm({ ...form, role: e.target.value })
          }
        >
          <option value="">Select Role</option>
          <option value="Customer">Customer</option>
          <option value="Restaurant Owner">Restaurant Owner</option>
          <option value="Delivery Agent">Delivery Agent</option>
        </select>

        <button className="btn btn-warning w-100" onClick={handleLogin}>
          Login
        </button>

        <p className="text-center mt-2">
          New user? <Link to="/signup">Sign up</Link>
        </p>
      </div>
    </div>
  );
}

export default Login;
