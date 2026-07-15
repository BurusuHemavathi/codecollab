import { Mail, Lock, Eye, EyeOff } from "lucide-react";
import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import api from "../../services/api";

function Login() {
  const navigate = useNavigate();

  const [showPassword, setShowPassword] = useState(false);

  const [loginData, setLoginData] = useState({
    email: "",
    password: "",
  });

  const handleChange = (e) => {
    setLoginData({
      ...loginData,
      [e.target.name]: e.target.value,
    });
  };

  const handleLogin = async () => {

    // IMPORTANT
    console.log("Sending Login Data :", loginData);

    try {
      const response = await api.post("/api/users/login", loginData);

      localStorage.setItem("token", response.data.token);
      localStorage.setItem("email", loginData.email);

      alert("Login Successful");

      navigate("/dashboard");

    } catch (error) {

      console.log("Axios Error :", error);
      console.log("Response :", error.response);
      console.log("Response Data :", error.response?.data);

      alert(error.response?.data?.message || "Login Failed");
    }
  };

  return (
    <div className="min-h-screen bg-slate-950 flex">

      <div className="w-1/2 flex flex-col justify-center px-20">

        <h1 className="text-6xl font-bold text-white mb-6">
          CodeCollab
        </h1>

        <p className="text-xl text-gray-400 leading-9">
          Practice DSA together.
          <br />
          Solve problems.
          <br />
          Track your team's progress.
          <br />
          Collaborate in real-time.
        </p>

      </div>

      <div className="w-1/2 flex items-center justify-center">

        <div className="w-[430px] bg-slate-900 rounded-3xl p-10 shadow-2xl">

          <h2 className="text-4xl font-bold text-white text-center mb-8">
            Login
          </h2>

          <div className="relative mb-6">

            <Mail
              className="absolute left-4 top-4 text-gray-400"
              size={20}
            />

            <input
              type="email"
              name="email"
              value={loginData.email}
              onChange={handleChange}
              placeholder="Email"
              className="w-full bg-slate-800 rounded-xl py-4 pl-12 pr-4 text-white border border-slate-700 outline-none focus:border-blue-500"
            />

          </div>

          <div className="relative mb-6">

            <Lock
              className="absolute left-4 top-4 text-gray-400"
              size={20}
            />

            <input
              type={showPassword ? "text" : "password"}
              name="password"
              value={loginData.password}
              onChange={handleChange}
              placeholder="Password"
              className="w-full bg-slate-800 rounded-xl py-4 pl-12 pr-12 text-white border border-slate-700 outline-none focus:border-blue-500"
            />

            <button
              type="button"
              onClick={() => setShowPassword(!showPassword)}
              className="absolute right-4 top-4 text-gray-400"
            >
              {showPassword ? (
                <EyeOff size={20} />
              ) : (
                <Eye size={20} />
              )}
            </button>

          </div>

          <button
            onClick={handleLogin}
            className="w-full bg-blue-600 hover:bg-blue-700 transition rounded-xl py-4 text-white font-bold"
          >
            Login
          </button>

          <p className="text-center text-gray-400 mt-6">
            Don't have an account?{" "}
            <Link
              to="/register"
              className="text-blue-500 hover:underline"
            >
              Register
            </Link>
          </p>

        </div>

      </div>

    </div>
  );
}

export default Login;