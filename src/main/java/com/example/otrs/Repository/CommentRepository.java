package com.example.otrs.Repository;

import com.example.otrs.DTO.CommentRequestDTO;
import com.example.otrs.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

/**
 *
 @author ishani.s
 */
public interface CommentRepository extends JpaRepository<Comment, String> {
    @Query("SELECT MAX(c.commentId) AS commentId FROM Comment c")
    Integer findMaxCommentId();

    @Query("SELECT new com.example.otrs.DTO.CommentRequestDTO(c.commentId, c.commentText, " +
            "c.addedDateTime, " +
            "u.displayName as addedBy, " +
            "c.commentType, c.ticketId," +
            "c.attachmentId, c.filePath) " +
            "FROM Comment c " +
            "LEFT JOIN User u ON u.username = c.addedBy WHERE ticketId = :ticketId")
    List<CommentRequestDTO> getCommentsByTicketId(String ticketId);
}