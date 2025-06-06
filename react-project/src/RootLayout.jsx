import { Outlet } from "react-router-dom";
import { Link } from "react-router-dom";

const RootLayout = () => {
  return (
    <div>
      <header>
        <Link to="/">"Adopt Me!"</Link>
      </header>
      <Outlet />
    </div>
  );
};

export default RootLayout;
