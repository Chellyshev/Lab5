package lab.collection;

public class Coordinates {
    private Long x;
    private Double y;

    public Coordinates(Long x, Double y) {
        this.x = x;
        this.y = y;
    }


    public void setX(Long x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Long getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

