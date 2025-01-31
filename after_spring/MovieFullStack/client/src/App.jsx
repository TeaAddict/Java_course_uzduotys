import { Routes, Route } from "react-router";
import "./App.css";
import NotFound from "./components/NotFound";
import Main from "./components/Main";
import RegistrationForm from "./components/book/RegistrationForm";
import Home from "./components/Home";
import { useState } from "react";

function App() {
  const [update, setUpdate] = useState(0);
  return (
    <Routes>
      <Route path="/" element={<Main />}>
        <Route index element={<Home update={update} setUpdate={setUpdate} />} />
        <Route
          path="register"
          element={<RegistrationForm setUpdate={setUpdate} />}
        />
      </Route>
      <Route path="*" element={<NotFound />} />
    </Routes>
  );
}

export default App;
