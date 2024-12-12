# TP8: Gestion des Comptes Bancaires avec GraphQL
Dans ce TP8, nous avons développé une application de gestion des comptes bancaires en utilisant Spring Boot pour la persistance des données et GraphQL pour la gestion des opérations CRUD (Create, Read, Update, Delete) sur une base de données H2.
Les éléments clés de ce projet incluent :
- **Configuration de GraphQL** : Utilisation de Spring Boot et Spring GraphQL pour configurer et exposer les endpoints GraphQL.
- **Schéma GraphQL** : Définition des types, des requêtes et des mutations dans le fichier `schema.graphqls`.
    - **Types** : `Compte`, `Transaction`, `TypeCompte`, `TypeTransaction`, `SoldeStats`, `TransactionStats`.
    - **Requêtes** :
        - `allComptes`: Récupère tous les comptes.
        - `compteById`: Récupère un compte par ID.
        - `totalSolde`: Calcule les statistiques de solde.
        - `compteByType`: Récupère les comptes par type.
        - `allTransactions`: Récupère toutes les transactions.
        - `compteTransaction`: Récupère les transactions d'un compte spécifique.
        - `transactionStats`: Calcule les statistiques de transaction.
    - **Mutations** :
        - `saveCompte`: Sauvegarde un nouveau compte.
        - `deleteCompte`: Supprime un compte par ID.
        - `addTransaction`: Ajoute une nouvelle transaction.
- **Contrôleurs GraphQL** :
    - `CompteControllerGraphQL` : Gère les opérations CRUD pour les comptes.
    - `TransactionControllerGraphQL` : Gère les opérations CRUD pour les transactions.
- **Gestion des exceptions** : Utilisation de `GraphQLExceptionHandler` pour gérer les exceptions et les erreurs GraphQL.
- **Tests avec GraphiQL** : Utilisation de l'interface GraphiQL pour tester les requêtes et mutations GraphQL.
### Video Demo TP8


https://github.com/user-attachments/assets/2c75aab1-c8ac-4691-a5d8-9ec6abc8a2c2


---
Alioui Jaâfar
