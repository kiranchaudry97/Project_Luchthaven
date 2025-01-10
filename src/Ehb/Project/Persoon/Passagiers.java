package Ehb.Project.Persoon;

public class Passagiers {
    private final String naam;
    private final double bagageGewicht;

    /**
     * Constructor voor Passagiers
     * @param naam naam van de passagier
     * @param bagageGewicht gewicht van de bagage (tussen 0 en 30 kg)
     */
    public Passagiers(String naam, double bagageGewicht) {
        this.naam = naam;
        this.bagageGewicht = Math.max(0, Math.min(30, bagageGewicht));
    }

    /**
     * Haalt de naam van de passagier op.
     * @return naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Haalt het bagagegewicht van de passagier op.
     * @return bagagegewicht
     */
    public double getBagageGewicht() {
        return bagageGewicht;
    }

    /**
     * Controleert of het bagagegewicht juist gegeven is aan een maximum gewicht.
     * @param  maxGewicht het maximum toegestane gewicht
     * @return true als het gewicht binnen het maximum valt, anders false
     */
    public boolean isBagageGewichtToegestaan(double maxGewicht) {
        return bagageGewicht <= maxGewicht;
    }

    /**
     * Geeft een stringrepresentatie van de passagier bagagegegevens.
     * @return string met naam en bagagegewicht
     */
    @Override
    public String toString() {
        return "Naam: " + naam + ", Bagagegewicht: " + bagageGewicht + " kg";
    }
}