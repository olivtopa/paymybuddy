import React from "react";
import TransactionScreen from "../transactions/transactions";

export default class LoginScreen extends React.Component {

	constructor(props) {
		super(props);
		this.state = { email: null, password: null, rememberMe: null, visible: false };

	}
	enterEmail = (email) => {
		console.log('your email: ' + email);
		this.setState(prevState => ({ ...prevState, email: String(email) }));
	}

	enterPassword = (password) => {
		this.setState(prevState => ({ ...prevState, password: String(password) }));
	}



	loginUser = (loginRequest) => {
		// TODO Cette méthode doit être liée au click bouton (regarder send_money.js pour des exemples de liaison)
		// récupérer du state email, password et remember me, puis avec ça,
		//  appeler le back-end (comme pour TransactionScreen.transferMoney)
		// En cas de réussite, appeler la méthode onLoginOk() du parent avec l'email de l'utilisateur.
		console.log(['login', loginRequest]);
		const loginEntity = this.state;
		axios.post('/api/login/' + loginEntity).then(() => {
			this.hideLoginScreen();
			this.displayTransactionScreen();
		});
	}
	displayTransactionScreen = () => {
		this.setState({ visible: true });
	}

	hideLoginScreen = () => {
		this.setState({ visible: false });
	}

	render() {

		return (
			<div>

				<input type="text" placeholder="Email" onInput={(e) => this.enterEmail(e.target.value)} />
				<input type="text" placeholder="Password" onInput={(e) => this.enterPassword(e.target.value)} />
				<button type="button" onClick={this.loginUser} className="btn btn-success">Login</button>

			</div>
		)
	}
}


