package Semester_1.skuskove;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main910Pomale {
    private static int mozneVyhry = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int pocetStavou = Integer.parseInt(scanner.nextLine());
            TreeMap<String, Label> hraciePole = new TreeMap<>();
            for (char i = 'A'; i < 'A' + pocetStavou; i++) {
                hraciePole.put(Character.toString(i), new Label(Character.toString(i)));
            }
            for (int i = 0; i < pocetStavou; i++) {
                StringTokenizer parser = new StringTokenizer(scanner.nextLine(), " ");
                Label setapLabel = hraciePole.get(parser.nextToken());
                setapLabel.setNula(hraciePole.get(parser.nextToken()));
                setapLabel.setJeden(hraciePole.get(parser.nextToken()));
                if (parser.nextToken().equals("x")) {
                    setapLabel.setSpecial();
                }
            }
            int pocetTahov = Integer.parseInt(scanner.nextLine());
            if (pocetTahov == 0) {
                System.out.println(1);
                continue;
            }

            generjHru(0, pocetTahov, hraciePole, hraciePole.get("A"));
            System.out.println(mozneVyhry);
            //System.out.println(Integer.toBinaryString((1 << pocetTahov) - 1));
            //System.out.println((1 << pocetTahov) - 1);


            /*
            //                  vygeneruje číslo potrebnej dĺžky so samými jednotkami
            for (long i = 0; i < (1 << pocetTahov) - 1 ; i++) {
                Semester_1.skuskove.Label stav = hraciePole.get("A");
                System.out.println(Long.toBinaryString(i));
                for (long j = 0; j < pocetTahov; j++) {
                    if (stav.isUzatvoreny()) {
                        break;
                    }
                    //System.out.print(stav);
                    if ((i & (1 << j)) == 0) {
                        stav = stav.getLabel(0);
                        continue;
                    }
                    stav = stav.getLabel(1);
                }
                if (stav.isSpecial()) {
                    mozneVyhry++;
                    //System.out.println(stav + " <---------");
                    continue;
                }

                //System.out.println(stav);
            }

            System.out.println(mozneVyhry);*/
        }

//        System.out.println(Integer.toBinaryString(21));
//        System.out.println(21 & (1 << 3));
    }

    private static void generjHru(int poradieTahu, int pocetTahovCelkovy, TreeMap<String, Label> hraciePole, Label akutualnePolicko) {
        if (poradieTahu >= pocetTahovCelkovy) {
            if (akutualnePolicko.isSpecial()) {
                Main910Pomale.mozneVyhry += 1;
            }
            return;
        }

        if (akutualnePolicko.isSpecial() && akutualnePolicko.isUzatvoreny()) {
            Main910Pomale.mozneVyhry += 1;
            return;
        }

        if (akutualnePolicko.isUzatvoreny()) {
            return;
        }

        for (int i = 0; i <= 1; i++) {
            generjHru(poradieTahu + 1, pocetTahovCelkovy, hraciePole, akutualnePolicko.getLabel(i));
        }
        return;


    }
}

class Label {
    private final String meno;
    private Label nula = null;
    private Label jeden = null;
    private boolean special = false;

    protected Label(String meno) {
        this.meno = meno;
    }

    public void setNula(Label nula) {
        this.nula = nula;
    }

    public void setJeden(Label jeden) {
        this.jeden = jeden;
    }

    public Label getLabel(int i) {
        if (i == 0) {
            return this.nula;
        }
        return this.jeden;
    }

    public boolean isSpecial() {
        return this.special;
    }

    public boolean isUzatvoreny() {
        return this.jeden == this && this.nula == this;
    }

    public void setSpecial() {
        this.special = true;
    }

    @Override
    public String toString() {
        return this.meno;
    }
}

