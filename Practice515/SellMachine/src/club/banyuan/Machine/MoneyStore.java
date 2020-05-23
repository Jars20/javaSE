package club.banyuan.Machine;

public class MoneyStore {


    private int money;

    public MoneyStore(int money) {
        this.money = money;
    }



    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }



    public void minusMoney(int money){
        this.money = this.money - money;
    }

    public void addMoney(int money) {
        this.money = this.money + money;
    }
}
