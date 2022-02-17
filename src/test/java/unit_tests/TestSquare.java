package unit_tests;


import Figures.Figure;
import Figures.Square;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSquare {
    @Test
    public void testGetAreaSquare(){
        final double SIDE = 1;
        final double ExpectedResult = SIDE*SIDE;

        Figure c1 = new Square(SIDE, "name");
        Assert.assertEquals(c1.getArea(), ExpectedResult, "Ожидаемая площадь не равна актуальной");
    }
    @Test
    public void testGetUsersNameSquare(){
        final double SIDE = 1;
        final String ExpectedResult = "name";
        Figure c1 = new Square(SIDE, "name");
        Assert.assertEquals(c1.getUsersName(), ExpectedResult, "Ожидаемое имя окружности не равно актуальной");
    }

    @Test
    public void testToStringSquare(){
        final double SIDE = 1;
        final double AREA = SIDE*SIDE;
        final String NAME = "name";

        final String ExpectedResult = "[Квадрат"+", "+NAME+", "+AREA+"]";
        Figure c1 = new Square(SIDE, NAME);
        Assert.assertEquals(c1.toString(), ExpectedResult, "Полная информация о квадрате не валидна");
    }

}
