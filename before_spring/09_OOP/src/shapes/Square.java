package shapes;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side,side);
    }

    public Square(double side, String color, boolean filled) {
        super(color, filled, side, side);
    }

    public double getSide(){
        return getLength();
    }

    public void setSide(double side){
        super.setLength(side);
        super.setWidth(side);
    }

    @Override
    public void setWidth(double side){
        setSide(side);
    }

    @Override
    public void setLength(double side){
        setSide(side);
    }

    @Override
    public String toString(){
        return "A Square with width=" + super.getWidth() + ", length=" + super.getLength() + ", which is a subclass of " + super.toString();
    }
}
