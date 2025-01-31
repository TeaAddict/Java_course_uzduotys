import axios from "axios";

const url = import.meta.env.VITE_URL;

export const getAllBooks = async () => {
  return (await axios.get(url)).data;
};

export const getOneBook = async (id) => {
  return (await axios.get(`${url}/${id}`)).data;
};
