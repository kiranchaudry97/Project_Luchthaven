package Ehb.Project.Luchthaven.Vlucht;

public class Persoon {
    private String naam;
    private int leeftijd;
    private String adres;

    public Persoon(String naam, int leeftijd, String adres) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.adres = adres;
    }

    public String getNaam() {
        return naam;
    }
}

