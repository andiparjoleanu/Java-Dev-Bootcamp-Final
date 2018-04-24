package org.bootcamp;

import Source.InsuranceCalculationResults;
import Source.InsuranceCalculatorService;
import org.bootcamp.dao.VehicleInfoDao;
import org.bootcamp.dao.VehicleInfoPlanFileInfoDao;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.formula.*;
import org.bootcamp.calculate.*;

import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

import java.util.*;

import static Source.ConversionUtils.getVehicle;

public class Main {

    /*public static void main(String[] args) {

        final Car joesCar = new Car(5, 200000, true, "auto");
        final Bus stevesBus = new Bus(3, 100000, true, 31);
        final Tipper petersTipper = new Tipper(6, 80000, false, 15);

        //final InsurancePolicyCalculate calculate = InsurancePolicyCalculate.INSTANCE;
        /*
        final int joesInsurancePolicyCost = calculate.calculate(joesCar);
        final int stevesInsurancePolicyCost = calculate.calculate(stevesBus);
        final int petersInsurancePolicyCost = calculate.calculate(petersTipper);

        //joesInsurancePolicyCost += joesCar.isDiesel() ? 500 : 0;
        /*if(joesCar.isDiesel()){
            joesInsurancePolicyCost +=500;
        }*/
      /*  final InsurancePolicyCalculate calculate = InsurancePolicyCalculate.INSTANCE;

        final Formula CarBasicFormula = new CarBasicFormula();
        final Formula BusBasicFormula = new BusBasicFormula();
        final Formula TipperBasicFormula = new TipperBasicFormula();

        final int joesInsurancePolicyCost = calculate.calculate(joesCar, CarBasicFormula);
        final int stevesInsurancePolicyCost = calculate.calculate(stevesBus, BusBasicFormula);
        final int petersInsurancePolicyCost = EnumFormula.TIPPER_FORMULA.calculate(petersTipper);  //calculate.calculate(petersTipper, TipperBasicFormula);

        System.out.println(args[0]);
        System.out.println("Joe's policy cost is " + joesInsurancePolicyCost);
        System.out.println("Steve's policy cost is " + stevesInsurancePolicyCost);
        System.out.println("Peter's policy cost is " + petersInsurancePolicyCost);

    }*/

      private static final int VEHICLE_ID = 0;
      private static final int VEHICLE_FORMULA = 2;
    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;
    private static final String SEPARATOR = ";";
    private static final String OUTPUT_FORMAT = "Vehicle with id %s and type of %s has total cost %d";



   /* public static void main(String[] args) {

        final InsurancePolicyCalculate calculator = InsurancePolicyCalculate.INSTANCE;
        if (args.length >= 1) {
            // final File inputFile = new File(args[0]);
            final VehicleInfoDao vehicleInfoDao = new VehicleInfoPlanFileInfoDao(args[0]);
            final List<VehicleInfo> vehicleInfos = vehicleInfoDao.getAllVehicles();
            if (vehicleInfos.isEmpty()) {
                System.err.println("No records found");
                return;
            } else {
                for (VehicleInfo info : vehicleInfos) {
                    final Vehicle vehicle = getVehicle(info.getVehicleTypeName(), info.getAge(),
                            info.getNumberOfMiles(), info.isDiesel());

                    final int totalCost = calculator.calculate(vehicle, EnumFormula.valueOf(info.getVehicleTypeFormula()));
                    final String output = String.format(OUTPUT_FORMAT, info.getId(), totalCost);
                    System.out.println(output);
                }
            }
        }
    }
    */





            /*
            try
            {
                final InputStream inputStream = new FileInputStream(inputFile);
                final Scanner scanner = new Scanner(inputStream);

                while(scanner.hasNextLine())
                {
                    final String line = scanner.nextLine();
                    final String[] tokens = line.split(SEPARATOR);

                    final Vehicle vehicle = getVehicle(tokens[VEHICLE_TYPE], Integer.parseInt(tokens[VEHICLE_AGE]),
                            Long.parseLong(tokens[VEHICLE_MILES]), Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL]));


                    final int totalCost = calculator.calculate(vehicle, EnumFormula.valueOf(tokens[VEHICLE_FORMULA]));
                    final String output = String.format(OUTPUT_FORMAT, tokens[VEHICLE_ID], totalCost);
                    System.out.println(output);
                }

                scanner.close();

            }
            catch(FileNotFoundException e)
            {
                System.err.println(e.getMessage());
            }
        }
        else
        {
            System.out.println("No args");
        }
        */


    public static void main(String[] args) {
        try
        {
            if (args.length >= 1) {

                final InsuranceCalculatorService service = new InsuranceCalculatorService(args[0]);
                final List<InsuranceCalculationResults> resultList = service.calculateAll();

                for (InsuranceCalculationResults result : resultList)
                {
                    final String output = String.format(OUTPUT_FORMAT, result.getId(), result.getType(), result.getCost());
                    System.out.println(output);
                }
            } else {
                System.out.println("No arguments");
            }
        }
        catch(IllegalStateException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static Vehicle getVehicle(String vehicleName, int age, long numberOfMiles, boolean isDiesel)
    {
       final String carClassName = Car.class.getSimpleName().toLowerCase();
       final String busClassName = Bus.class.getSimpleName().toUpperCase();
       final String tipperClassName = Tipper.class.getSimpleName().toUpperCase();
       if(vehicleName.equals(carClassName))
       {
           return new Car(age, numberOfMiles, isDiesel);
       }

        if(vehicleName.equals(busClassName))
        {
            return new Bus(age, numberOfMiles, isDiesel);
        }

        if(vehicleName.equals(tipperClassName))
        {
            return new Tipper(age, numberOfMiles, isDiesel);
        }

        return null;
    }
}
