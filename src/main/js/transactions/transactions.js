import React from "react";
import SendMoneyComponent from "./send_money";
import AddConnectionPopup from "../connections/add";
import axios from "axios";

export default class TransactionScreen extends React.Component {

	constructor(props) {
		super(props);
		this.state = {
			transactions: [],
			contacts: [],
			visible: false
		};
	}

	transferMoney = (transactionRequest) => {
		console.log(['Transferring money ', transactionRequest]);
		const entity = {
			emailOrigin: transactionRequest.selectedContact.emailOrigin,
			emailContact: transactionRequest.selectedContact.emailContact,
			description: transactionRequest.description,
			amount: transactionRequest.amount
		};
		axios.post('/api/transactions', entity).then(() => {
			console.log('Money transferred');
			// Rafraichissement des données
			this.fetchingAllUserData();
		});
	}

	// Cette méthode va charger toutes les données puis les stocker dans le state.
	// Le state est un emplacement spécial surveillé par React. Quand le state évolue,
	// React ré-affichera automatiquement le composant en appelant la méthode render.
	// Lors du ré-affichage, les transactions et contacts seront passées aux composants enfants.
	fetchingAllUserData = () => {
		console.log('Loading transactions & contacts');
		axios.get('/api/transactions/' + this.props.connectedUserEmail).then(response => {
			this.setState({ transactions: response.data });
		});

		axios.get('/api/contacts/' + this.props.connectedUserEmail).then(response => {
			this.setState({ contacts: response.data });
		});
	}

	componentDidMount() {
		this.fetchingAllUserData();
	}

	displayAddConnection = () => {
		this.setState({ visible: true });
	}

	hideAddConnection = () => {
		this.setState({ visible: false });
		this.fetchingAllUserData();
	}



	render() {
		console.log('Rendering transactions screen');
		const transactions = this.state.transactions.map(transaction =>
			<Transaction key={transaction.id} transaction={transaction} />
		);
		return (
			<div id="page">
          <nav className="navbar navbar-expand-lg navbar-light bg-light">

            <a className="navbar-brand">Pay My Buddy</a>

            <div className="collapse navbar-collapse" id="navbarSupportedContent">

              <ul className="navbar-nav mr-auto">
                <li className="nav_item mx-1">Home</li>
                <li className="nav_item active mx-1">Transfer</li>
                <li className="nav_item mx-1">Profile</li>
                <li className="nav_item mx-1">Contact</li>
                <li className="nav_item mx-1">Log off</li>
              </ul>
            </div>

          </nav>

				<div>
					<AddConnectionPopup visible={this.state.visible}
						hideAddConnection={this.hideAddConnection}
						emailOrigin={this.props.connectedUserEmail} />
					<SendMoneyComponent contacts={this.state.contacts}
						transferMoney={this.transferMoney}
						displayConnection={this.displayAddConnection} />
					<div id="transactions">
						<h5 className="card-title">My transactions</h5>
						<table>
							<tbody>
								<tr>
									<th>Connections</th>
									<th>Description</th>
									<th>Amount</th>
								</tr>
								{transactions}
							</tbody>
						</table>
					</div>
				</div>

        <div className="footer">
          <p className="mx-1 footer_page">&lt;&lt;</p>
          <p className="mx-1 footer_page">1</p>
          <p className="mx-1 footer_page">2</p>
          <p className="mx-1 footer_page">3</p>
          <p className="mx-1 footer_page">4</p>
          <p className="mx-1 footer_page">5</p>
          <p className="mx-1 footer_page">&gt;&gt;</p>
        </div>

			</div>
		)
	}
}

class Transaction extends React.Component {

	// this.props contient les paramètres issus du parent (passés lors de l'appel, par exemple
	// <Transaction transaction={transaction}/> => transaction sera automatiquement disponible dans this.props.transaction
	render() {
		return (
			<tr>
				<td>{this.props.transaction.contact.name}</td>
				<td>{this.props.transaction.description}</td>
				<td>{this.props.transaction.amount}</td>
			</tr>
		)
	}
}