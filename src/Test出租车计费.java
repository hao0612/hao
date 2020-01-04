import java.util.Scanner;

public class Test出租车计费 {
    public static void main(String[] args) {
        System.out.println("请输入公里数和等待的秒数");
        Scanner sc= new Scanner(System.in);
        int km = sc.nextInt();
        int sec = sc.nextInt();
        int kmPrice = 0;
        if(km <=3){
            kmPrice=10;
        }else if(km <=15){
            kmPrice = 10 +(km-3)*2;
        }
        else{
            kmPrice = 10 +(15-3)*2+(km-15)*3;
        }
        int secprice = sec /150;
        int sumprice = kmPrice+secprice;
        System.out.println("费用是"+sumprice);

    }
}
