package html.dom;

import java.util.ArrayList;
import java.util.List;

public class Table<T> extends AbstractElement {

    class TableHeader {
        String name;
        String width;

        public TableHeader(String name, String width) {
            this.name = name;
            this.width = width;
        }
    }

    private TableContentProvider<T> contentProvider;
    private List<TableHeader> headers = new ArrayList<>();
    private List<T> values = new ArrayList<>();

    public Table(List<T> values) {
        super(DOM.TABLE);
        this.values = values;
    }

    /**
     * @param name  of the column header
     * @param width in pixel
     */
    public void addHeader(String name, int width) {
        this.headers.add(new TableHeader(name, String.valueOf(width) + "px"));
    }

    public void addHeader(String name) {
        this.headers.add(new TableHeader(name, "auto"));
    }

    public void setContentProvider(TableContentProvider<T> contentProvider) {
        this.contentProvider = contentProvider;
    }

    public String render() {
        Element tr = new Element(DOM.TR);

        Element thead = new Element(DOM.THEAD);
        thead.addChild(tr);

        for (TableHeader header : this.headers) {
            Element th = new Element(DOM.TH);
            th.addStyle("width", header.width);
            th.addStyle("border", "1px solid black");
            th.appendString(header.name);
            tr.addChild(th);
        }

        Element tbody = new Element(DOM.TBODY);

        for (int i = 0; i < this.values.size(); i++) {
            T value = this.values.get(i);
            String[] row = this.contentProvider.getContentForRow(i, value);

            tr = new Element(DOM.TR);

            for (String cell : row) {
                Element td = new Element(DOM.TD);
                td.appendString(cell);
                td.addStyle("border", "1px solid black");
                tr.addChild(td);
            }

            tbody.addChild(tr);
        }

        this.addChild(thead);
        this.addChild(tbody);

        return super.render();
    }

}

