package experiment.experiment_2.T2_2;

public class Table {
    private String tableName;
    private String[] rowName;
    private String[] columnName;
    private String[][] content;
    private int rowCount;
    private int columnCount;
    private String frame = "|";

    Table(String tableName, String[][] content) {
        this.tableName = tableName;
        this.columnCount = content[0].length;
        this.rowCount = content.length/columnCount;
        this.content = content;
        rowName = new String[rowCount];
        columnName = new String[columnCount];
    }

    public Table(String[][] content) {
        this("default",content);
    }

    void print(){
        int index = 0;
        System.out.print("  "+"\t");
        for (String s : columnName) {
            System.out.print(s+frame+"\t");
        }
        System.out.println();
        for (String[] strings : content) {
            System.out.print(rowName[index]+frame+"\t");
            for (String string : strings) {
                System.out.print(string+frame+"\t");
            }
            index++;
            System.out.println();
        }
    }

    String getTableName() {
        return tableName;
    }

    void setTableName(String tableName) {
        this.tableName = tableName;
    }

    String[] getRowName() {
        return rowName;
    }

    void setRowName(String[] rowName) {
        this.rowName = rowName;
    }

    String[] getColumnName() {
        return columnName;
    }

    void setColumnName(String[] columnName) {
        this.columnName = columnName;
    }

    int getRowCount() {
        return rowCount;
    }

    int getColumnCount() {
        return columnCount;
    }

    void setFrame(String frame) {
        this.frame = frame;
    }
}
