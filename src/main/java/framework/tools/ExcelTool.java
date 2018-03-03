package framework.tools;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelTool {

    static Sheet wrksheet;
    static Workbook wrkbook = null;
    static Hashtable dict = new Hashtable();
    private int rowsCount;

    public ExcelTool(String ExcelSheetPath) throws BiffException, IOException {
        wrkbook = Workbook.getWorkbook(new File(ExcelSheetPath));
        wrksheet = wrkbook.getSheet("Arkusz1");

        columnDictionary();
        this.rowsCount = wrksheet.getRows();
    }

    public int rowCount() {
        return rowsCount;
    }

    private static String readCell(int column, int row) {
        return wrksheet.getCell(column, row).getContents();
    }

    public static String readCell(String columnName, int rowNumber) {
        return readCell(getCell(columnName), rowNumber);
    }

    private static void columnDictionary() {
        for (int col = 0; col < wrksheet.getColumns(); col++) {
            dict.put(readCell(col, 0), col);
        }
    }

    private static int getCell(String colName) {
        try {
            int value;
            value = ((Integer) dict.get(colName)).intValue();
            return value;
        } catch (NullPointerException e) {
            return (0);
        }
    }
}
