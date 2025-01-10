package Ehb.Project.Ticket;

import Ehb.Project.Klasse.Klasse;
import Ehb.Project.Persoon.Passagiers;
import Ehb.Project.Vlucht.Vlucht;

// Ticket Klasse
class Ticket {
    private final Passagiers passagier;
    private final Vlucht vlucht;
    private final Klasse klasse;

    /**
     * Constructor voor Ticket
     * @param passagier de passagier waarvoor het ticket is
     * @param vlucht de vlucht waar het ticket voor geldt
     * @param klasse de klasse waarin de passagier reist
     */
    public Ticket(Passagiers passagier, Vlucht vlucht, Klasse klasse) {
        this.passagier = passagier;
        this.vlucht = vlucht;
        this.klasse = klasse;
    }

    /**
     * Haalt de passagier op.
     * @return passagier
     */
    public Passagiers getPassagier() {
        return passagier;
    }

    /**
     * Haalt de vlucht op.
     * @return vlucht
     */
    public Vlucht getVlucht() {
        return vlucht;
    }

    /**
     * Haalt de klasse op.
     * @return klasse
     */
    public Klasse getKlasse() {
        return klasse;
    }

    /**
     * Geeft een stringrepresentatie van het ticket.
     * @return string met ticketinformatie
     */
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
