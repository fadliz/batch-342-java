package figure;

public abstract class Quadrilateral {
    private Double xAxis;
    private Double yAxis;

    protected Quadrilateral() {
    }

    protected Quadrilateral(Double xAxis, Double yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Double getxAxis() {
        return xAxis;
    }

    public void setxAxis(Double xAxis) {
        this.xAxis = xAxis;
    }

    public Double getyAxis() {
        return yAxis;
    }

    public void setyAxis(Double yAxis) {
        this.yAxis = yAxis;
    }

    
}
