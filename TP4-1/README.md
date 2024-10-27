# TP4 : Spring avec Hibernate

Dans ce TP, nous avons développé une application de gestion de produits utilisant Spring Framework intégré avec Hibernate ORM. Le projet implémente un système CRUD complet pour la gestion des produits, avec une architecture en couches bien définie et une configuration basée sur les annotations Spring.

Le projet se distingue par :
- L'utilisation de Spring pour l'injection de dépendances et la gestion des transactions
- L'intégration d'Hibernate comme ORM pour la persistance des données
- Une configuration moderne basée sur les annotations plutôt que sur XML
- L'utilisation de JPA pour la définition des entités

Les fonctionnalités principales incluent :
- Création, lecture, mise à jour et suppression de produits
- Gestion automatique des transactions avec `@Transactional`
- Configuration externalisée via `application.properties`
- Implémentation du pattern DAO avec une interface générique

La structure du projet suit une architecture en couches :
- **entities** : Contient les entités JPA (Product)
- **dao** : Contient l'interface IDao et son implémentation
- **util** : Contient la configuration Hibernate et Spring
- **presentation** : Contient la classe de démonstration

---
Alioui Jaâfar
