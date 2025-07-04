package groupe2.apicollabdevg2.DTO;

public class IdeeProjetDTO {
    private String titre;
    private String description;
    private int contributeurId;


    public IdeeProjetDTO(String titre, String description, int contributeurId) {
        this.titre = titre;
        this.description = description;
        this.contributeurId = contributeurId;
    }

    // Getters et setters
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getContributeurId() { return contributeurId; }
    public void setContributeurId(int contributeurId) { this.contributeurId = contributeurId; }
}