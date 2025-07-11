package springboot.Testing.pos.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.ArrayList;

@Entity
@Table(name= "customer")
//@Typedefs({
//    @TypeDef(name = "json", typeClass = org.hibernate.type.JsonType.class)
//})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id" , length = 50)
    private int customerId;

    @Column(name = "customer_name",length = 100, nullable = false)
    private String customerName;

    @Column(name = "customer_address", length = 100)
    private String customerAddress;

    @Column(name = "customer_salary")
    private double customerSalary;

    @Column(name = "nic")
    private String nic;

    @Column(name = "active_state" , columnDefinition = "boolean default true")
    private boolean active;

    public Customer() {
    }
    public Customer(int customerId, String customerName, String customerAddress, double customerSalary, String nic, boolean active) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
        this.nic = nic;
        this.active = active;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(double customerSalary) {
        this.customerSalary = customerSalary;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                ", nic='" + nic + '\'' +
                ", active=" + active +
                '}';
    }

    //    @Type("json")
//    @Column(name= "contact_number" , length = 10 , columnDefinition = "json")
//    private ArrayList contactNumbers;
}
