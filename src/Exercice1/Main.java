package Exercice1;

import java.util.ArrayList;
import java.util.List;

// Classe abstraite Utilisateur
abstract class Utilisateur {
    protected String nom;  // Attribut nom
    protected String email;  // Attribut email

    // Constructeur
    public Utilisateur(String nom, String email) {
        this.nom = nom;
        this.email = email;
    }

    // Méthode abstraite à redéfinir par les sous-classes
    public abstract void afficherRole();
}

// Classe Admin (sous-classe concrète)
class Admin extends Utilisateur {
    // Constructeur
    public Admin(String nom, String email) {
        super(nom, email);
    }

    // Implémentation de la méthode abstraite afficherRole
    @Override
    public void afficherRole() {
        System.out.println("Rôle : Administrateur");
    }
}

class Membre extends Utilisateur {
    public Membre(String nom, String email) {
        super(nom, email);
    }

    @Override
    public void afficherRole() {
        System.out.println("Rôle : Membre");
    }
}

public class Main {
    public static void main(String[] args) {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        utilisateurs.add(new Admin("Alice", "alice@admin.com"));
        utilisateurs.add(new Membre("Bob", "bob@membre.com"));
        utilisateurs.add(new Admin("Claire", "claire@admin.com"));
        utilisateurs.add(new Membre("David", "david@membre.com"));

        for (Utilisateur utilisateur : utilisateurs) {
            System.out.print(utilisateur.nom + " (" + utilisateur.email + ") - ");
            utilisateur.afficherRole();
        }
    }
}