import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import axios from "axios";

function Signup() {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    username: "",
    email: "",
    password: "",
    role: ""
  });

  const [error, setError] = useState("");

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const validate = () => {
    if (!form.username || !form.email || !form.password || !form.role) {
      return "All fields are required";
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(form.email)) {
      return "Invalid email format";
    }

    if (form.password.length < 6) {
      return "Password must be at least 6 characters";
    }

    return "";
  };

  const handleSubmit = async () => {
    const validationError = validate();
    if (validationError) {
      setError(validationError);
      return;
    }

    try {
      const res = await axios.post(
        "http://localhost:8083/users/register",
        form,
        { headers: { "Content-Type": "application/json" } }
      );

      alert(`Welcome ${res.data.username}, you signed up successfully!`);
      navigate("/restaurants");

    } catch (err) {
      setError("User already exists or server error");
    }
  };

  return (
    <div className="d-flex justify-content-center align-items-center vh-100">
      <div className="card p-4 shadow" style={{ width: "380px" }}>
        <h4 className="text-center mb-3">Create Account</h4>

        {error && <div className="alert alert-danger">{error}</div>}

        <input
          className="form-control mb-2"
          placeholder="Username"
          name="username"
          onChange={handleChange}
        />

        <input
          className="form-control mb-2"
          placeholder="Email"
          name="email"
          onChange={handleChange}
        />

        <input
          type="password"
          className="form-control mb-2"
          placeholder="Password"
          name="password"
          onChange={handleChange}
        />

        {/* Role Dropdown */}
        <select
          className="form-control mb-3"
          name="role"
          onChange={handleChange}
        >
          <option value="">Select Role</option>
          <option value="Customer">Customer</option>
          <option value="Restaurant Owner">Restaurant Owner</option>
          <option value="Delivery Agent">Delivery Agent</option>
        </select>

        <button className="btn btn-warning w-100" onClick={handleSubmit}>
          Sign Up
        </button>

        <p className="text-center mt-2">
          Already have an account? <Link to="/login">Login</Link>
        </p>
      </div>
    </div>
  );
}

export default Signup;
