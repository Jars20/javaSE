package club.banyuan;

public class Main {
//    声明一个由10个Cake对象组成的数组；
//    输入Cake对象的数据并将其存储到数组中；
//    显示所有蛋糕的总价；
//    显示ReadyMadeCake蛋糕的总价和数量之和；
//    显示最高价格出售的蛋糕的信息。
    public static void main(String[] args) {
        Cake[] cakes = new Cake[10];
        cakes[0] = new ReadyMadeCake(1,1,5);
        cakes[1] = new OrderCake(2,2,5);
        cakes[2] = new OrderCake(3,3,5);
        cakes[3] = new ReadyMadeCake(4,4,5);
        cakes[4] = new OrderCake(5,5,5);
        cakes[5] = new ReadyMadeCake(6,6,5);
        cakes[6] = new OrderCake(7,7,5);
        cakes[7] = new ReadyMadeCake(8,8,5);
        cakes[8] = new OrderCake(9,9,5);
        cakes[9] = new ReadyMadeCake(10,10,5);
        double totalprice = 0.0;
        double price1 = 0.0;
        int num = 0;
        int maxp = 0;
        for(Cake one :cakes){
            totalprice += one.calcPrice();
            if (one instanceof ReadyMadeCake ){
                price1 += one.calcPrice();
                num ++;
            }
            if (one.calcPrice()>=cakes[maxp].calcPrice()){
                maxp = one.id -1;
            }
        }
        System.out.println("最高价格的蛋糕id："+ cakes[maxp].id +"\t价格为"+ cakes[maxp].calcPrice());
        System.out.println("蛋糕的总价为"+ totalprice);
        System.out.println("ReadyMakeCake的价格之和为:"+ price1 +"\t其数量为" +num +"个");
    }
}
