package info.ryusukeblog.simplesqlbuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteCreator {

    private String table;
    private List<String> columns = new ArrayList<>();
    private List<String> values = new ArrayList<>();


    public String create() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ");
        sb.append(table);
        if (!values.isEmpty()) {
            sb.append(" WHERE ");
            sb.append(String.join(" AND ", values));
        }
        sb.append(";");
        return sb.toString();
    }

    public DeleteCreator from(String table) {
        this.table = table;
        return this;
    }

    public DeleteCreator table(String table) {
        this.table = table;
        return this;
    }

    public DeleteCreator columns(String... columns) {
        this.columns.addAll(Arrays.asList(columns));
        return this;
    }

    public DeleteCreator columns(List<String> columns) {
        this.columns.addAll(columns);
        return this;
    }

    public DeleteCreator where(String... values) {
        this.values.addAll(Arrays.asList(values));
        return this;
    }

    public DeleteCreator where(List<String> values) {
        this.values.addAll(values);
        return this;
    }
}
