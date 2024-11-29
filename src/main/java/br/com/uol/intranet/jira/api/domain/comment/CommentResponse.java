package br.com.uol.intranet.jira.api.domain.comment;


import java.util.List;

public record CommentResponse(List<Comment> comments) {
}
