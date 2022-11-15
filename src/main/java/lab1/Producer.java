package lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Producer {
    private String name;
    private String address;
    private Employee contactPerson;
    private List<Product> products;

    /**
     * Producer constructor
     * @param builder
     */
    private Producer(ProducerBuilder builder){
        this.name = builder.name;
        this.address = builder.address;
        this.contactPerson = builder.contactPerson;
        this.products = builder.products;
    }

    /**
     * toString
     * @return class description in string format
     */
    @Override
    public String toString(){
        return name + " | " + address + " | Contact person: \n" + contactPerson + "\n | List of products: \n " + products;
    }




    /**
     * equals
     * @param obj taken obj
     * @return verdict of equality with boolean type
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;
        Producer producer = (Producer) obj;
        return (producer.name.equals(this.name) &&
                producer.address.equals(this.address) &&
                producer.contactPerson.equals(this.contactPerson)
        );
    }

    /**
     * hashCode
     * @return hash
     */
    @Override
    public int hashCode(){
        int hash = 31;
        hash = 9 * hash + Objects.hashCode(this.name);
        hash = 9 * hash + Objects.hashCode(this.address);
        hash = 9 * hash + Objects.hashCode(this.contactPerson);
        return hash;
    }

    /**
     * Builder pattern
     */
    public static class ProducerBuilder {

        private String name;

        private String address = " ";
        private Employee contactPerson = new Employee.EmployeeBuilder(" ").build();
        private List<Product> products = new ArrayList<>();

        /**
         * Builder constructor
         */
        public ProducerBuilder(String name){
            this.name = name;
        }

        /**
         * Builder contact person setter
         */
        public ProducerBuilder setContactPerson(Employee contactPerson) {
            this.contactPerson= contactPerson;
            return this;
        }

        /**
         * Builder address setter
         */
        public ProducerBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        /**
         * Builder products setter
         */
        public ProducerBuilder setProducts(List<Product> products){
            this.products.addAll(products);
            return this;
        }

        /**
         * Builder product setter
         */
        public ProducerBuilder setProduct(Product product){
            this.products.add(product);
            return this;
        }

        /**
         * Builder build method
         */
        public Producer build(){
            return new Producer(this);
        }

    }

    /**
     * name getter
     */
    public String getName(){
        return name;
    }

    /**
     * contactPerson getter
     */
    public Employee getContactPerson() {
        return contactPerson;
    }

    /**
     * address getter
     */
    public String getAddress() {
        return address;
    }

    /**
     * products getter
     */
    public List<Product> getProducts(){
        return products;
    }

    /**
     * name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * address setter
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * contactPerson setter
     */
    public void setContactPerson(Employee contactPerson) {
        this.contactPerson = contactPerson;
    }

    /**
     * product setter
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
