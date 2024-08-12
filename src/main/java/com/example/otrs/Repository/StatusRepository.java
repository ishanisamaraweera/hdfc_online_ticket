package com.example.otrs.Repository;

import com.example.otrs.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 @author ishani.s
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, String> {
    @Query("SELECT s FROM Status s")
    List<Status> getStatues();

    @Query("SELECT DISTINCT s.statusId, s.statusDes FROM Status s WHERE s.module = :module ")
    List<Object[]> getStatuesByModule(String module);

    @Modifying
    @Query(value = "INSERT INTO Status s (s.statusId, s.statusDes) VALUES (:statusId, :statusDes)")
    void saveDetails(@Param("statusId") Integer statusId,
                     @Param("statusDes") String statusDes);

}
