import java.util.Scanner;

/*import java.util.Scanner;*/
public class MineSweeping {
    private static Mine mine = null;
    private static int mineCount = 0;
    private static int findMineCount = 0;
    public static void main(String[] args) {
        mine = new Mine();
        Scanner sc = new Scanner(System.in);
        System.out.println("欢迎进入扫雷游戏。请选择游戏难度：1：低级；2：中级；3：高级");
        int selNum = sc.nextInt();
        Mine arr[][] = null;
        a: while (true) {
            switch (selNum) {
                case 1:
                    // 创建矩阵的二维数组
                    arr = new Mine[9][9];
                    // 设置地雷个数10
                    mineCount = 10;
                    // 随机生成10个雷并随机放在二维数组中
                    arr = addMine(arr);
                    // 地雷信息存放到数组中
                    arr = addMineInfo(arr);
                    // 绘制
                    draw(arr);
                    // 扫雷开始
                    boolean outFalg = inXY(arr, sc);
                    // 结束游戏
                    if (outFalg) {
                        break a;
                    } else {
                        // 重新开始
                        break;
                    }
                case 2:
                    // 创建矩阵的二维数组
                    arr = new Mine[16][16];

                    // 设置地雷个数40
                    mineCount = 40;
                    // 随机生成40个雷并随机放在二维数组中
                    arr = addMine(arr);
                    // 地雷信息存放到数组中
                    arr = addMineInfo(arr);
                    draw(arr);
                    // 扫雷开始
                    outFalg = inXY(arr, sc);
                    // 结束游戏
                    if (outFalg) {
                        break a;
                    } else {
                        // 重新开始
                        break;
                    }
                case 3:
                    // 创建矩阵的二维数组
                    arr = new Mine[16][30];
                    // 设置地雷个数99
                    mineCount = 99;
                    // 随机生成99个雷并随机放在二维数组中
                    arr = addMine(arr);
                    // 地雷信息存放到数组中
                    arr = addMineInfo(arr);
                    draw(arr);
                    // 扫雷开始
                    outFalg = inXY(arr, sc);
                    // 结束游戏
                    if (outFalg) {
                        break a;
                    } else {
                        // 重新开始
                        break;
                    }
            }

        }

    }

    /**
     *
     * @param mineCount
     * @param nineArr矩阵的二维数组
     * @return 放入地雷后的二维数组
     */
    private static Mine[][] addMine(Mine[][] nineArr) {
        for (int i = 0; i < nineArr.length; i++) {
            for (int j = 0; j < nineArr[0].length; j++) {
                nineArr[i][j] = new Mine(false, 0, 0);
            }
        }
        for (int i = 0; i < mineCount;) {
            int intRandom1 = (int) (nineArr.length * Math.random());
            int intRandom2 = (int) (nineArr[0].length * Math.random());
            // 判断当前位置是否是地雷
            if (!nineArr[intRandom1][intRandom2].isMine()) {
                nineArr[intRandom1][intRandom2].setMine(true);
                i++;
            }
        }
        return nineArr;
    }

    /**
     *
     * @param nineArr矩阵数组
     * @return 地雷信息添加后的数组
     */
    private static Mine[][] addMineInfo(Mine[][] nineArr) {
        // 周围地雷个数
        for (int i = 0; i < nineArr.length; i++) {
            for (int j = 0; j < nineArr[0].length; j++) {
                int count = 0;
                // 判断左上位置是否为地雷
                if (i > 0 && j > 0) {
                    if (nineArr[i - 1][j - 1].isMine()) {
                        count++;
                    }
                }
                // 判断正上位置是否为地雷
                if (i > 0) {
                    if (nineArr[i - 1][j].isMine()) {
                        count++;
                    }
                }
                // 判断右上位置是否为地雷
                if (i > 0 && j < nineArr.length - 1) {
                    if (nineArr[i - 1][j + 1].isMine()) {
                        count++;
                    }
                }
                // 判断左边位置是否为地雷
                if (j > 0) {
                    if (nineArr[i][j - 1].isMine()) {
                        count++;
                    }
                }
                // 判断右边位置是否为地雷
                if (j < nineArr[i].length - 1) {
                    if (nineArr[i][j + 1].isMine()) {
                        count++;
                    }
                }
                // 判断左下位置是否为地雷
                if (i < nineArr.length - 1 && j > 0) {
                    if (nineArr[i + 1][j - 1].isMine()) {
                        count++;
                    }
                }
                // 判断正下位置是否为地雷
                if (i < nineArr.length - 1) {
                    if (nineArr[i + 1][j].isMine()) {
                        count++;
                    }
                }
                // 判断右下位置是否为地雷
                if (i < nineArr.length - 1 && j < nineArr[i].length - 1) {
                    if (nineArr[i + 1][j + 1].isMine()) {
                        count++;
                    }
                }
                nineArr[i][j].setOtherMineCount(count);
            }
        }
        return nineArr;
    }

