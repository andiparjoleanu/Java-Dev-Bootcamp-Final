package org.bootcamp.dao;

import org.bootcamp.model.VehicleInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class VehicleInfoPlanFileInfoDao implements VehicleInfoDao {

    private static int VEHICLE_ID = 0;
    private static final int VEHICLE_FORMULA = 2;
    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;
    private static final String SEPARATOR = ";";
    private String filePath;
    Map<String, VehicleInfo> map = new HashMap<>();

    public VehicleInfoPlanFileInfoDao(String filePath) throws IllegalStateException {
        this.filePath = filePath;
        try
        {
            FileInputStream inputStream = new FileInputStream(new File(this.filePath));
            final Scanner scanner = new Scanner(inputStream);

            while(scanner.hasNextLine())
            {
                final String line = scanner.nextLine();
                final String [] tokens = line.split(SEPARATOR);

                final VehicleInfo.Builder builder = VehicleInfo.builder();
                final VehicleInfo vehicle = builder.withId(tokens[VEHICLE_ID])
                        .withVehicleTypeName(tokens[VEHICLE_TYPE]).withVehicleTypeFormula(tokens[VEHICLE_FORMULA])
                        .withAge(Integer.parseInt(tokens[VEHICLE_AGE])).withNumberOfMiles(Long.parseLong(tokens[VEHICLE_MILES]))
                        .withIsDiesel(Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL])).build();

                 map.put(tokens[VEHICLE_ID], vehicle);
            }
        }
        catch(FileNotFoundException e)
        {
            throw new IllegalStateException("Can not create instance of class VehicleInfoPlanFileInfoDao");
        }
    }

        @Override
    public List<VehicleInfo> getAllVehicles()
     {
            List<VehicleInfo> aux = new ArrayList<>();
            /*final File inputFile = new File(this.filePath);
            try {

                FileInputStream inputStream = new FileInputStream(inputFile);
                final Scanner scanner = new Scanner(inputStream);

                while (scanner.hasNextLine()) {
                    final String line = scanner.nextLine();
                    final String[] tokens = line.split(SEPARATOR);

                    final VehicleInfo.Builder builder = VehicleInfo.builder();
                    final VehicleInfo vehicle = builder.withId(tokens[VEHICLE_ID])
                            .withVehicleTypeName(tokens[VEHICLE_TYPE]).withVehicleTypeFormula(tokens[VEHICLE_FORMULA])
                            .withAge(Integer.parseInt(tokens[VEHICLE_AGE])).withNumberOfMiles(Long.parseLong(tokens[VEHICLE_MILES]))
                            .withIsDiesel(Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL])).build();

                    //final VehicleInfo vehicle = new VehicleInfo(tokens[VEHICLE_ID], tokens[VEHICLE_TYPE], tokens[VEHICLE_FORMULA],
                    //        Integer.parseInt(tokens[VEHICLE_AGE]), Long.parseLong(tokens[VEHICLE_MILES]), Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL]));
                    //

                    aux.add(vehicle);
                }

                scanner.close();
            }
            catch(FileNotFoundException e)
            {
                  return Collections.emptyList();
            }*/

            Collection <VehicleInfo> collection = map.values();

            for(VehicleInfo vehicle : collection)
                aux.add(vehicle);

            return aux;
        }

        @Override
     public VehicleInfo getVehicleInfoById(String id)
        {
            return map.get(id);
        }
}


