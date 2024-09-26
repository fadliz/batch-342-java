package figure;

public class IsoscelesTrapezoid extends Quadrilateral implements PlaneFigure {
    private Double longerBase;

    public IsoscelesTrapezoid() {
    }

    public IsoscelesTrapezoid(Double xAxis, Double yAxis, Double longerBase) {
        super(xAxis, yAxis);
        this.longerBase = longerBase;
    }

    public Double getLongerBase() {
        return longerBase;
    }

    public void setLongerBase(Double longerBase) {
        this.longerBase = longerBase;
    }

    private Double getSide() {
        return (this.getLongerBase() - this.getxAxis()) * this.getyAxis() / 4;
    }

    @Override
    public Double calculateArea() {
        return (this.getxAxis() + this.getLongerBase()) * this.getyAxis() / 2;
    }

    @Override
    public Double calculateCircumference() {
        return (this.getSide() * 2) + this.getLongerBase() + this.getxAxis();
    }

}
