package com.example.otrs.Repository;

import com.example.otrs.Entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, String> {
}
