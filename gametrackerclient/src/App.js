import React from 'react';
import './App.css';

import { Container, Row, Col, Alert } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

import GameTable from './components/GameTable.js';
import AddGame from './components/AddGame.js';

class App extends React.Component {

  state = {
    games : [
      {
        id : 0,
        name : "TestName",
        genre : "TestGenre",
        publisher: "TestPublisher",
        releaseYear : 1980
      }
    ],
    newGame : {
      name : "",
      genre : "",
      publisher : "",
      releaseYear : ""
    },
    errorMessage : "",
    errorDisplay : "none"
  }

  componentDidMount() {
    this.loadGameData()
  }

  loadGameData() {
    fetch("http://localhost:8080/games")
      .then(response => response.json())
      .then(data => this.setState({ games : data}))
  }

  handleAddGameChange = (event) => {
    // console.log(event.target.value)
    // console.log(event.target.name)

    let inputName = event.target.name
    let inputValue = event.target.value
    let gameData = this.state.newGame

    if(gameData.hasOwnProperty(inputName)) {
      gameData[inputName] = inputValue
      this.setState({newGame : gameData})
    }
  }

  handleAddGameSubmit = (event) => {
    if(event) event.preventDefault();

    fetch("http://localhost:8080/game", {
      method : "POST",
      headers : {
        'Content-Type' : 'application/json'
      },
      body : JSON.stringify(this.state.newGame)
    }).then(response => {
      if(response.status == 201) {
        this.setState({newGame : {name : '', genre : '', publisher : '', releaseYear : ''}, errorMessage : "", errorDisplay : "none"})
        this.loadGameData()
      } else {
        response.json().then(data => { this.setState({errorMessage : data.message, errorDisplay : "block"}) })
      }
    })

  }

  render() {
    return (
      <Container>
        <Row>
          <h1>Game Tracker</h1>
        </Row>
        <Row>
          <Col>

            <Alert variant='danger' style={{display : this.state.errorDisplay}}>{this.state.errorMessage}</Alert>

          </Col>
        </Row>
        <Row>
          <Col>
            <AddGame newGameData = {this.state.newGame} 
              handleAddGameChange = {this.handleAddGameChange} 
              handleAddGameSubmit = {this.handleAddGameSubmit} />
          </Col>
        </Row>
        <Row>
          <Col> 
            <GameTable games={this.state.games}/>
          </Col>
        </Row>

      </Container>
    );
  }
}

export default App;
