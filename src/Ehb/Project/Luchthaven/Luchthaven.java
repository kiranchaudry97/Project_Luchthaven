package Ehb.Project.Luchthaven;

import java.util.Scanner;

public class Luchthaven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//methode of functie gebruikt om binnen applicatie te kunnen herbruiken en terug kan sturen.
//vlucht aanmaken met de inhoud van de class vlucht zelf
        Vlucht vlucht = new Vlucht("FL123", "Brussel", "Parijs", 2, 1);
        vlucht.toonVluchtInfo();
//personeel aanmaken met de inhoud van de class personeelslids
        vlucht.voegPersoneelToe(new Personeelslids("Fred VanHaven", 45, "Leuven", "Piloot"));
        vlucht.voegPersoneelToe(new Personeelslids("Anna VanHouwere", 35, "Luchtvaartlaan", "Stewardess"));

        vlucht.voerFlightCheckUit();
//vermelden als er personeel zijn dat dit mag opstijgen en print dit af
        if (vlucht.kanOpstijgen()) {
            System.out.println("De vlucht is klaar om op te stijgen.");
        }
//uit te kunnen printen zoals hier onder de naam, welke klasse, en begagegewicht
        System.out.println("Voer de naam van de passagier in:");
        //scanner gebruik om input te kunnen lezen vooral ook de volgende lijn.
        String ticketNaam = scanner.nextLine();
        System.out.println("Kies klasse (Economy of Business):");
        String klasse = scanner.nextLine();
        System.out.println("Voer bagagegewicht in (kg):");

        double bagageGewicht = scanner.nextDouble();

// voor extra passagier die worden toegevoegd of ingevuld
        vlucht.voegPassagierToe(new Passagiers(ticketNaam, 0, "/", bagageGewicht, true), vlucht.getAankomstBestemming(), klasse);

        vlucht.VluchtPassagiers();
    }
}
