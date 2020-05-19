package club.banyuan;

public class PrintIterator<T> {
    public static <T> void PrintIter(Iterable<T> input){
        for (T one : input) {
            System.out.println(","+one);
        }
    }
}
