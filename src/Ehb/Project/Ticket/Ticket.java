package Ehb.Project.Ticket;

import Ehb.Project.Klasse.Klasse;
import Ehb.Project.Persoon.Persoon;
import Ehb.Project.Vlucht.Vlucht;

// Ticket Klasse
class Ticket {
    private final Persoon.Passagiers passagier;
    private final Vlucht vlucht;
    private final Klasse klasse;

    public Ticket(Persoon.Passagiers passagier, Vlucht vlucht, Klasse klasse) {
        this.passagier = passagier;
        this.vlucht = vlucht;
        this.klasse = klasse;
    }

    public Persoon.Passagiers getPassagier() {
        return passagier;
    }

    public Vlucht getVlucht() {
        return vlucht;
    }

    public Klasse getKlasse() {
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