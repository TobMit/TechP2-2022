package Semester_1.doma_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MainJedlo {
    private static TreeMap<String, Integer> output = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        int countOfTestcases = Integer.parseInt(bufferReader.readLine());
        for (int i = 0; i < countOfTestcases; i++) {
            TreeMap<String, Integer> prisady = new TreeMap<>();
            int countOfPrisad = Integer.parseInt(bufferReader.readLine());
            for (int j = 0; j < countOfPrisad; j++) {
                StringTokenizer parser = new StringTokenizer(bufferReader.readLine(), " ");
                String nazov = parser.nextToken();
                prisady.put(nazov, (Integer.parseInt(parser.nextToken()) * 4) + (Integer.parseInt(parser.nextToken()) * 4) + (Integer.parseInt(parser.nextToken()) * 9) );
            }
            StringTokenizer parser = new StringTokenizer(bufferReader.readLine(), " ");
            int cMin = Integer.parseInt(parser.nextToken());
            int cMax = Integer.parseInt(parser.nextToken());

            boolean riesenie = false;
            for (Integer hodnota : prisady.values()) {
                if (hodnota <= cMax) {
                    riesenie = true;
                    continue;
                }
            }

//            if (!riesenie) {
//                System.out.println("no solution found");
//                if (i < countOfTestcases) {
//                    System.out.println();
//                }
//                continue;
//            }
            //System.out.println("blah");


//            for (String nazov : prisady.keySet()) {
//                System.out.println(nazov + " kalorie: " + prisady.get(nazov));
//            }
//            System.out.printf("Cmin: %d\t Cmax: %d\n\n", cMin, cMax);
            //      názov, pocet pouziti v recepte
            TreeMap<String, Integer> usedPrisady = new TreeMap<>();

            kombinuj(prisady, new TreeMap<>(prisady), cMin, cMax, 0, usedPrisady, true);


            if (!output.isEmpty()) {
                for (String vystup : output.keySet()) {
                    System.out.println(vystup.replace("}}}}}}}}}}}}}}}}}}{{", ""));
                }
            } else {
                System.out.println("no solution found");
            }

            System.out.println();
            output.clear();

        }
        bufferReader.close();

    }


    private static void kombinuj(TreeMap<String, Integer> prisady, TreeMap<String, Integer> prisadyNaPremazanie, int cMin, int cMax, int sum, TreeMap<String, Integer> usedPrisady, boolean prvyRun) {
        if (sum <= cMax && sum >= cMin) {
            //System.out.print(usedPrisady);
            String outputBilder = null;
            //int kcal = 0;
            for (String used : usedPrisady.keySet()) {
                //kcal += prisady.get(used) * usedPrisady.get(used);
                //System.out.print(used + " ");
                if (outputBilder == null) {
                    outputBilder = used + " " + usedPrisady.get(used) + "x";
                } else {
                    outputBilder += ", " + used + " " + usedPrisady.get(used) + "x";
                }
            }
            outputBilder += "}}}}}}}}}}}}}}}}}}{{ = " + sum + " kcal";
            //System.out.printf(" Suma: %d  Max: %d  Min: %d\n", kcal, cMax, cMin);
            output.put(outputBilder, 0);
            //System.out.println(outputBilder);
            //System.out.println(outputBilder + " " + sum);
        }

        for (String prisada : prisady.keySet()) {
            if (sum > cMax) {
                continue;
                //return;
            }
            if (usedPrisady.containsKey(prisada)) {
                usedPrisady.put(prisada, usedPrisady.get(prisada) + 1);
            } else {
                usedPrisady.put(prisada, 1);
            }

            if (sum + prisady.get(prisada) <= cMax) {
                kombinuj(prisadyNaPremazanie, prisadyNaPremazanie, cMin, cMax, sum + prisady.get(prisada), usedPrisady, false);
            }

            //kombinuj(prisady, cMin, cMax, sum + prisady.get(prisada), usedPrisady);
            


            if (usedPrisady.get(prisada) > 1) {
                usedPrisady.put(prisada, usedPrisady.get(prisada) - 1);
            } else {
                usedPrisady.remove(prisada);
            }
            if (prvyRun) {
                prisadyNaPremazanie.remove(prisada);
            }
            //usedPrisady.remove(usedPrisady.size() - 1);
        }
        return;
    }
}