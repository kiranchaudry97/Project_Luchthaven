package Ehb.Project.Luchthaven;


public class Passagiers extends Persoon {
    // Beschrijving:
    // Class aanmaken voor passagiers binnen de project,
    // gebruik van andere klasse voor extend van persoon om toe te voegen
    // Datatypes gebruiken om een Passagiers met de inhoud van
    // bagage gewicht en ticket vooral de double en boolean.
    //gebruik maken van private om binnen de klasse te kunnen verwerken


    private double bagageGewicht;
    private boolean heeftTicket;

    //om deze inhoud te kunnen
    public Passagiers(String naam, int leeftijd, String adres, double bagageGewicht, boolean heeftTicket) {
        super(naam, leeftijd, adres);
        this.bagageGewicht = bagageGewicht;
        this.heeftTicket = heeftTicket;
    }


    public double getBagageGewicht() {
        return bagageGewicht; }


    public boolean heeftTicket() {
        return heeftTicket; }
}