package org.bootcamp.dao;

import org.apache.poi.ss.usermodel.*;
import org.bootcamp.model.VehicleInfo;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class VehicleExcelFileDao implements VehicleInfoDao {

    private final Map<String, VehicleInfo> vehicleInfoMap = new HashMap<>();
    private final VehicleInfo.Builder vehicleInfoBuilder = VehicleInfo.builder();
    private static final int EXCEL_INFORMATION_SHEET = 0;
    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;
    private static final int VEHICLE_ID = 0;
    private static final int VEHICLE_FORMULA = 2;

    public VehicleExcelFileDao(String filePath) {
        try {
            final InputStream inputStream = new FileInputStream(filePath);
            final Workbook workbook = new XSSFWorkbook(inputStream);
            final Sheet datatypeSheet = workbook.getSheetAt(EXCEL_INFORMATION_SHEET);
            final Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {

                final Row currentRow = iterator.next();
                final Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    final Cell currentCell = cellIterator.next();
                    final Double tmp;
                    switch (currentCell.getAddress().getColumn()) {
                        case VEHICLE_ID:
                            vehicleInfoBuilder.withId(currentCell.getStringCellValue());
                            break;
                        case VEHICLE_TYPE:
                            vehicleInfoBuilder.withVehicleTypeName(currentCell.getStringCellValue());
                            break;
                        case VEHICLE_FORMULA:
                            vehicleInfoBuilder.withVehicleTypeFormula(currentCell.getStringCellValue());
                            break;
                        case VEHICLE_AGE:
                            tmp = currentCell.getNumericCellValue();
                            vehicleInfoBuilder.withAge(tmp.intValue());
                            break;
                        case VEHICLE_MILES:
                            tmp = currentCell.getNumericCellValue();
                            vehicleInfoBuilder.withNumberOfMiles(tmp.longValue());
                            break;
                        case VEHICLE_IS_DIESEL:
                            vehicleInfoBuilder.withIsDiesel(currentCell.getBooleanCellValue());
                            break;
                    }

                    if (currentCell.getAddress().getColumn() == VEHICLE_IS_DIESEL) {
                        final VehicleInfo vehicleInfo = vehicleInfoBuilder.build();
                        vehicleInfoMap.put(vehicleInfo.getId(), vehicleInfo);
                    }

                }

            }

        } catch (Exception e) {
            final String errorMessage = "Can not create instance of class " + VehicleExcelFileDao.class.getSimpleName();
            throw new IllegalStateException(errorMessage);
        }
    }

    @Override
    public List<VehicleInfo> getAllVehicles() {
        return new ArrayList<>(vehicleInfoMap.values());
    }

    @Override
    public VehicleInfo getVehicleById(String id) {
        return vehicleInfoMap.get(id);
    }
}
