package com.shivam.learn.reflection.graph;

import java.util.List;

import static com.shivam.learn.reflection.graph.annotations.Annotations.*;

/**
 * @author sksingh created on 14/01/24
 */


public class SqlQueryBuilder {

    @Input("ids")
    private List<String> ids;
    @Input("limit")
    private Integer limit;
    @Input("table")
    private String tableName;
    @Input("columns")
    private List<String> columnNames;

    public SqlQueryBuilder(List<String> ids, Integer limit, String tableName, List<String> columnNames) {
        this.ids = ids;
        this.limit = limit;
        this.tableName = tableName;
        this.columnNames = columnNames;
    }

    @Operation("SelectBuilder")
    public String selectStatementBuilder(@Input("table") String tableName, @Input("columns") List<String> columnNames) {
        String columnString = columnNames.isEmpty() ? "*" : String.join(", ", columnNames);

        return String.format("SELECT %s FROM %s", columnString, tableName);
    }

    @Operation("WhereClauseBuilder")
    public String addWhereClause(@DependsOn("SelectBuilder") String query, @Input("ids") List<String> ids) {
        if (ids.isEmpty()) {
            return query;
        }

        return String.format("%s WHERE id IN (%s)", query, String.join(", ", ids));
    }


    @FinalResult
    public String addLimit(@DependsOn("WhereClauseBuilder") String query, @Input("limit") Integer limit) {
        if (limit == null || limit == 0) {
            return query;
        }

        if (limit < 0) {
            throw new RuntimeException("limit can't be negative");
        }

        return String.format("%s LIMIT %d", query, limit);
    }
}
