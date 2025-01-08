package Ehb.Project.Luchthaven;

public class Persoon {
    // Beschrijving:
    // public gebruikt om class te kunnen verwerken in de project zelf.
    // class aangemaakt voor Persoon
    // Datatypes gebruiken om een persoon met de inhoud van
    // naam, leeftijd, adres.
    //Gebruik maken van private om binnen de klasse te kunnen verwerken .
    private String naam;
    private int leeftijd;
    private String adres;

// public gebruikt om class te kunnen verwerken in de project zelf.
    public Persoon(String naam, int leeftijd, String adres) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.adres = adres;
    }

    public String getNaam() {
        return naam; }

    public int getLeeftijd() {
        return leeftijd; }

    public String getAdres() {
        return adres;
    }
}

