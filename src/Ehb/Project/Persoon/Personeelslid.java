package Ehb.Project.Persoon;

public class Personeelslid extends Persoon {
    private final String functie;

    /** extend gebruikt met de verwerking van persoon samen te kunnen stellen.
     * info van de personeelslid.*/

    public Personeelslid(String naam, String functie) {
        super(naam);
        this.functie = functie;
    }
    /** constructor van maken met deze inhoud */
    public String getFunctie() {
        return functie;
    }
}

/**
 * @author Chaud-ry Kiran
 *  programming Advanced - Luchthaven
 */