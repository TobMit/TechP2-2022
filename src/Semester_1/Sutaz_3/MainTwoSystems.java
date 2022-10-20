package Semester_1.Sutaz_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class MainTwoSystems {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int pocetVystupov = Integer.parseInt(bufferedReader.readLine());
        TreeMap<String, Integer> firstMachine = new TreeMap<>();
        TreeMap<String, Integer> secondMachine = new TreeMap<>();

        //first machine
        for (int i = 0; i < pocetVystupov; i++) {
            String result = bufferedReader.readLine();
            if (firstMachine.containsKey(result)) {
                firstMachine.put(result, firstMachine.get(result) + 1);
            } else {
                firstMachine.put(result, 1);
            }
        }

        //second machine
        for (int i = 0; i < pocetVystupov; i++) {
            String result = bufferedReader.readLine();
            if (secondMachine.containsKey(result)) {
                secondMachine.put(result, secondMachine.get(result) + 1);
            } else {
                secondMachine.put(result, 1);
            }
        }

        System.out.println(vysledok(firstMachine, secondMachine));

    }

    private static int vysledok(TreeMap<String, Integer> firstMachine, TreeMap<String, Integer> secondMachine) {
        int result = 0;
        for (String overovaciaHodnota : firstMachine.keySet()) {
            int firstMach = firstMachine.get(overovaciaHodnota);
            int secontdMach = 0;
            if (secondMachine.containsKey(overovaciaHodnota)) {
                secontdMach = secondMachine.get(overovaciaHodnota);
            } else {
                continue;
            }

            if (firstMach < secontdMach) {
                result += firstMach;
            } else {
                result += secontdMach;
            }
        }
        return result;
    }
}
