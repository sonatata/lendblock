import React from "react";
import styled from "styled-components";
import { withRR4, Nav, NavIcon } from "react-sidenav";
import { Icon } from "react-icons-kit";
import { ic_home as home } from "react-icons-kit/md/ic_home";
import { ic_reorder as simple } from "react-icons-kit/md/ic_reorder";
import { ic_donut_large as render } from "react-icons-kit/md/ic_donut_large";
import { cubes } from "react-icons-kit/fa/cubes";

const Text = styled.div`
  padding-left: 8px;
`;

const theme = {
  hoverBgColor: "#f5f5f5",
  selectionBgColor: "#f5f5f5",
  selectionIconColor: "#03A9F4"
};

const SideNav = withRR4();

export class AppNavigation extends React.Component {
  render() {
    return (
      <SideNav theme={theme} defaultSelectedPath={"home"}>
        <Nav id="home">
          <NavIcon>
            <Icon icon={home} />
          </NavIcon>
          <Text>Home</Text>
        </Nav>
        <Nav id="Borrow">
          <NavIcon>
            <Icon icon={simple} />
          </NavIcon>
          <Text>Borrow A Thing!</Text>
        </Nav>
        <Nav id="Lend">
          <NavIcon>
            <Icon icon={render} />
          </NavIcon>
          <Text>Lend A Thing!</Text>
        </Nav>
        <Nav id="Transactions">
          <NavIcon>
            <Icon icon={cubes} />
          </NavIcon>
          <Text>Transactions</Text>
        </Nav>
      </SideNav>
    );
  }
}
