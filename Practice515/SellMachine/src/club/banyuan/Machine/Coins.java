package club.banyuan.Machine;

public enum Coins {
    $1(1),
    $2(2),
    $5(5),
    $10(10);
    private int worth;
    Coins(int worth) {
        this.worth = worth;
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }
}
