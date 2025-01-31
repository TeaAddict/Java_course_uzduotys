import axios from "axios";

const url = import.meta.env.VITE_URL;

const updateBook = async (id, data) => {
  return (await axios.patch(`${url}/${id}`, data)).data;
  // return (await axios.put(`${url}/${id}`, data)).data;
};
export default updateBook;
