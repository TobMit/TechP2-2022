package Semester_1.doma_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class MainMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, int[]> matrix = new TreeMap<>();
        int pocitadlo = 0;
        int numberOfMatrix = Integer.parseInt(bufferReader.readLine());
        //Nacitanie matic
        for (int i = 0; i < numberOfMatrix; i++) {
            String matica = bufferReader.readLine();
            StringTokenizer parser = new StringTokenizer(matica, " ");
            String nameMatrix = parser.nextToken();
            int[] matrixNuber = new int[2];
            matrixNuber[0] = Integer.parseInt(parser.nextToken());
            matrixNuber[1] = Integer.parseInt(parser.nextToken());
            matrix.put(nameMatrix, matrixNuber);
        }

        //nacitanie operácií
        while (bufferReader.ready()) {
            String vstup = bufferReader.readLine();
            int vypis = 0;
            for (int i = vstup.length();i > 2; i = vstup.length() ) {
                char[] rozlozenyVstup = vstup.toCharArray();
                int numberOfPravaZatvorka = 0;

                for (int k = 0; k < rozlozenyVstup.length; k++) {
                    String znak = Character.toString(rozlozenyVstup[k]);
                    if (znak.equals(")")) {
                        numberOfPravaZatvorka = k;
                        break;
                    }
                }

                int numberOfLavaZatvorka = 0;
                for (int k = numberOfPravaZatvorka; k >= 0; k--) {
                    String znak = Character.toString(rozlozenyVstup[k]);
                    if (znak.equals("(")) {
                        numberOfLavaZatvorka = k;
                        break;
                    }
                }

                String medziString = vstup.substring(numberOfLavaZatvorka, numberOfPravaZatvorka + 1);
                String remove = medziString;
                medziString = medziString.replace(" ", "");
                medziString = medziString.replace("(", "");
                medziString = medziString.replace(")", "");
                int[] matrix1 = matrix.get(medziString.substring(0, 1));
                int[] matrix2 = matrix.get(medziString.substring(1, 2));

                int vysledok = 0;
                if (matrix1[1] != matrix2[0]) {
                    vysledok = 0;
                } else {
                    int[] zasobnik = {matrix1[0], matrix2[1]};

                    matrix.put("" + pocitadlo, zasobnik);
                    pocitadlo++;

                    vysledok = matrix1[1] * matrix1[0] * matrix2[1];
                }
                if (vysledok == 0) {
                    System.out.println("error");
                    vypis = 0;
                    break;
                }
                vypis += vysledok;

                vstup = vstup.replace(remove, "" + (pocitadlo - 1));
            }
            pocitadlo = 0;
            if (vypis != 0 || vstup.length() == 1) {
                System.out.println(vypis);
            }
        }
    }
}
