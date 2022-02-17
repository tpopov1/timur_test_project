package Figures;

public class Rectangle extends Figure{
    private double width;
    private double height;
    private String name;

    public Rectangle(double width, double height, String name){
        this.width = width;
        this.height = height;
        this.name = name;
    }


    @Override
    public double getArea() {
        return width*height;
    }
    public String getFigureName(){
        return Circle.class.getName();
    }
    public String getUsersName(){
        return name;
    }
    @Override
    public String toString() {
        return "[Прямоугольник"+", "+getUsersName()+", "+getArea()+"]";
    }



}
