import React from 'react';

import {Form, Button, Row, Col} from 'react-bootstrap';

class AddGame extends React.Component {
	render() {
		let {newGameData, handleAddGameChange, handleAddGameSubmit} = this.props;
		return(
			<Form onSubmit={handleAddGameSubmit} >
				<Form.Group as={Row} controlId="name">
					<Form.Label column md={3}>Name: </Form.Label>
					<Col md={9}>
						<Form.Control type="text" name="name"
							value = {newGameData.name}
							onChange = {handleAddGameChange}/>
					</Col>
				</Form.Group>
				<Form.Group as={Row} controlId="genre">
					<Form.Label column md={3}>Genre: </Form.Label>
					<Col md={9}>
						<Form.Control type="text" name="genre"
							value = {newGameData.genre}
							onChange = {handleAddGameChange}/>
					</Col>
				</Form.Group>
				<Form.Group as={Row} controlId="publisher">
					<Form.Label column md={3}>Publisher: </Form.Label>
					<Col md={9}>
						<Form.Control type="text" name="publisher"
							value = {newGameData.publisher}
							onChange = {handleAddGameChange}/>
					</Col>
				</Form.Group>
				<Form.Group as={Row} controlId="releaseYear">
					<Form.Label column md={3}>Release Year: </Form.Label>
					<Col md={9}>
						<Form.Control type="number" name="releaseYear"
							value = {newGameData.releaseYear}
							onChange = {handleAddGameChange}/>
					</Col>
				</Form.Group>
				<Button variant="secondary" type="submit">Add Game</Button>
			</Form>
		);
	}
}

export default AddGame;