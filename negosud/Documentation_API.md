# DOCUMENTATION API

## Informations

Pour notre projet scolaire intitulé "Développer une application informatique" il nous à été demandé de créer une API REST. Hormis pour la l'operation **DELETE**, où la réponse est un booléen sur la réussite ou non de la suppression, les reponses sont sous le format **JSON**

## Accès

Notre API n'est pas privé, nulle besoin de s'autentifier pour y accèder.

## Arborèscence

Toutes les tables ont un accès CRUD : C'est à dire que vous pourrez :

* Créer une nouvelle instance (**Create**)

* Reccuperer toutes les instances ou uniquement celle de votre choix (**Read**)

* Modifier une instance existante (**Update**)

* Supprimer une instance (**Delete**)

Vous trouverez ci-dessous la liste des tables disponible de notre base de donnée au format de leur **endpoint**:

*  /api/v1/typeVin

*  /api/v1/personnes

*  /api/v1/livraisonsMagasins

*  /api/v1/livraisonsClients

*  /api/v1/fournisseurs

*  /api/v1/familles

*  /api/v1/factures

*  /api/v1/commandesMagasin

*  /api/v1/commandesClients

*  /api/v1/cartons

*  /api/v1/bonDeCommande

*  /api/v1/articles

*  /api/v1/articleVide

*  /api/v1/adresses

*  /api/v1/paiements

Pour le Read, le Update et le Delete vous rajoutez simplement l'id voulu au endpoint.

Pour le Create et le Update, rajoutez un **body** en Json

⚠️ ATTENTION ⚠️ Notre API ne prend pas en charge le format XML.