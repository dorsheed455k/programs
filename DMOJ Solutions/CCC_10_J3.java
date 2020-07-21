import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)  {
        int inst = in.nextInt();
        printInstruct(inst);
    }

    public static void printInstruct(int inst) {
        String var; String n;

        int a = 0, b = 0;
        while (inst != 7) {
            var = in.next();
            if(inst == 1) {
                n = in.next();
                switch (var) {
                    case "A": a = Integer.parseInt(n);
                        break;
                    case "B": b = Integer.parseInt(n);
                        break;
                }
            } else if(inst == 2) {
                switch (var) {
                    case "A":
                        System.out.println(a);
                        break;
                    case "B": System.out.println(b);
                        break;
                }
            } else if(inst == 3) {
                n = in.next();
                if(var.equals("A") && n.equals("B"))  a = a+b;
                else if(var.equals("B") && n.equals("A")) b = b+a;
                else if(var.equals("A") && n.equals("A")) a = a+a;
                else if(var.equals("B") && n.equals("B")) b = b+b;
            } else if(inst == 4) {
                n = in.next();
                if(var.equals("A") && n.equals("B"))  a = a*b;
                else if(var.equals("B") && n.equals("A")) b = b*a;
                else if(var.equals("A") && n.equals("A")) a = a*a;
                else if(var.equals("B") && n.equals("B")) b = b*b;
            } else if(inst == 5) {
                n = in.next();
                if(var.equals("A") && n.equals("B"))  a = a-b;
                else if(var.equals("B") && n.equals("A")) b = b-a;
                else if(var.equals("A") && n.equals("A")) a = 0;
                else if(var.equals("B") && n.equals("B")) b = 0;
            } else if(inst == 6) {
                n = in.next();
                if(var.equals("A") && n.equals("B"))  a = a/b;
                else if(var.equals("B") && n.equals("A")) b = b/a;
                else if(var.equals("A") && n.equals("A")) a = 1;
                else if(var.equals("B") && n.equals("B")) b = 1;
            }
            inst = in.nextInt();
        }
    }
}
