package cinema;

public class Arrangement {

    public static void main(String[] args) {
        System.out.println("Cinema:");
        for (int i = 1; i <= 8; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        
         for (int i = 1; i <= 7; i++) {
            System.out.print(i);
            for (int j = 1; j <= 8; j++) {
              System.out.print(" S");
            }
            System.out.println();
        } 
    }
}
