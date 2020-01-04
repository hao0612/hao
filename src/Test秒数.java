import java.util.Scanner;

public class Test秒数 {
    public static void main(String[] args) {
        System.out.println("请输入一个正整数的秒数");
        Scanner sc = new Scanner(System.in);
        int num =sc.nextInt();
        int hour = num / 3600;
        int min = num%3600/60;
        int sec = num %60;
        System.out.println(num +"秒转为"+ hour+"时"+min +"分"+sec+"秒");
    }
}
