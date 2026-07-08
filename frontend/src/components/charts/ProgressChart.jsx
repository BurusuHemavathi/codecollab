import {
  LineChart,
  Line,
  XAxis,
  YAxis,
  Tooltip,
  ResponsiveContainer,
} from "recharts";

const data = [
  { day: "Mon", solved: 5 },
  { day: "Tue", solved: 8 },
  { day: "Wed", solved: 10 },
  { day: "Thu", solved: 7 },
  { day: "Fri", solved: 12 },
  { day: "Sat", solved: 15 },
  { day: "Sun", solved: 18 },
];

function ProgressChart() {
  return (
    <div className="bg-slate-900 rounded-2xl p-6 mt-8 shadow-lg">
      <h2 className="text-white text-2xl font-bold mb-6">
        Weekly Progress
      </h2>

      <ResponsiveContainer width="100%" height={300}>
        <LineChart data={data}>
          <XAxis dataKey="day" stroke="#ffffff" />
          <YAxis stroke="#ffffff" />
          <Tooltip />
          <Line
            type="monotone"
            dataKey="solved"
            stroke="#3B82F6"
            strokeWidth={4}
          />
        </LineChart>
      </ResponsiveContainer>
    </div>
  );
}

export default ProgressChart;