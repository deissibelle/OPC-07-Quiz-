# OPC-07-Quiz 🌐

## Contexte 🎨
Ce projet est une application console développée en Kotlin permettant de jouer à un quiz interactif.
Le programme est conçu pour offrir une expérience immersive, 
avec des questions aléatoires et un système de temporisation pour chaque question. 

## Fonctionnalités demandées 📈

### 1. Gestion des utilisateurs
- **Enregistrement des participants** : Lors du lancement, le programme demande à l'utilisateur d'entrer son nom.
- **Message de bienvenue** : Affiche un message personnalisé en fonction du nom entré.

### 2. Sélection du domaine
- Proposer à l'utilisateur de choisir un **domaine thématique** (par exemple : Mathématiques, Science, Histoire).

### 3. Génération des questions
- Sélectionner **10 questions aléatoires** parmi une base de données organisée par domaine.
- Chaque question comprend **4 choix de réponses**.

### 4. Temporisation
- Chaque question dispose d'un **temps limite de 10 secondes** pour répondre.
- Si aucune réponse n'est donnée avant l'expiration du temps, le programme passe automatiquement à la question suivante.

### 5. Calcul du score et affichage des résultats
- Compter les **réponses correctes** pour calculer le score final.
- Afficher un message en fonction du résultat :
  - **Réussite** : Si le score est égal ou supérieur à 5/10, un message de félicitations est affiché.
  - **Échec** : Si le score est inférieur à 5/10, l'utilisateur peut choisir de **recommencer le quiz**.

## Prérequis 🚀
- **Kotlin** : Assurez-vous que Kotlin est installé sur votre machine. [Documentation officielle de Kotlin](https://kotlinlang.org/docs/home.html)
- **IDE** : Utilisez IntelliJ IDEA ou tout autre IDE compatible avec Kotlin pour exécuter le programme.

## Liens utiles pour se documenter 🔧
2. **Manipulation des collections** : [Collections en Kotlin](https://kotlinlang.org/docs/collections-overview.html)
3. **Gestion des exceptions** : [Gestion des exceptions en Kotlin](https://kotlinlang.org/docs/exceptions.html)
4. **Timer en Kotlin** : [Utilisation des Timer et Scheduled Tasks](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.concurrent/-timer/)


## Exécution du programme ⚡
1. Clonez le dépôt :
$ git clone https://github.com/deissibelle/OPC-07-Quiz-.git
2. Allez dans le dossier du projet :
$ cd OPC-07-Quiz
3. Lancez l'application via votre IDE ou en ligne de commande :

