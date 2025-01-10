package Ehb.Project.Vlucht;


import Ehb.Project.Klasse.Klasse;
import Ehb.Project.Persoon.Passagiers;
import Ehb.Project.Persoon.Personeelslid;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Vlucht {
    private final String vluchtcode;
    private final String vertrek;
    private final String bestemming;
    private final int maxPassagiers;
    private final Map<Klasse, Integer> beschikbarePlaatsen = new EnumMap<>(Klasse.class);
    private final Set<Passagiers> passagiers = new HashSet<>();
    private final Map<Passagiers, Klasse> passagierKlasseMap = new HashMap<>();
    private final Set<Personeelslid> personeel = new HashSet<>();
    private static final double MAX_BAGAGEGEWICHT = 20.0;
    private boolean flightCheckUitgevoerd = false;

    public Vlucht(String vluchtcode, String vertrek, String bestemming, int maxEconomy, int maxBusiness) {
/** gebruikt om de beschikbare plaatsen per klasse bij te houden en te gebruiken. */
        this.vluchtcode = vluchtcode;
        this.vertrek = vertrek;
        this.bestemming = bestemming;
        this.maxPassagiers = maxEconomy + maxBusiness;
        beschikbarePlaatsen.put(Klasse.ECONOMY, maxEconomy);
        beschikbarePlaatsen.put(Klasse.BUSINESS, maxBusiness);
    }

    /**
     * voegen van personeels, passgieren ze kunnen afprinten
     */
    public void voegPersoneelslidToe(Personeelslid personeelslid) {
        personeel.add(personeelslid);
        System.out.println(personeelslid.getNaam() + " toegevoegd als " + personeelslid.getFunctie());
    }

    /**
     * voegt vooral de specififieke klasse en controleert,
     * limiet zetten van de begageg gewicht
     * voegen van passagier en het aantal beschikbare plaatsen
     */

    public void voegPassagierToe(Passagiers passagier, Klasse klasse) {
        if (passagiers.size() >= maxPassagiers) {
            System.out.println("Maximaal aantal passagiers bereikt.");
            return;
        }
        if (!passagier.isBagageGewichtToegestaan(MAX_BAGAGEGEWICHT)) {
            System.out.println("Bagagegewicht te zwaar: maximaal " + MAX_BAGAGEGEWICHT + " kg.");
            return;
        }
        if (beschikbarePlaatsen.get(klasse) > 0) {
            passagiers.add(passagier);
            passagierKlasseMap.put(passagier, klasse);
            beschikbarePlaatsen.put(klasse, beschikbarePlaatsen.get(klasse) - 1);
            System.out.println(passagier.getNaam() + " is toegevoegd aan de " + klasse + " klasse.");
        } else {
            System.out.println("Geen beschikbare plaatsen in " + klasse + " klasse.");
        }
    }

    public void toonVluchtInfo() {
        System.out.println("Vlucht: " + vluchtcode);
        System.out.println("Van: " + vertrek + " Naar: " + bestemming); // Toegevoegd
        System.out.println("Beschikbare plaatsen: " + beschikbarePlaatsen);
        System.out.println("Passagiers: " + passagiers.size() + "/" + maxPassagiers);
        System.out.println("Personeel: " + personeel.size());
        passagiers.forEach(p -> System.out.println(p + ", Klasse: " + passagierKlasseMap.get(p))); //
    }

    public void slaPassagiersOp() {
        String bestandspad = "C:\\Users\\admin\\IdeaProjects\\Project_Luchthaven\\files\\" + vluchtcode + ".txt";
/** bestand te kunnen lezen */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bestandspad))) {
            writer.write("----- Passagierslijst voor vlucht: " + vluchtcode + " -----\n");
            writer.write("Van: " + vertrek + " Naar: " + bestemming + "\n"); //

            if (passagiers.isEmpty()) {
                writer.write("Geen passagiers aan boord.\n");
            } else {
                for (Passagiers passagier : passagiers) {
                    writer.write(passagier.toString() + ", Klasse: " + passagierKlasseMap.get(passagier) + "\n");
                }
            }
/** dit wordt vermeldt dat de gegevens opslaan mislukt is*/

            System.out.println("Passagierslijst opgeslagen in: " + bestandspad);
        } catch (IOException e) {
            System.out.println("Fout bij het opslaan van passagierslijst: " + e.getMessage());
        }
    }
    @Override
    public String toString() {
        return "Vlucht{" +
                "vluchtcode='" + vluchtcode + '\'' +
                ", vertrek='" + vertrek + '\'' +
                ", bestemming='" + bestemming + '\'' +
                ", maxPassagiers=" + maxPassagiers +
                ", beschikbarePlaatsen=" + beschikbarePlaatsen +
                ", passagiers=" + passagiers +
                ", personeel=" + personeel +
                '}';
    }
}
