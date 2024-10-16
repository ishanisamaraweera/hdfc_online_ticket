package com.example.otrs.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 @author ishani.s
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attachment {
    @Id
    @Column(name = "attachment_id", length = 225)
    private String attachmentId;
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "name")
    private String name;
    @Column(name = "uploaded_date_time")
    private String uploadedDateTime;
    @Column(name = "file_type")
    private String fileType;
    @Column(name = "comment_id")
    private String commentId;
}
