# TP7: Gestion des Comptes Bancaires

Dans ce TP7, nous avons développé une application de gestion des comptes bancaires en utilisant Spring Boot pour la persistance des données et gRPC pour la gestion des opérations CRUD (Create, Read, Update, Delete) sur une base de données H2.

Les éléments clés de ce projet incluent :
- La définition de l'entité `Compte` avec des champs pour `id`, `solde`, `dateCreation` et `type`, en utilisant les annotations JPA pour le mapping ORM.
- L'utilisation de l'interface `CompteRepository` qui étend `JpaRepository` pour fournir des opérations CRUD et des requêtes personnalisées.
- La classe `CompteService` qui contient la logique métier pour la gestion des comptes, y compris les méthodes pour sauvegarder, supprimer, trouver tous les comptes, trouver un compte par ID, trouver les comptes par type et calculer les statistiques de solde.
- La classe `CompteServiceImpl` qui gère les requêtes gRPC et les mappe aux méthodes du service. Elle inclut des endpoints gRPC pour sauvegarder, supprimer, trouver tous les comptes, trouver un compte par ID, trouver les comptes par type et calculer les statistiques de solde.
- La configuration de l'application pour se connecter à une base de données H2 en utilisant les propriétés définies dans le fichier `application.properties`.
- Les tests en utilisant BloomRPC.

### Video Demo TP7

https://github.com/user-attachments/assets/e4d46890-71a2-44fe-bedd-7185381600fd

---

Alioui Jaâfar