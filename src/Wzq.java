

/*
     编程实现控制台版的五子棋游戏，支持两人对战
 */

import java.util.Scanner;

public class Wzq {
    // 自定义二维数组来描述棋盘，默认初始值为0
    int[][] chessBoard = new int[16][16];

    // 自定义成员方法来绘制棋盘
    void paint() {
        // 1.先绘制棋盘中第一行的坐标信息，也就是列坐标信息
        for (int i = 0; i < 17; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                // 按照十六进制的格式打印i-1的数值
                System.out.printf("%x ", i - 1);
            }
        }
        System.out.println();

        // 2.绘制棋盘中除了第一行之外的其他部分以及行坐标信息
        for (int i = 0; i < 16; i++) {
            // 用于打印行坐标信息
            System.out.printf("%x ", i);
            for (int j = 0; j < 16; j++) {
                // 刚开始棋盘中的所有内容都是+，因此直接打印
                if (0 == chessBoard[i][j]) {
                    System.out.print("+ ");
                } else if (1 == chessBoard[i][j]) {
                    System.out.print("● ");
                } else {
                    System.out.print("○ ");
                }
            }
            // 打印完毕一行的所有内容之后进行换行
            System.out.println();
        }

    }

    // 自定义成员方法来提示黑方和白方分别下棋
    void play() {
        // 定义标志位来进行黑方和白方的切换，true代表黑方，false代表白方
        boolean flag = true;
        // 不断地分别提示黑方和白方下棋
        while (true) {
            System.out.println("请" + (flag ? "黑方" : "白方") + "输入落子坐标(x y)：");
            Scanner sc = new Scanner(System.in);
            int ix = sc.nextInt();
            int iy = sc.nextInt();
            // 根据用户输入的坐标来调整棋盘中的图案，策略为改变数组的元素值
            if (flag) {
                // 当黑方落子时就将数组中对应元素值改为1
                chessBoard[ix][iy] = 1;
            } else {
                // 当白方落子时就将数组中对应元素改为2
                chessBoard[ix][iy] = 2;
            }
            // 重新绘制图案
            paint();// 判断当前方是否胜利，若胜利就立刻结束游戏
            if (judge(ix, iy)) {
                System.out.println("恭喜" + (flag ? "黑方" : "白方") + "胜利了！");
                break;
            }
            // 此时切换下棋方
            flag = !flag;
        }
    }

    // 自定义成员方法来判断用户是否获胜，获胜的规则是：任意相同颜色的5个棋子连成一线
    boolean judge(int ix, int iy) {
        // 1.判断竖向是否连成一线，则需要以该点为中心向上四个点向下四个点
        // 声明变量来统计竖向相同颜色棋子的个数，先统计向上同色棋子的个数
        int count = 1;
        for (int i = ix - 1; i >= 0 && i >= ix - 4; i--) {
            // 若当前点代表的棋子与上述某个点代表的棋子不一样，则向上统计结束
            if (chessBoard[ix][iy] != chessBoard[i][iy]) {
                break;
            }
            count++;
        }
       // System.out.println("count1 = " + count);
        // 再统计向下颜色相同的个数
        for (int i = ix + 1; i <= 15 && i <= ix + 4; i++) {
            if (chessBoard[ix][iy] != chessBoard[i][iy]) {
                break;
            }
            count++;
        }
       // System.out.println("count2 = " + count);
        for (int i = iy - 1; i >= 0 && i >= iy - 4; i--) {
            // 若当前点代表的棋子与上述某个点代表的棋子不一样，则向左统计结束
            if (chessBoard[ix][iy] != chessBoard[ix][i]) {
                break;
            }
            count++;
        }
      //  System.out.println("count1 = " + count);
        // 再统计向右颜色相同的个数
        for (int i = iy + 1; i <= 15 && i <= iy + 4; i++) {
            if (chessBoard[ix][iy] != chessBoard[ix][i]) {
                break;
            }
            count++;
        }

      //  System.out.println("count2 = " + count);
        //左上

        int y= iy;
        for (int i = ix - 1; i >= 0 && i >= ix - 4; i--) {
            y--;
            if (chessBoard[ix][iy] != chessBoard[i][y]) {
                break;
            }
            count++;
        }
      //  System.out.println("count2 = " + count);

        //右下

        y= iy;
        for (int i = ix+1 ; i <= 15 && i <= ix + 4; i++) {
            y++;

            if (chessBoard[ix][iy] != chessBoard[i][y]) {
                break;
            }
            count++;

        }
       // System.out.println("count2 = " + count);

        //右上


        for (int i = ix - 1; i >= 0 && i >= ix - 4; i--) {
            y++;
            if (chessBoard[ix][iy] != chessBoard[i][y]) {
                break;
            }
            count++;
        }
       // System.out.println("count2 = " + count);

        //左下

        y= iy;
        for (int i = ix+1 ; i <= 15 && i <= ix + 4; i++) {
            y--;

            if (chessBoard[ix][iy] != chessBoard[i][y]) {
                break;
            }
            count++;

        }
       // System.out.println("count2 = " + count);


        return count >= 5;

        // 当所有可能胜利的情况都排除了，那么肯定是失败了

    }

}

