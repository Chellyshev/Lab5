package lab.collection;

public enum MpaaRating {
    G(1),
    PG_13(2),
    R(3),
    NC_17(4);

    int value;

    MpaaRating(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
