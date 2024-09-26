package figure;

public class Circle extends Circular implements PlaneFigure {

    @Override
    public Double calculateArea() {
        return Math.pow(this.getRadius(), 2) * this.getPi();
    }

    @Override
    public Double calculateCircumference() {
        return this.getRadius() * 2 * this.getPi();
    }

}
