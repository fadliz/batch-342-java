package figure;

public class Rectangle extends Quadrilateral implements PlaneFigure {

    public Rectangle(Double xAxis, Double yAxis) {
        super(xAxis, yAxis);
    }

    public Rectangle() {
    }

    @Override
    public Double calculateArea() {
        return this.getxAxis() * this.getyAxis();
    }

    @Override
    public Double calculateCircumference() {
        return (this.getxAxis() + this.getyAxis()) * 2;
    }

}
