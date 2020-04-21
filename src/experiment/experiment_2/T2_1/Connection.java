package experiment.experiment_2.T2_1;

import java.util.ArrayList;

public class Connection {
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<ArrayList<TextBook>> textBooks = new ArrayList<>();
    public void setConnection(Course course,ArrayList<TextBook> textBooks){
        this.courses.add(course);
        this.textBooks.add(textBooks);
    }
    public ArrayList<TextBook> getTextBooks(Course course){
        int index = 0;
        for (Course item : courses) {
            if (item.getName().equals(course.getName()))
                return textBooks.get(index);
            index++;
        }
        return null;
    }
}
