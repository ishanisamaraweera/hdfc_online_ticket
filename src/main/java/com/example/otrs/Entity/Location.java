package com.example.otrs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*

@author ishani.s
 */
@Entity
@Data
@Table(name = "location")
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @Column(name = "location_id", length = 45)
    private String locationId;
    @Column(name = "location_des")
    private String locationDes;
}
