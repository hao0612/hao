import java.util.Scanner;

public class Test最大值 {
    public static void main(String[] args) {
        System.out.println("请输入四个整数");
        Scanner sc = new Scanner(System.in);
        int ia = sc.nextInt();
        int ib = sc.nextInt();
        int ic = sc.nextInt();
        int id = sc.nextInt();

        int max = ia;
        if(ib>max){
            max = ib;
        }
        if (ic>max){
            max = ic;
        }
        if(id>max){
            max = id;
        }
        System.out.println("最大值是:"+max);
    }
}
