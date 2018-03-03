package framework.tools;

import cucumber.api.DataTable;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class CucumberTool {

    private static Dictionary<String, DataCollection> dataCollection = new Hashtable<String, DataCollection>();

    public static Dictionary<String, DataCollection> convertDataTableToDict(DataTable table) {
        List<List<String>> data = table.raw();

        int rowNumber = 0;

        for (List<String> col : data) {
            for (int colIndex = 0; colIndex < col.size(); colIndex++) {
                dataCollection.put(data.get(0).get(colIndex), new DataCollection(data.get(0).get(colIndex), col.get(colIndex), rowNumber));
            }
            rowNumber++;
        }
        return dataCollection;

    }

    public static String getCellValue(String columnName) {
        return dataCollection.get(columnName).columnValue;
    }

    private static class DataCollection {
        private String columnName;
        private String columnValue;
        private int rowNumber;

        public DataCollection(String columnName, String columnValue, int rowNumber) {
            this.columnName = columnName;
            this.columnValue = columnValue;
            this.rowNumber = rowNumber;
        }
    }

}