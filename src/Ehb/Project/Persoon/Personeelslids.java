package Ehb.Project.Persoon;

public class Personeelslids extends Persoon {
    /**
     * Beschrijving:
     * Het gebruik van extends van Persoon
     * Datatypes gebruiken om een Personeelslids met de inhoud te kunnen aanpassen.
     * Functie.
     * Gebruik maken van private om binnen de klasse te kunnen verwerken voor functie om final te maken.
     */

    private String functie;

    public Personeelslids(String naam, int leeftijd, String adres, String functie) {
        super(naam, leeftijd, adres);
        this.functie = functie;
    }

    public String getFunctie() {
        return functie; }
}

/**
 * @author Chaud-ry Kiran
 * @project programming Advanced - Luchthaven
 */