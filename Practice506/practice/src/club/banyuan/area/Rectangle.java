package club.banyuan.area;

public class Rectangle extends Shape{
    private int length,width;
    public Rectangle(int length,int width){
        this.length = length;
        this.width = width;
    }

    @Override
    public String getShapeName() {
        return "矩形";
    }

    @Override
    public double area() {
        return  this.width*this.length;
    }

    @Override
    public double perimeter() {
        return 2*(this.length+this.width);
    }
}
