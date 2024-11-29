package br.com.uol.intranet.jira.api.domain.comment;

import jakarta.validation.constraints.NotBlank;

public record CommentRequest(@NotBlank String body) {
}
