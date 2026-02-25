package org.example;

import java.util.*;

public class RuleMigrationFinal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter NEW rst_rlst_id series (example 7000): ");
        String rstBase = sc.nextLine().trim();

        System.out.print("Enter NEW rul_rl_id series (example 80000): ");
        String rulBase = sc.nextLine().trim();

        System.out.println("\nPaste ALL SQL and type END in new line:\n");

        StringBuilder input = new StringBuilder();
        while (true) {
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("END")) break;
            input.append(line).append("\n");
        }

        List<String> queries = splitQueries(input.toString());

        // Map old rst → new rst
        Map<String, String> rstMap = new LinkedHashMap<>();
        int counter = 1;

        // -------- PASS 1: Collect rst_rlst_id --------
        for (String sql : queries) {
            if (sql.toLowerCase().contains("insert into rst_ruleset")) {
                Parsed p = parse(sql);
                for (int i = 0; i < p.columns.size(); i++) {
                    if (p.columns.get(i).equalsIgnoreCase("rst_rlst_id")) {
                        String oldId = clean(p.values.get(i));
                        if (!rstMap.containsKey(oldId)) {
                            rstMap.put(oldId, rstBase + counter);
                            counter++;
                        }
                    }
                }
            }
        }

        // -------- PASS 2: Transform and Print --------
        for (String sql : queries) {

            if (sql.toLowerCase().contains("insert into rst_ruleset")) {
                sql = updateRst(sql, rstMap);
            }

            else if (sql.toLowerCase().contains("insert into rul_rule")) {
                sql = updateRule(sql, rstMap, rulBase);
            }

            System.out.println(sql);
        }
    }

    // ================= rst_ruleset =================
    static String updateRst(String sql, Map<String, String> map) {

        Parsed p = parse(sql);

        for (int i = 0; i < p.columns.size(); i++) {
            if (p.columns.get(i).equalsIgnoreCase("rst_rlst_id")) {
                String old = clean(p.values.get(i));
                if (map.containsKey(old)) {
                    p.values.set(i, map.get(old));
                }
            }
        }
        return p.build();
    }

    // ================= rul_rule =================
    static String updateRule(String sql,
                             Map<String, String> rstMap,
                             String rulBase) {

        Parsed p = parse(sql);

        // update rul_rlst_id
        for (int i = 0; i < p.columns.size(); i++) {
            if (p.columns.get(i).equalsIgnoreCase("rul_rlst_id")) {
                String old = clean(p.values.get(i));
                if (rstMap.containsKey(old)) {
                    p.values.set(i, rstMap.get(old));
                }
            }
        }

        // update rul_rl_id → Replace ONLY first digit
        for (int i = 0; i < p.columns.size(); i++) {

            if (p.columns.get(i).equalsIgnoreCase("rul_rl_id")) {

                String oldRule = clean(p.values.get(i));

                if (oldRule.length() > 0) {
                    String firstDigit = rulBase.substring(0, 1);
                    String newVal = firstDigit + oldRule.substring(1);
                    p.values.set(i, newVal);
                }
            }
        }

        return p.build();
    }

    // ================= SQL PARSER =================
    static Parsed parse(String sql) {

        String colPart = sql.substring(sql.indexOf("(") + 1, sql.indexOf(")"));
        String valPart = sql.substring(sql.lastIndexOf("(") + 1, sql.lastIndexOf(")"));

        List<String> cols = splitSafe(colPart);
        List<String> vals = splitSafe(valPart);

        return new Parsed(sql, cols, vals);
    }

    static List<String> splitSafe(String text) {
        List<String> list = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuote = false;

        for (char c : text.toCharArray()) {
            if (c == '\'') inQuote = !inQuote;

            if (c == ',' && !inQuote) {
                list.add(current.toString().trim());
                current.setLength(0);
            } else {
                current.append(c);
            }
        }
        list.add(current.toString().trim());
        return list;
    }

    static List<String> splitQueries(String sql) {
        String[] arr = sql.split(";");
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            if (!s.trim().isEmpty())
                list.add(s.trim() + ";");
        }
        return list;
    }

    static String clean(String v) {
        return v.replace("'", "").trim();
    }

    // ================= Helper Class =================
    static class Parsed {
        String original;
        List<String> columns;
        List<String> values;

        Parsed(String o, List<String> c, List<String> v) {
            original = o;
            columns = c;
            values = v;
        }

        String build() {
            String start = original.substring(0, original.lastIndexOf("(") + 1);
            StringBuilder sb = new StringBuilder(start);

            for (int i = 0; i < values.size(); i++) {
                sb.append(values.get(i));
                if (i != values.size() - 1) sb.append(", ");
            }

            sb.append(");");
            return sb.toString();
        }
    }
}