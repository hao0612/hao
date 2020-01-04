import sun.font.Script;

import java.util.Scanner;

public class test个人所得税 {
    public static void main(String[] args) {
        System.out.println("请输入工资");
        Scanner sc = new Scanner(System.in);
        int salary=sc.nextInt();
        double salaryPrice=0.0;
        if(salary<=5000){
            System.out.println("你工资太低");
        }else if(salary<=8000){
            salaryPrice =(salary-5000)*0.03;
        }else if(salary<17000){
            salaryPrice=(salary-8000)*0.1+(8000-5000)*0.03;
        }else if(salary<30000){
            salaryPrice=(salary-17000)*0.2+(17000-8000)*0.1+(8000-3000)*0.02;
    }
        System.out.println("个人所得税是"+salaryPrice);
    }
}
