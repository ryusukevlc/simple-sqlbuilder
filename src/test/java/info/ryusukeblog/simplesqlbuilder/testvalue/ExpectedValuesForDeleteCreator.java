package info.ryusukeblog.simplesqlbuilder.testvalue;

public class ExpectedValuesForDeleteCreator {

    public static final String DELETE_FROM_ARTICLES = "DELETE FROM articles;";
    public static final String DELETE_WITH_SOME_WHERE_CLAUSE = "DELETE FROM articles WHERE id = 1 AND title = 'this is title';";
    public static final String DELETE_WITH_WHERE_CLAUSE = "DELETE FROM articles WHERE id = 1;";
}
