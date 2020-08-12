import React from 'react';

import { Table } from 'react-bootstrap';

class GameTable extends React.Component {

	render() {
		let { games } = this.props;
		return (
			<Table striped>
				<thead>
					<tr>
						<th>Name</th>
						<th>Genre</th>
						<th>Publisher</th>
						<th>Release Year</th>
					</tr>
				</thead>
				<tbody>
					{games.map((game, i) => {
						return (
							<tr key={i}>
								<td>{game.name}</td>
								<td>{game.genre}</td>
								<td>{game.publisher}</td>
								<td>{game.releaseYear}</td>
							</tr>
							)
					})}
				</tbody>
			</Table>
		)
	}
}

export default GameTable;