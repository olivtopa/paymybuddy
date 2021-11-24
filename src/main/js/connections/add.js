import React from "react";
import axios from "axios";

export default class AddConnectionPopup extends React.Component {

	constructor(props) {
		super(props);
		this.state = { emailContact: null, connection: null, };
	}

	enterEmailContact = (emailContact) => {
		console.log('your new email contact: ' + emailContact);
		this.setState(prevState => ({ ...prevState, emailContact: String(emailContact) }));
	}

	enterConnection = (connection) => {
		console.log('your new connection: ' + connection);
		this.setState(prevState => ({ ...prevState, connection: String(connection) }));
	}

	hideAddConnection = () => {
		this.props.hideAddConnection();
	}

	addAConnection = () => {
		console.log(['Adding connection', this.state]);
		const entity = { emailOrigin: this.props.emailOrigin, emailContact: this.state.emailContact, name: this.state.connection };
		axios.post('api/contacts', entity).then(() => {
			this.hideAddConnection();
		});
	}


	render() {

		if (this.props.visible) {
			return (
				<div>
					<h3>Add a new connection</h3>
					<form>
						<input type="text" placeholder="Contact's Email "onInput={(e) => this.enterEmailContact(e.target.value)} />
						<input type="text" placeholder= "Name" onInput={(e) => this.enterConnection(e.target.value)} />
						<button type="button" onClick={this.addAConnection} className="btn btn primary">Submit</button>
						<button type="button" onClick={this.hideAddConnection}>Hide</button>
					</form>
				</div>
			)
		} else {
			return (<div />);
		}
	}
}
