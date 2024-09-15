package PrototypeAndRegistryDesignPattern;

public class Client {

    public static void main(String[] args) {
        Student st = new Student();
        st.setId(43);
        st.setName("Sandy");
        st.setMarks(99);

        Student copy = st.clone();
        Student newStudent = getStudent();
        Student newCopy = newStudent.clone();    //depending on teh object passed to newStudent object, respective clone method is called

        StudentRegistry registry = new StudentRegistry();
        Student aprbatch = new Student();
        aprbatch.setName("April 2024 batch");

        registry.addRegistry("APR_2024", aprbatch);
        Student copyApr2024 = registry.getPrototype("APR_2024").clone();

    }

    public static Student getStudent() {
        int n = (int) Math.random()*100;

        if(n%2 == 0) {
            return new IntelligentStudent();
        } else return new Student();
    }

}
