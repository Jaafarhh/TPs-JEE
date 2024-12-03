# Application de Gestion des Comptes Bancaires

Cette application fullstack permet la gestion des comptes bancaires en utilisant Spring Boot pour le backend et React pour le frontend.

## Technologies Utilisées

### Backend
- Spring Boot 3.3.5
- Spring Data JPA
- H2 Database
- Maven
- Java 17
- Lombok
- Jackson XML Support
- SpringDoc OpenAPI UI

### Frontend
- React
- Bootstrap et Bootstrap Icons
- Axios

## Fonctionnalités

L'application permet de :
- Créer un nouveau compte
- Afficher la liste des comptes
- Modifier les informations d'un compte
- Supprimer un compte
- Gérer les données en temps réel sans rechargement de page

## Architecture

### Backend
- **Entités**: `Compte` avec les champs id, solde, dateCreation et type
- **Repositories**: `CompteRepository` pour les opérations CRUD
- **Controllers**: `CompteController` pour gérer les endpoints REST
- **Configuration**: CORS configuré pour permettre les requêtes depuis le frontend

### Points d'Accès API
- GET /banque/comptes: Récupérer tous les comptes
- GET /banque/comptes/{id}: Récupérer un compte par ID
- POST /banque/comptes: Créer un nouveau compte
- PUT /banque/comptes/{id}: Modifier un compte
- DELETE /banque/comptes/{id}: Supprimer un compte

### Frontend
- **Composants**: 
  - `CompteForm`: Formulaire d'ajout de compte
  - `CompteList`: Affichage et gestion des comptes
- **Services**: Utilisation d'Axios pour les appels API
- **UI**: Interface utilisateur moderne avec Bootstrap 5

### Video Demo TP6
[Insérer capture d'écran ou GIF de démonstration]