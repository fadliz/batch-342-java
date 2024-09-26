package figure;

public abstract class Trilateral {
    private Double hypotenuse;
    private Double base;
    private Double height;
    
    protected Trilateral() {
    }

    protected Trilateral(Double hypotenuse, Double base, Double height) {
        this.hypotenuse = hypotenuse;
        this.base = base;
        this.height = height;
    }
    
    public Double getHypotenuse() {
        return hypotenuse;
    }
    public void setHypotenuse(Double hypotenuse) {
        this.hypotenuse = hypotenuse;
    }
    public Double getBase() {
        return base;
    }
    public void setBase(Double base) {
        this.base = base;
    }
    public Double getHeight() {
        return height;
    }
    public void setHeight(Double height) {
        this.height = height;
    }

}
