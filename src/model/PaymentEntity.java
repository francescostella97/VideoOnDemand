package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PAYMENT")
public class PaymentEntity extends BaseEntityAudit{

    @Column(name = "payment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "payment")
    private BillEntity bill;

    public Date getPaymentDate() {
        return paymentDate;
    }

    public PaymentEntity setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }

    public BillEntity getBill() {
        return bill;
    }

    public PaymentEntity setBill(BillEntity bill) {
        this.bill = bill;
        return this;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "paymentDate=" + paymentDate +
                ", bill=" + bill.getId() +
                '}';
    }
}
