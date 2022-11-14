package lab1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee employeeFirst = new Employee.EmployeeBuilder("Frank").setSalary(500.0).setAddress("Poshtova, 22").setPhoneNumber("0504340601").setMedicalExamination(true)
                .build();
        Employee employeeSecond = new Employee.EmployeeBuilder("Ivan").setSalary(1200.50).setAddress("Holovna, 30").setPhoneNumber("0684253082").setMedicalExamination(false)
                .build();
        Employee employeeThird = new Employee.EmployeeBuilder("Frank").setSalary(500.0).setAddress("Poshtova, 22").setPhoneNumber("0504340601").setMedicalExamination(true)
                .build();

        Producer producerFirst = new Producer.ProducerBuilder("Producer #1").setAddress("Bojenka,20").setContactPerson(employeeFirst)
                .build();

        Producer producerSecond = new Producer.ProducerBuilder("Producer #2").setAddress("Nezalezhnosti, 147").setContactPerson(employeeFirst)
                .build();

        Product productFirst = new Product.ProductBuilder(1, "Sofa").setPrice(50.49).setCategory("Living room").setProducer(producerFirst)
                .build();

        Product productSecond = new Product.ProductBuilder(2, "Table").setPrice(200.00).setCategory("Kitchen").setProducer(producerSecond)
                .build();

        Product productThird = new Product.ProductBuilder(1, "Sofa").setPrice(50.49).setCategory("Living room")
                .build();

        List<Product> products = new ArrayList<>();
        products.add(productFirst);
        products.add(productThird);

        Producer producerThird = new Producer.ProducerBuilder("Producer #1").setAddress("Bojenka,20").setContactPerson(employeeFirst).setProducts(products).setProduct(productSecond)
                .build();


        /// Print information about employee class
        System.out.println("Employee: ");
        System.out.println(employeeSecond);
        System.out.println(employeeFirst);
        System.out.println("equality: ");
        System.out.println(employeeFirst.equals(employeeSecond));
        System.out.println(employeeFirst.equals(employeeThird));

        /// Print information about product class
        System.out.println("Product: ");
        System.out.println(productFirst);
        System.out.println(productSecond);
        System.out.println("equality: ");
        System.out.println(productFirst.equals(productSecond));
        System.out.println(productFirst.equals(productThird));

        /// Print information about producer class
        System.out.println("Producer: ");
        System.out.println(producerFirst);
        System.out.println(producerSecond);
        System.out.println("equality: ");
        System.out.println(producerFirst.equals(producerSecond));
        System.out.println(producerFirst.equals(producerThird));
    }
}
