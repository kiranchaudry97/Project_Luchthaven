package Ehb.Project.Luchthaven;



public class LuchthavenTester {
    public static void main(String[] args) {
        

       // vlucht aanmaken
        Vlucht vlucht = new Vlucht("FL123", "Brussel", "Parijs", 2, 1);
        vlucht.toonVluchtInfo();

        // passagiers toevoegen
        Passagiers passagier1 = new Passagiers("Jan Janssen", 30, "Brussel", 10.0);
        vlucht.voegPassagierToe(passagier1, "Parijs", "Economy");

        Passagiers passagier2 = new Passagiers("Lisa Peeters", 25, "Antwerpen", 12.0);
        vlucht.voegPassagierToe(passagier2, "Parijs", "Business");


        Personeelslids piloot = new Personeelslids("Captain Marvel", 45, "Sky City", "Piloot");
        vlucht.voegPersoneelToe(piloot);

        vlucht.voerFlightCheckUit();


        vlucht.kanOpstijgen();


        vlucht.toonVluchtInfo();
    }
}
