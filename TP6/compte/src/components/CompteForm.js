import React, { useState } from "react";
import axios from "axios";
import API_BASE_URL from "../config";

function CompteForm({ onAccountCreated }) {
  const [compte, setCompte] = useState({
    solde: "",
    dateCreation: "",
    type: "",
  });

  const handleChange = (e) => {
    setCompte({ ...compte, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios
      .post(`${API_BASE_URL}/comptes`, compte)
      .then((response) => {
        onAccountCreated(response.data);
        setCompte({
          solde: "",
          dateCreation: "",
          type: "",
        });
      })
      .catch((error) => console.error(error));
  };

  return (
    <div className="container py-4">
      <div className="card shadow-sm border-0 rounded-3">
        <div className="card-body p-4">
          <h3 className="card-title mb-4 text-primary fw-light">
            Créer un Compte
          </h3>
          <form onSubmit={handleSubmit}>
            <div className="mb-4">
              <label className="form-label text-muted">Solde</label>
              <input
                type="number"
                name="solde"
                className="form-control form-control-lg border-light bg-light"
                onChange={handleChange}
                placeholder="Entrer le solde"
              />
            </div>
            <div className="mb-4">
              <label className="form-label text-muted">Date de Création</label>
              <input
                type="date"
                name="dateCreation"
                className="form-control form-control-lg border-light bg-light"
                onChange={handleChange}
              />
            </div>
            <div className="mb-4">
              <label className="form-label text-muted">Type</label>
              <select
                name="type"
                className="form-select form-select-lg border-light bg-light"
                onChange={handleChange}
              >
                <option value="">Sélectionner un type</option>
                <option value="COURANT">Courant</option>
                <option value="EPARGNE">Épargne</option>
              </select>
            </div>
            <button type="submit" className="btn btn-primary btn-lg w-100">
              Ajouter le compte
            </button>
          </form>
        </div>
      </div>
    </div>
  );
}
export default CompteForm;
