package figure;

public class Kite extends Quadrilateral implements PlaneFigure {
    private Double sideOne;
    private Double sideTwo;

    public Kite() {
    }

    public Kite(Double sideOne, Double sideTwo, Double xAxis, Double yAxis) {
        super(xAxis, yAxis);
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
    }

    @Override
    public Double calculateArea() {
        return this.getxAxis() * this.getyAxis() / 2;
    }
    
    @Override
    public Double calculateCircumference() {

        return (this.getSideOne() + this.getSideTwo()) * 2;
    }

    public Double getSideOne() {
        return sideOne;
    }
    
    public void setSideOne(Double sideOne) {
        this.sideOne = sideOne;
    }

    public Double getSideTwo() {
        return sideTwo;
    }

    public void setSideTwo(Double sideTwo) {
        this.sideTwo = sideTwo;
    }

}
