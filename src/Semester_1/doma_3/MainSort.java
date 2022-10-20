package Semester_1.doma_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

class Hodnoty {
    public String nazov;
    public Double hodnota;

    public Hodnoty(String nazov, Double hodnota) {
        this.nazov = nazov;
        this.hodnota = hodnota;
    }
}

public class MainSort {
    private static HashMap<String, Double> naPorovnanie = new HashMap<>();
    private static Double[] factLog = new Double[1001];
    private static ArrayList<Hodnoty> hodnotyClass = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        factLog[0] = 0.0;
        for (int i = 1; i < 1001; i++) {
            factLog[i] = Math.log(i) + factLog[i  - 1];
        }

        //Scanner scanner = new Scanner(System.in);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //int pocetTestCase = Integer.parseInt(scanner.nextLine());
        int pocetTestCase = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < pocetTestCase; i++) {
            String[] riadok = bufferedReader.readLine().split(" ");

            if (riadok.length == 2) {
                System.out.println(riadok[1]);
                continue;
            }

            for (int j = 1; j < riadok.length; j++) {
                //System.out.println(riadok[j]);
                if (riadok[j].contains("!")) {
                    String spracovanyRiadok = riadok[j].replace("!", "");
                    //naPorovnanie.put(riadok[j], factLog[Integer.parseInt(spracovanyRiadok)]);
                    hodnotyClass.add(new Hodnoty(riadok[j], factLog[Integer.parseInt(spracovanyRiadok)]));
                } else {
                    String[] rozdelenieCisel = riadok[j].split("\\^");
//                    for (String s : rozdelenieCisel) {
//                        System.out.println(s);
//                    }
                    //naPorovnanie.put(riadok[j], Integer.parseInt(rozdelenieCisel[1]) * Math.log(Integer.parseInt(rozdelenieCisel[0])) );
                    hodnotyClass.add(new Hodnoty(riadok[j], Integer.parseInt(rozdelenieCisel[1]) * Math.log(Integer.parseInt(rozdelenieCisel[0]))));

                }
            }

//            for (String slovo : naPorovnanie.keySet()) {
//                System.out.println(slovo);
//            }
            //porovnaj();
            porovnajDva();

        }

        long end = System.currentTimeMillis();
        //System.out.println("Môj cas je: " + (end - start));

    }

    private static void porovnajDva() {
        Collections.sort(hodnotyClass, new Comparator<Hodnoty>() {
            @Override
            public int compare(Hodnoty o1, Hodnoty o2) {
                return Double.valueOf(o1.hodnota).compareTo(o2.hodnota);
            }
        });

//        for (int i = 0; i < hodnotyClass.size(); i++) {
//            if (i == 0) {
//                System.out.print(hodnotyClass.get(i).nazov);
//                continue;
//            }
//
//            System.out.print(" " + hodnotyClass.get(i).nazov);
//        }
//        String vystup = null;
//        for (int i = 0; i < hodnotyClass.size(); i++) {
//            if (i == 0) {
//                vystup = hodnotyClass.get(i).nazov;
//                continue;
//            }
//
//            vystup += " " + hodnotyClass.get(i).nazov;
//        }
//        System.out.println(vystup);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < hodnotyClass.size(); i++) {
            builder.append(hodnotyClass.get(i).nazov).append(" ");
        }
        System.out.println(builder.substring(0, builder.length() - 1));
        hodnotyClass.clear();
    }

//    private static void porovnaj() {
//        ArrayList<String> poradie = new ArrayList<>();
//        String minimum = "";
//
//        if (naPorovnanie.containsKey("0!")) {
//            poradie.add("0!");
//            naPorovnanie.remove("0!");
//        }
//
//        while (!naPorovnanie.isEmpty()) {
//            for (String value : naPorovnanie.keySet()) {
//                for (String aDouble : naPorovnanie.keySet()) {
//
//                    if (naPorovnanie.get(value) < naPorovnanie.get(aDouble)) {
//                        if (!naPorovnanie.containsKey(minimum)) {
//                            minimum = value;
//                        }
//                        if (naPorovnanie.get(minimum) >= naPorovnanie.get(value)) {
//                            minimum = value;
//                        }
//                    } else {
//                        if (!naPorovnanie.containsKey(minimum)) {
//                            minimum = aDouble;
//                        }
//                        if (naPorovnanie.get(minimum) >= naPorovnanie.get(aDouble)) {
//                            minimum = aDouble;
//                        }
//                    }
//                }
//            }
//
//            poradie.add(minimum);
//            naPorovnanie.remove(minimum);
//            minimum = "";
//        }
//        for (int i = 0; i < poradie.size(); i++) {
//            if (i == 0) {
//                System.out.print(poradie.get(i));
//                continue;
//            }
//
//            System.out.print(" " + poradie.get(i));
//        }
//        System.out.println();
//    }
}
