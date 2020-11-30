package day_1;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PrintUtil {
    public static void print(ResultSet resultSet, String... columnNames) throws SQLException {
        while (resultSet.next()) {
            StringBuilder stringBuilder = new StringBuilder("ENTRY: [");
            for (String columnName : columnNames) {
                stringBuilder.append(columnName).append(": ").append(resultSet.getString(columnName)).append(", ");
            }

            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
            stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
            stringBuilder.append("]");

            System.out.println(stringBuilder);
        }
        System.out.println();
    }
}
