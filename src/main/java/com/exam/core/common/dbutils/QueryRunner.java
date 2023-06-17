package com.exam.core.common.dbutils;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.StatementConfiguration;

import javax.sql.DataSource;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class QueryRunner extends org.apache.commons.dbutils.QueryRunner {

    private final PrintStream log = System.out;

    @Override
    public void fillStatement(PreparedStatement stmt, Object... params) throws SQLException {
        super.fillStatement(stmt, params);

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append(stmt.toString()).append(" \nparams: [");
        for (Object param : params) {
            sqlBuilder.append(param).append(", ");
        }
        sqlBuilder.append("]");
        this.log.println("Prepared statement: " + sqlBuilder.toString());

    }

    public QueryRunner() {
        super();
    }

    public QueryRunner(boolean pmdKnownBroken) {
        super(pmdKnownBroken);
    }

    public QueryRunner(DataSource ds) {
        super(ds);
    }

    public QueryRunner(StatementConfiguration stmtConfig) {
        super(stmtConfig);
    }

    public QueryRunner(DataSource ds, boolean pmdKnownBroken) {
        super(ds, pmdKnownBroken);
    }

    public QueryRunner(DataSource ds, StatementConfiguration stmtConfig) {
        super(ds, stmtConfig);
    }

    public QueryRunner(DataSource ds, boolean pmdKnownBroken, StatementConfiguration stmtConfig) {
        super(ds, pmdKnownBroken, stmtConfig);
    }
}
