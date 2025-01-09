package Ehb.Project.Persoon;

public class Persoon {
    private String naam;
    private int leeftijd;
    /** enkel de naam wordt gelezen */
    public Persoon(String naam) {
        this.naam = naam;
        this.leeftijd = leeftijd;
    }
    /** stuurt de naam terug*/
    public String getNaam() {
        return naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public static class Passagiers extends Persoon {
        private final double bagageGewicht;
        /** extend toegevoegd en te kunnen verwerken met de passagiers */
        public Passagiers(String naam, double bagageGewicht) {
            super(naam);
    /** bagage gewicht van de passagiers */
            this.bagageGewicht = bagageGewicht;
        }
        /** stuurt terug het bagagegewicht van de passagier **/
        public double getBagageGewicht() {
            return bagageGewicht;
        }
    }
}

/**
 * @author Chaud-ry Kiran
 *  programming Advanced - Luchthaven
 */