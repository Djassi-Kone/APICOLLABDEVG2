package groupe2.apicollabdevg2.DTO;


public class CommentaireDTO {
    private String contenu;
    private int contributeurId; // Ajouté pour identifier l'auteur

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getContributeurId() {
        return contributeurId;
    }

    public void setContributeurId(int contributeurId) {
        this.contributeurId = contributeurId;
    }
}