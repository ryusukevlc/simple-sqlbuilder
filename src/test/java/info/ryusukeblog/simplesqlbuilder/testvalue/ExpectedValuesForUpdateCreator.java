package info.ryusukeblog.simplesqlbuilder.testvalue;

public class ExpectedValuesForUpdateCreator {
    public static final String UPDATE_ONE_COLUMN = "UPDATE articles SET title = 'this is updated title';";
    public static final String UPDATE_ONE_WHERE_CLAUSE = "UPDATE articles SET title = 'this is updated title' WHERE id = 1;";
    public static final String UPDATE_SOME_COLUMNS_WITH_SOME_WHERE_CLAUSE = "UPDATE articles SET title = 'this is updated title', content = 'this is updated content' WHERE id = 1 AND isDraft = true;";
    public static final String UPDATE_WITH_VARIABLE_LENGTH_ARGUMENT = "UPDATE articles SET title = 'this is updated title', content = 'this is updated content' WHERE id = 1 AND isDraft = true;";
}
