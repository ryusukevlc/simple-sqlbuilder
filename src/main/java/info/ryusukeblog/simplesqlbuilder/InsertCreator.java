package info.ryusukeblog.simplesqlbuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertCreator {

    private String table;
    private List<String> columns = new ArrayList<>();
    private List<String> values = new ArrayList<>();

    public String create() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append(table);
        sb.append("(");
        sb.append(String.join(",", columns));
        sb.append(") VALUES ('");
        sb.append(String.join("','", values));
        sb.append("');");
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

    public InsertCreator values(List<String> values) {
        this.values.addAll(values);
        return this;
    }
}
