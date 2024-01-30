import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Navbar, Nav } from 'react-bootstrap';
import { BrowserRouter , Route,  Routes } from 'react-router-dom';
import AdminLogin from '../AdminLogin/AdminLogin';
import { useState, useEffect } from 'react';


const TeamTable = () => {
  const [teams, setTeams] = useState([]);

  useEffect(() => {
    // Fetch data from the API
    fetch('http://localhost:8080/api/v1/teams')
      .then((response) => response.json())
      .then((data) => setTeams(data))
      .catch((error) => console.error('Error fetching data:', error));
  }, []);

  return (
    <div className="container mt-5">
      <h2>Team Table</h2>
      <table className="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Team Name</th>
            <th>Matches Played</th>
            <th>Victories</th>
            <th>Defeats</th>
            <th>Draws</th>
            <th>Points</th>
          </tr>
        </thead>
        <tbody>
          {teams.map((team) => (
            <tr key={team.idTeam}>
              <td>{team.idTeam}</td>
              <td>{team.nombreEquipo}</td>
              <td>{team.numeroDePartidosJugados}</td>
              <td>{team.numeroVictorias}</td>
              <td>{team.numeroDerrotas}</td>
              <td>{team.numeroEmpates}</td>
              <td>{team.puntos}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

const PrincipalPage = () => {
    return (
      
      <div>
        <Navbar bg="dark" variant="dark">
          <Navbar.Brand>Championship</Navbar.Brand>
          <Nav className="ml-auto">
            <Nav.Link href="/home">Home</Nav.Link>
            <Nav.Link href="/AdminLogin">Login</Nav.Link>
          </Nav>
        </Navbar>
      <BrowserRouter> 
        <Routes> 
        <Route path="/AdminLogin" element={<AdminLogin/>} />
         <Route path="/home" element={<TeamTable/>} />  
        </Routes>
     
      </BrowserRouter>
       </div>
   
  );
  };
  
  export default PrincipalPage;
  