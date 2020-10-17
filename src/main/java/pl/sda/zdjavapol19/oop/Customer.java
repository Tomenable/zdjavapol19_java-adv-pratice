package pl.sda.zdjavapol19.oop;

public class Customer {

    private MemberType memberType;
    private final String name;

    public Customer(String name) {
        this.memberType = MemberType.NONE;
        this.name = name;
    }

    public Customer(String name, MemberType memberType) {
        this.memberType = memberType;
        this.name = name;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "memberType=" + memberType +
                ", name='" + name + '\'' +
                '}';
    }
}
