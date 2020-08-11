import React from 'react';
import { Form, Button } from 'react-bootstrap'

class PlatformAdd extends React.Component {

	render() {
		let { platform, platformSubmit, platformChange } = this.props
		return (
			<Form onSubmit={platformSubmit}>
				<Form.Group controlId="platform">
					<Form.Label>Platform Name</Form.Label>
					<Form.Control type="text" name="platform" 
						value={platform.platform} onChange={platformChange} />
				</Form.Group>
				<Button type="submit"> Add Platform </Button>
			</Form>

			)
	}
}

export default PlatformAdd