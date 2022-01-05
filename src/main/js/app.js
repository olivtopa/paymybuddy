'use strict';

import TransactionsScreen from "./transactions/transactions";
import React from "react";
import ReactDOM from "react-dom";
import LoginScreen from "./login/login";
import NavigationComponent from "./navigation/navigation";
import UserScreen from "./user/user";
import RegistrationScreen from "./user/registration";
import axios from "axios";

// Point d'entrée de l'application React
class App extends React.Component {

	constructor(props) {
		super(props);

		let rememberedBasicHeader = localStorage.getItem('basicHeader');
		this.state = {
			connectedUserEmail: localStorage.getItem('connectedUserEmail'),
			basicHeader: rememberedBasicHeader,
			screen: this.resolveDefaultScreen(rememberedBasicHeader)
		}

		if(this.state.basicHeader) {
			this.addAuthorization(this.state.basicHeader);
		}
	}

	resolveDefaultScreen(basicHeader) {
		if(basicHeader) {
			return 'Transaction';
		}
		return 'login';
	}

	login = (connectedUserEmail, rememberMe, password) => {
		this.setState(prevState => ({ ...prevState, connectedUserEmail: (connectedUserEmail) }));
		//ici on enregistre dans le state le connectedUserEmail
		const basicHeader = Buffer.from(this.state.connectedUserEmail + ':' + password).toString('base64');
		if (rememberMe) {
			localStorage.setItem('connectedUserEmail', connectedUserEmail);
			localStorage.setItem('basicHeader', basicHeader);
		}
		this.addAuthorization(basicHeader);
		this.selectScreen('Transaction');
	}

	addAuthorization = (basicHeader) => {
		axios.defaults.headers.common['Authorization'] = 'Basic ' + basicHeader;
	}

	selectScreen = (screen) => {
		this.setState(prevState => ({ ...prevState, screen: screen }));
	}

	// Cette méthode est appelée par le moteur React quand il faut afficher un composant. Il contient un mix
	// de html et de syntaxe React (le { } par exemple qui permet d'injecter des données )
	// A noter: il doit y avoir exactement une balise racine (voir le composant TransactionsScreen -> si on veut mettre plusieurs balises
	// il faut wrapper avec un div ou une autre balise )
	render() {

		if(this.state.screen === 'registration') {
			return (<RegistrationScreen selectScreen={this.selectScreen}/>);
		}
		if (this.state.screen === 'login') {
			return (<LoginScreen onLoginOk={this.login} selectScreen={this.selectScreen}/>)
		}
		if(this.state.screen === 'Transaction') {
			return (
				<div>
					<NavigationComponent selectScreen={this.selectScreen}/>
					<TransactionsScreen connectedUserEmail={this.state.connectedUserEmail} />
				</div>
				);
		}
		if(this.state.screen === 'User') {
			return (
				<div>
					<NavigationComponent selectScreen={this.selectScreen}/>
					<UserScreen email={this.state.connectedUserEmail} />
				</div>
			);
		} else {
			return (<div>Error</div>)
		}
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)
