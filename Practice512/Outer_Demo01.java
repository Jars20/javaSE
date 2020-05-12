import org.w3c.dom.ls.LSOutput;

class Outerclass {
    int A = 99;
    private int MYmethod(int i) {
        return i;
    }

    public class Innerclass2{
                                            //this指代子类内的成员
        int b = MYmethod (A);
    }

    public static class Innerclass {
        static int A = 0;
        static double  B =9.0;
        static {
            A = 1;
            B = 11.0;
        }
        
        static void Method(){
            B = 12;
                                             //this.A = 13;                  static中不能用this方法
        }

    }

}

class Main {
    public static void main(String[] args) {
        Outerclass a = new Outerclass();
        System.out.println(Outerclass.Innerclass.A);



//        Outerclass.Innerclass.Method();
//        System.out.println(Outerclass.Innerclass.A);
    }
}

