package com.example.otrs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Table(name = "status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Status {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "status_id")
    private Integer statusId;
    @Column(name = "status_des")
    private String statusDes;
    @Column(name = "module")
    private String module;
}