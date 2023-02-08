import java.util.*;

// https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=667
public class Main726Decode {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String known = loaderKnown();
        String encoded = loaderEncoded();


        TreeMap<Character, Integer> mapKnown = new TreeMap();
        for (char c = 'a'; c <= 'z'; c++) {
            mapKnown.put(c,0);
        }
        TreeMap<Character, Integer> mapEncodec = new TreeMap<>(mapKnown);


        //known
        countCharacter(known.toLowerCase(), mapKnown);
        ArrayList<Pair> arrKnown = new ArrayList<>();
        arrProcess(mapKnown, arrKnown);

        // encoded
        countCharacter(encoded.toLowerCase(), mapEncodec);
        ArrayList<Pair> arrEncoded = new ArrayList<>();
        arrProcess(mapEncodec, arrEncoded);


        //vytvorenie listu na decode
        TreeMap<Character, Character> decodeMap = new TreeMap<>();
        for (int i = 0; i < arrEncoded.size(); i++) {
            decodeMap.put(arrEncoded.get(i).first, arrKnown.get(i).first);
            //potrebujem dekodovat aj male aj velke
            decodeMap.put(Character.toUpperCase(arrEncoded.get(i).first), Character.toUpperCase(arrKnown.get(i).first));
        }
        StringBuilder outputBuilder = new StringBuilder();
        for (int i = 0; i < encoded.length(); i++) {
            char tmp = encoded.charAt(i);
            if ( (tmp >= 'a' && tmp <= 'z') || (tmp >= 'A' && tmp <= 'Z')) {
                tmp = decodeMap.get(tmp);
            }
            outputBuilder.append(tmp);
        }
        System.out.print(outputBuilder.toString());
    }

    private static void arrProcess(TreeMap<Character, Integer> map, ArrayList<Pair> arr) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            arr.add(new Pair(entry.getKey(), entry.getValue()));
        }
        // velice komplykovany komparator, porovnanvaju sa najskor ci maju rovnaku pocetnost, ak ano tak sa usporiadavaju alfabetne
        // ak nemaju rovnaku pocetnost tak sa usporiadavaju podla najvecsej pocetnosti
        arr.sort(((o1, o2) -> o1.getSecond() == o2.getSecond() ? (o1.getFirst() < o2.getFirst() ? 0 : 1) : (o1.getSecond() < o2.getSecond() ? 0 : -1)));

    }

    private static void countCharacter(String toLowerCase, TreeMap<Character, Integer> map) {
        char[] tmp = toLowerCase.toCharArray();
        for (int i = 0; i < toLowerCase.length(); i++) {
            char debugTMP = tmp[i];
            if (tmp[i] >= 'a' && tmp[i] <= 'z') {
                int tmpI = map.get(tmp[i]);
                tmpI++;
                map.put(tmp[i], tmpI);
            }
        }
    }

    private static String loaderKnown() {
        boolean koniec = false;
        StringBuilder builder = new StringBuilder();
        while (!koniec) {
            String input = scanner.nextLine();
            if (input == null || input.equals("")) {
                koniec = true;
                break;
            }
            builder.append(input);
            builder.append("\n");

        }

        return builder.toString();
    }

    private static String loaderEncoded() {
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            builder.append(input);
            builder.append("\n");

        }

        return builder.toString();
    }

    static class Pair{
        public char getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        public char first;
        public int second;

        public Pair(char first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}