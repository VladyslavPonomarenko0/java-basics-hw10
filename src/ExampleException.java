public class ExampleException {
  public static int rectangleArea(int a, int b) {
    int area = a * b;
    if (a < 0 || b < 0 || a == 0 || b == 0) {
      throw new IllegalArgumentException("Please, dont input negative values and 0");
    }
    return area;
  }
}