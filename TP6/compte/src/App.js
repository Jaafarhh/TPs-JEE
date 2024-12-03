import React, { useState } from "react";
import CompteList from "./components/CompteList";
import CompteForm from "./components/CompteForm";

function App() {
  const [accounts, setAccounts] = useState([]);

  const handleNewAccount = (newAccount) => {
    setAccounts([...accounts, newAccount]);
  };

  return (
    <div>
      <CompteForm onAccountCreated={handleNewAccount} />
      <CompteList accounts={accounts} setAccounts={setAccounts} />
    </div>
  );
}

export default App;
