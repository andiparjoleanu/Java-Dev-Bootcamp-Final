package org.bootcamp;

import org.bootcamp.calculator.InsurancePolicyCalculator;
import org.bootcamp.dao.VehicleInfoDao;
import org.bootcamp.dao.VehicleInfoPlainFileDao;
import org.bootcamp.formula.Formula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.service.InsuranceCalculationResult;
import org.bootcamp.service.InsuranceCalculatorService;
import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class MainApp {


    private static final String OUTPUT_FORMAT = "Vehicle with id %s has total cost %d";


    public static void main(String[] args) {


        if (args.length >= 1) {
            final InsuranceCalculatorService service = new InsuranceCalculatorService(args[0]);
            final List<InsuranceCalculationResult> resultList = service.calculateAll();

            for (InsuranceCalculationResult result : resultList) {
                final String output = String.format(OUTPUT_FORMAT, result.getId(), result.getCost());
                System.out.println(output);
            }

        } else {
            System.out.println("No arguments!");
        }
    }


}
