import java.util.Scanner;

public class Test累加 {
    public static void main(String[] args) {
        System.out.println("请输入正整数");
        Scanner sc = new Scanner(System.in);
        int num =sc.nextInt();
        double sum =0.0;
        /*for (int i=1;i<=num;i++){
            sum =sum +1.0/i;
        }*/
        int i=1;
        while (i<=num){
            sum =sum +1.0/i;
            i++;

        }
        System.out.println("累加结果是"+sum);
    }
}
