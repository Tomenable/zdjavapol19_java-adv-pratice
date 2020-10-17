package pl.sda.zdjavapol19.oop;

import java.time.LocalDateTime;

public class Visit {

    private final Customer customer;
    private final LocalDateTime dateTime;
    private double serviceExpense, productExpense;

    public Visit(Customer customer, LocalDateTime dateTime) {
        this.customer = customer;
        this.dateTime = dateTime;
    }

    public double calcTotalExpense() {
        if(serviceExpense > 0.0) {
            return serviceExpense * (1 - customer.getMemberType().serviceDiscountRate) +
                    productExpense * (1 - customer.getMemberType().productDiscountRate);
        }
        else {
            throw new TotalExpenseCalcEx();
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
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

    @Override
    public String toString() {
        return "Visit{" +
                "customer=" + customer +
                ", dateTime=" + dateTime +
                ", serviceExpense=" + serviceExpense +
                ", productExpense=" + productExpense +
                '}';
    }

    public class TotalExpenseCalcEx extends RuntimeException {
        public TotalExpenseCalcEx() {
            super("Cannot calculate total expense because service expense is not set.");
        }
    }
}
