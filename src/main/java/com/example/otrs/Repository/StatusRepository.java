package com.example.otrs.Repository;

import com.example.otrs.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, String> {
    @Query("SELECT s FROM Status s")
    List<Status> getStatues();
}
