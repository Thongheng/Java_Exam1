interface DiscountRate {
    double getServiceMemberDiscount();
    double getProductMemberDiscount();
}

class Customer implements DiscountRate {
    private String customerName;
    private String customerType;

    public Customer(String customerName, String customerType) {
        this.customerName = customerName;
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public double getServiceMemberDiscount() {
        switch (customerType) {
            case "Premium":
                return 0.2;
            case "Gold":
                return 0.15;
            case "Silver":
                return 0.1;
            default:
                return 0;
        }
    }

    @Override
    public double getProductMemberDiscount() {
        switch (customerType) {
            case "Premium":
            case "Gold":
            case "Silver":
                return 0.1;
            default:
                return 0;
        }
    }
}

class Sale {
    private Customer customer;
    private String date;
    private double serviceExpense;
    private double productExpense;

    public Sale(Customer customer, String date) {
        this.customer = customer;
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public double getServiceDiscount() {
        return serviceExpense * customer.getServiceMemberDiscount();
    }

    public double getProductDiscount() {
        return productExpense * customer.getProductMemberDiscount();
    }

    public double getServiceExpenseAfterDiscount() {
        return serviceExpense - getServiceDiscount();
    }

    public double getProductExpenseAfterDiscount() {
        return productExpense - getProductDiscount();
    }

    public double getTotalExpense() {
        return getServiceExpenseAfterDiscount() + getProductExpenseAfterDiscount();
    }

    public void displayInfo() {
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Customer Type: " + customer.getCustomerType());
        System.out.println("Service Expense: $" + serviceExpense);
        System.out.println("Product Expense: $" + productExpense);
        System.out.println("Service Discount: " + customer.getServiceMemberDiscount() * 100 + "%");
        System.out.println("Product Discount: " + customer.getProductMemberDiscount() * 100 + "%");
        System.out.println("Service Expense After Discount: $" + getServiceExpenseAfterDiscount());
        System.out.println("Product Expense After Discount: $" + getProductExpenseAfterDiscount());
        System.out.println("Total Expense: $" + getTotalExpense());
    }
}

public class Main {

    public static void main(String[] args) {
        // Create customers
        Customer customer1 = new Customer("Ronaldo", "Premium");
        Customer customer2 = new Customer("Messi", "Gold");
        Customer customer3 = new Customer("Neymar", "Silver");
        Customer customer4 = new Customer("Mbappe", "Normal");

        // Create sales
        Sale sale1 = new Sale(customer1, "2024-01-15");
        sale1.setServiceExpense(150.0);
        sale1.setProductExpense(400.0);

        Sale sale2 = new Sale(customer2, "2024-02-16");
        sale2.setServiceExpense(500.0);
        sale2.setProductExpense(600.0);

        Sale sale3 = new Sale(customer3, "2024-01-30");
        sale3.setServiceExpense(800.0);
        sale3.setProductExpense(50.0);

        Sale sale4 = new Sale(customer4, "2024-02-11");
        sale4.setServiceExpense(450.0);
        sale4.setProductExpense(260.0);

        // Display sale information
        sale1.displayInfo();
        System.out.println();
        sale2.displayInfo();
        System.out.println();
        sale3.displayInfo();
        System.out.println();
        sale4.displayInfo();
    }
}
