package com.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "BILL")
public class BillEntity extends BaseEntityAudit{

    @OneToMany(mappedBy="bill")
    private List<BillRowEntity> billRows;

    @Column(name = "number")
    private String number;

    @Column(name = "amount")
    private double amount;

    @Column(name = "emission_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emissionDate;

    @Column(name = "cancellation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancellationDate;

    /*
    *  ---- Manager information -----
    */
    @Column(name = "heading")
    private String heading;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "partita_iva", length = 11)
    private String pIva;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "cap", length = 5)
    private String cap;

    // ------------------------------

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private PaymentEntity payment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public List<BillRowEntity> getBillRows() {
        return billRows;
    }

    public BillEntity setBillRows(List<BillRowEntity> billRows) {
        this.billRows = billRows;
        return this;
    }

    public String getNumber() {
        return number;
    }

    public BillEntity setNumber(String number) {
        this.number = number;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public BillEntity setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public Date getCancellationDate() {
        return cancellationDate;
    }

    public BillEntity setCancellationDate(Date cancellationDate) {
        this.cancellationDate = cancellationDate;
        return this;
    }

    public String getHeading() {
        return heading;
    }

    public BillEntity setHeading(String heading) {
        this.heading = heading;
        return this;
    }

    public String getBusinessName() {
        return businessName;
    }

    public BillEntity setBusinessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    public String getpIva() {
        return pIva;
    }

    public BillEntity setpIva(String pIva) {
        this.pIva = pIva;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public BillEntity setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getCap() {
        return cap;
    }

    public BillEntity setCap(String cap) {
        this.cap = cap;
        return this;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public BillEntity setPayment(PaymentEntity payment) {
        this.payment = payment;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public BillEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public Date getEmissionDate() {
        return emissionDate;
    }

    public BillEntity setEmissionDate(Date emissionDate) {
        this.emissionDate = emissionDate;
        return this;
    }

    @Override
    public String toString() {
        return "BillEntity{" +
                ", number='" + number + '\'' +
                ", amount=" + amount +
                ", emissionDate=" + emissionDate +
                ", cancellationDate=" + cancellationDate +
                ", heading='" + heading + '\'' +
                ", businessName='" + businessName + '\'' +
                ", pIva='" + pIva + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cap='" + cap + '\'' +
                ", payment=" + payment.getId() +
                ", user=" + user.getId() +
                '}';
    }
}
