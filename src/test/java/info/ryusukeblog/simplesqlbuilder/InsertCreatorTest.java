package info.ryusukeblog.simplesqlbuilder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

class InsertCreatorTest {

    private String table;
    private List<String> columnList;
    private List<Object> valueList;

    @BeforeEach
    void setUp() {
        table = "articles";
        columnList = new ArrayList<>();
        valueList = new ArrayList<>();
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
        System.out.println(SqlBuilder.insert().table(table).columns(columnList).values(valueList).create());
    }

    @Test
    void InsertWithOneColumnAndOneStringValue() {
        columnList.add("title");
        valueList.add("this is title");
        System.out.println(SqlBuilder.insert().table(table).columns(columnList).values(valueList).create());
        System.out.println(SqlBuilder.insert().table(table).columns("title").values("this is title").create());
    }

    @Test
    void InsertWithOneColumnAndOneIntegerValue() {
        columnList.add("id");
        valueList.add(1);
        System.out.println(SqlBuilder.insert().table(table).columns(columnList).values(valueList).create());
        System.out.println(SqlBuilder.insert().table(table).columns("id").values(1).create());
    }

    @Test
    void InsertWithOneColumnAndOneLongValue() {
        columnList.add("id");
        valueList.add(10L);
        System.out.println(SqlBuilder.insert().table(table).columns(columnList).values(valueList).create());
        System.out.println(SqlBuilder.insert().table(table).columns("id").values(10L).create());
    }

    @Test
    void InsertWithoutColumns() {
        valueList.add("this is title");
        valueList.add("this is content");
        System.out.println(SqlBuilder.insert().table(table).values(valueList).create());
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
        System.out.println(SqlBuilder.insert().table(table).columns(columnList).values(valueList).create());
    }

    @Test
    void InsertWithIntegerValues() {
        System.out.println(SqlBuilder.insert().table(table).values(1, 2).create());
    }

    @Test
    void InsertWithMinusValues() {
        System.out.println(SqlBuilder.insert().table(table).values(-1, -2).create());
    }

    @Test
    void InsertWithLongValues() {
        System.out.println(SqlBuilder.insert().table(table).values(10L, 20L).create());
    }

    @Test
    void InsertWithMinusLongValues() {
        System.out.println(SqlBuilder.insert().table(table).values(-10L, -20L).create());
    }


    @Test
    void InsertWithFloatValues() {
        System.out.println(SqlBuilder.insert().table(table).values(10.1F, 12.1F).create());
    }

    @Test
    void InsertWithDoubleValues() {
        System.out.println(SqlBuilder.insert().table(table).values(100.1, 120.1).create());
    }

    @Test
    void InsertWithJavaUtilDate() {
        System.out.println(SqlBuilder.insert().table(table).values(new Date(), new Date()).create());
    }

    @Test
    void InsertWithJavaSqlDate() {
        System.out.println(SqlBuilder.insert().table(table).values(new java.sql.Date(Calendar.getInstance().getTimeInMillis()), new java.sql.Date(Calendar.getInstance().getTimeInMillis())).create());
    }

    @Test
    void InsertWithJavaSqlTimestamp() {
        System.out.println(SqlBuilder.insert().table(table).values(new Timestamp(Calendar.getInstance().getTimeInMillis()), new Timestamp(Calendar.getInstance().getTimeInMillis())).create());
    }
}