package pl.sda.zdjavapol19.oop;

public enum MemberType {
    NONE(0.0, 0.0),
    SILVER(0.1, 0.1),
    GOLD(0.15, 0.1),
    PREMIUM(0.2, 0.1);

    double serviceDiscountRate, productDiscountRate;

    MemberType(double serviceDiscountRate, double productDiscountRate) {
        this.serviceDiscountRate = serviceDiscountRate;
        this.productDiscountRate = productDiscountRate;
    }
}
