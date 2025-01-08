package Ehb.Project.Luchthaven;


public class Ticket {

    // beschrijving:
    // Datatypes gebruiken om een ticket aan te maken voor passagier met de inhoud van ,
    // vlucht en klasse.
    private Passagiers passagier;
    private Vlucht vlucht;
    private String klasse; // Economy of Business


    public Ticket(Passagiers passagier, Vlucht vlucht, String klasse) {
        this.passagier = passagier;
        this.vlucht = vlucht;
        this.klasse = klasse;
    }
    // getters gebruikt om ze te laten kunnen lezen en wijzingen en capsuleren
    public Passagiers getPassagier() {
        return passagier;
    }

    public Vlucht getVlucht() {
        return vlucht;
    }

    public String getKlasse() {
        return klasse;
    }

    // overide
    @Override
    public String toString() {
        return "Ticket{" +
                "Passagier=" + passagier.getNaam() +
                ", Vlucht=" + vlucht +
                ", Klasse='" + klasse + '\'' +
                '}';
    }
}

