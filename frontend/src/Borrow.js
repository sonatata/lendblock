import React from "react";
import { Button, InputGroup, FormControl, Jumbotron } from 'react-bootstrap';
import "./styles.css";

class Borrow extends React.Component {
  render() {
    return (
        // requested item
        // return date
        // deposit 
        <div className="borrow__container">
            <div className="borrow__borrow-form">
                <Jumbotron>
                <label >Item You'd Like to Borrow</label>
                <InputGroup className="mb-3">
                    <InputGroup.Prepend>
                    <InputGroup.Text id="basic-addon3">
                    </InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl id="basic-url" aria-describedby="basic-addon3" />
                </InputGroup>

                <label >Please Provide A Return Date (YYYY-MM-DD)</label>
                <InputGroup className="mb-3">
                    <InputGroup.Prepend>
                    <InputGroup.Text id="basic-addon3">
                    </InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl id="basic-url" aria-describedby="basic-addon3" />
                </InputGroup>

                <label >Please Provide A Deposit Amount</label>
                <InputGroup className="mb-3">
                    <InputGroup.Prepend>
                    <InputGroup.Text id="basic-addon3">
                    </InputGroup.Text>
                    </InputGroup.Prepend>
                    <FormControl id="basic-url" aria-describedby="basic-addon3" />
                </InputGroup>

                <Button> 
                    Ask To Borrow! 
                </Button>
                </Jumbotron>
            </div>
        </div>
        
    );
  }
}
export default Borrow;