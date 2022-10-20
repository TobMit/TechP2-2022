package Semester_1.skuskove;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main531_WrongAnswer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            ArrayList<String> list1 = new ArrayList<>();
            ArrayList<String> list2 = new ArrayList<>();

            HashMap<String, Integer> list1Has = new HashMap<>();
            HashMap<String, Integer> list2Has = new HashMap<>();

            while (scanner.hasNext()) {
                String input = scanner.next();
                if (input.equals("#")) {
                    break;
                }
                list1.add(input);
                list1Has.put(input, 0);
            }

            while (scanner.hasNext()) {
                String input = scanner.next();
                if (input.equals("#")) {
                    break;
                }
                list2.add(input);
                list2Has.put(input, 0);
            }

//            int pocetOverovani = 0;
//            if (list1.size() >= list2.size()) {
//                pocetOverovani = list2.size();
//            } else {
//                pocetOverovani = list1.size();
//            }

            //HashMap<String, Integer> voVystupe = new HashMap();

            String vystup = null;
            while (!list1.isEmpty() && !list2.isEmpty()) {
                String over1 = list1.get(0);
                String over2 = list2.get(0);
                if (over1.equals(over2)) {
                    if (vystup == null) {
                        vystup = over1;
                    } else {
                        vystup += " " + over1;
                    }
                    list1.remove(0);
                    list2.remove(0);
                    list1Has.remove(over1);
                    list2Has.remove(over2);
                    continue;
                }

                if (!list2Has.containsKey(over1)) {
                    list1.remove(0);
                    list1Has.remove(over1);
                    continue;
                }

                if (!list1Has.containsKey(over2)) {
                    list2.remove(0);
                    list2Has.remove(over2);
                    continue;
                }

                int vzdialenost1 = list2.indexOf(over1);
                int vzdialenost2 = list1.indexOf(over2);

                if (vzdialenost1 >= vzdialenost2) {
                    list1.remove(0);
                    list1Has.remove(over1);
                    continue;
                } else {
                    list2.remove(0);
                    list1Has.remove(over2);
                    continue;
                }


            }
//            for (int i = 0; i < pocetOverovani; i++) {
//                String over1 = list1.get(i);
//                String over2 = list2.get(i);
//                if (over1.equals(over2) && !voVystupe.containsKey(over1)) {
//                    if (vystup == null) {
//                        vystup = over1;
//                        voVystupe.put(over1, 0);
//                    } else {
//                        vystup += " " + over1;
//                        voVystupe.put(over1, 0);
//                    }
//                    continue;
//                }
//
//                if (list2Has.containsKey(over1) && !voVystupe.containsKey(over1)) {
//                    if (vystup == null) {
//                        vystup = over1;
//                        voVystupe.put(over1, 0);
//                    } else {
//                        vystup += " " + over1;
//                        voVystupe.put(over1, 0);
//                    }
//                    continue;
//                }
//                if (list1Has.containsKey(over2) && !voVystupe.containsKey(over2)) {
//                    if (vystup == null) {
//                        vystup = over2;
//                        voVystupe.put(over2, 0);
//                    } else {
//                        vystup += " " + over2;
//                        voVystupe.put(over2, 0);
//                    }
//                    continue;
//                }
//
//            }

            System.out.println(vystup);

            if (!scanner.hasNext()) {
                return;
            }
        }
    }
}