package BuilderDesignPattern;

import java.util.Calendar;

public class Client {

    public static void main(String[] args) throws InvalidAgeException, InvalidGradYearException {
        Student st = Student.builder().age(20).id(49043).name("abc").gradYear(2024).psp(99.3).attendance(80.34).build();

        System.out.println(st.getId()+"     ->      "+st.getName());

        /*Student st2 = Student.builder().age(20).id(49043).name("xyz").gradYear(2030).psp(99.3).attendance(80.34).build();

        System.out.println(st2.getId()+"     ->      "+st2.getName());*/

       /* Student st3 = Student.builder().age(16).id(49043).name("sandy").gradYear(2016).psp(99.3).attendance(80.34).build();

        System.out.println(st3.getId()+"     ->      "+st3.getName());*/
    }

}
