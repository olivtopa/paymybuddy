import React from "react";

// TODO
export default class AddConnectionPopup extends React.Component {

	constructor(props) {
		super(props);
		this.state = {emailOrigin: null, emailContact: null, connection: null };
	}

	enterEmailOrigin = (emailOrigin) => {
		console.log('your new email: ' + emailOrigin);
		this.setState(prevState => ({ ...prevState, emailOrigine: String(emailOrigin) }));
	}
	
	enterEmailContact = (emailContact) => {
		console.log('your new email contact: ' + emailContact);
		this.setState(prevState => ({ ...prevState, emailContact: String(emailContact) }));
	}

	enterConnection = (connection) => {
		console.log('your new connection: ' + connection);
		this.setState(prevState => ({ ...prevState, connection: String(connection) }));
	}



	addAConnection = (connectionRequest) => {
		console.log(['Adding connection', connectionRequest]);
		const entity = { emailOrigin:connectionRequest.emailOrigin, emailContact: connectionRequest.emailContact, connection: connectionRequest.connection };
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
					<input type="text" onInput={(e) => this.enterEmailOrigin(e.target.value)} />
					<input type="text" onInput={(e) => this.enterEmailContact(e.target.value)} />
					<input type="text" onInput={(e) => this.enterConnection(e.target.value)} />
					<button>Submit</button>
				</form>
			</div>
		)
	}
}
