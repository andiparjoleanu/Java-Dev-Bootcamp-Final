package org.bootcamp.model;

public final class VehicleInfo
{
    private String id;
    private String vehicleTypeName;
    private String vehicleTypeFormula;
    private int age;
    private Long numberOfMiles;
    private boolean isDiesel;

    public VehicleInfo() {
    }

    private VehicleInfo(String id, String vehicleTypeName, String vehicleTypeFormula, int age, Long numberOfMiles, boolean isDiesel) {
        this.id = id;
        this.vehicleTypeName = vehicleTypeName;
        this.vehicleTypeFormula = vehicleTypeFormula;
        this.age = age;
        this.numberOfMiles = numberOfMiles;
        this.isDiesel = isDiesel;
    }

    public static Builder builder()
    {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getVehicleTypeName() {
        return vehicleTypeName;
    }

    public String getVehicleTypeFormula() {
        return vehicleTypeFormula;
    }

    public int getAge() {
        return age;
    }

    public Long getNumberOfMiles() {
        return numberOfMiles;
    }

    public boolean isDiesel() {
        return isDiesel;
    }

    public static final class Builder
    {
        private String id;
        private String vehicleTypeName;
        private String vehicleTypeFormula;
        private int age;
        private Long numberOfMiles;
        private boolean isDiesel;

        private Builder()
        {

        }

        public Builder withId(String id)
        {
            this.id = id;
            return this;
        }

        public Builder withVehicleTypeName(String vehicleTypeName)
        {
            this.vehicleTypeName = vehicleTypeName;
            return this;
        }

        public Builder withVehicleTypeFormula(String vehicleTypeFormula)
        {
            this.vehicleTypeFormula = vehicleTypeFormula;
            return this;
        }

        public Builder withAge(int age)
        {
            this.age = age;
            return this;
        }

        public Builder withNumberOfMiles(Long numberOfMiles)
        {
            this.numberOfMiles = numberOfMiles;
            return this;
        }

        public Builder withIsDiesel(boolean isDiesel)
        {
            this.isDiesel = isDiesel;
            return this;
        }

        public VehicleInfo build()
        {
            return new VehicleInfo(this.id, this.vehicleTypeName, this.vehicleTypeFormula, this.age, this.numberOfMiles, this.isDiesel);
        }
    }


}

