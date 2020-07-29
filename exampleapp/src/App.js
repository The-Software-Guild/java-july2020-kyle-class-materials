import React from 'react';
import './App.css';
import GameTable from './components/GameTable'
import PlatformTable from './components/PlatformRow'
import PlatformAdd from './components/PlatformAdd'

import { Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';

class App extends React.Component {

  state = {
    platforms : [
      {
        "id" : 1,
        "platform" : "Test Platform"
      }
    ],
    games: [
      {
        "id" : 1,
        "name" : "TestGame",
        "genre" : "TestGenre",
        "releaseYear" : 1980,
        "publisher" : {
          "id" : 1,
          "publisher": "Test Publisher",
          "country" : "Test Country"   
        },
        "platforms": [
          {
            "id" : 1,
            "platform" : "Test Platform"
          }
        ]
      }
    ],
    newPlatform : {
      platform : ""
    }
  }

  componentDidMount() {
    this.loadGameData()
    this.loadPlatformData()
  }

  loadGameData() {
    fetch("http://localhost:8080/games")
    .then(data => data.json())
    .then(data => this.setState({games : data}))
  }

  loadPlatformData() {
    fetch("http://localhost:8080/platforms")
    .then(data => data.json())
    .then(data => this.setState({platforms : data}))
  }

  handlePlatformSubmit = (event) => {
    console.log(JSON.stringify(this.state.newPlatform))
    if(event) event.preventDefault();
    fetch("http://localhost:8080/platform", {
      method : 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body : JSON.stringify(this.state.newPlatform)
    })
    .then(data => {
      this.setState({newPlatform : { platform : ''}})
      this.loadPlatformData()
    })
    .catch((error) => {
      console.log("error adding")
      console.log(error)
    })
  }

  handlePlatformChange = (event) => {
    let inputName = event.target.name;
    let inputValue = event.target.value;
    let platformData = this.state.newPlatform;

    console.log(inputName)
    console.log(inputValue)

    if(platformData.hasOwnProperty(inputName)) {
      platformData[inputName] = inputValue;
      this.setState({newPlatform : platformData})
    }
  }

  render () {
    return (
      <Container>
        <Row>
          <GameTable games={this.state.games}/>
        </Row>
        <Row>
          <PlatformTable platforms={this.state.platforms}/>
        </Row>
        <Row>
          <PlatformAdd platform={this.state.newPlatform} 
            platformSubmit={this.handlePlatformSubmit} 
            platformChange={this.handlePlatformChange} />
        </Row>
      </Container>
    );
  }
}

export default App;
