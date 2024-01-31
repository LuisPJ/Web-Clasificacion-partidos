// RegisterGame.js
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Button, Dropdown, Modal } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';


const RegisterGame = () => {
    const [options, setOptions] = useState(["monkeys", "5", "4", "3", "1", "2"]);
    const [team1, setTeam1] = useState(null);
    const [team2, setTeam2] = useState(null);
    const [resultOptions, setResultOption] = useState(["VICTORIA","DERROTA","EMPATE"]);
    const [selectedResult,setSelectedResult]= useState(null);
    const handleSave= async () => {
        try {
          // Your data to be sent in the request body
          const postData = {
            // Add your data properties here
            title: 'Example Title',
            content: 'Example Content',
          };
    
          // Make a POST request using Axios
          const response = await axios.post('YOUR_API_ENDPOINT', postData);
          
          // Handle the response as needed
          console.log('Response:', response.data);
    
          // Optionally, you can perform additional actions after a successful save
        } catch (error) {
          // Handle errors
          console.error('Error saving data:', error.message);
        }
      };
    
    /*useEffect(() => {
      // Fetch data from the backend
      const fetchData = async () => {
        try {
          const response = await axios.get('YOUR_BACKEND_ENDPOINT'); // Replace with your actual backend endpoint
          setOptions(response.data);
        } catch (error) {
          console.error('Error fetching data:', error);
        }
      };
  
      fetchData();
    }, []); // Empty dependency array means this effect will run once when the component mounts
  */
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

    return (
        <div
      className="modal show"
      style={{ display: 'block', /*position: 'initial'*/ }}
    >
      <Modal.Dialog>
        <Modal.Header closeButton>
          <Modal.Title>Register Game</Modal.Title>
        </Modal.Header>

        <Modal.Body>
        <div /*className="row"*/ style={{display:"flex"}}>
            <div /*className='col-md-6'*/>
                <Dropdown onSelect={handleSelectTeam1} style={{margin:'5px'}}>
                    <Dropdown.Toggle variant="dark" id="dropdown-basic">
                        {team1 ? team1 : 'Select team'}
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        {options.map((option, index) => (
                            <Dropdown.Item key={index} eventKey={option}>
                                {option}
                            </Dropdown.Item>
                        ))}
                    </Dropdown.Menu>
                </Dropdown>

            </div>
            <div /*className='col-md-6'*/>
            <Dropdown onSelect={handleSelectTeam2} style={{margin:'5px'}}>
                <Dropdown.Toggle variant="dark" id="dropdown-basic">
                    {team2 ? team2 : 'Select team'}
                </Dropdown.Toggle>

                <Dropdown.Menu>
                    {options.map((option, index) => (
                        <Dropdown.Item key={index} eventKey={option}>
                            {option}
                        </Dropdown.Item>
                    ))}
                </Dropdown.Menu>
            </Dropdown>
            </div>
            <div /*className='col-md-6'*/>
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
            </div>
            <Button variant='outline-success' onClick={handleSave}>Save</Button>
        </div>
        </Modal.Body>
      </Modal.Dialog>
    </div>
        
    );
};

export default RegisterGame;