package Ehb.Project.Luchthaven;

import Ehb.Project.Klasse.Klasse;
import Ehb.Project.Persoon.Persoon;
import Ehb.Project.Vlucht.Vlucht;
import Ehb.Project.Persoon.Personeelslid;

import java.util.Scanner;


public class Luchthaven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vlucht vlucht = new Vlucht("FL123", "Brussel", "Parijs", 20, 10);

        vlucht.voegPersoneelslidToe(new Personeelslid("Fred VanHaven", "Piloot"));
        vlucht.voegPersoneelslidToe(new Personeelslid("Anna VanHouwere", "Stewardess"));

        boolean running = true;
        while (running) {
            System.out.println("Keuzemenu Luchthaven ---");
            System.out.println("1. Toon Vluchtinformatie");
            System.out.println("2. Passagier Toevoegen");
            System.out.println("3. Passagier Opslaan");
            System.out.println("4. Afsluiten");
            System.out.print("kies een van de opties: ");

            try {
                int keuze = Integer.parseInt(scanner.nextLine());

                switch (keuze) {
                    case 1:
                        vlucht.toonVluchtInfo();
                        break;
                    case 2:
                        System.out.print("Naam passagier: ");
                        String naam = scanner.nextLine();
                        System.out.print("Bagagegewicht (kg): ");
                        double gewicht = Double.parseDouble(scanner.nextLine());
                        System.out.print(" welk klasse kies u ECONOMY of BUSINESS): ");
                        try {
                            Klasse klasse = Ehb.Project.Klasse.Klasse.valueOf(scanner.nextLine().toUpperCase());
                            vlucht.voegPassagierToe(new Persoon.Passagiers(naam, gewicht), klasse);
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
                        System.out.println("probeer opnieuw maak een andere keuze.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ongeldige invoer. Voer een geldig nummer in.");
            }
        }
        scanner.close();
    }
}