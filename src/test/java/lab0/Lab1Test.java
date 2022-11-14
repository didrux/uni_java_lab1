package lab0;

import lab1.Employee;
import lab1.Product;
import lab1.Customer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class Lab1Test {
    Employee employeeFirst = new Employee.EmployeeBuilder("Frank").setSalary(500.0).setAddress("Poshtova, 22").setPhoneNumber("0504340601").setMedicalExamination(true)
            .build();
    Employee employeeSecond = new Employee.EmployeeBuilder("Ivan").setSalary(1200.50)
            .build();
    Employee employeeThird = new Employee.EmployeeBuilder("Frank").setSalary(500.0).setAddress("Poshtova, 22").setPhoneNumber("0504340601").setMedicalExamination(true)
            .build();

    Customer customerFirst = new Customer.CustomerBuilder("Customer #1").setAddress("Bojenka,20").setContactPerson(employeeFirst)
            .build();

    Customer customerSecond = new Customer.CustomerBuilder("Customer #2").setAddress("Nezalezhnosti, 147")
            .build();

    Customer customerThird = new Customer.CustomerBuilder("Customer #1").setAddress("Bojenka,20").setContactPerson(employeeFirst)
            .build();

    Product productFirst = new Product.ProductBuilder(1, "Sofa").setPrice(50.49).setCategory("Living room").setCustomer(customerFirst)
            .build();

    Product productSecond = new Product.ProductBuilder(2, "Table").setPrice(200.00).setCategory("Kitchen")
            .build();

    Product productThird = new Product.ProductBuilder(1, "Sofa").setPrice(50.49).setCategory("Living room")
            .build();

    @Test(dataProvider = "employeeEqualsProvider")
    public void employeeEqualsTest(Employee e1, Employee e2) {
        assertEquals(e1, e2);
    }

    @DataProvider
    public Object[][] employeeEqualsProvider() {
        return new Object[][]{{employeeFirst, employeeThird}};
    }

    @Test(dataProvider = "employeeNotEqualsProvider")
    public void employeeNotEqualsTest(Employee e1, Employee e2) {
        assertNotEquals(e1, e2);
    }

    @DataProvider
    public Object[][] employeeNotEqualsProvider() {
        return new Object[][]{{employeeFirst, employeeSecond}};
    }

    @Test(dataProvider = "employeeToStringProvider")
    public void employeeToStringTest(Employee e1, String s) {
        assertEquals(e1.toString(), s);
    }

    @DataProvider
    public Object[][] employeeToStringProvider() {
        return new Object[][]{{employeeFirst, "Frank | 500.0 | Poshtova, 22 | 0504340601 | true"}};
    }

    @Test(dataProvider = "productEqualsProvider")
    public void productEqualsTest(Product p1, Product p2) {
        assertEquals(p1, p2);
    }

    @DataProvider
    public Object[][] productEqualsProvider() {
        return new Object[][]{{productFirst, productThird}};
    }

    @Test(dataProvider = "productNotEqualsProvider")
    public void productNotEqualsTest(Product p1, Product p2) {
        assertNotEquals(p1, p2);
    }

    @DataProvider
    public Object[][] productNotEqualsProvider() {
        return new Object[][]{{productFirst, productSecond}};
    }

    @Test(dataProvider = "productToStringProvider")
    public void productToStringTest(Product p1, String s) {
        assertEquals(p1.toString(), s);
    }

    @DataProvider
    public Object[][] productToStringProvider() {
        return new Object[][]{{productFirst, "Sofa | 1 | Sofa | 50.49 | Living room | Customer:\n" +
                "Customer #1 | Bojenka,20 | Contact person: \n" +
                "Frank | 500.0 | Poshtova, 22 | 0504340601 | true"}};
    }

    @Test(dataProvider = "customerEqualsProvider")
    public void customerEqualsTest(Customer s1, Customer s2) {
        assertEquals(s1, s2);
    }

    @DataProvider
    public Object[][] customerEqualsProvider() {
        return new Object[][]{{customerFirst, customerThird}};
    }

    @Test(dataProvider = "customerNotEqualsProvider")
    public void customerNotEqualsTest(Customer s1, Customer s2) {
        assertNotEquals(s1, s2);
    }

    @DataProvider
    public Object[][] customerNotEqualsProvider() {
        return new Object[][]{{customerFirst, customerSecond}};
    }

    @Test(dataProvider = "customerToStringProvider")
    public void customerToStringTest(Customer s1, String s) {
        assertEquals(s1.toString(), s);
    }

    @DataProvider
    public Object[][] customerToStringProvider() {
        return new Object[][]{{customerFirst, "Customer #1 | Bojenka,20 | Contact person: \n" +
                "Frank | 500.0 | Poshtova, 22 | 0504340601 | true"}};
    }
}
