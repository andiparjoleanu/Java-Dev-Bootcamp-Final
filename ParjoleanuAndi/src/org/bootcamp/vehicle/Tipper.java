package org.bootcamp.vehicle;

public final class Tipper extends Vehicle { //nu vom putea mosteni clasa respectiva cu final
    private float capacityInTons;

    public Tipper()
    {
    }
    public Tipper(int age, long numberOfMiles, boolean isDiesel)
    {
        super(age, numberOfMiles, isDiesel);
    }

    public Tipper(int age, long numberOfMiles, boolean isDiesel, int capacityInTons) {
        super(age, numberOfMiles, isDiesel);
        this.capacityInTons = capacityInTons;
    }

    public float getcapacityInTons() {
        return capacityInTons;
    }

    public void setcapacityInTons(float capacityInTons) {
        this.capacityInTons = capacityInTons;
    }
}
