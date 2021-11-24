package fr.ul.tp3_exo2_fx;

public class Card {

    private int id = 0;
    private String nom = "";
    private String type = "";
    private int niveau = 0;

    public Card() {

    }

    public Card(int id, String nom, String type, int niveau) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.niveau = niveau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "Card{" +
                "isbn='" + id + '\'' +
                ", nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                ", niveau=" + niveau +
                '}';
    }
}
