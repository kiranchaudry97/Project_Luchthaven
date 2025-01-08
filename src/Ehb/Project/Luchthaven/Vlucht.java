package Ehb.Project.Luchthaven.Vlucht;

import java.util.ArrayList;

public class Vlucht {
    private String vluchtcode;
    private String bestemming;
    private int plaatsen;
    private ArrayList<Passagiers> passagiers = new ArrayList<>();
    private ArrayList<Personeelslids> personeel = new ArrayList<>();

    public Vlucht(String vluchtcode, String bestemming, int plaatsen) {
        this.vluchtcode = vluchtcode;
        this.bestemming = bestemming;
        this.plaatsen = plaatsen;
    }

    public void voegPassagierToe(Passagiers passagier) {
        if (passagiers.size() < plaatsen) {
            passagiers.add(passagier);
            System.out.println("Passagier toegevoegd: " + passagier.getNaam());
        } else {
            System.out.println("Geen plaatsen meer beschikbaar.");
        }
    }

    public void voegPersoneelToe(Personeelslids personeelslid) {
        personeel.add(personeelslid);
        System.out.println("Personeel toegevoegd: " + personeelslid.getNaam());
    }

    public void toonVluchtInfo() {
        System.out.println("Vlucht: " + vluchtcode + ", Bestemming: " + bestemming);
        System.out.println("Passagierslijst:");
        for (Passagiers p : passagiers) {
            System.out.println("- " + p.getNaam());
        }
        System.out.println("Personeel:");
        for (Personeelslids );
    }
              {
            Personeelslids p = null;
            System.out.println("- " + p.getNaam() + " (" + p.getFunctie() + ")");
        }
    }
}
