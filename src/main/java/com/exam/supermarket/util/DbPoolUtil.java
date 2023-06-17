package com.exam.supermarket.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbPoolUtil {

    private static final DataSource ds;

    static {
        ds = new ComboPooledDataSource();
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnect() throws SQLException {
        return ds.getConnection();
    }

    public static QueryRunner getRunner() {
        return new QueryRunner(getDataSource());
    }
}
