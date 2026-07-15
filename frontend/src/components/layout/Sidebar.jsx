import {
  LayoutDashboard,
  Users,
  Code2,
  BookOpen,
  BarChart3,
  Trophy,
  User,
  LogOut,
} from "lucide-react";

import { useNavigate } from "react-router-dom";

const menuItems = [
  {
    icon: LayoutDashboard,
    label: "Dashboard",
    path: "/dashboard",
  },
  {
    icon: Users,
    label: "Rooms",
    path: "/rooms",
  },
  {
    icon: Code2,
    label: "Compiler",
    path: "/compiler",
  },
  {
    icon: BookOpen,
    label: "Learning Sheets",
    path: "/learning",
  },
  {
    icon: BarChart3,
    label: "Progress",
    path: "/progress",
  },
  {
    icon: Trophy,
    label: "Leaderboard",
    path: "/leaderboard",
  },
  {
    icon: User,
    label: "Profile",
    path: "/profile",
  },
  {
    icon: LogOut,
    label: "Logout",
  },
];

function Sidebar() {
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("email");
    navigate("/");
  };

  return (
    <div className="w-64 h-screen bg-slate-900 text-white shadow-xl">

      <div className="text-3xl font-bold text-center py-8 border-b border-slate-700">
        CodeCollab
      </div>

      <div className="mt-6">

        {menuItems.map((item, index) => {

          const Icon = item.icon;

          return (

            <div
              key={index}
onClick={() => {

  console.log("Navigating to:", item.path);

  if (item.label === "Logout") {
    handleLogout();
  } else {
    navigate(item.path);
  }

}}
              className="flex items-center gap-4 px-6 py-4 hover:bg-blue-600 transition-all duration-300 cursor-pointer"
            >
              <Icon size={22} />
              <span>{item.label}</span>
            </div>

          );

        })}

      </div>

    </div>
  );
}

export default Sidebar;