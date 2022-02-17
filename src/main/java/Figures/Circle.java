package Figures;

public class Circle extends Figure{
    private double radius;
    private String name;

    public Circle(double radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    public String getUsersName(){
        return name;
    }

    @Override
    public String toString() {
        return "[Круг"+", "+getUsersName()+", "+getArea()+"]";
    }
}

//    public String getFigureName(){
//        return Circle.class.getName();
//    }