import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Route, Routes } from 'react-router-dom';
import AdminLogin from '../components/AdminLogin';
import { useState, useEffect, useRef } from 'react';
import CustomNavbar from './CustomNavbar';
import RegisterGame from './RegisterGame';
import ListaTareas from './ListaTareas';
import LoggedRoute from './LoggedRoute';

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

    const isLoggedIn = localStorage.getItem("isLoggedIn");

    return ( 
      <div>
        <CustomNavbar/>
        <Routes>
            <Route path="" element={<TeamTable/>}/>
            <Route element={<LoggedRoute flag="false"/>}>
              <Route path="AdminLogin" element={<AdminLogin/>}/> 
            </Route>

            <Route element={<LoggedRoute flag="true"/>}>
              <Route path="RegisterGame" element={<RegisterGame/>} />
              <Route path="ListaTareas"  element={<ListaTareas/>} />
            </Route>
        </Routes>
      </div>
    );
  };
  export default PrincipalPage;
  