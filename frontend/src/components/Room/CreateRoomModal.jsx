import { X } from "lucide-react";
import { useState } from "react";
import api from "../../services/api";

function CreateRoomModal({ closeModal }) {
  const [room, setRoom] = useState({
    roomName: "",
    description: "",
    sheetId: "",
    isPrivate: false,
  });

  const handleChange = (e) => {
    setRoom({
      ...room,
      [e.target.name]:
        e.target.type === "checkbox"
          ? e.target.checked
          : e.target.value,
    });
  };

const handleCreate = async () => {

  try {

    const request = {
      roomName: room.roomName,
      createdBy: localStorage.getItem("email"),
    };

    const response = await api.post(
      "/api/rooms/create",
      request
    );

    alert(response.data);

    closeModal();

  } catch (error) {

    console.log(error);

    alert("Room Creation Failed");

  }

};

  return (
    <div className="fixed inset-0 bg-black/70 flex justify-center items-center z-50">
      <div className="bg-slate-900 w-[520px] rounded-3xl p-8 shadow-2xl">
        <div className="flex justify-between items-center mb-8">
          <h1 className="text-3xl font-bold text-white">
            Create Room
          </h1>

          <button onClick={closeModal}>
            <X className="text-white" />
          </button>
        </div>

        <input
          type="text"
          name="roomName"
          placeholder="Room Name"
          value={room.roomName}
          onChange={handleChange}
          className="w-full mb-5 bg-slate-800 p-4 rounded-xl text-white outline-none"
        />

        <textarea
          name="description"
          placeholder="Description"
          rows="4"
          value={room.description}
          onChange={handleChange}
          className="w-full mb-5 bg-slate-800 p-4 rounded-xl text-white outline-none"
        />

        <select
          name="sheetId"
          value={room.sheetId}
          onChange={handleChange}
          className="w-full mb-5 bg-slate-800 p-4 rounded-xl text-white outline-none"
        >
          <option value="">Select Learning Sheet</option>
          <option value="1">Java Interview Prep</option>
          <option value="2">Spring Boot</option>
          <option value="3">React</option>
        </select>

        <div className="flex items-center gap-3 mb-8">
          <input
            type="checkbox"
            name="isPrivate"
            checked={room.isPrivate}
            onChange={handleChange}
          />

          <span className="text-white">
            Private Room
          </span>
        </div>

        <div className="flex justify-end gap-4">
          <button
            onClick={closeModal}
            className="px-6 py-3 rounded-xl bg-slate-700 text-white"
          >
            Cancel
          </button>

          <button
            onClick={handleCreate}
            className="px-6 py-3 rounded-xl bg-blue-600 hover:bg-blue-700 text-white"
          >
            Create Room
          </button>
        </div>
      </div>
    </div>
  );
}

export default CreateRoomModal;