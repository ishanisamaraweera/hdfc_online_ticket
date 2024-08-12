package com.example.otrs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 @author ishani.s
 */
@Entity
@Data
@Table(name = "page")
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    @Id
    @Column(name = "page_id", length = 45)
    private String pageId;
    @Column(name = "page_description")
    private String pageDescription;
    @Column(name = "status")
    private Integer status;
}