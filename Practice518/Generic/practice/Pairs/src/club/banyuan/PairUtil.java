package club.banyuan;

import java.util.ArrayList;

public class PairUtil {
    static public  <T> Pair<T> swap(Pair<T> input){
        input.swap();
        return input;
    }

    static public <T extends Measurable> Pair<T> minmax(T[] input){
        T max = input[0];
        T min =  max;
        for (T one : input) {
            if (one.getMeasure()>max.getMeasure()){
                max = one;
            }
            if (one.getMeasure()<min.getMeasure()){
                min = one;
            }
        }
        return new Pair<>(max,min);
    }


    static public <T extends Comparable<T>> Pair<T> minmax(T[] input){

        T min = input[0];
        T max = min;
        for (T one : input) {
            if (one.compareTo(max)>0){
                max = one;
            }
            if (one.compareTo(min)<0){
                min = one;
            }
        }
        return new Pair(max,min);
    }
}
