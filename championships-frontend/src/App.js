import React, { useEffect } from 'react';
import './App.css';
import PrincipalPage from './components/PrincipalPage';

function App() {

  if(localStorage.getItem("isLoggedIn") != "true"){
    localStorage.setItem("isLoggedIn", "false");
  }

  return (
    <div>
        <PrincipalPage/>
    </div>
    );
}

export default App;
