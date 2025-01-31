/** @type {import('tailwindcss').Config} */
import forms from "@tailwindcss/forms";
import daisyui from "daisyui";

export default {
  content: ["./index.html", "./src/**/*.{js,ts,jsx,tsx}"],
  theme: {
    extend: {},
  },
  plugins: [forms, daisyui],
  safelist: ["btn-primary", "btn-outline"],
};
