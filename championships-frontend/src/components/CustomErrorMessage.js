import { useState } from 'react';
import Alert from 'react-bootstrap/Alert';
import Button from 'react-bootstrap/Button';

const CustomErrorMessage = ({show, title = "Error", message = "Something went wrong", onCloseError}) => {

  if (show) {
    return (
      <Alert variant="danger" onClose={onCloseError} dismissible>
        <Alert.Heading>{title}</Alert.Heading>
        <p>
          {message}
        </p>
      </Alert>
    );
  }
  return <></>
};

export default CustomErrorMessage;