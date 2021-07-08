package battleship;

public class Fleet {

    Ship aircraftCarrier = new Ship("Aircraft Carrier", 5);
    Ship battleShip = new Ship("Battleship", 4);
    Ship submarine = new Ship("Submarine", 3);
    Ship cruiser = new Ship("Cruiser", 3);
    Ship destroyer = new Ship("Destroyer", 2);

    Ship[] fleet = new Ship[]{aircraftCarrier, battleShip, submarine, cruiser, destroyer};

    public int howManyShipsExist(Sea sea) {
        int exist=0;
        for (Ship ship : fleet) {
            if (!ship.testDestroyed(sea)) {
                exist++;
            }
        }
        return exist;
    }
}


