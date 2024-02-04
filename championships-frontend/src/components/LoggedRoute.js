import { Navigate, Outlet } from "react-router-dom";

const LoggedRoute = ({isLoggedIn, path = "/"}) => {
    return (isLoggedIn === "true" ?  <Outlet/>: <Navigate to={path} replace/>); 
};

export default LoggedRoute;