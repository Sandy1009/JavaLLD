package PrototypeAndRegistryDesignPattern;

public class Student implements Prototype<Student> {

    private int id;
    private String name;
    private int marks;

    @Override
    public Student clone() {
        Student copy = new Student();
        copy.id = id;
        copy.name = name;
        copy.marks = marks;
        return copy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
