package html.dom;

public abstract class TableContentProvider<T> {
    public abstract String[] getContentForRow(int row, T value);
}
