package club.banyuan.anonymous;

public class Main {

    public static void show(Bird bird) {
        System.out.println(bird.getName() + "能够飞 " + bird.fly() + "米");
    }

    public static void main(String[] args) {
//        Bird bird1 = new Bird() {
//            @Override
//            public int fly() {
//                return 1000;
//            }
//        };
//        bird1.setName("燕子");                              正常setget方法
//        bird1.getName();
//        show(bird1);
        show(new Bird() {
            {
                this.setName(" 燕子");
            }
            @Override
            public int fly() {
                return 1000;
            }

//            @Override
//            public String getName() {
//                return " 燕子";
//            }
        });
    }
}