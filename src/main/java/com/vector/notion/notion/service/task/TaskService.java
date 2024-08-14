package com.vector.notion.notion.service.task;

import com.vector.notion.notion.dto.task.TaskRequest;
import com.vector.notion.notion.entity.Task;

import java.util.List;

public interface TaskService {

    Task createTask(TaskRequest request);

    List<Task> getTaskByAccountId(Long accountId);

    Task editTask(Long taskId, TaskRequest taskRequest);

    List<String> searchTasksByNamePrefix(String prefix);

}
