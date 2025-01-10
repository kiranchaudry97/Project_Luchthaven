package Ehb.Project.Persoon;


public class Persoon {
    /**
     * inhoud van de persoon
     */
    private final String naam;
    private int leeftijd;
    private double gewicht;

    /**
     * Persoon object aanmaken.
     * deze methoden toegang hebben en terug gestuurd
     */

    public Persoon(String naam) {
        this.naam = naam;

    }

    /**
     * object voor passagier van bagagewicht
     */
    public static class Passagiers {
        public Passagiers(String naam, double gewicht) {

        }
    }
}