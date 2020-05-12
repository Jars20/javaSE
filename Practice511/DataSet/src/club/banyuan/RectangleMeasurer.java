package club.banyuan;

public class RectangleMeasurer implements Measurer {
// TODO: 创建实现Measurer接口的RectangleMeasurer类。
//  提示：RectangleMeasurer类应包含具有与接口中指定的签名相同的方法。
//  measure()应该返回矩形的周长。

    @Override
    public double measure(Object anObject) {
        return ((Rectangle)anObject).width*((Rectangle)anObject).height;
    }
}
