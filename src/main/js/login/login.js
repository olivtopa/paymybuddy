import React from "react";
import axios from "axios";

export default class LoginScreen extends React.Component {

	constructor(props) {
		super(props);
		this.state = { email: null, password: null, rememberMe: false, visible: false };

	}
	enterEmail = (email) => {
		console.log('your email: ' + email);
		this.setState(prevState => ({ ...prevState, email: String(email) }));
	}

	enterPassword = (password) => {
		this.setState(prevState => ({ ...prevState, password: String(password) }));
	}
	
	rememberMe = () => {
		this.setState(prevState => ({ ...prevState, rememberMe:!prevState.rememberMe }));
	}



	loginUser = (loginRequest) => {
		//Cette méthode est liée au click bouton
		// récupérer du state email, password et remember me, puis avec ça,
		//  appele le back-end
		// En cas de réussite, appele la méthode onLoginOk() du parent avec l'email de l'utilisateur.
		console.log(['login', loginRequest]);
		const loginEntity = this.state;
		axios.post('/api/login/', loginEntity).then(() => {
			this.props.onLoginOk(loginEntity.email, loginEntity.rememberMe)

		});
	}

	render() {

		return (
			<div style={{ display: 'flex', justifyContent: 'center' }}>
				<div style={{ display: 'flex', flexDirection: 'column', width: '800px', paddinigTop: '200ox', alignItems: 'center' }}>

					<p>Pay My Buddy</p>
					<input type="text" placeholder="Email" onInput={(e) => this.enterEmail(e.target.value)} />
					<input type="text" placeholder="Password" onInput={(e) => this.enterPassword(e.target.value)} />
					<div style={{ display: 'flex' }}>
						<input type="checkbox" onClick={() => this.rememberMe()} />
						<p>Remember Me</p>
					</div>
					<button type="button" onClick={this.loginUser} className="btn btn-success">Login</button>
				</div>
			</div>
		)
	}
}


