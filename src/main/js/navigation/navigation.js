import React from "react";

export default class NavigationComponent extends React.Component {

    constructor(props) {
        super(props);
    }

    selectScreen = (screen) => {
        console.log('selecting ' + screen);
        this.props.selectScreen(screen);
    }

    render() {

        return (
            <nav className="navbar navbar-expand-lg navbar-light bg-light">

                <a className="navbar-brand">Pay My Buddy</a>

                <div className="collapse navbar-collapse" id="navbarSupportedContent">

                    <ul className="navbar-nav mr-auto">
                        <li className="nav_item mx-1">Home</li>
                        <li className="nav_item mx-1" onClick={() => this.selectScreen('Transaction')}>Transfer</li>
                        <li className="nav_item mx-1" onClick={() => this.selectScreen('User')}>Profile</li>
                        <li className="nav_item mx-1">Contact</li>
                        <li className="nav_item mx-1">Log off</li>
                    </ul>
                </div>

            </nav>
        )
    }
}