    /**
     * 打印所有信息
     *
     * @param arr
     *            地雷信息
     */
    private static void draw(Mine[][] arr) {
        System.out.print("   ");
        // 打印横向的标尺
        for (int i = 0; i < arr[0].length; i++) {
            if (i < 9) {
                System.out.print(" " + (i + 1) + " ");
            } else {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            // 打印纵向坐标
            if (i < 9) {
                System.out.print(" " + (i + 1));
            } else {
                System.out.print(i + 1);
            }
            System.out.print("|");
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j].isShowFalg()&&(!arr[i][j].isMine())) {
                    System.out.print("-" + arr[i][j].getOtherMineCount() + "-");
                } else if (arr[i][j].isMine() && arr[i][j].isShowFalg()) {
                    System.out.print("-" + "●" + "-");
                } else {
                    System.out.print("-□-");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }

    /**
     *
     * @param sc控制台输入流
     * @param nineArr地雷信息
     * @return true：退出游戏；false重新开始游戏、继续游戏
     */
    private static boolean inXY(Mine[][] arr, Scanner sc) {
        while (true) {
            System.out.println("扫雷开始，若输入雷的坐标请输入M/m+横坐标+纵坐标,空格隔开；输入-1退出游戏");
            System.out.println("若输入要点的坐标请输入P/p+横坐标+纵坐标,空格隔开；输入-1退出游戏");
            String inSelect = sc.next();
            int xVal = sc.nextInt() - 1;
            // 横坐标非法检查
            if (xVal < 0 || xVal >= arr.length) {
                System.out.println("您输入的横坐标非法，请重新输入。");
                continue;
            }
            if (xVal == -1) {
                return true;
            }
            int yVal = sc.nextInt() - 1;
            // 横坐标非法检查
            if (yVal < 0 || yVal >= arr[0].length) {
                System.out.println("您输入的纵坐标非法，请重新输入。");
                continue;
            }
            if (yVal == -1) {
                return true;
            }
            // 判断是否赢得游戏
            if (inSelect.equalsIgnoreCase("M")) {
                System.out.println(arr[xVal][yVal].toString());
                if (checkWine(arr, xVal, yVal)) {
                    findMineCount++;
                    arr[xVal][yVal].setShowFalg(true);
                    System.out.println("输入正确，已找到地雷个数：" + findMineCount + "\t共有地雷：" + mineCount + "个。再接再厉。");
                } else {
                    mine.setWinCount(mine.getWinCount() - 1);
                    System.out.println("输入错误，您已经输了！！！！重新开始游戏输入Y/y，退出游戏输入其他。");
                    if (sc.next().equalsIgnoreCase("")) {
                        return false;
                    } else {
                        return true;
                    }
                }
            } else if (inSelect.equalsIgnoreCase("P")) {
                if (checkWine(arr, xVal, yVal)) {
                    mine.setWinCount(mine.getWinCount() - 1);
                    System.out.println("踩到地雷，您已经输了！！！！重新开始游戏输入Y/y，退出游戏输入其他。");
                    if (sc.next().equalsIgnoreCase("")) {
                        return false;
                    } else {
                        return true;
                    }
                }
                // 判定输入信息,返回
                arr = check(arr, xVal, yVal);
            }
            if (checkWin()) {
                System.out.println("您已经赢得游戏，已找到地雷个数：" + findMineCount + "\t共有地雷：" + mineCount + "个。");
                System.out.println("输入错误，您已经输了！！！！重新开始游戏输入Y/y，退出游戏输入其他。");
                if (sc.next().equalsIgnoreCase("")) {
                    return false;
                } else {
                    return true;
                }
            }
            draw(arr);

        }

    }

    /**
     *
     * @param arr
     *            地雷现有信息
     * @param xVal
     *            输入的横坐标
     * @param yVal
     *            输入的纵坐标
     * @return null:踩到地雷；arr：数组最新信息添加
     */
    private static Mine[][] check(Mine[][] arr, int xVal, int yVal) {
//		System.out.println(xVal + "\t" + yVal);
        // 当前点设置为显示
        if (!arr[xVal][yVal].isMine()) {
            arr[xVal][yVal].setShowFalg(true);
        }
        // 判断当前点是否为0，未0时显示周边的非雷位置的信息
        if (arr[xVal][yVal].getOtherMineCount() == 0) {
            // 把当前点是否已经判断标记设置为true
            arr[xVal][yVal].setUsedFalg(true);
            // 判断左上是否存在
            if (xVal >= 1 && yVal >= 1) {
                // 左上设置为显示
                //arr[xVal - 1][yVal - 1].setShowFalg(true);
                // 判断下一个点是否已经经过判断
                if (!arr[xVal - 1][yVal - 1].isUsedFalg()) {
                    // 判断左上是否为0，如果是0继续判断周围部分坐标信息
                    if (arr[xVal - 1][yVal - 1].getOtherMineCount() == 0) {
                        check(arr, xVal - 1, yVal - 1);
                    }

                }
            }

            // 判断正上是否存在
            if (xVal >= 1) {
                // 正上设置为显示
                //arr[xVal - 1][yVal].setShowFalg(true);
                // 判断下一个点是否已经经过判断
                if (!arr[xVal - 1][yVal].isUsedFalg()) {
                    // 判断正上是否为0，如果是0继续判断周围部分坐标信息
                    if (arr[xVal - 1][yVal].getOtherMineCount() == 0) {
                        check(arr, xVal - 1, yVal);
                    }

                }

            }
            // 判断右上是否存在
            if (xVal >= 1 && yVal < arr[0].length - 1) {
                // 右上设置为显示
                //arr[xVal - 1][yVal + 1].setShowFalg(true);
                // 判断下一个点是否已经经过判断
                if (!arr[xVal - 1][yVal + 1].isUsedFalg()) {

                    // 判断右上是否为0，如果是0继续判断周围部分坐标信息
                    if (arr[xVal - 1][yVal + 1].getOtherMineCount() == 0) {
                        check(arr, xVal - 1, yVal + 1);
                    }
                }

            }
            // 判断左边是否存在
            if (yVal >= 1) {
                // 左边设置为显示
                arr[xVal][yVal - 1].setShowFalg(true);
                if (!arr[xVal][yVal - 1].isUsedFalg()) {
                    // 判断左边是否为0，如果是0继续判断周围部分坐标信息
                    if (arr[xVal][yVal - 1].getOtherMineCount() == 0) {
                        check(arr, xVal, yVal - 1);
                    }

                }
            }
            // 判断右边是否存在
            if (yVal < arr[0].length - 1) {
                // 右边设置为显示
                //arr[xVal][yVal + 1].setShowFalg(true);
                if (!arr[xVal][yVal + 1].isUsedFalg()) {

                    // 判断左上是否为0，如果是0继续判断周围部分坐标信息
                    if (arr[xVal][yVal + 1].getOtherMineCount() == 0) {
                        check(arr, xVal, yVal + 1);
                    }
                }
            }
            // 判断左下是否存在
            if (xVal < arr.length - 1 && yVal >= 1) {
                // 当前坐标设置为显示
                //arr[xVal + 1][yVal - 1].setShowFalg(true);
                if (!arr[xVal + 1][yVal - 1].isUsedFalg()) {
                    // 判断左上是否为0，如果是0继续判断周围部分坐标信息
                    if (arr[xVal + 1][yVal - 1].getOtherMineCount() == 0) {
                        check(arr, xVal + 1, yVal - 1);
                    }
                }
            }
            // 判断正下是否存在
            if (xVal < arr.length - 1) {
                // 当前坐标设置为显示
                //arr[xVal + 1][yVal].setShowFalg(true);
                if (!arr[xVal + 1][yVal].isUsedFalg()) {

                    // 判断左上是否为0，如果是0继续判断周围部分坐标信息
                    if (arr[xVal + 1][yVal].getOtherMineCount() == 0) {
                        check(arr, xVal + 1, yVal);
                    }
                }
            }
            // 判断右下是否存在
            if (xVal < arr.length - 1 && yVal < arr[0].length - 1) {
                // 当前坐标设置为显示
                //arr[xVal + 1][yVal + 1].setShowFalg(true);
                if (!arr[xVal + 1][yVal].isUsedFalg()) {
                    // 判断左上是否为0，如果是0继续判断周围部分坐标信息
                    if (arr[xVal + 1][yVal + 1].getOtherMineCount() == 0) {
                        check(arr, xVal + 1, yVal + 1);
                    }
                }

            }
        }

        return arr;
    }

    /**
     *
     * @param arr：地雷信息
     * @param xVal：输入的横坐标
     * @param yVal：输入的纵坐标
     * @return true：踩到地雷；false：不是地雷
     */
    private static boolean checkWine(Mine[][] arr, int xVal, int yVal) {
        if (arr[xVal][yVal].isMine()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return true：赢得游戏；false：没赢
     */
    private static boolean checkWin() {
        if (findMineCount == mineCount) {
            // 胜场+1
            mine.setWinCount(mine.getWinCount() + 1);
            return true;
        }
        return false;
    }

}

