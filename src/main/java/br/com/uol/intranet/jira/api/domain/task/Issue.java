package br.com.uol.intranet.jira.api.domain.task;

import java.util.List;

public record Issue(List<TaskResponse> issues) {
}
