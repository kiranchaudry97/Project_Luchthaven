package Ehb.Project.Luchthaven;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Vlucht {
    // string soort naam geven
    private String vluchtcode, vertrekBestemming, aankomstBestemming;
    // decimale getallen te gebruiken als private binnen de klasse te verwerken.
    private int economyPlaatsen, businessPlaatsen;
    // true en false methode te gebruiken
    private boolean flightCheckUitgevoerd = false;


    // MAX te gebruiken om maximale waarde te kunnen geven van de bagage.
    private final double MAX_BAGAGEGEWICHT = 20.0;
    //Array gebruikt om verzameling van de passagiers en personeel toe te voegen als extra.
    private ArrayList<Passagiers> passagiers = new ArrayList<>();
    private ArrayList<Personeelslids> personeel = new ArrayList<>();

    public Vlucht(String vluchtcode, String vertrekBestemming, String aankomstBestemming, int economyPlaatsen, int businessPlaatsen) {
        this.vluchtcode = vluchtcode;
        this.vertrekBestemming = vertrekBestemming;
        this.aankomstBestemming = aankomstBestemming;
        this.economyPlaatsen = economyPlaatsen;
        this.businessPlaatsen = businessPlaatsen;
    }


    public String getAankomstBestemming() {
        return aankomstBestemming;
    }

    public void setAankomstBestemming(String aankomstBestemming) {
        this.aankomstBestemming = aankomstBestemming;
    }


    public void voegPassagierToe(Passagiers passagier, String bestemming, String klasse) {
        if (!aankomstBestemming.equalsIgnoreCase(bestemming) || passagier.getBagageGewicht() > MAX_BAGAGEGEWICHT) {
            System.out.println("Ongeldige bestemming of te zware bagage.");
            return;
        }

        //switch case gebruikt om meerdere variable te kunnen gebruiken en te kunnen vergelijken.

        switch (klasse.toLowerCase()) {
            case "business":
                if (businessPlaatsen > 0) {
                    // gebruikt gemaakt van en decrement van aangtal plaatsen.
                    businessPlaatsen--;
                    passagiers.add(passagier);
                    System.out.println(passagier.getNaam() + " toegevoegd aan Business Class.");
                } else {
                    System.out.println("Geen beschikbare plaatsen in Business Class.");
                }
                break;

            case "economy":
                if (economyPlaatsen > 0) {
                    economyPlaatsen--;
                    passagiers.add(passagier);
                    System.out.println(passagier.getNaam() + " toegevoegd aan Economy Class.");
                } else {
                    System.out.println("Geen beschikbare plaatsen in Economy Class.");
                }
                break;

            default:
                System.out.println("Ongeldige klasse. Kies 'business' of 'economy'.");
        }
    }

    public void voegPersoneelToe(Personeelslids personeelslid) {
        //conditie operator gebruikt om false te geven
        //if en else statement gebruikt om deze waarde waar of niet waar aan te geven.
        if (personeelslid != null) {
            personeel.add(personeelslid);
            System.out.println(personeelslid.getNaam() + " toegevoegd als " + personeelslid.getFunctie());
        } else {
            System.out.println("Fout: Personeelslid mag niet null zijn.");
        }
    }
// vermelden Als er geen piloot of steward zijn dat dit niet mag opstijgen
    public void voerFlightCheckUit() {
        //
        flightCheckUitgevoerd = personeel.stream().anyMatch(p -> "Piloot".equalsIgnoreCase(p.getFunctie()));
        System.out.println(flightCheckUitgevoerd ? "Flightcheck succesvol uitgevoerd." : "Geen piloot voor flightcheck.");
    }

    //true en false te gebruiken en te vermelden wanneer er geen piloot of stewardess niet aanwezig
    // is dat dit niet mag opstijgen door if te gebruiken. Met de class van hun functie, en boodschapp te kunnen uitgeven.
    public boolean kanOpstijgen() {
        //conditie operator gebruikt om false te geven.
        // return te geven als de boodschap fout is.
        if (!flightCheckUitgevoerd) return foutmelding("Flightcheck niet uitgevoerd.");


        if (personeel.stream().noneMatch(p -> "Piloot".equalsIgnoreCase(p.getFunctie())))
            return foutmelding("Geen piloot aanwezig.");
        if (personeel.stream().noneMatch(p -> "Stewardess".equalsIgnoreCase(p.getFunctie())))
            return foutmelding("Geen stewardess aanwezig.");
        // printen in tekst en omzetten in true zijn.
        System.out.println("Vlucht is klaar voor vertrek!");
        return true;
    }

    //bij foutmelding moet dit in false zijn

    private boolean foutmelding(String boodschap) {
        System.out.println(boodschap);
        return false;
    }

    public void toonVluchtInfo() {
        System.out.printf("Vluchtcode:  | Vertrek:  | Aankomst: ", vluchtcode, vertrekBestemming, aankomstBestemming);
        System.out.printf("Economy plaatsen: | Business plaatsen: ", economyPlaatsen, businessPlaatsen);
        toonLijst("Passagiers", passagiers.stream().map(p -> p.getNaam() + " (" + p.getBagageGewicht() + " kg)").toArray());
        toonLijst("Personeel", personeel.stream().map(p -> p.getNaam() + " (" + p.getFunctie() + ")").toArray());
    }

    private void toonLijst(String titel, Object[] lijst) {
        System.out.print(titel + ": ");
        if (lijst.length == 0) System.out.println("Geen " + titel.toLowerCase() + " aan boord.");
        else for (Object item : lijst) System.out.print(item + ", ");
        System.out.println();
    }

    public void VluchtPassagiers() {

        // beschrijving: de vlucht van de passagier en hun gegevens kunnen opslaan bij een bestand.
        String bestandspad = "C:\\Users\\admin\\IdeaProjects\\Project_Luchthaven\\files"  +  vluchtcode + ".txt" ;
        String invoer = " Passagierslijst voor vlucht: "  +  vluchtcode ;

        // beschrijving: try methode gebruiken om de file te kunnen opslaan of afprinten
        //De vlucht info kunnen afprinten
        // if en else methode te gebruiken zie onder
        try (FileWriter writer = new FileWriter(bestandspad)) {

            writer.write(" Passagiers voor de vlucht: "  + vluchtcode );

            // vermelden als er geen passagier aan boord zijn dat dit empty is tenzij je naam niet indient.
            if (passagiers.isEmpty()) {
                writer.write("Geen passagiers aan boord.");
            } else {
           // als er passagier ingevuld wordt, moet de naam en het gewicht kunnen vermelden van de passagiers en de inhoud van de passergier zelf.
                for (Passagiers p : passagiers) {
                    writer.write(" Naam van de passagier " + p.getNaam() + " het gewicht van de bagage is " + p.getBagageGewicht() + " kg ");
                }
            }
        //printen om ze te kunnen tonen en aanmaken van tekst dat dit in orde is
            System.out.println(" Passagierslijst opgeslagen in: " + bestandspad);
        } catch (IOException e) {

        // Catch vooral als je fout misloopt in het bestand dat dit waarschuwt
            // om ze te kunnen vermelden dat er een probleem is.
            System.out.println("Fout bij het opslaan: " + e.getMessage());
        }
    }
}
