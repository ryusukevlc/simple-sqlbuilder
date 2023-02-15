package info.ryusukeblog.simplesqlbuilder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static info.ryusukeblog.simplesqlbuilder.testvalue.ExpectedValuesForSelectCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        String sql = SqlBuilder.select().from(table).create();
        System.out.println(sql);
        assertEquals(sql, SELECT_FULL_ACCESS);
    }

    @Test
    void selectSomeColumns() {
        columnList.add("title");
        columnList.add("content");
        String sql = SqlBuilder.select().columns(columnList).from(table).create();
        System.out.println(sql);
        assertEquals(sql, SELECT_SOME_COLUMNS);
    }

    @Test
    void selectAllColumnsWithWhere() {
        whereList.add("id = 1");
        whereList.add("title = 'this is title'");
        String sql = SqlBuilder.select().from(table).where(whereList).create();
        System.out.println(sql);
        assertEquals(sql, SELECT_ALL_COLUMNS_WITH_WHERE);
    }


    @Test
    void selectSomeColumnsWithWhere() {
        columnList.add("title");
        columnList.add("content");
        whereList.add("id = 1");
        whereList.add("title = 'this is title'");
        String sql = SqlBuilder.select().columns(columnList).from(table).where(whereList).create();
        System.out.println(sql);
        assertEquals(sql, SELECT_SOME_COLUMNS_WITH_WHERE);
    }

    @Test
    void selectOneColumnsWithWhere() {
        columnList.add("title");
        whereList.add("id = 1");
        String sql = SqlBuilder.select().columns(columnList).from(table).where(whereList).create();
        System.out.println(sql);
        assertEquals(sql, SELECT_ONE_COLUMNS_WITH_WHERE);
    }

    @Test
    void selectWithVariableLengthArgument() {
        String sql = SqlBuilder.select().columns("title", "content").from(table).where("id = 1", "title = 'this is title'").create();
        System.out.println(sql);
        assertEquals(sql, SELECT_WITH_VARIABLE_LENGTH_ARGUMENT);
    }

    @Test
    void selectWithOneArgument() {
        String sql = SqlBuilder.select().columns("title").from(table).where("id = 1").create();
        System.out.println(sql);
        assertEquals(sql, SELECT_WITH_ONE_ARGUMENT);
    }
}