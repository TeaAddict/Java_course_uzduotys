import { useForm } from "react-hook-form";
import updateBook from "../../helpers/update";
import postBook from "../../helpers/post";
import toast from "react-hot-toast";
import { useNavigate } from "react-router";
import { useEffect, useState } from "react";
import { getAllBooks } from "../../helpers/get";

const RegistrationForm = ({ data, setUpdate }) => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm({
    defaultValues: {
      title: data?.title || "",
      author: data?.author || "",
      category: data?.category || "",
      price: data?.price || "",
      cover: data?.cover || "",
    },
  });
  const navigate = useNavigate();
  const [categories, setCategories] = useState();

  const handleFormSubmit = async (formData) => {
    try {
      if (data) {
        await updateBook(data.id, formData);
        toast.success("Successfully updated a book!");
        document.getElementById(`my-modal-${data.id}`).close();
      } else {
        await postBook(formData);
        toast.success("Successfully added a book!");
        navigate("/");
      }
      setUpdate((update) => update + 1);
    } catch (error) {
      console.error(error);
      toast.error("Problem submitting...");
    }
  };

  const getCategories = async () => {
    const books = await getAllBooks();
    const categories = books
      .map((book) => book.category)
      .filter((val, index, array) => {
        return array.indexOf(val) === index;
      });
    setCategories(categories);
  };

  useEffect(() => {
    getCategories();
  }, []);

  if (!categories) return <p>Problem with getting categories</p>;

  return (
    <div className="">
      <h1 className="justify-self-center text-2xl mb-5">
        {data ? "Edit book" : "Add book"}
      </h1>
      <div className="flex justify-center">
        <form
          onSubmit={handleSubmit(handleFormSubmit)}
          className="flex flex-col gap-3"
        >
          <div className="flex flex-col">
            <label className="flex flex-col justify-between">
              Title
              <input
                {...register("title", {
                  required: "Title is required",
                  minLength: {
                    value: 3,
                    message: "Min title length is 3 symbols",
                  },
                  maxLength: {
                    value: 100,
                    message: "Max title length is 100 symbols",
                  },
                })}
                placeholder="Enter title"
              />
            </label>
            {errors.title && (
              <p className="text-red-500 flex justify-center">
                {errors.title.message}
              </p>
            )}
          </div>
          <div className="flex flex-col">
            <label className="flex flex-col justify-between">
              Author
              <input
                {...register("author", {
                  required: "Author is required",
                  pattern: {
                    value: /^[a-zA-Z\s]*$/,
                    message: "Only letters and spaces allowed",
                  },
                })}
                placeholder="Enter author"
              />
            </label>
            {errors.author && (
              <p className="text-red-500 flex justify-center">
                {errors.author.message}
              </p>
            )}
          </div>
          <div className="flex flex-col">
            <label className="flex flex-col justify-between">
              Category
              <select
                {...register("category", { required: "Select a category" })}
              >
                <option value="">Select category</option>
                {categories?.map((category) => (
                  <option value={category} key={category}>
                    {category}
                  </option>
                ))}
              </select>
            </label>
            {errors.category && (
              <p className="text-red-500 flex justify-center">
                {errors.category.message}
              </p>
            )}
          </div>
          <div className="flex flex-col">
            <label className="flex flex-col justify-between">
              Price
              <input
                {...register("price", {
                  required: "Price is required",
                  pattern: {
                    value: /^[+]?([.]\d+|\d+[.]?\d*)$/,
                    message: "Prices has to be positive",
                  },
                })}
                placeholder="Enter price"
              />
            </label>
            {errors.price && (
              <p className="text-red-500 flex justify-center">
                {errors.price.message}
              </p>
            )}
          </div>
          <div className="flex flex-col">
            <label className="flex flex-col justify-between">
              Cover
              <input
                {...register("cover", {
                  required: "Cover is required",
                  pattern: {
                    value:
                      //eslint-disable-next-line
                      /^(https?:\/\/)?([\da-z\.-]+)\.([a-z\.]{2,6})([\/\w \.-]*)*\/?$/,
                    message: "Cover format incorrect",
                  },
                })}
                placeholder="Enter cover"
              />
            </label>
            {errors.cover && (
              <p className="text-red-500 flex justify-center">
                {errors.cover.message}
              </p>
            )}
          </div>
          <button className="btn btn-primary mt-4">Submit</button>
        </form>
      </div>
    </div>
  );
};

export default RegistrationForm;
