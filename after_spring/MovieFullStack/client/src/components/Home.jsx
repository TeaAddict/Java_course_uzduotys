import { useEffect, useState } from "react";
import { getAllBooks } from "../helpers/get";
import Book from "./book/Book";

const Home = ({ update, setUpdate }) => {
  const [books, setBooks] = useState();
  const [errors, setErrors] = useState();

  const getBooks = async () => {
    try {
      const newBooks = await getAllBooks();
      setBooks(newBooks);
    } catch (error) {
      console.error(error);
      setErrors(error);
    }
  };

  useEffect(() => {
    console.log("Rendering");
    getBooks();
  }, [update]);

  if (errors) return <p>{errors.message}</p>;
  if (!books) return <p>Problem getting books...</p>;

  return (
    <div className="overflow-auto">
      <div className="grid sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-3 xl:grid-cols-4 gap-5">
        {books.map((book, index) => (
          <Book
            data={book}
            key={book.title + index}
            update={update}
            setUpdate={setUpdate}
          />
        ))}
      </div>
    </div>
  );
};

export default Home;
