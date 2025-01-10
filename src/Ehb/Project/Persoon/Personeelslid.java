package Ehb.Project.Persoon;

public class Personeelslid extends Persoon {
    /** Attributen */
    private final String functie;

    /**
     * Constructor voor Personeelslid
     *
     */
    public Personeelslid(String naam, String functie) {
        super(naam);
        this.functie = functie;
    }

    /**
     * Haalt de functie van het personeelslid op.
     *
     */
    public String getFunctie() {
        return functie;
    }

    /**
     * Geeft een stringrepresentatie van het personeelslid.
     * string met naam en functie
     */
    @Override
    public String toString() {
        return "Personeelslid{" +
                "naam=" + getNaam() +
                ", functie='" + functie + '\'' +
                '}';
    }

    public boolean getNaam() {
        return false;
    }
}
