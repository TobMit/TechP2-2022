import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GraysB {
    static ArrayList<String> bits = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";

        line = reader.readLine();
        int n = Integer.parseInt(line);

        for (int i = 0; i < n; i++){
            line = reader.readLine();
            String[] numbers = line.split(" ");
            System.out.println(generateGray(Integer.parseInt(numbers[1])));
            bits.clear();
        }

    }
    static int generateGray(int k) {
        for (int i = k; i < k + 1; i++) {
            int x = i ^ (i >> 1);
            bits.add(Integer.toBinaryString(x));
        }
        return Integer.parseInt(bits.get(0), 2);
    }
}