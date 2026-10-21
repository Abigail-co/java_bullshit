import java.util.ArrayList;
import java.util.List;

public class Student {
    public String name;
    public String last_name;
    public List<Integer> grades;

    Student(String name, String last_name) {
        this.name = name;
        this.last_name = last_name;
        this.grades = new ArrayList<>();
    }

    public double average() {
        double sum = 0;
        for(Integer i : grades) {
            sum += (double)i;
        }
        return sum / (double)grades.size();
    }
}
