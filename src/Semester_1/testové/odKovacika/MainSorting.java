package Semester_1.testové.odKovacika;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainSorting {
    static double[] generated = new double[1002];
    static List<Pair<String, Double>> pary = new ArrayList<>();

    static {
        generated[0] = 0.0;
        for (int i = 1; i <= 1000; i++) {
            generated[i] = Math.log(i) +  generated[i - 1];
            //System.out.println(generated[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader reader = new BufferedReader(new FileReader("src/sub.txt"));

        String line = "";
        int tests = 0;

        line = reader.readLine();
        tests = Integer.parseInt(line);

        for (int i = 0; i < tests; i++) {
            line = reader.readLine();
            String[] array = line.split(" ");
            handleInput(array);
            sortListofPairs();
            pary.clear();
        }
        reader.close();
        long end = System.currentTimeMillis();
        System.out.println("Môj čas je: " + (end - start));
    }
    static void handleInput(String[] input) {
        for (int i = 1; i < input.length; i++) {
            if (input[i].contains("!")) {
                String s = input[i].replace("!","");
                pary.add(new Pair<>(input[i], logFackt(Integer.parseInt(s))));
            } else {
                String[] cisla = input[i].split("\\^");
                int x = Integer.parseInt(cisla[0]);
                int y = Integer.parseInt(cisla[1]);
                pary.add(new Pair<>(input[i], y * Math.log(x)));
            }
        }
    }
    static double logFackt(int n) {
        return generated[n];
    }
    static void sortListofPairs() {
        pary.sort(Comparator.<Pair<String, Double>>comparingDouble(Pair::getValue).
                thenComparingDouble(Pair::getValue));

        StringBuilder pom = new StringBuilder();

        for (Pair pair : pary) {
            pom.append(pair.key).append(" ");
        }
        System.out.println(pom.substring(0, pom.length() - 1));

    }
    public static class Pair<S, D extends Number> {
        private String key;
        private Double value;

        public Pair(String key, Double value) {
            this.key = key;
            this.value = value;
        }
        public Double getValue() {
            return value;
        }
    }
}
