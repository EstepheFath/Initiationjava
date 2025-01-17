# Initiationjava

Initialisation du projet:

- dans le fichier config.properties openai.api.key="" remlplacer les quotes par al clef API
- Installer les librairies:
      com.google.api-client:google-api-client-gson:1.26.0 /
      com.google.code.gson:gson:2.11.0 /
      org.mongodb:mongodb-driver-sync:5.3.0 /
      com.squareup.okhttp3:okhttp:4.12.0 /
      com.squareup.okio:okio:3.4.0 /


Question théorique :
○ Pourquoi est-il important de ne pas inclure la clé API directement dans le
code source ?

Réponse: Question de sécurité, si elle est récupéré il est possible qu'elle sois utilisé et si c'est une clef payante, le montan peux vite monnter.

3. Question théorique :
○ Pourquoi est-il utile de combiner les fonctionnalités d’une API externe comme
ChatGPT avec une base de données comme MongoDB ?

Réponse: Permet de peupler rapidement la base par exemple
