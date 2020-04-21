package experiment.experiment_2.T2_2;

public class Test {
    public static void main(String[] args) {
        String[][] content = {
            {"0","0","1","1","0","0"},
            {"0","1","1","1","1","0"},
            {"0","0","1","1","0","0"}
        };
        String[] rowName = {"1","2","3"};
        String[] columnName = {"1","2","3","4","5","6"};
        Table table = new Table("testTable",content);
        table.setRowName(rowName);
        table.setColumnName(columnName);
        table.print();
        table.setFrame("#");
        table.print();
    }
}
