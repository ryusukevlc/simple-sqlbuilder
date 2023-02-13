package info.ryusukeblog.simplesqlbuilder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SelectCreatorTest {

    private String table;
    private List<String> columnList;
    private List<String> whereList;

    @BeforeEach
    void setUp() {
        table = "articles";
        columnList = new ArrayList<>();
        whereList = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void selectFullAccess() {
        System.out.println(SqlBuilder.select().from(table).create());
    }

    @Test
    void selectSomeColumns() {
        columnList.add("title");
        columnList.add("content");
        System.out.println(SqlBuilder.select().columns(columnList).from(table).create());
    }

    @Test
    void selectAllColumnsWithWhere() {
        whereList.add("id = 1");
        whereList.add("title = 'this is title'");
        System.out.println(SqlBuilder.select().from(table).where(whereList).create());
    }


    @Test
    void selectSomeColumnsWithWhere() {
        columnList.add("title");
        columnList.add("content");
        whereList.add("id = 1");
        whereList.add("title = 'this is title'");
        System.out.println(SqlBuilder.select().columns(columnList).from(table).where(whereList).create());
    }

    @Test
    void selectOneColumnsWithWhere() {
        columnList.add("title");
        whereList.add("id = 1");
        System.out.println(SqlBuilder.select().columns(columnList).from(table).where(whereList).create());
    }

    @Test
    void selectWithVariableLengthArgument() {
        System.out.println(SqlBuilder.select().columns("title", "content").from(table).where("id = 1", "title = 'this is title'").create());
    }

    @Test
    void selectWithOneArgument() {
        System.out.println(SqlBuilder.select().columns("title").from(table).where("id = 1").create());
    }
}