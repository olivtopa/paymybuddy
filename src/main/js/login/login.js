import React from "react";

export default class LoginScreen extends React.Component {

  constructor(props) {
    super(props);
    // TODO compléter le state. Pour des exemples, regarder send_money.js par exemple
    this.state = {
    };
  }

  loginUser = () => {
    // TODO Cette méthode doit être liée au click bouton (regarder send_money.js pour des exemples de liaison)
    // récupérer du state email, password et remember me, puis avec ça,
    //  appeler le back-end (comme pour TransactionScreen.transferMoney)
    // En cas de réussite, appeler la méthode onLoginOk() du parent avec l'email de l'utilisateur.
  }

  render() {

    return (
        <div>
          <h1>Pay My Buddy</h1>
          <form>
            <input/>
            {/* TODO ajouter le champ password, la checkbox remember me et le bouton login. Des exemples sont visibles dans la partie transaction */}
          </form>
        </div>
    )
  }
}
