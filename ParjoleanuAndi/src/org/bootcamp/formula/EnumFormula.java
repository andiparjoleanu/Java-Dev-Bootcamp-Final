package org.bootcamp.formula;

import org.bootcamp.vehicle.Vehicle;

public enum EnumFormula
{
     CAR_BASIC_FORMULA {
         public int calculate(Vehicle vehicle) {
             int cost = 100 * vehicle.getAge();
             cost += vehicle.isDiesel() ? 500 : 0;
             cost += vehicle.getNumberOfMiles() > 200000 ? 500 : 0;

             return cost;
         }
     },
    CAR_CHRISTMAS_FORMULA {
         public int calculate(Vehicle vehicle)
         {
             return 19 * CAR_BASIC_FORMULA.calculate(vehicle) / 20;
         }
    },
    BUS_BASIC_FORMULA{
        public int calculate(Vehicle vehicle)
        {
            int cost = 200 * vehicle.getAge();
            cost += vehicle.isDiesel() ? 1000 : 0;

            if (vehicle.getNumberOfMiles() > 100000 && vehicle.getNumberOfMiles() < 200000) {
                cost += 500;
            }
            if (vehicle.getNumberOfMiles() > 200000) {
                cost += 1000;
            }
            return cost;
        }
    },
    BUS_CHRISTMAS_FORMULA{
         public int calculate(Vehicle vehicle)
         {
             return 9 * BUS_BASIC_FORMULA.calculate(vehicle) / 10;
         }
    },
    TIPPER_BASIC_FORMULA{
        public int calculate(Vehicle vehicle) {
            int cost = 300 * vehicle.getAge();
            if (vehicle.getNumberOfMiles() > 80000) {
                cost += 700;
            }
            return cost;
        }
    },
    TIPPER_CHRISTMAS_FORMULA {
       public int calculate(Vehicle vehicle)
       {
            return 17 * TIPPER_BASIC_FORMULA.calculate(vehicle) / 20;
       }
     };

    public abstract int calculate(Vehicle vehicle);

}
