import React from "react";
import { Table } from 'react-bootstrap';
import "./styles.css";


class Lend extends React.Component {
  render() {
    return (
        <div className="lend__container">
            <Table striped bordered hover variant="dark">
                <thead class="thead-dark">
                    <tr>
                    <th>#</th>
                    <th></th>
                    <th>Name</th>
                    <th></th>
                    <th>Item</th>
                    <th>ReturnDate</th>
                    <th>Deposit</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                    <td>1</td>
                    <th></th>
                    <td>Mark</td>
                    <th></th>
                    <th>Toothbrush</th>
                    <td>2019-4-5</td>
                    <td>@mdo</td>
                    </tr>
                    <tr>
                    <td>2</td>
                    <th></th>
                    <td>Jacob</td>
                    <th></th>
                    <th>Pan</th>
                    <td>2019-4-5</td>
                    <td>@fat</td>
                    </tr>
                    <tr>
                    <td>3</td>
                    <th></th>
                    <td >Larry </td>
                    <th></th>
                    <th>Pot</th>
                    <td>2019-4-5</td>
                    <td>@twitter</td>
                    </tr>
                </tbody>
            </Table>
        </div>
    );
  }
}
export default Lend;