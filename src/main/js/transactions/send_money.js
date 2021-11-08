import React from "react";

export default class SendMoneyComponent extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      selectedContact: null,
      amount: 0
    };
  }

  transferMoney = () => {
    this.props.transferMoney(this.state);
  }

  selectConnection = (selectedConnectionEmail) => {

    const selectedContact = this.props.contacts.filter(c => c.emailContact === selectedConnectionEmail)[0];
    console.log(`Selecting contact ${JSON.stringify(selectedContact)}`);

    this.setState(prevState => {
      return ({...prevState, selectedContact: selectedContact});
    });
  }

  enterAmount = (amount) => {
    console.log('Amount to transfer: ' + amount);
    this.setState(prevState => ({...prevState, amount: Number(amount)}));
  }

  addConnection = () => {
    // TODO afficher le composant AddConnectionPopup en overlay
    // Ce composant doit être ajouté au render, mais en étant masqué par défaut.
    console.log('TODO open a popup to add a connection');
  }

  render() {

    const connections = this.props.contacts.map(connection =>
        <option key={connection.emailContact} value={connection.emailContact}>{connection.name}</option>);

    return (
        <div>
          <div style={{display: 'flex'}}>
            <h5 className="card-title">Send Money</h5>
            <button className="btn btn-primary" type="button" onClick={this.addConnection}>Add Connection</button>
          </div>
          <form style={{display: 'flex'}}>
            <select className="form-select" onChange={(e) => this.selectConnection(e.target.value)}>
              <option value="-1">Select A Connection</option>
              {connections}
            </select>
            <input type="text" onInput={(e) => this.enterAmount(e.target.value)}/>
            <button className="btn btn-success" type="button" onClick={this.transferMoney}>Pay</button>
          </form>
        </div>
    )
  }
}
