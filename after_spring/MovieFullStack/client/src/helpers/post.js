import axios from "axios";

const url = import.meta.env.VITE_URL;

const postBook = async (data) => {
  return (await axios.post(url, data)).data;
};
export default postBook;
