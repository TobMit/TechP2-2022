import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MainSlova {
    static ArrayList<String> dictionary = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        int tests = 0;

        line = reader.readLine();
        tests = Integer.parseInt(line);
        //nacitanie prveho prazdneho
        line = reader.readLine();

        for (int i = 0; i < tests; i++) {
            dictionary.clear();
            while (!(line = reader.readLine()).equals("*")) {
                dictionary.add(line);
            }
            while ((line = reader.readLine()) != null && (line.length() != 0) ) {
                String[] array = line.split(" ");
                System.out.println(array[0]+" "+ array[1]+" "+getTransformation(array[0],array[1],dictionary));

            }
            if (i != tests - 1) {
                System.out.println();
            }
        }
    }
    static int getTransformation(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        visited.add(beginWord);
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //System.out.println(queue.toString());
                String currWord = queue.poll();
                //System.out.println(currWord);
                if (currWord.equals(endWord)) return level;

                char[] wordArr = currWord.toCharArray();
                for (int j = 0; j < wordArr.length; j++) {
                    char temp = wordArr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArr[j] = c;
                        String newWord = new String(wordArr);

                        if (!visited.contains(newWord) && wordSet.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    wordArr[j] = temp;
                }
            }
            level++;
        }
        return 0;
    }

}