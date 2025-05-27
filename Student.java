import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    private String name;
    private LocalDate dob;

    public Student(String name, String dobStr) {
        this.name = name;
        DateTimeFormatter formatter;
        if (dobStr.contains("-") && dobStr.length() == 10 && dobStr.charAt(2) == '-') {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        } else {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        }
        this.dob = LocalDate.parse(dobStr, formatter);
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name);
        Period age = Period.between(dob, LocalDate.now());
        System.out.println("Age: " + age.getYears() + " years");
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", "2004-08-15"); // or "15-08-2004"
        s1.displayInfo();
    }
}