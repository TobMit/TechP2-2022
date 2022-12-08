package TechProg2.Sutaz3;

import java.util.Scanner;
import java.util.TreeMap;

public class MainHelpJurry {
    private static TreeMap<String, Integer> domJudge;
    private static TreeMap<String, Integer> kattis;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //while (scanner.hasNext()) {
            domJudge = new TreeMap<>();
            kattis = new TreeMap<>();
            int numberOfSubbmissions = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numberOfSubbmissions; i++) {
                String tmp = scanner.nextLine();
                if (!domJudge.containsKey(tmp)) {
                    domJudge.put(tmp, 1);
                } else {
                    int value = domJudge.get(tmp);
                    value++;
                    domJudge.replace(tmp, value);
                }
            }

            for (int i = 0; i < numberOfSubbmissions; i++) {
                String tmp = scanner.nextLine();
                if (!kattis.containsKey(tmp)) {
                    kattis.put(tmp, 1);
                } else {
                    int value = kattis.get(tmp);
                    value++;
                    kattis.replace(tmp, value);
                }
            }
            int value = 0;
            for (String key : domJudge.keySet()) {
                if (kattis.containsKey(key)) {
                    value += Math.min(domJudge.get(key), kattis.get(key));
                }
            }
            System.out.println(value);

        //}
    }
}
