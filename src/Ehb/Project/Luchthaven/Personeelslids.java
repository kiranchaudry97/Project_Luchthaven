package Ehb.Project.Luchthaven.Vlucht;

public class Personeelslids extends Persoon {
    private String functie;

    public Personeelslids(String naam, int leeftijd, String adres, String functie) {
        super(naam, leeftijd, adres);
        this.functie = functie;
    }

    public String getFunctie() {
        return functie;
    }
}

