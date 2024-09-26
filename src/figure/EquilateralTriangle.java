package figure;

public class EquilateralTriangle extends Trilateral implements PlaneFigure {

    public EquilateralTriangle() {
    }

    public EquilateralTriangle(Double hypotenuse, Double base, Double height) {
        super(hypotenuse, base, height);
    }

    @Override
    public Double calculateArea() {
        return this.getBase() * this.getHeight() / 2;
    }

    @Override
    public Double calculateCircumference() {
        return this.getBase() + (this.getHypotenuse() * 2);
    }

}
