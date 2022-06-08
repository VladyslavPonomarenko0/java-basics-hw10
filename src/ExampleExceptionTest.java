import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExampleExceptionTest {
  @DataProvider(name = "data")
  public static Object[][] data() {
    return new Object[][]{
        {2, 2, 4},
        {2, 3, 6},
        {10, 10, 100},
        {10000, 1111, 11110000}

    };
  }

  @DataProvider(name = "negativeData")
  public static Object[][] negativeData() {
    return new Object[][]{
        {-2, 2},
        {2, -2},
        {0, -2},
        {-2, -2},
        {0, 0},
        {0, 1}
    };
  }

  @Test(dataProvider = "data")
  public void testRectangleArea(int a, int b, int c) {
    int actualResult = ExampleException.rectangleArea(a, b);
    assertEquals(actualResult, c, "The area calculation formula isn't correct");
  }


  @Test(dataProvider = "negativeData")
  public void testRectangleAreaNegative(int a, int b) {
    try {
      ExampleException.rectangleArea(a, b);
      fail("Expected an IllegalArgumentException to be thrown");
    } catch (IllegalArgumentException anIllegalArgumentException) {
      assertEquals(anIllegalArgumentException.getMessage(), "Please, dont input negative values and 0");
    }
  }
}