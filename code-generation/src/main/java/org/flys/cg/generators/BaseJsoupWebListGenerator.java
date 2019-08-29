package org.flys.cg.generators;

import org.flys.cg.Generator;
import org.flys.cg.meta.Column;
import org.flys.cg.meta.MetaTable;
import org.flys.cg.util.ColumnSplicing;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * @program: code-generation
 * @description: 基于Jsoup的web列表生成器
 * @author: feifei.li
 * @create: 2019-08-29 09:55
 **/
public class BaseJsoupWebListGenerator extends AbstractGenerator implements Generator {
    public BaseJsoupWebListGenerator(String packageName) {
        super(packageName);
    }

    @Override
    public Product doGenerate(MetaTable metaTable) {
        String fileName = ColumnSplicing.convertColumnToField(metaTable.getTableName());
        super.layer = "web." + fileName;
        String resource = this.loadResource("WebList.html");
        Document document = Jsoup.parse(resource);
        Element tableHeader = document.getElementById("table-header");
        Element tableRow = document.getElementById("table-row");
        Element form = document.getElementById("form");
        String param = "{";
        for (int i = 0; i < metaTable.getColumns().size(); i++) {
            Column column = metaTable.getColumns().get(i);
            String headerTd = column.getNotes();
            String field = ColumnSplicing.convertColumnToField(column.getName());
            if (headerTd != null && headerTd.trim().length() > 0) {
                tableHeader.before("<td>" + headerTd + "</td>");
                tableRow.before("<td>{{obj." + field + "}}</td>");
                form.append(column.getNotes() + ":<input type=\"text\" v-model=\"param." + field + "\" class=\"form-item\"/>");
                if (i != (metaTable.getColumns().size() - 1)) {
                    param += field + ":null,\n";
                } else {
                    param += field + ":null\n";
                }
            }
        }
        param += "}";
        current.put("modelJson", param);

        String string = document.toString();
        string = string.replace("'&param&'", param);
        string = string.replaceAll("&tableName&", fileName);
        string = string.replaceAll("%primaryKey%", current.getPrimaryKey());
        return new Product("list.html", string);
    }
}
