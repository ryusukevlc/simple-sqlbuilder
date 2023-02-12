package info.ryusukeblog.simplesqlbuilder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class InsertCreatorTest {

    private String table;
    private List<String> columnList;
    private String[] columnArray;
    private List<Object> valueList;
    private Object[] valueArray;
    private List<String> whereList;
    private String[] whereArray;

    @BeforeEach
    void setUp() {
        table = "articles";
        columnList = new ArrayList<>();
        valueList = new ArrayList<>();
        whereList = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void InsertWithAllStrings() {
        columnList.add("title");
        columnList.add("content");
        valueList.add("this is title");
        valueList.add("this is content");
        System.out.println(new InsertCreator().table(table).columns(columnList).values(valueList).create());
    }

    @Test
    void InsertWithOneColumnAndOneStringValue() {
        columnList.add("title");
        valueList.add("this is title");
        System.out.println(new InsertCreator().table(table).columns(columnList).values(valueList).create());
        System.out.println(new InsertCreator().table(table).columns("title").values("this is title").create());
    }

    @Test
    void InsertWithOneColumnAndOneIntegerValue() {
        columnList.add("id");
        valueList.add(1);
        System.out.println(new InsertCreator().table(table).columns(columnList).values(valueList).create());
        System.out.println(new InsertCreator().table(table).columns("id").values(1).create());
    }

    @Test
    void InsertWithOneColumnAndOneLongValue() {
        columnList.add("id");
        valueList.add(10L);
        System.out.println(new InsertCreator().table(table).columns(columnList).values(valueList).create());
        System.out.println(new InsertCreator().table(table).columns("id").values(10L).create());
    }

    @Test
    void InsertWithoutColumns() {
        valueList.add("this is title");
        valueList.add("this is content");
        System.out.println(new InsertCreator().table(table).values(valueList).create());
    }

    @Test
    void InsertDifferentDataTypes() {
        columnList.add("id");
        columnList.add("id2");
        columnList.add("title");
        columnList.add("content");
        columnList.add("writing");
        valueList.add(1);
        valueList.add(100L);
        valueList.add("this is title");
        valueList.add("this is content");
        valueList.add(true);
        System.out.println(new InsertCreator().table(table).columns(columnList).values(valueList).create());
    }

    @Test
    void InsertWithIntegerValues() {
        System.out.println(new InsertCreator().table(table).values(1, 2).create());
    }

    @Test
    void InsertWithMinusValues() {
        System.out.println(new InsertCreator().table(table).values(-1, -2).create());
    }

    @Test
    void InsertWithLongValues() {
        System.out.println(new InsertCreator().table(table).values(10L, 20L).create());
    }

    @Test
    void InsertWithMinusLongValues() {
        System.out.println(new InsertCreator().table(table).values(-10L, -20L).create());
    }
}