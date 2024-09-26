package figure;

public abstract class Circular {
    private Double radius;
    private static final Double PI = Math.PI;

    protected Circular() {
    }

    protected Circular(Double radius) {
        this.radius = radius;
    }
    
    public Double getRadius() {
        return radius;
    }
    public void setRadius(Double radius) {
        this.radius = radius;
    }
    public Double getPi() {
        return PI;
    }
    
}
