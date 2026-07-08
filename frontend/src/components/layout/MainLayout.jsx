import Sidebar from "./Sidebar";
import Navbar from "./Navbar";
import Dashboard from "../../pages/Dashboard/Dashboard";

function MainLayout() {
  return (
    <div className="flex bg-slate-950 min-h-screen">

      <Sidebar />

      <div className="flex-1 flex flex-col">

        <Navbar />

<main className="flex-1 p-8 bg-slate-950 overflow-auto">
    <Dashboard />
</main>

      </div>

    </div>
  );
}

export default MainLayout;