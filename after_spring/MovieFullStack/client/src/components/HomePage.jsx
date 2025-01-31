import { Link } from "react-router";

const HomePage = () => {
  return (
    <div>
      <h1>Welcome to Homepage</h1>
      <nav className="flex gap-2">
        <Link to="/blog">Blog</Link>
        <Link to="/about">About</Link>
      </nav>
    </div>
  );
};

export default HomePage;
