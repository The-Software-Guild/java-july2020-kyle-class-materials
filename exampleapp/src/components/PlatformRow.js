import React from 'react';
import {Table} from 'react-bootstrap';

const PlatformTable = ({platforms}) => {
	return (
		<Table striped border hover>
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
				</tr>
			</thead>
			<tbody>
				{platforms.map((platform, i) => {
					return <PlatformRow platform = {platform} key = {i}/>
				})}
			</tbody>
		</Table>
		)
}

const PlatformRow = ({platform}) => {
	return (
		<tr>
			<td>{platform.id}</td>
			<td>{platform.platform}</td>
		</tr>
		)
}

export default PlatformTable






