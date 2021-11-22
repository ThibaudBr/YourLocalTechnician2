##YourLocalTechnician
#Projet réaliser par BRIAND Thibaud

Projet CC1 Architecture de logiciel

L'application s'utilise via le cmd. 
Le stockage de données est simplement des list d'user et d'invoice se trouvant dans les class repository.
Les repository s'occupe de la logique de gestion des données/ stockage
Les service s'occupe de validée les données envoyer par l'utilisateur.
Les validator sont des class static qui valide les données présente dans les class requests.
Les request sont des class simple permettant de stocker de manière plus simple les données de requête ainsi que de permettre
de cibler uniquement les données util pour les requêtes (exemple: LoginRequest qui ne comprend que le login et le mot de passe et
non une nouvelle classe entière de user).

Toutes la logique de gestion entre les différentes class se trouve dans APIClient (ne fait pas attention au nom je ne savais pas comment la nommée).

Le cli est composé principalement de 4 class abstraite Menu, Action, ListAction/ListSelectionMenu et Form:

Les Form s'occupe de demander a l'utilisateur les données et de stocker les données dans une request.
Les menus sont des class comptenant des listes d'actions que l'on appelle avec un numéro.
Les Actions permettent de générer des actions à réaliser sans avoir besoin d'utiliser des switch ou if dans le code.
Les listSelectionMenu suivent la même logique que les actions en allant chercher une liste de données dans les repository et 
permettent de sélectionner des entity.


PS: Il n'y à pas de tests car je me suis laissé avoir par la date de rendu que je pensais le 21/11/2021
à 23h59 et non a 00h00 et je comptatis poser des question lors du cours a ce sujet.