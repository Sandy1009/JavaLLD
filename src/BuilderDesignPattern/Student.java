package BuilderDesignPattern;

public class Student {

    int id;
    String name;
    String univName;
    double psp;
    int gradYear;
    int batchId;
    double attendance;
    int age;

    public Student(Builder builder) {
        id = builder.id;
        name = builder.name;
        univName = builder.univName;
        psp = builder.psp;
        gradYear = builder.gradYear;
        batchId = builder.batchId;
        attendance = builder.attendance;
        age = builder.age;
    }

    public static Builder builder() {
        return new Builder();
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getUnivName() {
        return univName;
    }

    public double getPsp() {
        return psp;
    }

    public int getGradYear() {
        return gradYear;
    }

    public int getBatchId() {
        return batchId;
    }

    public double getAttendance() {
        return attendance;
    }

    static class Builder {
        int id;
        String name;
        String univName;
        double psp;
        int gradYear;
        int batchId;
        double attendance;
        int age;

        public Builder() {
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder univName(String univName) {
            this.univName = univName;
            return this;
        }

        public Builder psp(double psp) {
            this.psp = psp;
            return this;
        }

        public Builder gradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public Builder batchId(int batchId) {
            this.batchId = batchId;
            return this;
        }

        public Builder attendance(double attendance) {
            this.attendance = attendance;
            return this;
        }

        private void validate(Builder builder) throws InvalidGradYearException, InvalidAgeException {
            if(builder.gradYear > 2024) {
                throw new InvalidGradYearException("Grad year cannot be greater than 2024");
            }

            if(builder.age < 18) {
                throw new InvalidAgeException("Age should be minimum 18");
            }
        }

        public Student build() throws InvalidAgeException, InvalidGradYearException {
            validate(this);
            return new Student(this);
        }

    }


}
