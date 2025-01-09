package Ehb.Project.Vlucht;


import Ehb.Project.Persoon.Passagiers;
import Ehb.Project.Persoon.Personeelslids;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;




public class Vlucht {
    /**
     *  klasse vlucht aangemaakt met het gebruik van de character en zie de inhoud.
     *  private gebruik om binnen klassen te verwerken.
     *   methode gebruik zoals true en false aan te kunnen geven.
     */

    private String vluchtcode, vertrekBestemming, aankomstBestemming;

    private int economyPlaatsen, businessPlaatsen;

    private boolean flightCheckUitgevoerd = false;


    /**
     *  MAX gebruikt om maximale waarde te kunnen geven van de bagage, om de waarde vast te stellen is dit 20 gebruik te maken van final.
     *  Array gebruikt om de verzameling van de passsagiers en personeel toe te voegen als extra.
     */


    private final double MAX_BAGAGEGEWICHT = 20.0;

    private ArrayList<Passagiers> passagiers = new ArrayList<>();
    private ArrayList<Personeelslids> personeel = new ArrayList<>();


 /**
  *  public gebruikt om toegang van andere klassen.
  *  vlucht klasse een naam gegeven van de constructor.
  *  de lijsten aangegeven.
  *  this gebruikt met de object.
 */

    public Vlucht(String vluchtcode, String vertrekBestemming, String aankomstBestemming, int economyPlaatsen, int businessPlaatsen) {
        this.vluchtcode = vluchtcode;
        this.vertrekBestemming = vertrekBestemming;
        this.aankomstBestemming = aankomstBestemming;
        this.economyPlaatsen = economyPlaatsen;
        this.businessPlaatsen = businessPlaatsen;
    }

    /**
     * get en return gebruikt om deze methode terug aantwoord kan geven soort aanroeping.
     *
     */
    public String getAankomstBestemming() {

        return aankomstBestemming;
    }

    /**
     *
     * dat je deze set kan wijzigen
     */
    public void setAankomstBestemming(String aankomstBestemming) {
        this.aankomstBestemming = aankomstBestemming;
    }

