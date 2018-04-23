package org.bootcamp;

import org.bootcamp.service.InsuranceCalculationResult;
import org.bootcamp.service.InsuranceCalculatorService;

import java.text.DecimalFormat;
import java.util.List;

public class MainApp {


    private static final String OUTPUT_FORMAT = "%s with id %s has total cost %s";
    private static DecimalFormat df2 = new DecimalFormat(".#");

    public static void main(String[] args) {


        if (args.length >= 1) {
            final InsuranceCalculatorService service = new InsuranceCalculatorService(args[0]);
            final List<InsuranceCalculationResult> resultList = service.calculateAll();

            for (InsuranceCalculationResult result : resultList) {
                final String output = String.format(OUTPUT_FORMAT, result.getVehicleType(), result.getId(), df2.format(result.getCost()));
                System.out.println(output);
            }

        } else {
            System.out.println("No arguments!");
        }
    }


}
