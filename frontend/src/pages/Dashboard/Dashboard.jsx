import StatCard from "../../components/cards/StatCard";
import ProgressChart from "../../components/charts/ProgressChart";

function Dashboard() {
  return (
    <>

      <h1 className="text-4xl font-bold text-white mb-8">
        Welcome Back 👋
      </h1>

      <div className="grid grid-cols-4 gap-6">

        <StatCard
          title="Learning Sheets"
          value="18"
          color="bg-blue-600"
        />

        <StatCard
          title="Rooms"
          value="5"
          color="bg-green-600"
        />

        <StatCard
          title="Problems Solved"
          value="210"
          color="bg-purple-600"
        />

        <StatCard
          title="Bookmarks"
          value="42"
          color="bg-red-600"
        />

      </div>

    </>
  );
}

export default Dashboard;