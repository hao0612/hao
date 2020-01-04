import java.sql.SQLOutput;
import java.util.Scanner;

public class Test聊天 {
    public static void main(String[] args) {
        boolean flag=true;
        for(;;){
            System.out.println("请"+(flag?"你":"我")+"输入发送的内容:");
            Scanner sc =new Scanner(System.in);
            String str = sc.next();
            if("bye".equals(str)){
                System.out.println("聊天结束");
                break;
            }
            else{
                System.out.println((flag?"你:":"我")+str);
            }
            flag=!flag;
        }
    }
}
