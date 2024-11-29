package br.com.uol.intranet.jira.api.repositories;

import br.com.uol.intranet.jira.api.domain.comment.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JiraCommentRepository {
    Comment postComment(String task, String comment);
    List<Comment> getComments(String task);
}
