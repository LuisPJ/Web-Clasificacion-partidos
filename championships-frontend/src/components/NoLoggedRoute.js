import { Navigate, Outlet } from "react-router-dom";

const NoLoggedRoute = ({isLoggedIn, path = "/"}) => {
    return (isLoggedIn ==="false" ?  <Outlet/>: <Navigate to={path} replace/>); 
};

export default NoLoggedRoute;