public class User {
    private String fname;
    private String lname;
    private int age;
    public char sex;

    void set_lname(String x) {
        System.out.println("logging in...");
        lname = x;
    }

    void set_fname(String x) {
        fname = x;
    }

    void set_age(int x) {
        age = x;
    }

    void set_sex(char x) {
        sex = x;
    }

    String get_name() {
        return lname + " " + fname;
    }

}
