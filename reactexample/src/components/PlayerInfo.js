import React from 'react';

import { Container, Row, Col } from 'react-bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css';

class PlayerInfo extends React.Component {

	render() {

		let {name, level, steps, health, gold, potions} = this.props;

		return(
			<Container>
				<Row>
					<Col>Name: </Col>
					<Col>{name}</Col>
				</Row>
				<Row>
					<Col>Level: </Col>
					<Col>{level}</Col>
				</Row>
				<Row>
					<Col>Steps: </Col>
					<Col>{steps}</Col>
				</Row>
				<Row>
					<Col>Health: </Col>
					<Col>{health}</Col>
				</Row>
				<Row>
					<Col>Gold: </Col>
					<Col>{gold}</Col>
				</Row>
				<Row>
					<Col>Potions: </Col>
					<Col>{potions}</Col>
				</Row>
			</Container>
			);
	}


}

export default PlayerInfo;