import java.util.ArrayList;
import java.util.Scanner;
// https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=798

public class Main857Quantiser {
    private static ArrayList<Message> messages;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int numberN = scanner.nextInt();
            if (numberN == -1) {
                break;
            }

            messages = new ArrayList<>();
            for (int i = 0; i < numberN; i++) {
                //messages.add(new Message(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));

                //spracovanie casov
                Message tmp = new Message(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                //zaokrulhovanie časov na 0 60 120 180... 420
                // musí sa pripočítať polovička intervalu (60/2) na rozhodovanie či sa to zaokruhli k nižšiemu alebo k vyššiemu
                // /60 *60 je na odstránenie des čísel (tmp.t je int tak to zaokruhluje automaticky)
                tmp.t = ((tmp.t + 30) /60) * 60;
                //ktorola či nepretiekol rozsah
                if (tmp.t == 480) {
                    tmp.t = 0;
                    tmp.b++;
                    if (tmp.b == 5) {
                        tmp.m++;
                        tmp.b = 1;
                    }
                }
                messages.add(tmp);
            }

            for (int i = 0; i < messages.size(); i++) {
                for (int j = i + 1; j < messages.size(); j++) {
                    if (messages.get(i).note == messages.get(j).note && messages.get(i).code == 1 && messages.get(j).code == 0) {
                        if (messages.get(i).m == messages.get(j).m && messages.get(i).b == messages.get(j).b && messages.get(i).t == messages.get(j).t) {
                            messages.remove(j);
                            messages.remove(i);
                            i-=2;
                        }
                        break;
                    }
                }
            }

            System.out.println(messages.size());
            for (Message mesage: messages) {
                System.out.printf("%d %d %d %d %d\n", mesage.code, mesage.note, mesage.m, mesage.b, mesage.t);
            }

        }
        System.out.println("-1");
    }

    private static class Message {
        public int code;
        public int note;
        public  int m;
        public int b;
        public  int t;

        public Message(int code, int note, int m, int b, int t) {
            this.code = code;
            this.note = note;
            this.m = m;
            this.b = b;
            this.t = t;
        }
    }
}
