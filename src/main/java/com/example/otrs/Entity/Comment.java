package com.example.otrs.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Comment {
    @Id
    @Column(name = "comment_id", length = 225)
    private Integer commentId;
    @Column(name = "comment", length = 225)
    private String comment;
    @Column(name = "added_date_time")
    private String addedDateTime;
    @Column(name = "added_by", length = 45)
    private String addedBy;
    @Column(name = "comment_type", length = 10)
    private String commentType;
    @Column(name = "ticket_id", length = 20)
    private String ticketId;
}