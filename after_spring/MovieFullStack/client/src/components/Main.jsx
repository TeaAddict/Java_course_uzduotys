import { Outlet } from "react-router";
import Header from "./Header";
import Footer from "./Footer";

const Main = () => {
  return (
    <div className="grid grid-[1rem_1fr_auto] h-[100vh] bg-base-100">
      <Header />
      <div className="p-5 justify-self-center">
        <Outlet />
      </div>
      <Footer />
    </div>
  );
};

export default Main;
