package club.banyuan;

public class PrintIterator {
    public static <T> void PrintIter(Iterable<T> input){
        for (T one : input) {
            System.out.println(","+one);
        }
    }
}
