import { useNavigate } from 'react-router-dom';
import React from 'react';
import { Button } from 'react-bootstrap';

const Intermediate = () => {
    const navigate=useNavigate();
    const handleRedirectToLink1 = () => {
        
        navigate("/RegisterGame");
    };

    const handleRedirectToLink2 = () => {
       
        navigate("/ListaTareas");
    };

    return (
        <div>
            <Button variant='primary' onClick={handleRedirectToLink1}>puntuacion de equipos</Button>
            <Button variant='primary' onClick={handleRedirectToLink2}>registrar equipos</Button>
        </div>
    );
}

export default Intermediate;