package Semester_1.Sutaz;

public class MainPascalovTrojuholnik {
    public static void main(String[] args) {
        int pocetRiadkov = 22;
        //int pocetRiadkov = 100;
        int n = 0;
        long[] faktorialy = new long[102];
        for (int i = 0; i < faktorialy.length; i++) {
            faktorialy[i] = faktorial(i);
        }


//        for (long l : faktorialy) {
//            System.out.println(l);
//        }


        while (n <= pocetRiadkov) {
            for (int k = 0; k <= n; k++) {
                long cisloOverenie = faktorialy[k] * faktorialy[n - k];
                //System.out.printf("%d / %d\n", faktorialy[n], cisloOverenie );
                //System.out.printf("%d /%d * %d\n", n, k, n - k );
                if (cisloOverenie == 0) {
                    System.out.print(1 + " ");
                    continue;
                }
                long cislo = (faktorialy[n] / (faktorialy[k] * faktorialy[n - k]) );
                if (k == n) {
                    System.out.print(cislo + " ");
                } else {
                    System.out.print(cislo + " ");
                }
            }
            System.out.println();
            n++;
        }
        
    }

    private static long faktorial(int cislo) {
        if (cislo == 0) {
            return 1;
        }
        long vysledneCiso = cislo;
        long factorial = cislo - 1;
        while (factorial > 0) {
            //System.out.println(factorial);
            vysledneCiso = (long)((vysledneCiso * factorial)) % 1000000000000000000L;
            factorial--;
        }
        return vysledneCiso;
    }
}

