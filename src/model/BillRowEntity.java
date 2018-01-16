package model;

import javax.persistence.*;

@Entity
@Table(name = "BILL_ROW")
public class BillRowEntity extends BaseEntityAudit {

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="film_id")
    private FilmEntity film;

    @Column(name = "price")
    private double price;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="bill_id")
    private BillEntity bill;

    public double getPrice() {
        return price;
    }

    public BillRowEntity setPrice(double price) {
        this.price = price;
        return this;
    }

    public BillEntity getBill() {
        return bill;
    }

    public BillRowEntity setBill(BillEntity bill) {
        this.bill = bill;
        return this;
    }

    @Override
    public String toString() {
        return "BillRowEntity{" +
                "price=" + price +
                ", bill=" + bill.getId() +
                '}';
    }
}
