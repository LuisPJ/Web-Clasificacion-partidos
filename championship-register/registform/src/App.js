import logo from './logo.svg';
import './App.css';
import {Col, Container, Row } from 'reactstrap';
import ListaTareas from './ListaTareas';
import axios from 'axios';

function App() {

  const onSubmit = (values) => {
    axios.post('http://localhost:8080/api/v1/register', values)
    .then((response)=>{console.log(response)})
    .catch((error) => {
      console.error("Error en el servidor");
    });
  }

  return (
    <>
      <Container>
        <Row>
          <Col>
            <ListaTareas onSubmit={onSubmit}/>
          </Col>
        </Row>
      </Container>
    </>
  );
}

export default App;
