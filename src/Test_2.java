

import java.util.Scanner;

public class Test_2 {

   public static void main(String[] args) {
      int age = 0;
      int m = 0;
      String C = " ";
      
      System.out.println("����");
      Scanner scanner = new Scanner(System.in);
      age = scanner.nextInt();
      
      if (age < 8) {
         m = 1200;
         C = "���";
      }else if (age < 19) {
         m = 1500;
         C = "�л�";
      }else if (20 < age);
         m = 2000;
         C = "����";
         
         System.out.println("�����"+m+"�̰� "+C+"�Դϴ�.");
   }
      

}