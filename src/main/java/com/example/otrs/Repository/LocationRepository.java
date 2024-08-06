package com.example.otrs.Repository;

import com.example.otrs.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*

@author ishani.s
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, String> {
}
