package com.example.otrs.Repository;

import com.example.otrs.Entity.EmergencyLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmergencyLevelRepository extends JpaRepository<EmergencyLevel, Integer> {
    @Query("SELECT e FROM EmergencyLevel e")
    List<EmergencyLevel> getEmergencyLevels();
}
