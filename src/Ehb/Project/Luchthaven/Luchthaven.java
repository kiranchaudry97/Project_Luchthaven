package Ehb.Project.Luchthaven;


import Ehb.Project.Klasse.Klasse;
import Ehb.Project.Persoon.Passagiers;
import Ehb.Project.Persoon.Personeelslid;
import Ehb.Project.Vlucht.Vlucht;
import java.util.Scanner;

public class Luchthaven {
    /** De gegevens kunnen verwerken binnen het project van de klasse */
    public static void main(String[] args) {
        /** Het project laten werken met alle inhoud,
         *  de resultaten kunnen uitvoeren en lezen.
         */

        Scanner scanner = new Scanner(System.in);
        Vlucht vlucht = new Vlucht("FL123", "Brussel", "Parijs", 20, 10);
        /** Vlucht.java van daar de personeelsleden toegevoegd */
        try {
            vlucht.voegPersoneelslidToe(new Personeelslid("Fred VanHaven", "Piloot"));
            vlucht.voegPersoneelslidToe(new Personeelslid("Anna VanHouwere", "Stewardess"));
        } catch (Exception e) {
            System.out.println("Fout bij het toevoegen van personeelslid: " + e.getMessage());
        }
/** de keuzes waar maken die geselecteerd hebt **/

        boolean running = true;
        while (running) {
            System.out.println("Keuzemenu Luchthaven ---");
            System.out.println("1. Toon Vluchtinformatie");
            System.out.println("2. Passagier Toevoegen");
            System.out.println("3. Passagier Opslaan");
            System.out.println("4. Afsluiten");
            System.out.print("Kies een van de opties: ");
/** de volgende gekozen keuze van deze cases en dat ze leest en bij volgende can gaan*/
            try {
                int keuze = Integer.parseInt(scanner.nextLine());

                switch (keuze) {
                    case 1:
                        vlucht.toonVluchtInfo();
                        break;
                    case 2:
/** print de naam af een leest de volgende lijn dezelfde manier, de gegeven die je optypt leest. Dat je nummerie format geeft */
                        System.out.print("Naam passagier: ");
                        String naam = scanner.nextLine();
                        System.out.print("Bagagegewicht (kg): ");
                        double gewicht = Double.parseDouble(scanner.nextLine());
                        System.out.print("Welk klasse kies je (ECONOMY of BUSINESS): ");
                        try {
/** het value lezen van de klasse en het negeren van hoofdletter
 * Voegt de classe vlucht de info op */
                            Klasse klasse = Klasse.valueOf(scanner.nextLine().toUpperCase());
                            vlucht.voegPassagierToe(new Passagiers(naam, gewicht), klasse);
                            System.out.println(naam + " is toegevoegd aan de " + klasse + " klasse.");
/** tenzij het anders aangeven is dat dit aan neemt, en moet deze inhoud gekozen wat er wordt vermeld **/
                        } catch (IllegalArgumentException e) {
                            System.out.println("Ongeldige klasse. Kies ECONOMY of BUSINESS.");
                        }
                        break;
                    case 3:
                        vlucht.slaPassagiersOp();
                        break;
                    case 4:
                        running = false;
                        System.out.println("Applicatie wordt afgesloten.");
                        break;
                    default:
                        System.out.println("Probeer opnieuw en maak een andere keuze.");
                }
/** ongledige invoer tenzij je niet de juiste gegeven invoer geeft dit wordt vermeldt*/
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer. Voer een geldig nummer in.");
            }
        }
        scanner.close();
    }
}
