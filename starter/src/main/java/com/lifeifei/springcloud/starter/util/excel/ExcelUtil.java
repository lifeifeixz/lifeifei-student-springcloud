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
        for (int j = 0; j < metaData.size(); j++) {
            for (int i = 0; i < rowNum; i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(j);
                System.out.print(cell.getStringCellValue() + "\t");
            }
            System.out.println();
        }
        return null;
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
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
