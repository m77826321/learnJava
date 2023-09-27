package com.example.learn.audit;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public class Auditable<T> {
    @CreatedBy
    @Column(name="created_by",updatable = false)
    private T createdBy;

    @CreatedDate
    @Column(name = "created_date",updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @LastModifiedBy
    @Column(name="last_modified_by",updatable = false)
    private T lastModifiedBy;

    @LastModifiedDate
    @Column(name = "last_modified_date",updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
}
