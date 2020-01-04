import java.util.Scanner;
public class Text1键盘输入 {
    public static void main(String[] args) {

        System.out.println("请输入姓名和年龄");
        //扫描器
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        int age =sc.nextInt();
       //打印
        System.out.println("name="+name +",age="+age);
    }
}
