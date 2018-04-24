package org.bootcamp.calculate;

import org.bootcamp.formula.EnumFormula;
import org.bootcamp.vehicle.Vehicle;

public final class InsurancePolicyCalculate {

    public static final InsurancePolicyCalculate INSTANCE = new InsurancePolicyCalculate();
    private InsurancePolicyCalculate() {

    }

    public int calculate (Vehicle vehicle, EnumFormula formula)
    {
        return formula.calculate(vehicle);
    }

}

