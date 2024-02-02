import { AvField, AvForm, AvGroup } from "availity-reactstrap-validation";
import React, { useRef } from "react";
import { Button } from "reactstrap";

const ListaTareas = ({onSubmit}) => {
    let form = useRef();

    const _onSubmit = (values) => {
        onSubmit(values);
        form.reset();
    }

    return(
        <div>
            <h3 className="mb-3">Registrar nuevo equipo</h3>
            <AvForm ref = {c => (form = c)} onValidSubmit={(_,values) => _onSubmit(values)}>
                <AvGroup className="mb-3">
                    <AvField name = "nombreDeEquipo" label="Nombre"></AvField>
                </AvGroup>
                <div className="text-end">
                    <Button color="primary">Guardar</Button>
                </div>
            </AvForm>
        </div>
    );
}

export default ListaTareas;