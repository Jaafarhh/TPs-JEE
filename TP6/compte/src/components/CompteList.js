import React, { useState, useEffect, useCallback } from "react";
import axios from "axios";
import API_BASE_URL from "../config";

function CompteList({ accounts, setAccounts }) {
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [editMode, setEditMode] = useState(null);
  const [editData, setEditData] = useState({});

  // Memoize the fetch function
  const fetchAccounts = useCallback(() => {
    setLoading(true);
    axios
      .get(`${API_BASE_URL}/comptes`)
      .then((response) => {
        setAccounts(response.data);
        setLoading(false);
      })
      .catch((error) => {
        setError("Erreur lors du chargement des comptes");
        setLoading(false);
        console.error("Error fetching accounts:", error);
      });
  }, [setAccounts]); // Include setAccounts in dependencies

  // Update useEffect with memoized function
  useEffect(() => {
    fetchAccounts();
  }, [fetchAccounts]); // Add fetchAccounts as dependency

  const handleDelete = (id) => {
    if (window.confirm("Êtes-vous sûr de vouloir supprimer ce compte ?")) {
      axios
        .delete(`${API_BASE_URL}/comptes/${id}`)
        .then(() => {
          setAccounts(accounts.filter((account) => account.id !== id));
        })
        .catch((error) => console.error(error));
    }
  };

  const handleEdit = (compte) => {
    setEditMode(compte.id);
    setEditData(compte);
  };

  const handleUpdate = () => {
    axios
      .put(`${API_BASE_URL}/comptes/${editMode}`, editData)
      .then((response) => {
        setAccounts(
          accounts.map((account) =>
            account.id === editMode ? response.data : account
          )
        );
        setEditMode(null);
      })
      .catch((error) => console.error(error));
  };

  const handleEditChange = (e) => {
    setEditData({ ...editData, [e.target.name]: e.target.value });
  };

  if (loading)
    return (
      <div className="d-flex justify-content-center py-5">
        <div className="spinner-border text-primary" role="status">
          <span className="visually-hidden">Chargement...</span>
        </div>
      </div>
    );

  if (error)
    return (
      <div className="alert alert-danger shadow-sm rounded-3 m-4" role="alert">
        <i className="bi bi-exclamation-triangle me-2"></i>
        {error}
      </div>
    );

  const renderTableRow = (compte) => {
    if (editMode === compte.id) {
      return (
        <tr key={compte.id}>
          <td>{compte.id}</td>
          <td>
            <input
              type="number"
              name="solde"
              value={editData.solde}
              onChange={handleEditChange}
              className="form-control form-control-sm"
            />
          </td>
          <td>
            <input
              type="date"
              name="dateCreation"
              value={editData.dateCreation}
              onChange={handleEditChange}
              className="form-control form-control-sm"
            />
          </td>
          <td>
            <select
              name="type"
              value={editData.type}
              onChange={handleEditChange}
              className="form-select form-select-sm"
            >
              <option value="COURANT">Courant</option>
              <option value="EPARGNE">Épargne</option>
            </select>
          </td>
          <td>
            <div className="btn-group btn-group-sm">
              <button onClick={handleUpdate} className="btn btn-success">
                <i className="bi bi-check-lg"></i>
              </button>
              <button
                onClick={() => setEditMode(null)}
                className="btn btn-secondary"
              >
                <i className="bi bi-x-lg"></i>
              </button>
            </div>
          </td>
        </tr>
      );
    }

    return (
      <tr key={compte.id}>
        <td className="fw-bold text-muted">{compte.id}</td>
        <td className="text-primary">{compte.solde.toFixed(2)} Dhs</td>
        <td>{new Date(compte.dateCreation).toLocaleDateString()}</td>
        <td>
          <span
            className={`badge ${
              compte.type === "COURANT" ? "bg-info" : "bg-success"
            }`}
          >
            {compte.type}
          </span>
        </td>
        <td>
          <div className="btn-group btn-group-sm">
            <button
              onClick={() => handleEdit(compte)}
              className="btn btn-outline-primary"
            >
              <i className="bi bi-pencil"></i>
            </button>
            <button
              onClick={() => handleDelete(compte.id)}
              className="btn btn-outline-danger"
            >
              <i className="bi bi-trash"></i>
            </button>
          </div>
        </td>
      </tr>
    );
  };

  return (
    <div className="container py-4">
      <div className="card shadow-sm border-0 rounded-3">
        <div className="card-body p-4">
          <h3 className="card-title mb-4 text-primary fw-light">
            Liste des Comptes
          </h3>
          {accounts.length === 0 ? (
            <div className="text-center text-muted py-5">
              <i className="bi bi-inbox fs-1"></i>
              <p className="mt-3">Aucun compte trouvé</p>
            </div>
          ) : (
            <div className="table-responsive">
              <table className="table table-hover align-middle mb-0">
                <thead className="bg-light">
                  <tr>
                    <th className="border-0">ID</th>
                    <th className="border-0">Solde</th>
                    <th className="border-0">Date de Création</th>
                    <th className="border-0">Type</th>
                    <th className="border-0">Actions</th>
                  </tr>
                </thead>
                <tbody>
                  {accounts.map((compte) => renderTableRow(compte))}
                </tbody>
              </table>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

export default CompteList;
