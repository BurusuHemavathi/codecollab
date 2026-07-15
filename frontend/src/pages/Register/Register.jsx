import { User, Mail, Lock, Eye, EyeOff } from "lucide-react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../services/api";

function Register() {

    const navigate = useNavigate();

    const [showPassword, setShowPassword] = useState(false);

    const [user, setUser] = useState({
        name: "",
        email: "",
        password: ""
    });

    const handleChange = (e) => {
        setUser({
            ...user,
            [e.target.name]: e.target.value
        });
    };

    const handleRegister = async () => {

        try {

            await api.post("/api/users/register", user);

            alert("Registration Successful");

            navigate("/");

        } catch (error) {

            console.log(error);

            alert("Registration Failed");

        }

    };

    return (

        <div className="min-h-screen bg-slate-950 flex">

            {/* Left Section */}

            <div className="w-1/2 flex flex-col justify-center px-20">

                <h1 className="text-6xl font-bold text-white mb-6">
                    Join CodeCollab
                </h1>

                <p className="text-xl text-gray-400 leading-9">
                    Create your account.
                    <br />
                    Join coding rooms.
                    <br />
                    Learn together.
                    <br />
                    Crack placements.
                </p>

            </div>

            {/* Right Section */}

            <div className="w-1/2 flex justify-center items-center">

                <div className="bg-slate-900 rounded-3xl shadow-2xl p-10 w-[430px]">

                    <h2 className="text-white text-4xl font-bold text-center mb-8">
                        Register
                    </h2>

                    {/* Name */}

                    <div className="relative mb-5">

                        <User
                            className="absolute left-4 top-4 text-gray-400"
                            size={20}
                        />

                        <input
                            type="text"
                            name="name"
                            placeholder="Name"
                            value={user.name}
                            onChange={handleChange}
                            className="w-full bg-slate-800 border border-slate-700 rounded-xl py-4 pl-12 pr-4 text-white outline-none focus:border-green-500"
                        />

                    </div>

                    {/* Email */}

                    <div className="relative mb-5">

                        <Mail
                            className="absolute left-4 top-4 text-gray-400"
                            size={20}
                        />

                        <input
                            type="email"
                            name="email"
                            placeholder="Email"
                            value={user.email}
                            onChange={handleChange}
                            className="w-full bg-slate-800 border border-slate-700 rounded-xl py-4 pl-12 pr-4 text-white outline-none focus:border-green-500"
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
                            placeholder="Password"
                            value={user.password}
                            onChange={handleChange}
                            className="w-full bg-slate-800 border border-slate-700 rounded-xl py-4 pl-12 pr-12 text-white outline-none focus:border-green-500"
                        />

                        <button
                            type="button"
                            className="absolute right-4 top-4 text-gray-400"
                            onClick={() => setShowPassword(!showPassword)}
                        >
                            {showPassword ? <EyeOff size={20} /> : <Eye size={20} />}
                        </button>

                    </div>

                    {/* Register Button */}

                    <button
                        onClick={handleRegister}
                        className="w-full bg-green-600 hover:bg-green-700 transition-all rounded-xl py-4 text-white font-bold text-lg"
                    >
                        Create Account
                    </button>

                    <p className="text-center text-gray-400 mt-6">
                        Already have an account?
                        <span
                            onClick={() => navigate("/")}
                            className="text-green-500 cursor-pointer ml-2"
                        >
                            Login
                        </span>
                    </p>

                </div>

            </div>

        </div>

    );

}

export default Register;