package Ehb.Project.Ticket;


import Ehb.Project.Vlucht.Vlucht;
import Ehb.Project.Persoon.Passagiers;

public class Ticket {

/**
* beschrijving:
*  Datatypes gebruiken om een ticket aan te maken voor passagier met de inhoud van ,
* vlucht en klasse.
* private Passagiers passagier;
*/

    private Passagiers passagier;
    private Vlucht vlucht;
    private String klasse; // Economy of Business


    public Ticket(Passagiers passagier, Vlucht vlucht, String klasse) {
        this.passagier = passagier;
        this.vlucht = vlucht;
        this.klasse = klasse;
    }
    public Passagiers getPassagier() {
        return passagier;
    }

    public Vlucht getVlucht() {
        return vlucht;
    }

    public String getKlasse() {
        return klasse;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "Passagier=" + passagier.getNaam() +
                ", Vlucht=" + vlucht +
                ", Klasse='" + klasse + '\'' +
                '}';
    }
}

/**
 * @author Chaud-ry Kiran
 * @project programming Advanced - Luchthaven
 */