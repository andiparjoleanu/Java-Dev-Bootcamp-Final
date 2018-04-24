package org.bootcamp.vehicle;

public final class Bus extends Vehicle { //nu vom putea mosteni clasa respectiva cu final
    private int numberOfSeats;

    public Bus()
    {
    }

    public Bus(int age, long numberOfMiles, boolean isDiesel)
    {
        super(age, numberOfMiles, isDiesel);
    }

    public Bus(int age, long numberOfMiles, boolean isDiesel, int numberOfSeats) {
        super(age, numberOfMiles, isDiesel);
        this.numberOfSeats = numberOfSeats;
    }

    public int getnumberOfSeats() {
        return numberOfSeats;
    }

    public void setnumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
