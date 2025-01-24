package Exercice1;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

public class MongoConnection {
    private static final String CONNECTION_STRING = "mongodb+srv://carmelohays:790SEBfv1lrZNPD2@cluster0.yd7bp.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
    private static MongoClient mongoClient = null;

    public static MongoDatabase getDatabase(String dbName) {
        if (mongoClient == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
        }
        return mongoClient.getDatabase(dbName);
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    public class CreateCollections {
        public static void main(String[] args) {
            String databaseName = "EstèpheDB";
            MongoDatabase database = MongoConnection.getDatabase(databaseName);

            String prefix = "Estèphe";
            String[] collections = {
                    prefix + "taches",
                    prefix + "logs",
                    prefix + "utilisateurs"
            };

            for (String collectionName : collections) {
                if (database.listCollectionNames().into(new ArrayList<>()).contains(collectionName)) {
                    System.out.println("La collection " + collectionName + " existe déjà.");
                } else {
                    database.createCollection(collectionName);
                    System.out.println("Collection " + collectionName + " créée avec succès.");
                }
            }

            MongoConnection.close();
        }
    }

}