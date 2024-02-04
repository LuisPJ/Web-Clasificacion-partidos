import { AvField, AvForm, AvGroup } from "availity-reactstrap-validation";
import axios from "axios";
import React, { useRef } from "react";
import { Button, Col, Container, Row } from "reactstrap";

const ListaTareas = () => {
    let form = useRef();

    const onSubmit = (values) => {
        console.log(values);
        
        axios.post('http://localhost:8080/api/v1/register', values)
        .then((response)=>{
          console.log(response);
          window.alert("Team registered!");
        })
        .catch((error) => {
          console.error("Error en el servidor");
        });
    }

    return(

        <>
        <Container>
          <Row>
            <Col>
            <div>
                <h3 className="mb-3">Registrar nuevo equipo</h3>
                <AvForm ref = {c => (form = c)} onValidSubmit={(_,values) => onSubmit(values)}>
                    <AvGroup className="mb-3">
                        <AvField name = "nombreEquipo" label="Nombre"></AvField>
                    </AvGroup>
                    <div className="text-end">
                        <Button color="primary">Guardar</Button>
                    </div>
                </AvForm>
            </div>
            </Col>
          </Row>
        </Container>
      </>
        
    );
}

export default ListaTareas;