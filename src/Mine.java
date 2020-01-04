
public class Mine {
    private boolean isMine;// 是否是地雷
    private int otherMineCount;// 周围地雷个数
    private int winCount;// 赢的局数
    private boolean showFalg = false;// 是否显示
    private boolean usedFalg = false;// 是否用此点判断过周围地雷--用于递归出口判断

    public Mine() {
        super();
    }

    public Mine(boolean isMine, int otherMineCount, int winCount) {
        super();
        this.isMine = isMine;
        this.otherMineCount = otherMineCount;
        this.winCount = winCount;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }

    public int getOtherMineCount() {
        return otherMineCount;
    }

    public void setOtherMineCount(int otherMineCount) {
        this.otherMineCount = otherMineCount;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public boolean isShowFalg() {
        return showFalg;
    }

    public void setShowFalg(boolean showFalg) {
        this.showFalg = showFalg;
    }

    public boolean isUsedFalg() {
        return usedFalg;
    }

    public void setUsedFalg(boolean usedFalg) {
        this.usedFalg = usedFalg;
    }

    @Override
    public String toString() {
        return "Mine [isMine=" + isMine + ", otherMineCount=" + otherMineCount + ", winCount=" + winCount
                + ", showFalg=" + showFalg + ", usedFalg=" + usedFalg + "]";
    }

}
