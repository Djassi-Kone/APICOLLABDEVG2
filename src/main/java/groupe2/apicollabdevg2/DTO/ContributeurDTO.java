package groupe2.apicollabdevg2.DTO;

import groupe2.apicollabdevg2.entity.Nivau;
import groupe2.apicollabdevg2.entity.Profil;

public class ContributeurDTO {
   private String nom;
    private String prenom;
    private String email;
    private String password;
    private Profil profil;
    private Nivau niveau;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profil getProfil() {
        return profil;
    }

    public void setProfil(Profil profil) {
        this.profil = profil;
    }

    public Nivau getNiveau() {
        return niveau;
    }

    public void setNiveau(Nivau niveau) {
        this.niveau = niveau;
    }
}
