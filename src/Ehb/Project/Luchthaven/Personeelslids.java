package Ehb.Project.Luchthaven;

public class Personeelslids extends Persoon {
    // Beschrijving:
    // Het gebruik van extends van Persoon
    // Datatypes gebruiken om een Personeelslids met de inhoud van
    // Fucntie.
    //gebruik maken van private om binnen de klasse te kunnen verwerken voor functie.
    private String functie;

    public Personeelslids(String naam, int leeftijd, String adres, String functie) {
        super(naam, leeftijd, adres);
        this.functie = functie;
    }

    //getter gebruikt
    public String getFunctie() {
        return functie; }
}