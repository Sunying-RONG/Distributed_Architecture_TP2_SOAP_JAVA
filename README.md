# TP2_SOAP_JAVA
cours HAI704I Architectures logicielles distribuées

Pour lancer/exécuter le projet:  
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
