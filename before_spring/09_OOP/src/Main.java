import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;
import shapes.Square;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        ArrayList<Shape> shapes = new ArrayList<>();

        Square square1 = new Square(2.5);
        Circle circle1 = new Circle(9.9, "red", false);
        Rectangle rectangle1 = new Rectangle("blue", false, 1.4, 2.4);

        square1.setLength(3.0);

        shapes.add(square1);
        shapes.add(circle1);
        shapes.add(rectangle1);

        double totalArea2 = 0;
        totalArea2 = shapes.stream().mapToDouble(Shape::getArea).sum();

        System.out.println(getTotalArea(shapes));
        System.out.println(totalArea2);

        System.out.println("Highest perimeter: " + getHighestPerimeter(shapes));

        printOnlySides(shapes);
    }

    public static double getTotalArea(ArrayList<Shape> shapes){
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
        }
        return totalArea;
    }

    public static double getHighestPerimeter(ArrayList<Shape> shapes){
        double highestPerimeter = 0;
        for (Shape shape : shapes) {
            double currentPerimeter = shape.getPerimeter();
            if (currentPerimeter > highestPerimeter) highestPerimeter = currentPerimeter;
        }
        return highestPerimeter;
    }

    public static void printOnlySides(ArrayList<Shape> shapes){
        for (Shape shape : shapes) {
            if (shape.getClass() == Square.class) {
                System.out.println(((Square) shape).getSide());
            }
        }
    }
}
