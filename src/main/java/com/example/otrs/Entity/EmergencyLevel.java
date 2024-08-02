package com.example.otrs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Table(name = "emergency_level")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmergencyLevel {
    @Id
    @Column(name = "level_id")
    private String levelId;
    @Column(name = "level_des")
    private String levelDes;
}