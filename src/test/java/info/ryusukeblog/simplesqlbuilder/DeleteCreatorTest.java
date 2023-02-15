package info.ryusukeblog.simplesqlbuilder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static info.ryusukeblog.simplesqlbuilder.testvalue.ExpectedValuesForDeleteCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DeleteCreatorTest {

    private String table;
    private List<String> whereList;


    @BeforeEach
    void setUp() {
        table = "articles";
        whereList = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void deleteAllRows() {
        String sql = SqlBuilder.delete().from(table).create();
        System.out.println(sql);
        assertEquals(sql, DELETE_FROM_ARTICLES);
    }

    @Test
    void deleteWithSomeWhereClause() {
        whereList.add("id = 1");
        whereList.add("title = 'this is title'");
        String sql = SqlBuilder.delete().from(table).where(whereList).create();
        System.out.println(sql);
        assertEquals(sql, DELETE_WITH_SOME_WHERE_CLAUSE);
    }

    @Test
    void deleteWithWhereClause() {
        whereList.add("id = 1");
        String sql = SqlBuilder.delete().from(table).where(whereList).create();
        System.out.println(sql);
        assertEquals(sql, DELETE_WITH_WHERE_CLAUSE);
    }
}