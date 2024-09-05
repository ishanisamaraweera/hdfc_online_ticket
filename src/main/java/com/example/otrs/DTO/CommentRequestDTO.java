package com.example.otrs.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 @author ishani.s
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDTO {
    private String commentId;
    private String comment;
    private String addedDateTime;
    private String addedBy;
    private String attachmentId;
    private String commentType;
    private String ticketId;
}