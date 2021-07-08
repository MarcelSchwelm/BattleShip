package battleship;

import java.util.Scanner;

public class Main {

    static Scanner scanner;
    static boolean testForVictory = false;
    static boolean playerOnesTurn = true;

    public static void main(String[] args) {

        //initialize sea and fleet for Player1
        Sea playerSea = new Sea();
        playerSea.draw();
        Sea playerSeaFog = new Sea();
        Fleet playerFleet = new Fleet();

        //Player 1 set Ships
        setShips(playerFleet, playerSea);
        clearScreen();

        //initialize sea and fleet for Player2
        Sea player2Sea = new Sea();
        player2Sea.draw();
        Sea player2SeaFog = new Sea();
        Fleet player2Fleet = new Fleet();

        //Player 2 set Ships
        setShips(player2Fleet, player2Sea);
        clearScreen();

        //Players fire on each other
        playersFire(playerSea, playerSeaFog, playerFleet, player2Sea, player2SeaFog, player2Fleet);
    }

    private static void playersFire(Sea playerSea, Sea playerSeaFog, Fleet playerFleet, Sea player2Sea, Sea player2SeaFog, Fleet player2Fleet) {

        while (!testForVictory) {
            if (playerOnesTurn) {
                playerFire(playerSea, player2SeaFog, player2Fleet, player2Sea);
                playerOnesTurn = false;
            } else {
                playerFire(player2Sea, playerSeaFog, playerFleet, playerSea);
                playerOnesTurn = true;
            }
            clearScreen();
        }
    }

    private static void clearScreen() {
        System.out.println("Press Enter and pass the move to another player");
        scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    private static void playerFire(Sea sea, Sea seaFog, Fleet fleet, Sea oppSea) {
        int x = 0;
        int y = 0;
        seaFog.draw();
        System.out.println("---------------------");
        sea.draw();
        int numberOfShips = fleet.howManyShipsExist(oppSea);
        System.out.println(playerOnesTurn ? "Player 1, it's your turn:" : "Player 2, it's your turn:");
        while (x <= 0 || x > 10 || y <= 0 || y > 10) {
            String targetCoordinate = scanner.next();
            x = sea.parseX(targetCoordinate);
            y = sea.parseY(targetCoordinate);
            if (x <= 0 || x > 10 || y <= 0 || y > 10) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
        }

        if (oppSea.sea[y][x].equals("O")) {
            oppSea.sea[y][x] = "X";
            seaFog.sea[y][x] = "X";
            int howManyShipsExist = fleet.howManyShipsExist(oppSea);
            if (howManyShipsExist == 0) {
                System.out.println("You sank the last ship. You won. Congratulations!");
                System.exit(0);
            }

            if (numberOfShips > howManyShipsExist) {
                System.out.println("You sank a ship! Specify a new target:\n");
                numberOfShips = howManyShipsExist;
                testForVictory = testWin(oppSea);
            } else
                System.out.println("You hit a ship!");

        }
        if (oppSea.sea[y][x].equals("X") || oppSea.sea[y][x].equals("M")) {
            System.out.println("You missed!");
        }
        if (oppSea.sea[y][x].equals("~")) {
            oppSea.sea[y][x] = "M";
            seaFog.sea[y][x] = "M";
            System.out.println("You missed!");
        }

    }

    private static boolean testWin(Sea sea) {
        //check if all seafields are free of ship(-parts) ("O");
        for (String[] s : sea.sea) {
            for (String s1 : s) {
                if (s1.equals("O")) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void setShips(Fleet fleet, Sea sea) {
        String firstCoordinate;
        String secondCoordinate;
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        scanner = new Scanner(System.in);
        for (Ship ship : fleet.fleet) {
            System.out.printf("Enter the coordinates of the %s (%d cells):%n", ship.name, ship.length);
            System.out.println();
            boolean validCoordinates = false;
            while (!validCoordinates) {
                firstCoordinate = scanner.next();
                secondCoordinate = scanner.next();
                x1 = Math.min(sea.parseX(firstCoordinate), sea.parseX(secondCoordinate));
                y1 = Math.min(sea.parseY(firstCoordinate), sea.parseY(secondCoordinate));
                x2 = Math.max(sea.parseX(firstCoordinate), sea.parseX(secondCoordinate));
                y2 = Math.max(sea.parseY(firstCoordinate), sea.parseY(secondCoordinate));
                validCoordinates = checkInput(x1, y1, x2, y2, ship.length, ship.name, sea);
            }
            sea.setShip(x1, y1, x2, y2, ship);
            sea.draw();
        }
    }

    private static boolean checkInput(int x1, int y1, int x2, int y2, int length, String name, Sea sea) {
        if (!checkCoordinates(x1, y1, x2, y2)) {
            return false;
        }
        if (!checkLength(x1, y1, x2, y2, length, name)) {
            return false;
        }
        if (!checkFieldsEmpty(x1, y1, x2, y2, sea)) {
            return false;
        }
        return checkTooClose(x1, y1, x2, y2, sea);
    }

    private static boolean checkTooClose(int x1, int y1, int x2, int y2, Sea sea) {
        for (int y = y1; y <= y2; y++) {
            if ((sea.sea[y][Math.min(x1 + 1, 10)].equals("O")) || (sea.sea[y][x1 - 1].equals("O")) || (sea.sea[y - 1][x1].equals("O")) || (sea.sea[Math.min(y + 1, 10)][x1].equals("O"))) {
                System.out.println("Error! You placed it too close to another one. Try again!");
                return false;
            }
        }
        for (int x = x1; x <= x2; x++) {
            if ((sea.sea[Math.min(y1 + 1, 10)][x].equals("O")) || (sea.sea[y1 - 1][x].equals("O")) || (sea.sea[y1][Math.min(x + 1, 10)].equals("O")) || (sea.sea[y1][x - 1].equals("O"))) {
                System.out.println("Error! You placed it too close to another one. Try again!");
                return false;
            }
        }
        return true;
    }

    private static boolean checkFieldsEmpty(int x1, int y1, int x2, int y2, Sea sea) {
        if (x1 == x2) {
            for (int y = y1; y <= y2; y++) {
                if (!(sea.sea[y][x1].equals("~"))) {
                    System.out.println("Error! Fields are not empty! Try again!");
                    return false;
                }
            }
            return true;
        }
        if (y1 == y2) {
            for (int x = x1; x <= x2; x++) {
                if (!(sea.sea[y1][x].equals("~"))) {
                    System.out.println("Error! Fields are not empty! Try again!");
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean checkLength(int x1, int y1, int x2, int y2, int length, String name) {
        if ((x1 == x2) && (y2 - y1 == length - 1)) {
            return true;
        }
        if ((y1 == y2) && (x2 - x1 == length - 1)) {
            return true;
        }
        System.out.printf("Error! Wrong length of the %s! Try again:%n", name);
        return false;
    }

    private static boolean checkCoordinates(int x1, int y1, int x2, int y2) {
        if (x1 == x2 || y1 == y2) {
            return true;
        } else {
            System.out.println("Error! Wrong ship location. Try again:");
            return false;
        }
    }
}
