package uti.ro.examples.csv;

import uti.ro.examples.csv.gen.CSVBaseListener;
import uti.ro.examples.csv.gen.CSVParser;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CSVMapsBuilder extends CSVBaseListener {

    private static final String EMPTY = "";

    List<Map<String,String>> rows = new ArrayList<>();
    private List<String> header;
    private List<String> currentRowFieldValues;

    @Override
    public void exitHdr(CSVParser.HdrContext ctx) {
        header = new ArrayList<>();
        header.addAll(currentRowFieldValues);
    }

    @Override
    public void exitString(CSVParser.StringContext ctx) {
        currentRowFieldValues.add(ctx.STRING().getText());
    }

    @Override
    public void exitText(CSVParser.TextContext ctx) {
        currentRowFieldValues.add(ctx.TEXT().getText());
    }

    @Override
    public void enterEmpty(CSVParser.EmptyContext ctx) {
        currentRowFieldValues.add(EMPTY);
    }

    @Override
    public void enterRow(CSVParser.RowContext ctx) {
        currentRowFieldValues = new ArrayList<>();
    }

    @Override
    public void exitRow(CSVParser.RowContext ctx) {
        if ( ctx.getParent().getRuleIndex() == CSVParser.RULE_hdr) return;
        addRow();
    }

    private void addRow(){
        Map<String, String> m = new LinkedHashMap<>();
        for (int i = 0; i < currentRowFieldValues.size(); i++) {
            m.put(header.get(i), currentRowFieldValues.get(i));
        }
        rows.add(m);
    }
}
