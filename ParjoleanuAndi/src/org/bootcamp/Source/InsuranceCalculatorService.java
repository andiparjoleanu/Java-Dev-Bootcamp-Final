package Source;
import org.bootcamp.calculate.InsurancePolicyCalculate;
import org.bootcamp.dao.VehicleInfoDao;
import org.bootcamp.dao.VehicleInfoPlanFileInfoDao;
import org.bootcamp.formula.EnumFormula;
import org.bootcamp.model.VehicleInfo;
import org.bootcamp.vehicle.Vehicle;

import java.util.*;

import static Source.ConversionUtils.getVehicle;

public class InsuranceCalculatorService {
   private String filePath;
   VehicleInfoDao vehicleInfoDao;

   public InsuranceCalculatorService(String filePath) throws IllegalStateException{
       this.filePath = filePath;
       vehicleInfoDao = new VehicleInfoPlanFileInfoDao(this.filePath);
   }

   public List<InsuranceCalculationResults> calculateAll() {
       final InsurancePolicyCalculate calculator = InsurancePolicyCalculate.INSTANCE;
       final List<VehicleInfo> vehicleInfos = vehicleInfoDao.getAllVehicles();
       final List<InsuranceCalculationResults> resultList = new LinkedList<>();
       if (vehicleInfos.isEmpty()) {
           return Collections.emptyList();
       } else {
           for (VehicleInfo info : vehicleInfos) {
               final Vehicle vehicle = getVehicle(info.getVehicleTypeName(), info.getAge(),
                       info.getNumberOfMiles(), info.isDiesel());

               EnumFormula formula = EnumFormula.valueOf(info.getVehicleTypeFormula());
               final int totalCost = calculator.calculate(vehicle, formula);
               final InsuranceCalculationResults result = new InsuranceCalculationResults(info.getId(), totalCost, info.getVehicleTypeName());
               resultList.add(result);

           }
           return resultList;
       }
   }

   public InsuranceCalculationResults calculateById(String id)
   {
        final InsurancePolicyCalculate calculator = InsurancePolicyCalculate.INSTANCE;
        VehicleInfo info = vehicleInfoDao.getVehicleInfoById(id);
        final Vehicle vehicle = getVehicle(info.getVehicleTypeName(), info.getAge(), info.getNumberOfMiles(), info.isDiesel());
        EnumFormula formula = EnumFormula.valueOf(info.getVehicleTypeFormula());
        final int cost = calculator.calculate(vehicle, formula);
        return new InsuranceCalculationResults(info.getId(), cost, info.getVehicleTypeName());

   }

   public List<InsuranceCalculationResults> getCostsHigherThan(int cost)
   {
       List<InsuranceCalculationResults> costs = new LinkedList<>();
       for(InsuranceCalculationResults item : calculateAll())
           if(item.getCost() > cost)
               costs.add(item);
       return costs;
   }
}
