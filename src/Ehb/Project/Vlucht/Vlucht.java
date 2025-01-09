package Ehb.Project.Vlucht;

import Ehb.Project.Klasse.Klasse;
import Ehb.Project.Persoon.Personeelslid;
import Ehb.Project.Persoon.Persoon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Beschrijving:
 * Een vlucht met passagiers, personeel en beschikbare plaatsen.
 * Biedt methoden om personen toe te voegen en te controleren of de vlucht kan opstijgen.
 */
public class Vlucht {
    private final String vluchtcode;
    private final String vertrek;
    private final String bestemming;
    private final int maxPassagiers;
    private final Map<Klasse, Integer> beschikbarePlaatsen = new EnumMap<>(Klasse.class);
    private final Set<Persoon.Passagiers> passagiers = new HashSet<>();
    private final Set<Personeelslid> personeel = new HashSet<>();
    private static final double MAX_BAGAGEGEWICHT = 20.0;
    private boolean flightCheckUitgevoerd = false;

    /**
     * Constructor voor het aanmaken van een vlucht.
     */
    public Vlucht(String vluchtcode, String vertrek, String bestemming, int maxEconomy, int maxBusiness) {
        this.vluchtcode = vluchtcode;
        this.vertrek = vertrek;
        this.bestemming = bestemming;
        this.maxPassagiers = maxEconomy + maxBusiness;
        beschikbarePlaatsen.put(Klasse.ECONOMY, maxEconomy);
        beschikbarePlaatsen.put(Klasse.BUSINESS, maxBusiness);
    }

    /**
     * Voeg een personeelslid toe aan de vlucht.
     */
    public void voegPersoneelslidToe(Personeelslid personeelslid) {
        personeel.add(personeelslid);
        System.out.println(personeelslid.getNaam() + " toegevoegd als " + personeelslid.getFunctie());
    }

    /**
     * Voeg een passagier toe aan de vlucht.
     */
    public void voegPassagierToe(Persoon.Passagiers passagier, Klasse klasse) {
        if (passagiers.size() >= maxPassagiers) {
            System.out.println("Maximaal aantal passagiers bereikt.");
            return;
        }
        if (passagier.getBagageGewicht() > MAX_BAGAGEGEWICHT) {
            System.out.println("Bagagegewicht te zwaar: maximaal " + MAX_BAGAGEGEWICHT + " kg.");
            return;
        }
        if (beschikbarePlaatsen.get(klasse) > 0) {
            passagiers.add(passagier);
            beschikbarePlaatsen.put(klasse, beschikbarePlaatsen.get(klasse) - 1);
            System.out.println(passagier.getNaam() + " is toegevoegd aan de " + klasse + " klasse.");
        } else {
            System.out.println("Geen beschikbare plaatsen in " + klasse + " klasse.");
        }
    }

    /**
     * Voer een flightcheck uit.
     */
    public void voerFlightCheckUit() {
        this.flightCheckUitgevoerd = true;
        System.out.println("Flightcheck uitgevoerd.");
    }

    /**
     * Controleer of de vlucht kan opstijgen.
     */
    public boolean kanOpstijgen() {
        if (!flightCheckUitgevoerd) return foutmelding("Flightcheck niet uitgevoerd.");

        if (personeel.stream().noneMatch(p -> "Piloot".equalsIgnoreCase(p.getFunctie())))
            return foutmelding("Geen piloot aanwezig.");
        if (personeel.stream().noneMatch(p -> "Stewardess".equalsIgnoreCase(p.getFunctie())))
            return foutmelding("Geen stewardess aanwezig.");

        System.out.println("Vlucht is klaar voor vertrek!");
        return true;
    }

    private boolean foutmelding(String boodschap) {
        System.out.println(boodschap);
        return false;
    }

    /**
     * Toon informatie over de vlucht.
     */
    public void toonVluchtInfo() {
        System.out.println("Vlucht: " + vluchtcode);
        System.out.println("Van: " + vertrek + " Naar: " + bestemming);
        System.out.println("Beschikbare plaatsen: " + beschikbarePlaatsen);
        System.out.println("Passagiers: " + passagiers.size() + "/" + maxPassagiers);
        System.out.println("Personeel: " + personeel.size());
        passagiers.forEach(p -> System.out.println("Passagier: " + p.getNaam() + ", Bagagegewicht: " + p.getBagageGewicht() + " kg"));
    }

    /**
     * passagiersgegevens opslaan in een bestand.
     */
    public void slaPassagiersOp() {
        String bestandspad = "C:\\Users\\admin\\IdeaProjects\\Project_Luchthaven\\files\\" + vluchtcode + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bestandspad))) {
            writer.write("----- Passagierslijst voor vlucht: " + vluchtcode + " -----\n");

            if (passagiers.isEmpty()) {
                String melding = "Geen passagiers aan boord.";
                writer.write(melding);
                System.out.print(melding);
            } else {
                for (Persoon.Passagiers passagier : passagiers) {
                    String passagierInfo = "Naam: " + passagier.getNaam() +
                            ", Bagagegewicht: " + passagier.getBagageGewicht() + " kg" +
                            ", Vertrek: " + vertrek +
                            ", Bestemming: " + bestemming + "\n";
                    writer.write(passagierInfo);
                    System.out.print(passagierInfo);
                }
            }

            System.out.println("Passagierslijst opgeslagen in: " + bestandspad);
        } catch (IOException e) {
            System.out.println("Fout bij het opslaan van passagierslijst: " + e.getMessage());
        }
    }
}
