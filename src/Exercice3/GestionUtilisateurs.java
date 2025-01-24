package Exercice3;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import Exercice1.MongoConnection; // Import de la connexion MongoDB

public class GestionUtilisateurs {

    private static final String COLLECTION_NAME = "utilisateurs";

    public static void ajouterUtilisateur(String nom, String email, String role) {
        MongoDatabase database = MongoConnection.getDatabase("EstèpheDB");
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        Document utilisateur = new Document("nom", nom)
                .append("email", email)
                .append("role", role);

        collection.insertOne(utilisateur);
        System.out.println("Utilisateur ajouté : " + utilisateur.toJson());
    }

    public static void listerUtilisateurs() {
        MongoDatabase database = MongoConnection.getDatabase("EstèpheDB");
        MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

        System.out.println("Liste des utilisateurs dans la collection MongoDB :");
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                System.out.println(cursor.next().toJson());
            }
        }
    }

    public static void main(String[] args) {
        ajouterUtilisateur("Alice", "alice@example.com", "Admin");
        ajouterUtilisateur("Bob", "bob@example.com", "Membre");

        listerUtilisateurs();

        MongoConnection.close();
    }
}