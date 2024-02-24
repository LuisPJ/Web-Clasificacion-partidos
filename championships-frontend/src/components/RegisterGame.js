import React, { useEffect, useState} from 'react';
import axios from 'axios';
import { Button, Dropdown, Modal, Toast, ToastContainer } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import './RegisterGame.css';
import CustomErrorMessage from './CustomErrorMessage';


const RegisterGame = () => {
    const [teams, setTeams] = useState([]);
    const [options, setOptions] = useState([]);
    const [team1, setTeam1] = useState(null);
    const [team2, setTeam2] = useState(null);
    const [resultOptions] = useState(["VICTORIA","DERROTA","EMPATE"]);
    const [selectedResult,setSelectedResult]= useState(null);
    const [isDropDownTeam1Open, setIsDropDownTeam1Open] = useState(false);
    const [errorMessage, setErrorMessage] = useState('');
    const [showErrorMessage, setShowErrorMessage] = useState(false);
    const [showToast, setShowToast] = useState(false);

    const handleSave= async () => {

        if(team1 === team2 || team1 == null || team2 == null){
          setErrorMessage("Select 2 different teams");
          setShowErrorMessage(true);
        }else if (selectedResult == null){
          setErrorMessage("Select a result");
          setShowErrorMessage(true);
        }else{ 
          try {
            
            // Your data to be sent in the request body
            const postData = {
              // Add your data properties here
              team1: teams.find((option)=> option.nombreEquipo === team1),
              team2: teams.find((option)=> option.nombreEquipo === team2),
              result: selectedResult
            };
      
            // Make a POST request using Axios
            const response = await axios.post('http://localhost:8080/api/v1/register-game', postData);
            
            // Handle the response as needed
            console.log('Response:', response.data);
      
            setShowErrorMessage(false);
            setShowToast(true);

            setTeam1(null);
            setTeam2(null);
            setSelectedResult(null);
            
            // Optionally, you can perform additional actions after a successful save
          } catch (error) {
            // Handle errors
            console.error('Error saving data:', error.message);
          }
        }
      };
    
    useEffect(() => {
      // Fetch data from the backend
      const fetchData = async () => {
        try {
          const response = await axios.get('http://localhost:8080/api/v1/teams'); // Replace with your actual backend endpoint
          setTeams(response.data);
          setOptions(response.data.map((team)=>{return team.nombreEquipo;}));
        } catch (error) {
          console.error('Error fetching data:', error);
        }
      };
  
      fetchData();
    }, []); // Empty dependency array means this effect will run once when the component mounts
  
    const handleSelectTeam1 = (selectedValue) => {
        setTeam1(selectedValue);
        // You can perform additional actions on selection if needed
    };
    const handleSelectTeam2 = (selectedValue) => {
        setTeam2(selectedValue);
        // You can perform additional actions on selection if needed
    };
    const handleSelectResult = (selectedValue) => {
        setSelectedResult(selectedValue);
        // You can perform additional actions on selection if needed
    };

    const handleDropdownTeam1Toggle = () => {
      setIsDropDownTeam1Open(!isDropDownTeam1Open);
    };

    const handleDropdownTeam1Close = () => {
      setIsDropDownTeam1Open(false);
    };

    return (
      <div>
      <div className="centeredDiv">

        <div>
          <h4>Register Game</h4>
        </div>
      
        <div className="line"/>

          <CustomErrorMessage 
              show={showErrorMessage} title='Invalid Input' 
              message={errorMessage} onCloseError={()=>{setShowErrorMessage(false)}}/>

          <div style={{display:"flex"}}>
          
            <Dropdown show={isDropDownTeam1Open} onToggle={handleDropdownTeam1Toggle}
              onSelect={handleSelectTeam1} style={{margin:'5px'}}>

                <Dropdown.Toggle variant="dark" id="dropdown-basic">
                    {team1 ? team1 : 'Select team'}
                </Dropdown.Toggle>

                <Dropdown.Menu  style={{ maxHeight: '200px', overflowY: 'scroll' }} onBlur={handleDropdownTeam1Close}>
                    {options.map((option, index) => (
                        <Dropdown.Item key={index} eventKey={option}>
                            {option}
                        </Dropdown.Item>
                    ))}
                </Dropdown.Menu>
            </Dropdown>


            <Dropdown onSelect={handleSelectTeam2} style={{margin:'5px'}}>
                <Dropdown.Toggle variant="dark" id="dropdown-basic">
                    {team2 ? team2 : 'Select team'}
                </Dropdown.Toggle>

                <Dropdown.Menu style={{ maxHeight: '200px', overflowY: 'scroll' }} >
                    {options.map((option, index) => (
                        <Dropdown.Item key={index} eventKey={option}>
                            {option}
                        </Dropdown.Item>
                    ))}
                </Dropdown.Menu>
            </Dropdown>
            
            <Dropdown onSelect={handleSelectResult} style={{margin:'5px'}}>
                <Dropdown.Toggle variant="dark" id="dropdown-basic">
                    {selectedResult ? selectedResult : 'select result'}
                </Dropdown.Toggle>

                <Dropdown.Menu>
                    {resultOptions.map((option, index) => (
                        <Dropdown.Item key={index} eventKey={option}>
                            {option}
                        </Dropdown.Item>
                    ))}
                </Dropdown.Menu>
            </Dropdown>
            
            <Button variant='outline-success' onClick={handleSave}>Save</Button>
            
          </div>
          
        </div>
       

      <ToastContainer
          className="p-3"
          position={'middle-center'}
          style={{ zIndex: 1 }}
        >
          <Toast onClose={() => setShowToast(false)} show={showToast} delay={2000} autohide
            className="d-inline-block m-1"
            bg={'success'}
          >
            <Toast.Header>
              <strong className="me-auto">Register Game</strong>
            </Toast.Header>
            <Toast.Body>Game saved successfully!</Toast.Body>
          </Toast>
        </ToastContainer>
    </div>
        
    );
};

export default RegisterGame;