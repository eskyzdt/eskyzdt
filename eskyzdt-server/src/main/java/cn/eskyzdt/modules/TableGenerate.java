package cn.eskyzdt.modules;

public class TableGenerate {


    /**
     * 生成一个html表格
     * @param tableHead
     * @param contents
     * @return
     */
    private static String generateTable(String[] tableHead, String[] ... contents) {
        StringBuilder builder = new StringBuilder();
        // 表格头
        builder.append("<tr>\n");
        // 表格的第一行
        for (String tem : tableHead) {
            builder.append("  <td>").append(tem).append("</td>\n");
        }
        builder.append("</tr>\n<tr>\n");
        // 表格的后面内容
        for (String[] content : contents) {
            for (String eachRow : content) {
                builder.append("  <td>").append(eachRow).append("</td>\n");
            }
        }
        // 表格尾部
        builder.append("</tr>\n</table>\n");
        return builder.toString();
    }
}
