import { useEffect, useState } from "react";
import updateData from "../../helpers/update";
import Modal from "../Modal";
import RegistrationForm from "./RegistrationForm";
import { getOneBook } from "../../helpers/get";

const Book = ({ data, update, setUpdate }) => {
  const [book, setBook] = useState(data);
  const { id, title, author, category, price, cover, reserved } = book;

  const handleUpdateBook = async () => {
    await updateData(id, { reserved: !reserved });
    setBook({ ...data, reserved: !reserved });
  };

  const getBook = async (id) => {
    setBook(await getOneBook(id));
  };

  useEffect(() => {
    getBook(id);
  }, [id, update]);

  return (
    <div className="card bg-base-100 w-56 shadow-xl">
      <figure>
        <img src={cover} alt="book cover" />
      </figure>
      <div className="card-body">
        <p className="font-bold">{title}</p>
        <p>{author}</p>
        <p>{category}</p>
        <p className="text-red-400">{price} €</p>
        <div className="card-actions justify-end">
          <button
            onClick={handleUpdateBook}
            className={`btn btn-primary ${reserved && "btn-outline"}`}
          >
            {reserved ? "Grąžinti" : "Išduoti"}
          </button>
          <Modal buttonText="Edit" modalId={data.id}>
            <RegistrationForm data={data} setUpdate={setUpdate} />
          </Modal>
        </div>
      </div>
    </div>
  );
};

export default Book;
