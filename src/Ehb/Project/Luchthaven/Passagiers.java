package Ehb.Project.Luchthaven.Vlucht;

public class Passagiers extends Persoon{
    private double bagageGewicht;
    private String ticket;

    public Passagiers(String naam, int leeftijd, String adres, double bagageGewicht, String ticket) {
        super(naam, leeftijd, adres);
        this.bagageGewicht = bagageGewicht;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    public String getTicket() {
        return ticket;
    }
}
