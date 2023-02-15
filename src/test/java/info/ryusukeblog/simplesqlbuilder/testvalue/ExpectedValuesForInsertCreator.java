package info.ryusukeblog.simplesqlbuilder.testvalue;

public class ExpectedValuesForInsertCreator {
    public static final String INSERT_WITH_ALL_STRINGS = "INSERT INTO articles (title, content) VALUES ('this is title', 'this is content');";
    public static final String INSERT_WITH_ONE_COLUMN_AND_ONE_STRING_VALUE = "INSERT INTO articles (title) VALUES ('this is title');";
    public static final String INSERT_WITH_ONE_COLUMN_AND_ONE_INTEGER_VALUE = "INSERT INTO articles (id) VALUES (1);";
    public static final String INSERT_WITH_ONE_COLUMN_AND_ONE_LONG_VALUE = "INSERT INTO articles (id) VALUES (10);";
    public static final String INSERT_WITHOUT_COLUMNS = "INSERT INTO articles VALUES ('this is title', 'this is content');";
    public static final String INSERT_DIFFERENT_DATA_TYPES = "INSERT INTO articles (id, id2, title, content, writing) VALUES (1, 100, 'this is title', 'this is content', true);";
    public static final String INSERT_WITH_INTEGER_VALUES = "INSERT INTO articles VALUES (1, 2);";
    public static final String INSERT_WITH_MINUS_VALUES = "INSERT INTO articles VALUES (-1, -2);";
    public static final String INSERT_WITH_LONG_VALUES = "INSERT INTO articles VALUES (10, 20);";
    public static final String INSERT_WITH_MINUS_LONG_VALUES = "INSERT INTO articles VALUES (-9, -20);";
    public static final String INSERT_WITH_FLOAT_VALUES = "INSERT INTO articles VALUES (10.1, 12.1);";
    public static final String INSERT_WITH_DOUBLE_VALUES = "INSERT INTO articles VALUES (100.1, 120.1);";

}
