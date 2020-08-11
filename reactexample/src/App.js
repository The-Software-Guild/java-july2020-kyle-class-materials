import React from 'react';
import './App.css';

import PlayerInfo from './components/PlayerInfo.js'

import { Container, Row, Col, Button } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';

class App extends React.Component {

  state = {
    name : "",
    level: 0,
    steps: 0,
    health: 10,
    gold : 0,
    potions : 1,
    maxHealth : 10,
    message : "",
    potionButton : "none",
    buyPotionButton : "none",
    goblins : 0
  }

  componentDidMount() {
    var promptedName = prompt("Enter your name")
    this.setState({ name : promptedName })
  }

  checkDrinkPotionDisplay(potions, health) {
    if(potions > 0 && health != this.state.maxHealth) {
      this.setState({potionButton: "block"})
    } else {
      this.setState({potionButton : "none"})
    }
  }

  step = () => {
    var steps = this.state.steps
    steps++

    var health = this.state.health
    var gold = this.state.gold
    var goblins = this.state.goblins
    var message = ""
    if(Math.random() > 0.5) { //No goblin
      if(health < this.state.maxHealth) {
        health++
      }
      message = "No goblin"
    } else { //Goblin
      message = "Goblin encountered (-2 health, +1 gold)"
      health -= 2
      gold++
      goblins++
    }

    this.setState({steps : steps, health : health, gold : gold, message : message, goblins : goblins})

    this.checkDrinkPotionDisplay(this.state.potions, health)

    if(steps%15 == 0) {
      this.setState({level : this.state.level + 1})
      if(gold >= 3 && this.state.potions < 5) {
        this.setState({buyPotionButton : "block"})
      }
    } else {
      if(this.state.buyPotionButton == "block") {
       this.setState({buyPotionButton : "none"})
      }
    }

    if(health <= 0) {
      var playAgain = window.confirm("Game over, would you like to play again?")
      console.log(playAgain)
      if(playAgain) {
        var promptedName = prompt("Enter your name")
        this.setState({name : promptedName, 
          level: 0,
          steps: 0,
          health: 10,
          gold : 0,
          potions : 1,
          message : "Starting new game", 
          goblins : 0})
      } else {
        document.getElementById("maingame").style.display = "none"
        document.getElementById("gameover").style.display = "block"
      }

    }

  }

  drink = () => {
    var health = this.state.health + 2
    if(health > this.state.maxHealth) {
      health = this.state.maxHealth
    }
    var potions = this.state.potions - 1

    this.setState({health : health, potions : potions, message : "Drank potion (+2 health)"})

    this.checkDrinkPotionDisplay(potions, health)
  }

  buy = () => {
    var gold = this.state.gold - 3;
    var potions = this.state.potions + 1

    this.setState({gold : gold, potions : potions, message : "Potion Purchased"})

    if(gold < 3 || potions >= 5) {
      this.setState({buyPotionButton : "none"})
    }

    this.checkDrinkPotionDisplay(potions, this.state.health)
  }




  render () {
    return (
      <div>
        <Container id="maingame">
          <h1>Goblin Tower</h1>
          <Row>
            <Col md={4} className='border'>
              <PlayerInfo
                name={this.state.name}
                level={this.state.level}
                steps={this.state.steps}
                health={this.state.health}
                gold={this.state.gold}
                potions={this.state.potions}/>
            </Col>
            <Col md={8} className='border'>
              <Row>
                <Button variant="primary" onClick={this.step}>Step</Button>
                <Button variant="secondary" onClick={this.drink} style={{display: this.state.potionButton}}>Drink Potion</Button>
                <Button variant="success" onClick={this.buy} style={{display : this.state.buyPotionButton}}>Buy Potion</Button>
              </Row>
              <Row>
                {this.state.message}
              </Row>
            </Col>
          </Row>
        </Container>
        <Container id="gameover" style={{display : "none"}}>
          <h1>Game Over</h1>
          <Row>
            <Col>Steps Taken:</Col><Col>{this.state.steps}</Col>
          </Row>
          <Row>
            <Col>Goblins Encountered:</Col><Col>{this.state.goblins}</Col>
          </Row>
          <Row>
            <Col>Gold Left to Heirs:</Col><Col>{this.state.gold}</Col>
          </Row>
        </Container>
      </div>
    );
  }
}

export default App;
