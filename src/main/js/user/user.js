import React from "react";
import axios from "axios";
import DepositScreen from "./deposit";
import WithdrawalScreen from "./withdrawal";

export default class UserScreen extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            email: this.props.email,
            balance: 0
        };
    }

    componentDidMount() {
        this.refresh();
    }

    withdrawMoney = (withdrawRequest) => {
        axios.post('/api/withdrawMoney', withdrawRequest).then(() => {
            this.refresh();
        });
    }

    depositMoney = (depositRequest) => {
        axios.post('/api/addMoney', depositRequest).then(() => {
            this.refresh();
        });
    }

    refresh = () => {
        console.log(this.state);
        axios.get('/api/user/' + this.state.email).then(res => {
            this.setState({balance: res.data.solde});
        })
    }

    render() {
        return (
            <div id="userAccount">
                <h2>User account</h2>
                <span>Balance : {this.state.balance}</span>
                <DepositScreen email={this.state.email} depositMoney={this.depositMoney}/>
                <WithdrawalScreen email={this.state.email} withdrawMoney={this.withdrawMoney}/>
            </div>
        )
    }
}