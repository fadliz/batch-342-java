package figure;

public class IsoscelesTriangle extends Trilateral implements PlaneFigure {

    public IsoscelesTriangle() {
    }

    public IsoscelesTriangle(Double base, Double height) {
        super(Math.sqrt(base * base + height * height), base, height);
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
