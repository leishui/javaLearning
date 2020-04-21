package experiment.experiment_2.T2_1;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Course chinese = new Course("语文");
        Course math = new Course("数学");
        Course english = new Course("英语");
        ArrayList<TextBook> chineseBooks = getChineseBooks();
        ArrayList<TextBook> mathBooks = getMathBooks();
        ArrayList<TextBook> englishBooks = getEnglishBooks();
        Connection connection = new Connection();
        connection.setConnection(chinese,chineseBooks);
        connection.setConnection(math,mathBooks);
        connection.setConnection(english,englishBooks);
        System.out.print("语文课本有：");
        for (TextBook textBook : connection.getTextBooks(chinese)) {
            System.out.print(textBook.getName()+"\t");
        }
        System.out.print("\n\n数学课本有：");
        for (TextBook textBook : connection.getTextBooks(math)) {
            System.out.print(textBook.getName()+"\t");
        }
        System.out.print("\n\n英语课本有：");
        for (TextBook textBook : connection.getTextBooks(english)) {
            System.out.print(textBook.getName()+"\t");
        }
    }

    private static ArrayList<TextBook> getChineseBooks() {
        TextBook textBook = new TextBook("语文必修一");
        TextBook textBook1 = new TextBook("语文必修二");
        TextBook textBook2 = new TextBook("语文必修三");
        ArrayList<TextBook> chineseBooks = new ArrayList<>();
        chineseBooks.add(textBook);
        chineseBooks.add(textBook1);
        chineseBooks.add(textBook2);
        return chineseBooks;
    }

    private static ArrayList<TextBook> getMathBooks() {
        TextBook textBook = new TextBook("数学必修一");
        TextBook textBook1 = new TextBook("数学必修二");
        ArrayList<TextBook> mathBooks = new ArrayList<>();
        mathBooks.add(textBook);
        mathBooks.add(textBook1);
        return mathBooks;
    }

    private static ArrayList<TextBook> getEnglishBooks() {
        TextBook textBook = new TextBook("英语课本");
        ArrayList<TextBook> englishBooks = new ArrayList<>();
        englishBooks.add(textBook);
        return englishBooks;
    }
}
