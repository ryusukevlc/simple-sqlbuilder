package info.ryusukeblog.simplesqlbuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpdateCreator {


    private String table;
    private List<String> columns = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    public UpdateCreator() {
    }

    public UpdateCreator(String table) {
        this.table = table;
    }

    public String create() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ");
        sb.append(table);
        sb.append(" SET ");
        sb.append(String.join(", ", columns));
        if (!values.isEmpty()) {
            sb.append(" WHERE ");
            sb.append(String.join(" AND ", values));
        }
        sb.append(";");
        return sb.toString();
    }

    public UpdateCreator table(String table) {
        this.table = table;
        return this;
    }

    public UpdateCreator set(String... columns) {
        this.columns.addAll(Arrays.asList(columns));
        return this;
    }

    public UpdateCreator set(List<String> columns) {
        this.columns.addAll(columns);
        return this;
    }

    public UpdateCreator columns(String... columns) {
        this.columns.addAll(Arrays.asList(columns));
        return this;
    }

    public UpdateCreator columns(List<String> columns) {
        this.columns.addAll(columns);
        return this;
    }

    public UpdateCreator where(String... values) {
        this.values.addAll(Arrays.asList(values));
        return this;
    }

    public UpdateCreator where(List<String> values) {
        this.values.addAll(values);
        return this;
    }

}
