
import React from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import PrincipalPage from './components/PrincipalPage';
import Intermediate from './components/Intermediate';
import RegisterGame from './components/RegisterGame';
import ListaTareas from './components/ListaTareas';


function App() {


  return (
    <><PrincipalPage/>
        <BrowserRouter>
            <Routes>
               
                <Route
                    exact
                    path="/Intermediate"
                    element={<Intermediate/>}
                />
                <Route
                    exact
                    path="/RegisterGame"
                    element={<RegisterGame/>}
                />
                <Route
                    exact
                    path="/ListaTareas"
                    element={<ListaTareas/>}
                />
            </Routes>
        </BrowserRouter>
    </>
);
}

export default App;
