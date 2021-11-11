import React from "react";

export default class LoginScreen extends React.Component {

	constructor(props) {
		super(props);
		this.state = { email: null, password: null, rememberMe: null };

	}

	loginUser = (loginRequest) => {
		// TODO Cette méthode doit être liée au click bouton (regarder send_money.js pour des exemples de liaison)
		// récupérer du state email, password et remember me, puis avec ça,
		//  appeler le back-end (comme pour TransactionScreen.transferMoney)
		// En cas de réussite, appeler la méthode onLoginOk() du parent avec l'email de l'utilisateur.
		console.log(['login',loginRequest]);
		const loginEntity = {email:loginRequest.email, password:loginRequest.password};
		axios.post('')

		enterEmail = (email) => {
			console.log('your email: ' + email);
			this.setState(prevState => ({ ...prevState, String: String(email) }));
		}

		enterPassword = (password) => {
			this.setState(prevState => ({ ...prevState, amount: String(password) }));
		}

	}

	render() {

		return (
			<div>
				<h1>Pay My Buddy</h1>
				<input type="text" onInput={(e) => this.enterEmail(e.target.value)} />
				<input type="text" onInput={(e) => this.enterPassword(e.target.value)} />
				<button className="btn btn-success" type="button" onClick={this.loginUser}>Login</button>
				{/* TODO ajouter le champ password, la checkbox remember me et le bouton login. Des exemples sont visibles dans la partie transaction */}
			</div>
		)
	}
}
