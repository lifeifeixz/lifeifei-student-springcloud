package com.lifeifei.springcloud.starter.util.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

    /**
     * 导入数据时，大多以List的结构呈现给使用者
     *
     * @param workbook
     * @param t
     * @param <T>
     * @return
     */
    public static <T> List<T> formatToBean(Workbook workbook, Class<T> t) {
        Sheet sheet = workbook.getSheetAt(0);
        int rowNum = sheet.getLastRowNum();
        //获取T中需要导如的属性
        List<Entry<String, Field>> metaData = getMetaData(t);

        for (int i = 1; i <= rowNum; i++) {
            Row row = sheet.getRow(i);
            T bean = getInstance(t);
            for (int j = 0; j < metaData.size(); j++) {
                Cell cell = row.getCell(j);
                Object value = getCellValue(cell);

            }
            System.out.println();
        }
        return null;
    }

    public static <T>T getInstance(Class<T> t){
        try {
            return t.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Object getCellValue(Cell cell) {
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {//string
            return cell.getStringCellValue();
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return cell.getNumericCellValue();
        }else{
            return cell.getDateCellValue();
        }
    }

    private static List<Entry<String, Field>> getMetaData(Class t) {
        Field[] fields = t.getDeclaredFields();
        List<Entry<String, Field>> entrys = new ArrayList<>();
        for (Field f : fields) {
            f.setAccessible(true);
            Title title = f.getAnnotation(Title.class);
            if (title != null) {
                entrys.add(new Entry(title.name(), f));
            }
        }
        return entrys;
    }

    public static <T> List<T> invokeImort(InputStream inputStream, Class<T> t) {

        try {
            List<T> ts = formatToBean(new XSSFWorkbook(inputStream), t);
            return ts;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
