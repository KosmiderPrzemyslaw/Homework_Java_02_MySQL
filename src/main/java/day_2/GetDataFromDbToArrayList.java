package day_2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetDataFromDbToArrayList {

    public static List<String> getDataFromDbToArrayList(Connection connection, String query) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int countColumn = resultSetMetaData.getColumnCount();
        List<String> stringList = new ArrayList<>(countColumn);

        while (resultSet.next()) {
            int i = 1;
            while (i <= countColumn) {
                stringList.add(resultSet.getMetaData().getColumnName(i) + ": " + resultSet.getString(i++) + " ");
            }

            stringList.add("\n");
        }
        return stringList;
    }
}
