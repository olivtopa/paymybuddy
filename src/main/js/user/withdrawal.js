import React from "react";

export default class WithdrawalScreen extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            amount: 0,
            iban: '',
            bic: '',
            email: props.email
        };
    }

    withdraw = () => {
        this.props.withdrawMoney(this.state);
    }

    enterIban = (value) => {
        this.setState({iban: value});
    }

    enterBic = (value) => {
        this.setState({bic: value});
    }

    enterMoneyValue = (value) => {
        this.setState({amount: value});
    }

    componentDidMount() {

    }

    render() {
        return (
            <div id="withdrawal">
                <h3>Withdraw money</h3>
                <input type="text" placeholder="IBAN"
                       onInput={(e) => this.enterIban(e.target.value)}/>
                <input type="text" placeholder="BIC"
                       onInput={(e) => this.enterBic(e.target.value)}/>
                <input type="text" placeholder="money to withdraw"
                       onInput={(e) => this.enterMoneyValue(e.target.value)}/>
                <button type="button" onClick={this.withdraw} className="btn btn-success">Withdraw</button>
            </div>
        )
    }
}