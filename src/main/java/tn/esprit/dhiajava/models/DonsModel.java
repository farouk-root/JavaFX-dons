package tn.esprit.dhiajava.models;

public class DonsModel {
    private int id;
    private String titre;
    private String description;
    private int montant;

    public DonsModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public DonsModel(String titre, String description, int montant) {
        this.titre = titre;
        this.description = description;
        this.montant = montant;
    }

    public DonsModel(int id, String titre, String description, int montant) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.montant = montant;
    }
}
