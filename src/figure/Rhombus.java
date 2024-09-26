package figure;

public class Rhombus extends Quadrilateral implements PlaneFigure {

    public Rhombus(Double xAxis, Double yAxis) {
        super(xAxis, yAxis);
    }

    public Rhombus() {
    }

    @Override
    public Double calculateArea() {
        return this.getxAxis() * this.getyAxis() / 2;
    }

    @Override
    public Double calculateCircumference() {
        return Math.sqrt((Math.pow(this.getxAxis(), 2) + Math.pow(this.getyAxis(), 2))) * 2;
    }

}
