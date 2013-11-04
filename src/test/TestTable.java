package test;

import html.dom.Table;
import html.dom.TableContentProvider;

import java.util.ArrayList;
import java.util.List;

public class TestTable {

    public static void main(String... args) {

        List<String[]> values = new ArrayList<>();
        values.add(new String[]{
                "Sort mit 1000 Elementen unsortiert",
                "28442",
                "24808",
                "29851",
                "58331541"
        });

        values.add(new String[]{
                "Rekursionstiefe",
                "-",
                "890",
                "960",
                "254133"
        });

        Table<String[]> table = new Table<>(values);
        table.addHeader("Versuche");
        table.addHeader("Insertionsort");
        table.addHeader("Quicksort");
        table.addHeader("Quicksort Median");
        table.addHeader("QuicksortRandomX");

        table.setContentProvider(new TableContentProvider<String[]>() {
            @Override
            public String[] getContentForRow(int row, String[] value) {
                return value;
            }
        });

        System.out.println();
        System.out.println(table.render());

    }
}
