package unit_tests;

import Figures.Figure;
import Figures.Triangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;

public class TestTriangle {
    @Test
    public void testGetAreaTriangle(){
        double a = 1;
        double b = 1;
        double c = 1;
        final String NAME = "name";
        double p = (a+b+c)/2;
        final double ExpectedResult = Math.sqrt(p*(p-a)*(p-b)*(p-c));

        Figure c1 = new Triangle(a, b, c, NAME);
        Assert.assertEquals(c1.getArea(), ExpectedResult, "Ожидаемая площадь треугольника не равна актуальной");
    }
    @Test
    public void testGetUsersNameTriangle(){
        double a = 1;
        double b = 1;
        double c = 1;
        final String NAME = "name";
        final String ExpectedResult = "name";
        Figure c1 = new Triangle(a, b, c, NAME);
        Assert.assertEquals(c1.getUsersName(), ExpectedResult, "Ожидаемое имя треугольника не равно актуальной");
    }

    @Test
    public void testToStringTriangle(){
        double a = 1;
        double b = 1;
        double c = 1;
        final String NAME = "name";
        double p = (a+b+c)/2;
        final double AREA = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        final double ALPHA = Math.toDegrees(Math.acos(((a*a)+(c*c)-(b*b))/(2*a*c)));
        final double BETTA = Math.toDegrees(Math.acos(((a*a)+(b*b)-(c*c))/(2*a*b)));
        final double GAMMA = Math.toDegrees(Math.acos(((b*b)+(c*c)-(a*a))/(2*c*b)));

        String fAlpha = new DecimalFormat("#0.00").format(ALPHA);
        String fBetta = new DecimalFormat("#0.00").format(BETTA);
        String fGamma = new DecimalFormat("#0.00").format(GAMMA);


        final String ExpectedResult = "[Треугольник"+", "+NAME+", "+AREA+", углы: "+fAlpha+" "+fBetta+" "+fGamma+"]";
        Figure c1 = new Triangle(a,b,c, NAME);
        Assert.assertEquals(c1.toString(), ExpectedResult, "Полная информация о треугольнике не валидна");
    }

    @Test
    public void testGetAnglesTriangle(){
        double a = 1;
        double b = 1;
        double c = 1;
        final String NAME = "name";
        double p = (a+b+c)/2;
        final double AREA = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        final double ALPHA = Math.toDegrees(Math.acos(((a*a)+(c*c)-(b*b))/(2*a*c)));
        final double BETTA = Math.toDegrees(Math.acos(((a*a)+(b*b)-(c*c))/(2*a*b)));
        final double GAMMA = Math.toDegrees(Math.acos(((b*b)+(c*c)-(a*a))/(2*c*b)));

        String fAlpha = new DecimalFormat("#0.00").format(ALPHA);
        String fBetta = new DecimalFormat("#0.00").format(BETTA);
        String fGamma = new DecimalFormat("#0.00").format(GAMMA);


        final String ExpectedResult = fAlpha+" "+fBetta+" "+fGamma;
        Triangle c1 = new Triangle(a,b,c, NAME);
        Assert.assertEquals(c1.getAngles(), ExpectedResult, "Ожидаемые углы не равны актуальным");
    }
}
