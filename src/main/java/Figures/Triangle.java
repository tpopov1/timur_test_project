package Figures;

import java.text.DecimalFormat;

public class Triangle extends Figure{
    private double a;
    private double b;
    private double c;
    private double alpha;
    private double betta;
    private double gamma;
    private String name;

    public Triangle(double a, double b, double c, String name){
        this.a = a;
        this.b = b;
        this.c = c;
        this.name = name;
    }
    public String getAngles(){

        alpha = Math.toDegrees(Math.acos(((a*a)+(c*c)-(b*b))/(2*a*c)));
        betta = Math.toDegrees(Math.acos(((a*a)+(b*b)-(c*c))/(2*a*b)));
        gamma = Math.toDegrees(Math.acos(((b*b)+(c*c)-(a*a))/(2*c*b)));

        String fAlpha = new DecimalFormat("#0.00").format(alpha);
        String fBetta = new DecimalFormat("#0.00").format(betta);
        String fGamma = new DecimalFormat("#0.00").format(gamma);
        return fAlpha+" "+fBetta+" "+fGamma;
    }

    @Override
    public double getArea() {
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    public String getFigureName(){
        return Circle.class.getName();
    }
    public String getUsersName(){
        return name;
    }
    public String toString() {
        return "[Треугольник"+", "+getUsersName()+", "+getArea()+", углы: "+getAngles()+"]";
    }
}
