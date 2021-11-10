import React from "react";

// TODO
export default class AddConnectionPopup extends React.Component {

	state = {
		contacts: []
	}


render() {

	return (
		<div>
			<h1>Add a new connection</h1>
			<form>
				<input type="email" placeholder="Email du contact" />
				<button>Submit</button>
			</form>
		</div>
	)
}
}
