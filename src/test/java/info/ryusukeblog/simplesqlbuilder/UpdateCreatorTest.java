package info.ryusukeblog.simplesqlbuilder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static info.ryusukeblog.simplesqlbuilder.testvalue.ExpectedValuesForUpdateCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UpdateCreatorTest {

    private String table;
    private List<String> columnValueList;
    private List<String> whereList;


    @BeforeEach
    void setUp() {
        table = "articles";
        whereList = new ArrayList<>();
        columnValueList = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void updateOneColumn() {
        columnValueList.add("title = 'this is updated title'");
        String sql = SqlBuilder.update(table).set(columnValueList).create();
        System.out.println(sql);
        assertEquals(sql, UPDATE_ONE_COLUMN);
    }

    @Test
    void updateOneWhereClause() {
        columnValueList.add("title = 'this is updated title'");
        whereList.add("id = 1");
        String sql = SqlBuilder.update(table).set(columnValueList).where(whereList).create();
        System.out.println(sql);
        assertEquals(sql, UPDATE_ONE_WHERE_CLAUSE);
    }

    @Test
    void updateSomeColumnsWithSomeWhereClause() {
        columnValueList.add("title = 'this is updated title'");
        columnValueList.add("content = 'this is updated content'");
        whereList.add("id = 1");
        whereList.add("isDraft = true");
        String sql = SqlBuilder.update(table).set(columnValueList).where(whereList).create();
        System.out.println(sql);
        assertEquals(sql, UPDATE_SOME_COLUMNS_WITH_SOME_WHERE_CLAUSE);
    }

    @Test
    void updateWithVariableLengthArgument() {
        String sql = SqlBuilder.update("articles").set("title = 'this is updated title'", "content = 'this is updated content'").where("id = 1", "isDraft = true").create();
        System.out.println(sql);
        assertEquals(sql, UPDATE_WITH_VARIABLE_LENGTH_ARGUMENT);
    }
}
