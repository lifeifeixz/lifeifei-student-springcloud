package org.flys.cg.generators;

import org.flys.cg.Generator;
import org.flys.cg.meta.Column;
import org.flys.cg.meta.MetaTable;
import org.flys.cg.util.ColumnSplicing;
import org.flys.cg.util.TypeConverter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.List;

/**
 * @program: code-generation
 * @description: 基于jsoup的表单生成器。后续可能还会是详情页生成器
 * @author: feifei.li
 * @create: 2019-08-29 13:41
 **/
public class BasedJsoupFormGenerator extends AbstractGenerator implements Generator {
    public BasedJsoupFormGenerator(String packageName) {
        super(packageName);
    }

    @Override
    public Product doGenerate(MetaTable metaTable) {
        String fileName = ColumnSplicing.convertColumnToField(metaTable.getTableName());
        super.layer = "web." + fileName;
        String resource = this.loadResource("form.html");
        Document document = Jsoup.parse(resource);
        Element bzw = document.getElementById("bzw");
        List<Column> columns = metaTable.getColumns();
        for (int i = 0; i < columns.size(); i++) {
            Column column = columns.get(i);
            String field = ColumnSplicing.convertColumnToField(column.getName());
            String type = TypeConverter.exchange(column.getType());
            String formItem = "";
            if (column.getNotes() != null && column.getNotes().trim().length() > 0) {
                formItem = "<div class=\"form-group\">\n" +
                        "\t\t\t\t\t\t\t<label for=\"" + field + "\">" + column.getNotes() + "</label>\n" +
                        "\t\t\t\t\t\t\t<input type=\"text\" v-model=\"model." + field + "\" class=\"form-control\" name=\"" + field + "\" id=\"" + field + "\" placeholder=\"" + column.getNotes() + "\">\n" +
                        "\t\t\t\t\t\t</div>";
                bzw.before(formItem);
            }
        }
        Object modelJson = current.getData("modelJson");
        String string = document.toString();
        string = string.replaceAll("'&model&'", modelJson.toString())
                .replaceAll("&fileName&", fileName);

        return new Product("form.html",string);
    }
}
