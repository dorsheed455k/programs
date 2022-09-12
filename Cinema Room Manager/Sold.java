package cinema;

import java.util.Scanner; 

public class Sold {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int r, c;
       
       System.out.println("Enter the number of rows:");
       r = in.nextInt();
       
       System.out.println("Enter the number of seats in each row:");
       c = in.nextInt();
       
       int seats = r * c;
       int income = 0;
       if (seats < 60) {
        income = seats * 10;
       } else {
           int front;
           int back;
           if(r % 2 == 0) {
               front = ((r / 2) * c) * 10;
               back = ((r / 2) * c) * 8;
               income = front + back;
           } else {
               front = ((r / 2) * c) * 10;
               back = (((r/2) + 1) * c) * 8;
               income = front + back;
           }
       }
      System.out.println("Total income:");
      System.out.println("$" + income);

         
    }
}
