import React from "react";
import SendMoneyComponent from "./send_money";
import axios from "axios";

export default class TransactionScreen extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      transactions: [],
      contacts: []
    };
  }

  transferMoney = (transactionRequest) => {
    console.log(['Transferring money ', transactionRequest]);
    const entity = {contact: transactionRequest.selectedContact, description: transactionRequest.description, amount: transactionRequest.amount};
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
      this.setState({transactions: response.data});
    });
    // TODO ajouter les contacts au state (comme pour les transactions)
  }

  componentDidMount() {
    this.fetchingAllUserData();
  }

  render() {
    console.log('Rendering transactions screen');
    const transactions = this.state.transactions.map(transaction =>
        <Transaction key={transaction.id} transaction={transaction}/>
    );
    return (
        <div>
          <SendMoneyComponent contacts={this.state.contacts} transferMoney={this.transferMoney}/>
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
          {/* TODO afficher amount */}
        </tr>
    )
  }
}
