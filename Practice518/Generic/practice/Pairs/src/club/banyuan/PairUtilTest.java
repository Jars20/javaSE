package club.banyuan;

import org.junit.Assert;
import org.junit.Test;


public class PairUtilTest {

    @Test
    public void test() {
        Pair<String> a = new Pair<>("a", "b");
        Pair<Integer> b = new Pair<>(1, 2);
        a.swap();
        b.swap();
        Assert.assertEquals("b", a.getFirst());
        Assert.assertEquals("a", a.getSecond());
        Assert.assertEquals(2, b.getFirst().intValue());
        Assert.assertEquals(1, b.getSecond().intValue());
        Pair<String> temp = PairUtil.swap(a);
        Assert.assertEquals("a", temp.getFirst());
        Assert.assertEquals("b", temp.getSecond());
        Integer[] array = {1, 2, 3, 4, 5, 6};
        Pair<Integer> temp2 = PairUtil.minmax(array);
        Assert.assertEquals(1, temp2.getFirst().intValue());
        Assert.assertEquals(6, temp2.getSecond().intValue());

        Measurable[] measurable = {() -> 1.0, () -> 2.0, () -> 3.0};
        Pair<Measurable> temp3 = PairUtil.minmax(measurable);

        Assert.assertEquals(1.0, temp3.getFirst().getMeasure(), 0.1);
        Assert.assertEquals(3.0, temp3.getSecond().getMeasure(), 0.1);

    }
}