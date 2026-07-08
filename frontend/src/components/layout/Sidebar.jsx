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

const menuItems = [
  { icon: LayoutDashboard, label: "Dashboard" },
  { icon: Users, label: "Rooms" },
  { icon: Code2, label: "Compiler" },
  { icon: BookOpen, label: "Learning Sheets" },
  { icon: BarChart3, label: "Progress" },
  { icon: Trophy, label: "Leaderboard" },
  { icon: User, label: "Profile" },
  { icon: LogOut, label: "Logout" },
];

function Sidebar() {
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