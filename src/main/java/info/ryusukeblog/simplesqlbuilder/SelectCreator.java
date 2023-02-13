package info.ryusukeblog.simplesqlbuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectCreator {

    private String table;
    private List<String> columns = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    public String create() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        if (!columns.isEmpty()) {
            sb.append(String.join(", ", columns));
        } else {
            sb.append("*");
        }
        sb.append(" FROM ");
        sb.append(table);
        if (!values.isEmpty()) {
            sb.append(" WHERE ");
            sb.append(String.join(" AND ", values));
        }
        sb.append(";");
        return sb.toString();
    }

    public SelectCreator from(String table) {
        this.table = table;
        return this;
    }

    public SelectCreator columns(String... columns) {
        this.columns.addAll(Arrays.asList(columns));
        return this;
    }

    public SelectCreator columns(List<String> columns) {
        this.columns.addAll(columns);
        return this;
    }

    public SelectCreator where(String... values) {
        this.values.addAll(Arrays.asList(values));
        return this;
    }

    public SelectCreator where(List<String> values) {
        this.values.addAll(values);
        return this;
    }
}
