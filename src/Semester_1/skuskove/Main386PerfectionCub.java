package Semester_1.skuskove;

public class Main386PerfectionCub {
    public static void main(String[] args) {
        for (int i = 2; i < 201; i++) {
            // a
            int a = i * i * i;

            for (int j = 2; j < i; j++) {
                //b
                int b = j * j * j;
                if (b > a) {
                    break;
                }

                for (int k = j; k < i; k++) {
                    //c
                    int c = k * k * k;
                    if (c + b > a) {
                        break;
                    }

                    for (int l = k; l < i; l++) {
                        // d
                        int d = l * l * l;
                        if (b + c + d > a) {
                            break;
                        } else if (b + c + d == a) {
                            System.out.printf("Cube = %d, Triple = (%d,%d,%d)\n", i, j, k, l);
                        }
                    }
                }
            }
        }
    }
}
