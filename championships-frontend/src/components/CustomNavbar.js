import React from 'react';
import { Navbar as  BootstrapNavbar, Nav } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const CustomNavbar = () => {

    const navigate = useNavigate();

    const handleLogout = () => {
        localStorage.setItem("isLoggedIn", "false");
        navigate("/");
    };

    return (
        <div>
        <BootstrapNavbar bg="dark" variant="dark">
          <BootstrapNavbar.Brand>Championship</BootstrapNavbar.Brand>
          <Nav className="ml-auto">
            <Nav.Link href="/">Home</Nav.Link>
            {
            localStorage.getItem("isLoggedIn") === "true" ?
                (<>
                    <Nav.Link href="/RegisterGame">Register Game</Nav.Link>
                    <Nav.Link href="/ListaTareas">Register Team</Nav.Link>
                    <Nav.Link onClick={handleLogout}>Logout</Nav.Link>
                </>)
                :   (<>
                    
                    <Nav.Link href="/AdminLogin">Login</Nav.Link>
                </>)
            }        
          </Nav>
        </BootstrapNavbar>
        </div>
    );
  };
  
  export default CustomNavbar;