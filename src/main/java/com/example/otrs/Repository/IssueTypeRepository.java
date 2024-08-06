package com.example.otrs.Repository;

import com.example.otrs.Entity.IssueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*

@author ishani.s
 */
@Repository
public interface IssueTypeRepository extends JpaRepository<IssueType, Integer> {
}
