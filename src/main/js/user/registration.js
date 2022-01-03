import React from "react";
import axios from "axios";

export default class RegistrationScreen extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            email: '',
            password: '',
            passwordConfirmation: ''
        };
    }

    enterEmail = email => {
        console.log('your email: ' + email);
        this.setState(prevState => ({ ...prevState, email: email }));
    }

    enterPassword = password => {
        this.setState(prevState => ({ ...prevState, password: password }));
    }

    enterPasswordConfirmation = password => {
        this.setState(prevState => ({ ...prevState, passwordConfirmation: password }));
    }

    createUser = () => {
        axios.post('/api/register', this.state).then(() => {
           this.props.selectScreen('login');
        });
    }

    render() {
        return <div>
            <h2>Welcome to PayMyBuddy app!</h2>
            <h3>Account creation</h3>
            <input type="text" placeholder="Email" onInput={e => this.enterEmail(e.target.value)} />
            <input type="password" placeholder="Password" onInput={e => this.enterPassword(e.target.value)} />
            <input type="password" placeholder="Confirm password" onInput={e => this.enterPasswordConfirmation(e.target.value)} />
            <button type="button" onClick={this.createUser} className="btn btn-success">Register</button>
            <button type="button" onClick={() => this.props.selectScreen('login')} className="btn">Already an Account?</button>
        </div>
    }
}