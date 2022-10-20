package Semester_1.skuskove;

import java.util.HashMap;
import java.util.Scanner;

public class Main417WordIndex {
    public static void main(String[] args) {
        HashMap<String, Integer> databaza = new HashMap<>();
        int h = 1;
        for (char i = 'a'; i <= 'z'; i++) {
            databaza.put(Character.toString(i), h);
            h++;
        }

        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (j > i) {
                    databaza.put(Character.toString(i) + Character.toString(j), h);
                    //System.out.println(test + " " + h);
                    h++;
                }
            }
        }

        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (j > i) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k > j) {
                            databaza.put(Character.toString(i) + Character.toString(j) + Character.toString(k), h);
                            //System.out.println(test + " " + h);
                            h++;
                        }
                    }
                }
            }
        }

        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (j > i) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k > j) {
                            for (char l = 'a'; l <= 'z'; l++) {
                                if (l > k) {
                                    databaza.put(Character.toString(i) + Character.toString(j) + Character.toString(k) + Character.toString(l), h);
                                    //System.out.println(test + " " + h);
                                    h++;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (j > i) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k > j) {
                            for (char l = 'a'; l <= 'z'; l++) {
                                if (l > k) {
                                    for (char m = 'a'; m <= 'z'; m++) {
                                        if (m > l) {
                                            databaza.put(Character.toString(i) + Character.toString(j) + Character.toString(k) + Character.toString(l) + Character.toString(m), h);
                                            //System.out.println(test + " " + h);
                                            h++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (databaza.containsKey(input)) {
                System.out.println(databaza.get(input));
            } else {
                System.out.println(0);
            }

        }
    }
}

