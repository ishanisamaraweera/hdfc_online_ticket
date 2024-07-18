package com.example.otrs.Repository;

import com.example.otrs.Entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, String> {
}
