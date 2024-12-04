package com.example.otrs.Repository;

import com.example.otrs.Entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 @author ishani.s
 */
public interface AttachmentRepository extends JpaRepository<Attachment, String> {
}
