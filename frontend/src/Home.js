import React from "react";
import { Table, Jumbotron } from 'react-bootstrap';
import "./styles.css";

class Home extends React.Component {
  render() {
    return (
      // profile pic
      // name 
      // Community Id
      // History
      <div className="home__container">
        <Jumbotron>

        <span>Sonata Katt</span>
        </Jumbotron>
        
        <span>CommunityId: 0938432</span>
        <div>
          <span>
            History of Transactions
          </span>
          <Table striped bordered hover variant="dark">
          <thead>
            <tr>
              <th>#</th>
              <th>Name</th>
              <th>ReturnDate</th>
              <th>Deposit</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1</td>
              <td>Mark</td>
              <td>Otto</td>
              <td>@mdo</td>
            </tr>
            <tr>
              <td>2</td>
              <td>Jacob</td>
              <td>Thornton</td>
              <td>@fat</td>
            </tr>
            <tr>
              <td>3</td>
              <td colSpan="2">Larry the Bird</td>
              <td>@twitter</td>
            </tr>
          </tbody>
        </Table>

        </div>
      </div>
        
    );
  }
}
export default Home;