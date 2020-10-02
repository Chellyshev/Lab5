package lab.collection;

public class Location {
    private Long x; //Поле не может быть null
    private Double y; //Поле не может быть null
    private Double z; //Поле не может быть null

    public Location(Long x, Double y, Double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public Long getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
