# TP2_SOAP_JAVA
cours HAI704I Architectures logicielles distribuées - une pratique de SOAP  

La conception de la solution:  
![alt text](https://github.com/Sunying-RONG/Distributed_Architecture_TP2_SOAP_JAVA/blob/main/TPUMLDISTRIBUE.jpg)

### Fonctionnalité en résumé :
Données créées dans RepoPlateformeImpl, comme base de données.  

D'abord, Agence login avec identifiant et mot de passe. Dans RepoPlateformeImpl, il y a une liste d'agences pour identifier agence qui login.  
Puis Agence peut rechercher les propositions. Dans Class Agence, il existe une liste de HotelPartenaireTarif qui comprend Hotel et le pourcentage de prix.  
Les Propositions qui comprend offreId, HotelPartenaireTarif, liste de chambres proposé, sont construites par chaque hôtel qui est le partenaire de cette agence. Enfant, retourner les listes de Proposition.  

Agence login encore une fois sur Service 2, pour utiliser les services de réservation etc de Service 2, doit être la même agence qui recherche les propositions dans Service 1, pour profiter son pourcentage de prix.  
Puis, demander les informations de client, créer objet carteCredit et client, et faire la réservation. Créer un objet de Réservation et ajouter dans la liste de réservation de l'hôtel, et aussi ajouter dans l'agence, pour hôtel et agence accéder des informations de réservation facilement.  

Sur côté Serveur, il y a tous les Classes, images, base de données, et les deux services. Serveur publier les services sur url ("http://localhost:8080/serviceweb1" et "http://localhost:8080/serviceweb2").  

Sur côté Client, il y a le programme pour toutes les opérations. Client découvre les services par les urls et récupère les proxys sur lesquels appeler les méthodes de Serveur. Les requêtes et les réponses sont en format XML.

### Pour lancer/exécuter le projet:  
Ouvrir le lien ci-dessus dans le navigateur.   
Télécharger le code (main branch) sur local par git clone.  
Le nom du dossier est "TP2_SOAP_JAVA".  
Lancer Eclipse, choisir le dossier "TP2_SOAP_JAVA" comme le Workspace, et lancer. 
Importer les projets. 

pour projets "TPQ2ClientAgence" et "TPQ1" 
Import projects dans Package Explorer.  
Puis choisir "General" -> "Existing Projects into Workspace" -> 
"Next>" ->  
Select root directory, cliquer sur "Browse" ->  
Choisir "TPQ2ClientAgence" -> "Finish" 
Les mêmes étapes pour importer "TPQ1".  

pour projet "TPQ2ArtifactId"  
Importer "TPQ2ArtifactId" par "Maven" ->  "Existing Maven Projects"  
"Next>" ->  
Select root directory, cliquer sur "Browse" ->  
Choisir "TPQ2ArtifactId" -> "Finish"  

Vous devez voir trois projets dans Package Explorer.  
Vérifier "JRE System Library" dans projet "TPQ2ArtifactId", doit être version "[JavaSe-1.8]". Sinon, cliquer droite sur ce projet, "Build Path" - "Configure Build Path" - "Libraries" - choisir JRE - "Edit" - choisir version 1.8  
"TPQ2ArtifactId" est le Serveur, "TPQ2ClientAgence" est le Client pour question 2 et question 3.  
Dans "TPQ2ArtifactId" - "src/main/java" - "serverPubliser" - ServerPubliser.java, Lancer ServerPubliser.java.  
"Server web 1 ready" et "Server web 2 ready" doit être affiché dans console.  
Lancer HotelServiceClientCLI.java qui est dans le projet "TPQ2ClientAgence" -> src -> main.  
On peut tester dans le console de Client selon les instructions.  
