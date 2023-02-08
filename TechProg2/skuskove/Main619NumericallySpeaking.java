import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=560
public class Main619NumericallySpeaking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true == !false){
            String input = reader.readLine();
            if (input.equals("*")){
                break;
            }

            String slovo;
            String cislo;

            if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
                //input je cislo
                slovo = getInputString(input);
                cislo = input;
            } else {
                //input je slovo
                cislo = getNumber(input);
                slovo = input;
            }
            cislo = spracujCiarky(cislo);
            System.out.printf("%-20s  %s\n",slovo, cislo);

        }
    }

    private static String spracujCiarky(String cislo) {
        StringBuilder builder = new StringBuilder(cislo);
        builder.reverse();
        for (int i = 3; i < builder.length(); i+=3) {
            builder.insert(i, ",");
            i++;
        }
        return builder.reverse().toString();

    }

    private static String getInputString(String input) {
        BigInteger intInput = new BigInteger(input);
        StringBuilder builder = new StringBuilder();
        while (intInput.compareTo(BigInteger.ZERO) > 0){
            int modValue = intInput.mod(BigInteger.valueOf(26)).intValue();
            if (intInput.equals(BigInteger.valueOf(26))) {
                intInput = BigInteger.ZERO;
            } else {
                intInput = intInput.divide(BigInteger.valueOf(26));
            }
            intInput.subtract(BigInteger.valueOf(modValue));
            if (modValue == 0) {
                builder.append("z");
            } else {
                char tmp = (char) ('a' + modValue -1);
                builder.append(tmp);
            }
        }
        builder.reverse();
        return builder.toString();
    }

    private static String  getNumber(String input) {
        BigInteger cislo = BigInteger.ZERO;
        for (int i = 0; i < input.length(); i++) {
            char znak = input.charAt(i);
            cislo = cislo.multiply(BigInteger.valueOf(26));
            cislo = cislo.add(BigInteger.valueOf(znak - 'a' + 1));
        }
        return cislo.toString();
    }
}
