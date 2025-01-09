package Ehb.Project.Luchthaven;

import Ehb.Project.Persoon.Passagiers;
import Ehb.Project.Persoon.Personeelslids;
import Ehb.Project.Vlucht.Vlucht;

import java.util.Scanner;

public class Luchthaven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/**
 * methode of functie gebruikt om binnen de applicatie te kunnen herbruiken en terug kan sturen.
 * Vlucht aangemaakt met de inhoud van de class vlucht zelf bij toonvluchtinfo, en ze te kunnen toevoegen.
 * Dat dit de vlucht info toont.
 */
        Vlucht vlucht = new Vlucht("FL123", "Brussel", "Parijs", 2, 1);
        vlucht.toonVluchtInfo();
/**
 * nieuwe Personeels toevoegen met de inhoud van de class personeelslid
 * bij public voegPersoneelToe.
 */

        vlucht.voegPersoneelToe(new Personeelslids("Fred VanHaven", 45, "Leuven", "Piloot"));
        vlucht.voegPersoneelToe(new Personeelslids("Anna VanHouwere", 35, "Luchtvaartlaan", "Stewardess"));
/**
 *  als de personeels aanwezig zijn
 * dat ze mogen opstijgen
 *  bij de klasse vlucht.java info kan je zien de informatie over de public void: Voerflightcheckout en (if) Vluchtkanopstijgen.
 * Als ze niet aanwezig zijn dat dit foutmelding aangeeft.
 *
 *
 */
        vlucht.voerFlightCheckUit();
/**
 *  vermelden als er personeel zijn dat dit mag opstijgen en dat dit print af bij de output.
 */

        if (vlucht.kanOpstijgen()) {
            System.out.println("De vlucht is klaar om op te stijgen.");
        }
/**
 * om de keuze waar te maken , om waar te maken van de gekozen keuze
 * true gebruikt.
 * while running --> voor de gekozen selecties waar te maken.
 * deze genoemde keuzen als output geprint.
 * de waarde nummer die je heb ingevoerd van de gekozen selectie.
 */
        boolean running = true;
        while (running) {
            System.out.println(" --- Keuzemenu Luchthaven ---");
            System.out.println("1. Toon Vluchtinformatie");
            System.out.println("2. Passagiers toevoegen");
            System.out.println("3. Passagierslijst opslaan");
            System.out.println("4. Afsluiten");
            System.out.print("Selecteer een optie: ");
/**
 * de Invoer als string lezen en converteren naar een integer.
 * dat deze volgende lijn kan lezen als scanner gebruikt
 * van gekozen nummer in int omzetten
 */

            String input = scanner.nextLine().trim();
            int keuze;
/**
 *  dat je de invoer enkel waarde kan gebruiken bij de input.
 *  en de gekozen input die je hebt gebruikt, tenzij niet van deze gekozen nummer is
 *  ,vermeld dit dat je enkel tussen 1 en 4 kan kiezen.
 */
            try {

                keuze = Integer.parseInt(input);
            } catch (NumberFormatException e) {


                System.out.println(" Ongeldige invoer. Voer een nummer in tussen 1 en 4.");
/**
 * dat deze continue gaat voor de gekozen input bij de keuze optie.
 * Dat dit gebruikt maakt van switch case. case zoals bij de classe info vlucht.java zie je deze
 *  informatie zien, bij public void de gegevens wordt hier onderstaan.
  */
                continue;
            }
            switch (keuze) {
                case 1:

/** zie bij vlucht.java --> public voids ToonVlucht en anderen,zie je de inhoud */
                    vlucht.toonVluchtInfo();
                    break;

                case 2:
/**
 *  gebruikt om extra passagier toevoegen en dit waar te maken --> zie bij vlucht.java
 *  public void bij voegPassagiersAutomatischToe in lijn 209 dat deze scanner leest en toevoegt.
  */
                    boolean addingPassengers = true;
                    while (addingPassengers) {
                        System.out.println("Voer de naam van de passagier in (of druk op Enter om te stoppen):");
                        String ticketNaam = scanner.nextLine().trim();
/**
 * if gebruikt tenzij er passagiers in ingevoerd is dat dit stopt zie vlucht.info lijn 268.
 *  break --> dat dit stop.
 */
                    if (ticketNaam.isEmpty()) {
                            System.out.println("Passagier-invoer gestopt.");
                            break;
                        }
/**
 *  output maken voor te kiezen welke klasse die je voor kiest dat je dit invult.
 *  en dat de scanner dit leest en volgende lijn gaat, zie bij vlucht.java, lijn 243 tot 250.
 */
                        System.out.println("Kies klasse (Economy of Business):");
                        String klasse = scanner.nextLine().trim();
/**
 *  zie de inhoud vlucht.java lijn 256 tot 269.
 *  while --> true aangeven tenzij de bagage gewicht is onder de 20kg
 *  dat ze vlucht mogen nemen.
 * dat de bagage gewicht van de waarde invullen dat de scanner dit leest en volgende gaat,
 *  if bagage gewicht >= 0 is dit inorde.
 *  else en catch enkel nummerieke waarde moeten geven of dat dit gewicht negatief moet zijn.
 * NumberFormatException e: dat dit vermeld als dit
  */

                        double bagageGewicht;
                        while (true) {
                            System.out.println("Voer bagagegewicht in (kg):");
                            try {
                                //Om ze volgende lijn te kunnen lezen,
                                bagageGewicht = Double.parseDouble(scanner.nextLine());
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
 * passiergs toevoegen zie --> vlucht.java lijn  en 92 tot 114 zie de inhoud.
 * met de aankomst bestemming en dat ze de ticketen hebben, zie lijn 60 en ze kunnen afprinten in de ouput.
 **/


                        vlucht.voegPassagierToe(
                                new Passagiers(ticketNaam, 0, "/", bagageGewicht, true),
                                vlucht.getAankomstBestemming(),
                                klasse
                        );

                        System.out.println(" Passagier '" + ticketNaam + "' succesvol toegevoegd aan " + klasse + " Class.");
                    }
/**
 * in de lijst --> de gegevens van de passagier die werden bewaard.
 * zie vlucht.java lijn 176 en 286
 *  de passagierslijst op slaan en ze te kunnen afprinten.
 */

                    System.out.println(" Overzicht Toegevoegde Passagiers ");
                    vlucht.toonVluchtInfo();
                    vlucht.VluchtPassagiers();
                    break;

                case 3:

                    vlucht.VluchtPassagiers();
                    break;
/**
 * om de applicatie kunnen afgesloten is
 *  als false aantegeven,
 *  default om case af te sluiten.
 *
 */
                case 4:


                    running = false;
                    System.out.println("Applicatie afgesloten.");
                    break;

                default:
/**
 *  Ongeldige invoer
 */

                    System.out.println("Ongeldige keuze. Kies een nummer tussen 1 en 4.");
            }
        }
/**
 *  om afsluiten en gegevens te bewaren.
 *
 */
        scanner.close();
    }
}

/**
 * @author Chaud-ry Kiran
 * programming Advanced - Luchthaven
 */

