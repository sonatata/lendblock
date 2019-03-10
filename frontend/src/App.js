import React from "react";

import { AppNavigation } from "./AppNavigation";
import { MemoryRouter as Router, Route, Switch } from "react-router-dom";

import { AppContainer, Navigation, Body, Title } from "./containers";

import { cubes } from "react-icons-kit/fa/cubes";

import Home from "./Home";
import Borrow from "./Borrow";
import Lend from "./Lend";
import Transactions from "./Transactions";
import { Icon } from "react-icons-kit";

import "./styles.css"

class App extends React.Component {
  render() {
    return (
      <AppContainer>
        <Navigation>
          <div className="titleContainer">
            <Icon icon={cubes} />
            <Title> LendBlock </Title>
          </div>
          
          <AppNavigation />
        </Navigation>
        <Body>
          <Switch>
            <Route path="//Transactions" component={Transactions} />
            <Route path="//borrow" component={Borrow} />
            <Route path="//Lend" component={Lend} />
            <Route path="/" exact component={Home} />
          </Switch>
        </Body>
      </AppContainer>
    );
  }
}

export const createApp = () => {
  return class SideNavApp extends React.Component {
    render() {
      return (
        <Router>
          <App />
        </Router>
      );
    }
  };
};
