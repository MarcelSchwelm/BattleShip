package battleship;

public class Sea {
    final int ROWS = 10;
    final int COLUMNS = 10;

    String[][] sea = new String[ROWS + 1][COLUMNS + 1];

    public Sea() {
        //assign header
        sea[0][0] = " ";
        for (int x = 1; x <= 10; x++) {
            sea[x][0] = String.valueOf(x);
        }
        //assign first column
        char firstChar = 'A';
        for (int y = 1; y <= 10; y++) {
            sea[0][y] = String.valueOf(firstChar);
            firstChar++;
        }
        //assign seafields
        for (int y = 1; y <= 10; y++) {
            for (int x = 1; x <= 10; x++) {
                sea[x][y] = "~";
            }
        }
    }

    public void draw() {

        for (int y = 0; y <= COLUMNS; y++) {
            for (int x = 0; x <= ROWS; x++) {
                System.out.print(sea[x][y] + " ");
            }
            System.out.println();
        }
    }

    public void setShip(int x1, int y1, int x2, int y2, Ship ship) {
        //give the ship its coordinates
        ship.x1 = x1;
        ship.y1 = y1;
        ship.x2 = x2;
        ship.y2 = y2;

        //draw ship
        //horizontal ship (e.g. A1 A5)
        if (x1 == x2) {
            for (int y = y1; y <= y2; y++) {
                sea[y][x1] = "O";
            }
        }
        //vertical ship (e.g. A1 D1)
        if (y1 == y2) {
            for (int x = x1; x <= x2; x++) {
                sea[y1][x] = "O";
            }
        }
    }

    int parseX(String firstCoordinate) {
        return firstCoordinate.charAt(0) - 'A' + 1;
    }

    int parseY(String firstCoordinate) {
        if (firstCoordinate.length() == 2) {
            return firstCoordinate.charAt(1) - '1' + 1;
        } else {
            return 10;
        }
    }
}
