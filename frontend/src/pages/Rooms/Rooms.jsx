import { Plus, Users, Lock, Globe } from "lucide-react";
import { useState } from "react";
import CreateRoomModal from "../../components/Room/CreateRoomModal";
function Rooms() {

  const [showModal, setShowModal] = useState(false);

  console.log("showModal =", showModal);

  const rooms = [
    {
      id: 1,
      name: "Java DSA Batch",
      members: 18,
      private: false,
    },
    {
      id: 2,
      name: "Spring Boot",
      members: 9,
      private: true,
    },
    {
      id: 3,
      name: "React Team",
      members: 14,
      private: false,
    },
    {
      id: 4,
      name: "Placement Preparation",
      members: 26,
      private: true,
    },
  ];

  return (
    <div className="p-10 bg-slate-950 min-h-screen text-white">

      {/* Header */}

      <div className="flex justify-between items-center mb-10">

        <div>

          <h1 className="text-4xl font-bold">
            Coding Rooms
          </h1>

          <p className="text-slate-400 mt-2">
            Join coding rooms and collaborate with your teammates.
          </p>

        </div>

        <button
          onClick={() => {
            console.log("Button Clicked");
            setShowModal(true);
          }}
          className="bg-blue-600 hover:bg-blue-700 px-6 py-3 rounded-xl flex items-center gap-2 transition-all"
        >
          <Plus size={20} />
          Create Room
        </button>

      </div>

      {/* Rooms */}

      <div className="grid grid-cols-2 gap-8">

        {rooms.map((room) => (

          <div
            key={room.id}
            className="bg-slate-900 rounded-2xl p-6 border border-slate-700 hover:border-blue-500 hover:scale-105 transition-all duration-300 shadow-lg"
          >

            <div className="flex justify-between items-center">

              <h2 className="text-2xl font-semibold">
                {room.name}
              </h2>

              {room.private ? (
                <Lock className="text-red-400" />
              ) : (
                <Globe className="text-green-400" />
              )}

            </div>

            <div className="flex items-center gap-2 mt-5 text-slate-400">

              <Users size={18} />

              <span>{room.members} Members</span>

            </div>

            <button
              className="mt-8 w-full bg-blue-600 hover:bg-blue-700 py-3 rounded-xl font-semibold transition-all"
            >
              Join Room
            </button>

          </div>

        ))}

      </div>

      {showModal && (
        <CreateRoomModal
          closeModal={() => setShowModal(false)}
        />
      )}

    </div>
  );
}

export default Rooms;