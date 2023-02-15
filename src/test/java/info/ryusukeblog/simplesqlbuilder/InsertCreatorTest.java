package info.ryusukeblog.simplesqlbuilder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static info.ryusukeblog.simplesqlbuilder.testvalue.ExpectedValuesForInsertCreator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void insertWithAllStrings() {
        columnList.add("title");
        columnList.add("content");
        valueList.add("this is title");
        valueList.add("this is content");
        String sql = SqlBuilder.insert().into(table).columns(columnList).values(valueList).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITH_ALL_STRINGS);
    }

    @Test
    void insertWithOneColumnAndOneStringValue() {
        columnList.add("title");
        valueList.add("this is title");
        String sql = SqlBuilder.insert().into(table).columns(columnList).values(valueList).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITH_ONE_COLUMN_AND_ONE_STRING_VALUE);
    }

    @Test
    void insertWithOneColumnAndOneStringValue2() {
        String sql = SqlBuilder.insert().into(table).columns("title").values("this is title").create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITH_ONE_COLUMN_AND_ONE_STRING_VALUE);
    }

    @Test
    void insertWithOneColumnAndOneIntegerValue() {
        columnList.add("id");
        valueList.add(1);
        String sql = SqlBuilder.insert().into(table).columns(columnList).values(valueList).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITH_ONE_COLUMN_AND_ONE_INTEGER_VALUE);
    }

    @Test
    void insertWithOneColumnAndOneIntegerValue2() {
        String sql = SqlBuilder.insert().into(table).columns("id").values(1).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITH_ONE_COLUMN_AND_ONE_INTEGER_VALUE);
    }


    @Test
    void insertWithOneColumnAndOneLongValue() {
        columnList.add("id");
        valueList.add(10L);
        String sql = SqlBuilder.insert().into(table).columns(columnList).values(valueList).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITH_ONE_COLUMN_AND_ONE_LONG_VALUE);
    }

    @Test
    void insertWithOneColumnAndOneLongValue2() {
        String sql = SqlBuilder.insert().into(table).columns("id").values(10L).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITH_ONE_COLUMN_AND_ONE_LONG_VALUE);
    }

    @Test
    void insertWithoutColumns() {
        valueList.add("this is title");
        valueList.add("this is content");
        String sql = SqlBuilder.insert().into(table).values(valueList).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITHOUT_COLUMNS);
    }

    @Test
    void insertDifferentDataTypes() {
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
        String sql = SqlBuilder.insert().into(table).columns(columnList).values(valueList).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_DIFFERENT_DATA_TYPES);
    }

    @Test
    void insertWithIntegerValues() {
        String sql = SqlBuilder.insert().into(table).values(1, 2).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITH_INTEGER_VALUES);
    }

    @Test
    void insertWithMinusValues() {
        String sql = SqlBuilder.insert().into(table).values(-1, -2).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITH_MINUS_VALUES);
    }

    @Test
    void insertWithLongValues() {
        String sql = SqlBuilder.insert().into(table).values(10L, 20L).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITH_LONG_VALUES);
    }

    @Test
    void insertWithMinusLongValues() {
        String sql = SqlBuilder.insert().into(table).values(-9L, -20L).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITH_MINUS_LONG_VALUES);
    }


    @Test
    void insertWithFloatValues() {
        String sql = SqlBuilder.insert().into(table).values(10.1F, 12.1F).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITH_FLOAT_VALUES);
    }

    @Test
    void insertWithDoubleValues() {
        String sql = SqlBuilder.insert().into(table).values(100.1, 120.1).create();
        System.out.println(sql);
        assertEquals(sql, INSERT_WITH_DOUBLE_VALUES);
    }

    @Test
    void insertWithJavaUtilDate() {
        String sql = SqlBuilder.insert().into(table).values(new Date(), new Date()).create();
        System.out.println(sql);
    }

    @Test
    void insertWithJavaSqlDate() {
        String sql = SqlBuilder.insert().into(table).values(new java.sql.Date(Calendar.getInstance().getTimeInMillis()), new java.sql.Date(Calendar.getInstance().getTimeInMillis())).create();
        System.out.println(sql);
    }

    @Test
    void insertWithJavaSqlTimestamp() {
        String sql = SqlBuilder.insert().into(table).values(new Timestamp(Calendar.getInstance().getTimeInMillis()), new Timestamp(Calendar.getInstance().getTimeInMillis())).create();
        System.out.println(sql);
    }
}