    /**
     * if gebruikt een van de voorwaarde ongeldig is.
     * of operator gebruikt,
     * teksten negeren met hoofdletters of kleine letters., de limiet van de bagage
     * stop zetten van de uitvoering.
     */
    public void voegPassagierToe(Passagiers passagier, String bestemming, String klasse) {
        if (!aankomstBestemming.equalsIgnoreCase(bestemming) || passagier.getBagageGewicht() > MAX_BAGAGEGEWICHT) {
            System.out.println("Ongeldige bestemming of te zware bagage.");
            return;
        }

/**
 * 89 tot 111: switch case gebruikt om meerdere variable te kunnen gebruiken en te kunnen vergelijken.
 * , de hoofdletters worden genegeerd
 * 113: voor ongeldige invoer
 *  ingevoegd of afgetrokken van passagier, plaatsen van business en economy
  */

        switch (klasse.toLowerCase()) {
            case "business":
                if (businessPlaatsen > 0) {
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
/**
* conditie operator gebruikt om false te geven, en geen waarde doorgeven gebruik maken van if en else statement.
*  en dat dit niet nul mag zijn.
 * if en else statement gebruikt om deze waarde waar of niet waar aan te geven.
*/



        if (personeelslid != null) {
            personeel.add(personeelslid);
            System.out.println(personeelslid.getNaam() + " toegevoegd als " + personeelslid.getFunctie());
        } else {
            System.out.println("Fout: Personeelslid mag niet null zijn.");
        }
    }

    /**
     * vermelden Als er geen piloot of steward zijn dat dit niet mag opstijgen,
     *dat minstens een persoon aanwezig zijn die door de lijst controleert.
     */
    public void voerFlightCheckUit() {
        //
        flightCheckUitgevoerd = personeel.stream().anyMatch(p -> "Piloot".equalsIgnoreCase(p.getFunctie()));
        System.out.println(flightCheckUitgevoerd ? "Flightcheck succesvol uitgevoerd." : "Geen piloot voor flightcheck.");
    }

    /**
     * if controleert de flight check die niet uitgevoerd is.
     * geeft een foutmelding aan en wordt terug gestuurd.
     * controleert of personeel aanwezig zijn, bij foutmelding vemerld.
     * dit tenzij ze niet aanwezig zijn door false gebruiken.
     * tenzij ze aanwezig zijn mogen ze vertrekken.
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
     * lijst met passagiers en personeel aangemaakt met de inhoud
     * voor ze kunnen printen.
     */
    public void toonVluchtInfo() {
        System.out.println("Vluchtinformatie:");
        System.out.println("Vluchtcode: " + vluchtcode);
        System.out.println("Vertrek: " + vertrekBestemming);
        System.out.println("Aankomst: " + aankomstBestemming);
        System.out.println("Economy plaatsen: " + economyPlaatsen);
        System.out.println("Business plaatsen: " + businessPlaatsen);

        toonLijst("Passagiers", passagiers.stream()
                .map(p -> p.getNaam() + " (" + p.getBagageGewicht() + " kg)").toArray());

        toonLijst("Personeel", personeel.stream()
                .map(p -> p.getNaam() + " (" + p.getFunctie() + ")").toArray());
    }

    /**
     *
     *als de lijst geen passagier aanwezig zijn dat de lijst leeg
     * for loop gebruikt.
     * de object list van de array.
     * lengt gebruikt en operator --> dit betekent dat de lijst leeg is.
     */
    private void toonLijst(String titel, Object[] lijst) {
        System.out.print(titel + ": ");
        if (lijst.length == 0) System.out.println("Geen " + titel.toLowerCase() + " aan boord.");
        else for (Object item : lijst) System.out.print(item + ", ");
        System.out.println();
    }

    public void voegPassagiersAutomatischToe() {
/**
* Scanner gebruiken voor gebruikersinvoer.
*/
        Scanner scanner = new Scanner(System.in);

/**
*   While-loop voor continue passagiersinvoer.
*/

        while (true) {
/**
*  passagiers naam in te voeren, en dat de scanner dit leest.
*/
            System.out.println("Voer de naam van de passagier in (of druk op Enter om te stoppen):");
            String naam = scanner.nextLine().trim();

/**
*  226: Stopt de loop als de naam leeg is.
*/

            if (naam.isEmpty()) {
                System.out.println("Passagier-invoer gestopt.");
                break;
            }
/**
 *
 */

/**
 * lus gebruikt dat ze blijven doorgaan voor de klasse.
 * dat de scanner dit leest die je invoert
 * de vergelijkingen negeert met de hoofdletters
 * break stop de lus.
 */
            String klasse;
            while (true) {
                System.out.println("Kies klasse (Economy of Business):");
                klasse = scanner.nextLine().trim();

                if (klasse.equalsIgnoreCase("Economy") || klasse.equalsIgnoreCase("Business")) {
                    break;
                } else {
                    System.out.println("Ongeldige klasse. Kies 'Economy' of 'Business'.");
                }
            }

/**
 * vraagt om naar bagage gewicht, de invoert naar double omzetten
 * als dit negatief is moet je opnieuw invoeren en breekt de lus, vermeld foutmelding.
 * catch, gebruikt voor foutieve nummer van de waarde die niet geld.
  */
            double bagageGewicht = 0;
            while (true) {
                System.out.println("Voer bagagegewicht in (kg):");
                String bagageInput = scanner.nextLine().trim();
                try {
                    bagageGewicht = Double.parseDouble(bagageInput);
                    if (bagageGewicht >= 0) {
                        break;
                    } else {
                        System.out.println("Bagagegewicht mag niet negatief zijn. Probeer opnieuw.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ongeldige invoer. Voer een numerieke waarde in voor bagagegewicht.");
                }
            }
/**
 *  voegt vooral de passagier toe,
 * 280 en dat dit succesvol is toegevoed is.
 * met de inhoud van de passagiers er bij de vlucht.
  */

            voegPassagierToe(new Passagiers(naam, 30, "/", bagageGewicht, true), aankomstBestemming, klasse);


            System.out.println(" Passagier '" + naam + "' succesvol toegevoegd aan " + klasse + " Class.");
        }
    }


    public void VluchtPassagiers() {

/**
*   om de gevegevens te kunne opslaan van de passagiers en hun vlucht.
*/
        String bestandspad = "C:\\Users\\admin\\IdeaProjects\\Project_Luchthaven\\files\\" + vluchtcode + ".txt";

        try (FileWriter writer = new FileWriter(bestandspad)) {
/**
*  Schrijft de vluchtinformatie naar het bestand \n voor nieuw wit regel
*/
            writer.write("----- Passagierslijst voor vlucht: " + vluchtcode + " -----\n");

/**
 * drukt af naar console.
  */
            System.out.println("\n----- Passagierslijst voor vlucht: " + vluchtcode + " -----");

            // Vermelden als er geen passagiers aan boord zijn
            if (passagiers.isEmpty()) {
                String melding = "Geen passagiers aan boord.\n";
                writer.write(melding); // Schrijf naar bestand
                System.out.print(melding); // Print naar console
            } else {

                for (Passagiers p : passagiers) {

                    String klasse = bepaalKlasse(p);
/**
 *  Maakt een string met passagiersinformatie inclusief klasse, vertrek en bestemming
 */

                    String passagierInfo = "Naam: " + p.getNaam() +
                            ", Bagagegewicht: " + p.getBagageGewicht() + " kg" +
                            ", Klasse: " + klasse +
                            ", Vertrek: " + vertrekBestemming +
                            ", Bestemming: " + aankomstBestemming + "\n";
/**
*  Schrijf de passagiersinformatie naar het bestand.
*/
                    writer.write(passagierInfo);
/**
 *  toon dezelfde informatie op de console.
 */

                    System.out.print(passagierInfo);
                }
            }
/**
 *  Printen om te tonen dat de lijst succesvol is opgeslagen
  */
            String bevestiging = "Passagierslijst opgeslagen in: " + bestandspad + "\n";
            System.out.println(bevestiging);
        } catch (IOException e) {
/**
*  vooral als je fout misloopt in het bestand dat dit waarschuwt
 * om ze te kunnen vermelden dat er een probleem is.
*/
            System.out.println(" Fout bij het opslaan: " + e.getMessage());
        }
    }

    /**
     *
     *  passagier controleert of ze aanwezig zijn, bij de beschikbare plaatsen.
     *  als de passgiers niet in lijst staat wordt dit onbekend.
     */

    private String bepaalKlasse(Passagiers passagier) {
        if (passagiers.contains(passagier)) {

            if (businessPlaatsen < economyPlaatsen) {
                return "Business";
            } else {
                return "Economy";
            }
        }
        return "Onbekend";
    }
}

/**
 * @author Chaud-ry Kiran
 *  programming Advanced - Luchthaven
 */