package lab1;

public class Product {
    private final int barcode;
    private String name;
    private double price;
    private String category;
    private Customer customer;

    /**
     * Product constructor
     * @param builder
     */
    private Product(ProductBuilder builder){
        this.barcode= builder.barcode;
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category;
        this.customer = builder.customer;
    }

    /**
     * toString
     * @return class description in string format
     */
    @Override
    public String toString(){
        return name + " | " + barcode + " | " + name + " | " + price + " | " + category + " | Customer:\n" + customer.toString();
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
        Product product = (Product) obj;
        return (product.barcode == this.barcode);
    }

    /**
     * hashCode
     * @return hash
     */
    @Override
    public int hashCode(){
        return 31 * 9 + this.barcode;
    }

    /**
     * Builder pattern
     */
    public static class ProductBuilder {

        private int barcode;
        private String name;

        private double price = 0.0;
        private String category = " ";
        private Customer customer = new Customer.CustomerBuilder("none").build();

        /**
         * Builder constructor
         */
        public ProductBuilder(int barcode, String name){
            this.barcode= barcode;
            this.name = name;
        }

        /**
         * Builder price setter
         */
        public ProductBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        /**
         * Builder category setter
         */
        public ProductBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        /**
         * Builder Customer setter
         */
        public ProductBuilder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        /**
         * Builder build method
         */
        public Product build(){
            return new Product(this);
        }

    }

    /**
     * name getter
     */
    public String getName(){
        return name;
    }

    /**
     * price getter
     */
    public double getPrice(){
        return price;
    }

    /**
     * barcode getter
     */
    public int getBarcode(){
        return barcode;
    }

    /**
     * category getter
     */
    public String getCategory(){
        return category;
    }

    /**
     * Customer getter
     */
    public Customer getCustomer(){
        return customer;
    }

    /**
     * name setter
     */
    public void setName(String name) { this.name = name; }

    /**
     * category setter
     */
    public void setCategory(String category) { this.category = category; }

    /**
     * price setter
     */
    public void setPrice(double price) { this.price = price; }

    /**
     * Customer setter
     */
    public void setCustomer(Customer customer){
        this.customer = customer;
    }

}
