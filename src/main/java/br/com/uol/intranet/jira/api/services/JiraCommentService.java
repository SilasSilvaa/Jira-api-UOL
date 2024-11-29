package br.com.uol.intranet.jira.api.services;

import br.com.uol.intranet.jira.api.domain.comment.Comment;
import br.com.uol.intranet.jira.api.domain.comment.CommentRequest;
import br.com.uol.intranet.jira.api.domain.comment.CommentResponse;
import br.com.uol.intranet.jira.api.repositories.JiraCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JiraCommentService implements JiraCommentRepository {

    private final WebClient webClient;

    @Override
    public Comment postComment(String task, String comment) {
        return webClient
                .post()
                .uri("/issue/" + task +"/comment")
                .bodyValue(new CommentRequest(comment))
                .retrieve()
                .bodyToMono(Comment.class)
                .block();
    }

    @Override
    public List<Comment> getComments(String task) {
        return webClient
                .get()
                .uri("/issue/" + task + "/comment")
                .retrieve()
                .bodyToMono(CommentResponse.class)
                .map(CommentResponse::comments)
                .block();
    }
}
