package net.proteanit.sql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public final class DbUtils {
    private DbUtils() {
    }

    public static TableModel resultSetToTableModel(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        Vector<String> columns = new Vector<>();
        for (int column = 1; column <= columnCount; column++) {
            columns.add(metaData.getColumnLabel(column));
        }

        Vector<Vector<Object>> rows = new Vector<>();
        while (rs.next()) {
            Vector<Object> row = new Vector<>();
            for (int column = 1; column <= columnCount; column++) {
                row.add(rs.getObject(column));
            }
            rows.add(row);
        }

        return new DefaultTableModel(rows, columns);
    }
}
