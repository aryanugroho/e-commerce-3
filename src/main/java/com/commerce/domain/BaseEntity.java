package com.commerce.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by suat on 12/22/16.
 */
@MappedSuperclass
public class BaseEntity<P extends Serializable> {

    private P id;
    private Date createdDate;

    public P getId() {
        return id;
    }

    public void setId(P id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
