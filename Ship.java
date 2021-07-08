package battleship;

public class Ship {
    String name;
    int length;
    int x1;
    int x2;
    int y1;
    int y2;
    String[] fields;
    boolean destroyed;

    public Ship(String name, int length) {
        this.name = name;
        this.length = length;
        this.fields = new String[length - 1];
        this.destroyed = false;
    }

    public boolean isDestroyed() {

        return destroyed;
    }

    public boolean testDestroyed(Sea sea) {

        destroyed=true;

        //test if ship is destroyed complete
        //horizontal ship (e.g. A1 A5)

        if (x1 == x2) {
            for (int y = y1; y <= y2; y++) {
                if (sea.sea[y][x1].equals("O")) {
                    destroyed = false;
                }
            }

        }
        //vertical ship (e.g. A1 D1)
        if (y1 == y2) {
            for (int x = x1; x <= x2; x++) {
                if (sea.sea[y1][x].equals("O")) {
                    destroyed = false;
                }
            }
        }
        return destroyed;
    }
}
