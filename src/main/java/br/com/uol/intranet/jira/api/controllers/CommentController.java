package br.com.uol.intranet.jira.api.controllers;

import br.com.uol.intranet.jira.api.domain.comment.Comment;
import br.com.uol.intranet.jira.api.domain.comment.CommentRequest;
import br.com.uol.intranet.jira.api.services.JiraCommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("jira/comment")
@RequiredArgsConstructor
public class CommentController {
    private final JiraCommentService jiraService;

    @PostMapping("/{task}")
    public ResponseEntity<Comment> postComment(@PathVariable String task,
                                               @RequestBody @Valid CommentRequest comment,
                                               UriComponentsBuilder builder){

        Comment postedComment = jiraService.postComment(task, comment.body());

        var uri = builder.path("issue/comment/" + task + "/{id}").buildAndExpand(postedComment.id()).toUri();
        return ResponseEntity.created(uri).body(new Comment(postedComment.id(), postedComment.body()));
    }

    @GetMapping("/{task}")
    public ResponseEntity<List<Comment>> getComments(@PathVariable String task){

        List<Comment> comments = jiraService.getComments(task);

        return ResponseEntity.ok(comments);
    }
}
