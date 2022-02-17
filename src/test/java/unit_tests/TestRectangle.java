package unit_tests;

import Figures.Figure;
import Figures.Rectangle;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestRectangle {

        @Test
        public void testGetAreaRectangle(){
            final double a = 1;
            final double b = 1;
            final double ExpectedResult = a*b;
            final String NAME = "name";

            Figure c1 = new Rectangle(a, b, NAME);
            Assert.assertEquals(c1.getArea(), ExpectedResult, "Ожидаемая площадь прямоугольника не равна актуальной");
        }
        @Test
        public void testGetUsersNameRectagle(){
            final double a = 1;
            final double b = 1;
            final String ExpectedResult = "name";
            Figure c1 = new Rectangle(a, b, "name");
            Assert.assertEquals(c1.getUsersName(), ExpectedResult, "Ожидаемое имя прямоугольника не равно актуальной");
        }

        @Test
        public void testToStringRectangle(){
            final double a = 1;
            final double b = 1;
            final double AREA = a*b;
            final String NAME = "name";
            String ExpectedResult = "[Прямоугольник"+", "+NAME+", "+AREA+"]";

            Figure c1 = new Rectangle(a, b, "name");
            Assert.assertEquals(c1.toString(), ExpectedResult, "Полная информация о прямоугольнике не валидна");
        }
}
