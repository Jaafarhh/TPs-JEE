# TP5: Gestion des Étudiants

Dans ce TP5-1, nous avons développé une application de gestion des étudiants en utilisant Spring Boot pour la persistance des données et la gestion des opérations CRUD (Create, Read, Update, Delete) sur une base de données MySQL.

Les éléments clés de ce projet incluent :
- La définition de l'entité `Student` avec des champs pour `id`, `nom`, `prenom` et `dateNaissance`, en utilisant les annotations JPA pour le mapping ORM.
- L'utilisation de l'interface `StudentRepository` qui étend `JpaRepository` pour fournir des opérations CRUD et des requêtes personnalisées.
- La classe `StudentService` qui contient la logique métier pour la gestion des étudiants, y compris les méthodes pour sauvegarder, supprimer, trouver tous les étudiants, compter les étudiants et trouver le nombre d'étudiants par année.
- La classe `StudentController` qui gère les requêtes HTTP et les mappe aux méthodes du service. Elle inclut des endpoints pour sauvegarder, supprimer, trouver tous les étudiants, compter les étudiants et trouver les étudiants par année.
- La configuration de l'application pour se connecter à une base de données MySQL en utilisant les propriétés définies dans le fichier `application.properties`.
- Les tests unitaires pour la couche contrôleur en utilisant JUnit et Mockito.

### Video Demo TP5-1

---

Alioui Jaâfar
