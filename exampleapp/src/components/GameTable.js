import React from 'react';
import {Table} from 'react-bootstrap';

const GameTable = ({games}) => {
	return (
		<Table striped border hover>
			<thead>
				<tr>
					<th>Name</th>
					<th>Genre</th>
					<th>Release Year</th>
					<th>Publisher</th>
				</tr>
			</thead>
			<tbody>
				{games.map((game, i) => {
					return <GameRow game = {game} key = {i}/>
				})}
			</tbody>
		</Table>
	)
}

const GameRow = ({game}) => {
	return (
		<tr>
			<td>{game.name}</td>
			<td>{game.genre}</td>
			<td>{game.releaseYear}</td>
			<td>{game.publisher.publisher}</td>
		</tr>
	)
}

export default GameTable

