package model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntityAudit extends BaseEntity{

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "created_by", length = 20)
    private String createdBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "updated_by", length = 20)
    private String updatedBy;

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public BaseEntityAudit setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public BaseEntityAudit setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }

    @PrePersist
    public void setCreationDate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    public void setChangeDate(){
        this.updatedAt = new Date();
    }
}
