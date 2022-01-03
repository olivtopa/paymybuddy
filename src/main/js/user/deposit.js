import React from "react";

export default class DepositScreen extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            moneyToAdd: 0,
            iban: '',
            bic: '',
            email: props.email
        };
    }

    addMoney = () => {
        console.log(['Adding money ', this.state]);

        this.props.depositMoney(this.state);
    }

    enterIban = (value) => {
        this.setState({iban: value});
    }

    enterBic = (value) => {
        this.setState({bic: value});
    }

    enterMoneyValue = (value) => {
        this.setState({moneyToAdd: value});
    }

    componentDidMount() {

    }

    render() {
        return (
            <div id="deposit">
                <h3>Deposit money</h3>
                <input type="text" placeholder="IBAN"
                       onInput={(e) => this.enterIban(e.target.value)}/>
                <input type="text" placeholder="BIC"
                       onInput={(e) => this.enterBic(e.target.value)}/>
                <input type="text" placeholder="money to deposit"
                       onInput={(e) => this.enterMoneyValue(e.target.value)}/>
                <button type="button" onClick={this.addMoney} className="btn btn-success">Deposit</button>
            </div>
        )
    }
}