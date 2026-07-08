import { Bell, Search, Moon } from "lucide-react";

function Navbar() {
  return (
    <div className="h-20 bg-slate-900 border-b border-slate-700 flex items-center justify-between px-8">
      <h2 className="text-2xl font-bold text-white">
        Dashboard
      </h2>

      <div className="flex items-center gap-6 text-white">
        <Search className="cursor-pointer hover:text-blue-500" />
        <Bell className="cursor-pointer hover:text-blue-500" />
        <Moon className="cursor-pointer hover:text-blue-500" />

        <div className="w-10 h-10 rounded-full bg-blue-600 flex items-center justify-center font-bold">
          H
        </div>
      </div>
    </div>
  );
}

export default Navbar;