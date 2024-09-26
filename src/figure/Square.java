package figure;

public class Square extends Quadrilateral implements PlaneFigure {

    public Square(Double xAxis, Double yAxis) {
        super(xAxis, yAxis);
    }

    public Square() {
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
