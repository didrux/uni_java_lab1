package lab1;

import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private String address;
    private String phoneNumber;
    private boolean medicalExamination;

    /**
     * Employee constructor
     * @param builder
     */
    private Employee(EmployeeBuilder builder){
        this.name = builder.name;
        this.salary = builder.salary;
        this.address = builder.address;
        this.phoneNumber = builder.phoneNumber;
        this.medicalExamination = builder.medicalExamination;
    }

    /**
     * toString
     * @return class description in string format
     */
    @Override
    public String toString(){
       return name + " | " + salary + " | " + address + " | " + phoneNumber + " | " + medicalExamination;
    }

    /**
     * hashCode
     * @return hash
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Employee employee = (Employee) obj;
        return (employee.name.equals(this.name) &&
                employee.address.equals(this.address) &&
                employee.phoneNumber.equals(this.phoneNumber)
        );
    }

    /**
     * Overrided hashCode method
     * @return hash
     */
    @Override
    public int hashCode(){
        int hash = 31;
        hash = 9 * hash + Objects.hashCode(this.name);
        hash = 9 * hash + Objects.hashCode(this.address);
        hash = 9 * hash + Objects.hashCode(this.phoneNumber);
        return hash;
    }

    /**
     * Implement classes via builder
     */
    public static class EmployeeBuilder{
        private String name;

        private double salary = 0;
        private String address = " ";
        private String phoneNumber = " ";
        private boolean medicalExamination = false;

        /**
         * @param name
         */
        public EmployeeBuilder(String name){
            this.name = name;
        }

        /**
         * @param salary
         * @return
         */
        public EmployeeBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        /**
         * @param address
         * @return
         */
        public EmployeeBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        /**
         *
         * @param phoneNumber
         * @return
         */
        public EmployeeBuilder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        /**
         *
         * @param medicalExamination
         * @return
         */
        public EmployeeBuilder setMedicalExamination(boolean medicalExamination) {
            this.medicalExamination = medicalExamination;
            return this;
        }

        /**
         *
         * @return
         */
        public Employee build(){
            return new Employee(this);
        }

    }

    /**
     * name getter
     */
    public String getName(){
        return name;
    }

    /**
     * salary getter
     */
    public double getSalary(){
        return salary;
    }

    /**
     * address getter
     */
    public String getAddress(){
        return address;
    }

    /**
     * phoneNumber getter
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * medicalExamination getter
     */
    public boolean getMedicalExamination() {
        return medicalExamination;
    }

    /**
     * name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * salary setter
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * phoneNumber setter
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * address setter
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * medicalExamination setter
     */
    public void setMedicalExamination(boolean medicalExamination) {
        this.medicalExamination = medicalExamination;
    }
}