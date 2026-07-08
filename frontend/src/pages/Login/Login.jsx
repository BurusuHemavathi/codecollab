import { Mail, Lock, Eye, EyeOff } from "lucide-react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
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
    try {
      const response = await api.post("/api/users/login", loginData);

   localStorage.setItem("token", response.data.token);
localStorage.setItem("email", loginData.email);

      alert("Login Successful");

      navigate("/dashboard");
    } catch (error) {
      alert("Invalid Email or Password");
    }
  };

  return (
    <div className="min-h-screen bg-slate-950 flex">
      {/* Left Section */}
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

      {/* Right Section */}
      <div className="w-1/2 flex items-center justify-center">
        <div className="w-[430px] bg-slate-900 rounded-3xl p-10 shadow-2xl">
          <h2 className="text-4xl text-white font-bold mb-8 text-center">
            Login
          </h2>

          {/* Email */}
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
              className="w-full bg-slate-800 rounded-xl py-4 pl-12 pr-4 text-white outline-none border border-slate-700 focus:border-blue-500"
            />
          </div>

          {/* Password */}
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
              className="w-full bg-slate-800 rounded-xl py-4 pl-12 pr-12 text-white outline-none border border-slate-700 focus:border-blue-500"
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

          {/* Login Button */}
          <button
            onClick={handleLogin}
            className="w-full bg-blue-600 hover:bg-blue-700 transition-all rounded-xl py-4 text-white font-bold text-lg"
          >
            Login
          </button>

          <p className="text-center text-gray-400 mt-6">
            Don't have an account?
            <span className="text-blue-500 cursor-pointer ml-2">
              Register
            </span>
          </p>
        </div>
      </div>
    </div>
  );
}

export default Login;