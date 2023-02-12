package info.ryusukeblog.simplesqlbuilder;

import java.util.*;

public class InsertCreator {

    private String table;
    private List<String> columns = new ArrayList<>();
    private List<Object> values = new ArrayList<>();

    public String create() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(table);
        if (!columns.isEmpty()) {
            sb.append(" (");
            sb.append(String.join(", ", columns));
            sb.append(")");
        }
        sb.append(" VALUES (");
        sb.append(valueBuilder(values));
        sb.append(");");
        return sb.toString();
    }

    public InsertCreator table(String table) {
        this.table = table;
        return this;
    }

    public InsertCreator columns(String... columns) {
        this.columns.addAll(Arrays.asList(columns));
        return this;
    }

    public InsertCreator columns(List<String> columns) {
        this.columns.addAll(columns);
        return this;
    }

    public InsertCreator values(String... values) {
        this.values.addAll(Arrays.asList(values));
        return this;
    }

    public InsertCreator values(Integer... values) {
        this.values.addAll(Arrays.asList(values));
        return this;
    }

    public InsertCreator values(Long... values) {
        this.values.addAll(Arrays.asList(values));
        return this;
    }

    public InsertCreator values(Float... values) {
        this.values.addAll(Arrays.asList(values));
        return this;
    }

    public InsertCreator values(Double... values) {
        this.values.addAll(Arrays.asList(values));
        return this;
    }

    public InsertCreator values(Date... values) {
        this.values.addAll(Arrays.asList(values));
        return this;
    }

    public InsertCreator values(List<?> values) {
        this.values.addAll(values);
        return this;
    }

    private String valueBuilder(List<?> values) {

        StringBuilder sb = new StringBuilder();
        for (Iterator<?> iterator = values.iterator();
             iterator.hasNext(); ) {
            Object value = iterator.next();
            if (value instanceof java.sql.Date || value instanceof java.sql.Timestamp) {
                sb.append("'").append(value).append("'");
            } else if (value instanceof java.util.Date) {
                sb.append("'").append(new java.sql.Date(((Date) value).getTime())).append("'");
            } else if (value instanceof String) {
                sb.append("'").append(value).append("'");
            } else if (value instanceof Integer || value instanceof Long || value instanceof Boolean || value instanceof Float || value instanceof Double) {
                sb.append(value);
            }
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}