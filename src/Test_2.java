

import java.util.Scanner;

public class Test_2 {

   public static void main(String[] args) {
      int age = 0;
      int m = 0;
      String C = " ";
      
      System.out.println("나이");
      Scanner scanner = new Scanner(System.in);
      age = scanner.nextInt();
      
      if (age < 8) {
         m = 1200;
         C = "어린이";
      }else if (age < 19) {
         m = 1500;
         C = "학생";
      }else if (20 < age);
         m = 2000;
         C = "성인";
         
         System.out.println("요금은"+m+"이고 "+C+"입니다.");
   }
      

}