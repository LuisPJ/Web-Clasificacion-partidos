import { Navigate, Outlet } from "react-router-dom";

const LoggedRoute = ({flag = "true"}) => {
    const isLoggedIn = localStorage.getItem("isLoggedIn");
    return (isLoggedIn == flag ?  <Outlet/>: <Navigate to={"/"} replace/>); 
};

export default LoggedRoute;