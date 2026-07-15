import {
  Users,
  Lock,
  Globe,
  Copy,
  ArrowRight
} from "lucide-react";

function RoomCard({ room }) {

  const copyRoomCode = () => {
    navigator.clipboard.writeText(room.roomCode);
    alert("Room Code Copied");
  };

  return (
    <div className="bg-slate-900 rounded-3xl border border-slate-700 hover:border-blue-500 hover:-translate-y-2 transition-all duration-300 shadow-xl p-6">

      {/* Header */}

      <div className="flex justify-between items-center">

        <div>

          <h2 className="text-2xl font-bold text-white">
            {room.roomName}
          </h2>

          <p className="text-slate-400 mt-1">
            {room.description}
          </p>

        </div>

        {room.privateRoom ? (
          <Lock className="text-red-400" />
        ) : (
          <Globe className="text-green-400" />
        )}

      </div>

      {/* Members */}

      <div className="flex items-center gap-2 mt-6 text-slate-300">

        <Users size={18} />

        <span>
          {room.totalMembers} Members
        </span>

      </div>

      {/* Room Code */}

      <div className="mt-6 flex justify-between items-center bg-slate-800 rounded-xl px-4 py-3">

        <span className="text-blue-400 font-semibold tracking-wider">
          {room.roomCode}
        </span>

        <button onClick={copyRoomCode}>
          <Copy
            size={18}
            className="hover:text-blue-400"
          />
        </button>

      </div>

      {/* Footer */}

      <div className="mt-8 flex justify-between items-center">

        <span className="text-slate-400">
          Owner
        </span>

        <span className="text-white font-semibold">
          {room.ownerEmail}
        </span>

      </div>

      <button
        className="mt-6 w-full bg-blue-600 hover:bg-blue-700 rounded-xl py-3 flex justify-center items-center gap-2 text-white font-semibold transition-all"
      >
        Enter Room
        <ArrowRight size={18} />
      </button>

    </div>
  );
}

export default RoomCard;