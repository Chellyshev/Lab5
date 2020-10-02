package lab.collection;

public class Person {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Float weight; //Поле не может быть null, Значение поля должно быть больше 0
    private Color eyeColor; //Поле не может быть null
    private Location location; //Поле не может быть null

    public Person() {
    }

    public Person(String name, Float weight , Color eyeColor, Location location) {
        this.name = name;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", eyeColor=" + eyeColor +
                ", location=" + location +
                '}';
    }
}


