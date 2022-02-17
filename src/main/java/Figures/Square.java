package Figures;

public class Square extends Figure {
    private double side;
    private String name;

    public Square(double side, String name) {
        this.side = side;
        this.name = name;
    }

    @Override
    public double getArea() {

        return side*side;
    }
    public String getFigureName(){
        return Circle.class.getName();
    }
    public String getUsersName(){
        return name;
    }
    @Override
    public String toString() {
        return "[Квадрат"+", "+getUsersName()+", "+getArea()+"]";
    }
}
