function StatCard({ title, value, color }) {
  return (
    <div
      className={`rounded-2xl p-6 shadow-lg hover:scale-105 transition duration-300 ${color}`}
    >
      <h3 className="text-lg text-white">{title}</h3>

      <h1 className="text-4xl font-bold text-white mt-4">
        {value}
      </h1>
    </div>
  );
}

export default StatCard;