package info.ryusukeblog.simplesqlbuilder.testvalue;

public class ExpectedValuesForSelectCreator {

    public static final String SELECT_FULL_ACCESS = "SELECT * FROM articles;";
    public static final String SELECT_SOME_COLUMNS = "SELECT title, content FROM articles;";
    public static final String SELECT_ALL_COLUMNS_WITH_WHERE = "SELECT * FROM articles WHERE id = 1 AND title = 'this is title';";
    public static final String SELECT_SOME_COLUMNS_WITH_WHERE = "SELECT title, content FROM articles WHERE id = 1 AND title = 'this is title';";
    public static final String SELECT_ONE_COLUMNS_WITH_WHERE = "SELECT title FROM articles WHERE id = 1;";
    public static final String SELECT_WITH_VARIABLE_LENGTH_ARGUMENT = "SELECT title, content FROM articles WHERE id = 1 AND title = 'this is title';";
    public static final String SELECT_WITH_ONE_ARGUMENT = "SELECT title FROM articles WHERE id = 1;";

}
