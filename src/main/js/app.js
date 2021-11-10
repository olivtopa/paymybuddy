'use strict';

import TransactionsScreen from "./transactions/transactions";
import React from "react";
import ReactDOM from "react-dom";
import LoginScreen from "./login/login";

// Point d'entrée de l'application React
class App extends React.Component {

	constructor(props) {
		super(props);
		// TODO quand l'écran de listing des transactions sera ok, il faudra supprimer la valeur en dur pour travailler sur la partie login
		this.state = {
			connectedUserEmail: 'email1@gmail.com'
		}
	}

	login = (connectedUserEmail) => {
		// TODO ici on enregistre dans le state le connectedUserEmail
	}

	// Cette méthode est appelée par le moteur React quand il faut afficher un composant. Il contient un mix
	// de html et de syntaxe React (le { } par exemple qui permet d'injecter des données )
	// A noter: il doit y avoir exactement une balise racine (voir le composant TransactionsScreen -> si on veut mettre plusieurs balises
	// il faut wrapper avec un div ou une autre balise )
	render() {

		if (this.state.connectedUserEmail == null) {
			return (<LoginScreen onLoginOk={this.login} />)
		} else {
			return (<TransactionsScreen connectedUserEmail={this.state.connectedUserEmail} />);
		}
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)
