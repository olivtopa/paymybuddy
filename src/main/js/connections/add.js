import React from "react";

// TODO
export default class AddConnectionPopup extends React.Component {
	
	constructor (props) {
		super(props);
		this.state = {emailContact:null, connection:null};
	}
	
	enterEmailContact = (emailContact) => {
		console.log('your new email contact: '+ emailContact);
		this.setState(prevState => ({...prevState, contactEmail: String(contactEmail)}));
	}
	
	enterConnection = (connection) => {
		console.log('your new connection: '+ connection);
		this.setState(prevState => ({...prevState, connection: String(connection)}));
	}
	
	

	addConnection = (connectionRequest) => {
		console.log(['Adding connection', connectionRequest]);
		const entity = {emailContact:connectionRequest.emailContact, connection:connectionRequest.connection};
		axios.post('/addContact', entity).then(() => {
			console.log('connection added');
		}
		
		)
	}


render() {

	return (
		<div>
			<h1>Add a new connection</h1>
			<form>
				<input type="text" onInput={(e) => this.enterEmailContact(e.target.value)}/>
				<input type="text" onInput={(e) => this.enterConnection(e.target.value)}/>
				<button>Submit</button>
			</form>
		</div>
	)
}
}
