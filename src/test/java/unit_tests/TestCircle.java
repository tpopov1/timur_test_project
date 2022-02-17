package unit_tests;

import Figures.Circle;
import Figures.Figure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCircle {
    @Test
    public void testGetAreaCircle(){
        final double RADIUS = 1;
        final double ExpectedResult = RADIUS*RADIUS*Math.PI;

        Figure c1 = new Circle(RADIUS, "name");
        Assert.assertEquals(c1.getArea(), ExpectedResult, "Ожидаемая площадь не равна актуальной");
    }
    @Test
    public void testGetUsersNameCircle(){
        final double RADIUS = 1;
        final String ExpectedResult = "name";
        Figure c1 = new Circle(RADIUS, "name");
        Assert.assertEquals(c1.getUsersName(), ExpectedResult, "Ожидаемое имя окружности не равно актуальной");
    }

    @Test
    public void testToStringCircle(){
        final double RADIUS = 1;
        final double AREA = RADIUS*RADIUS*Math.PI;
        final String NAME = "name";

        final String ExpectedResult = "[Круг"+", "+NAME+", "+AREA+"]";
        Figure c1 = new Circle(RADIUS, NAME);
        Assert.assertEquals(c1.toString(), ExpectedResult, "Полная информация об окружности не валидна");
    }

}
