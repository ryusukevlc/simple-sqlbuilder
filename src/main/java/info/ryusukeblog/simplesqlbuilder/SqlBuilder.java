package info.ryusukeblog.simplesqlbuilder;

public class SqlBuilder {

    public static InsertCreator insert() {
        return new InsertCreator();
    }

    public static SelectCreator select() {
        return new SelectCreator();
    }

    public static UpdateCreator update() {
        return new UpdateCreator();
    }

    public static UpdateCreator update(String table) {
        return new UpdateCreator(table);
    }

    public static DeleteCreator delete() {
        return new DeleteCreator();
    }
}
