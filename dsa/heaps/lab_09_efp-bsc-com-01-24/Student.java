
public class Student implements Comparable<Student> {

    private final String name;
    private final int grade;

    private static int count = 0;

    public Student() {

        count++;

        name = String.format("student_%02d", count);

        grade = (int) (Math.random() * 101);
    }

    public String getName() { // getter
        return name;
    }

    public int getGrade() { // getter
        return grade;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.grade, other.grade);
    }

    @Override
    public String toString() {
        return name + ", " + grade;
    }
}
