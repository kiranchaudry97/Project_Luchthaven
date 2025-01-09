package Ehb.Project.Persoon;

public class Passagiers extends Persoon{
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

/**
 * @author Chaud-ry Kiran
 *  programming Advanced - Luchthaven
 */

