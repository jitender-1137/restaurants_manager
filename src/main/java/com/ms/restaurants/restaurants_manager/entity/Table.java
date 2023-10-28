package com.ms.restaurants.restaurants_manager.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@javax.persistence.Table(name = "tables")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Long tableId;
    @Column(name = "table_name")
    private String tableName;
    @Column(name = "capacity")
    private int capacity;
    @Column(name = "status")
    private String status; // occupied, available
    @Column(name = "qr_code")
    private String qrCode;
    @Column(name = "table_no")
    private String tableNo;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_by")
    private String updatedBy;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}