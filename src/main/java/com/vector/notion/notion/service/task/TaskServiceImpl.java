package com.vector.notion.notion.service.task;

import com.vector.notion.notion.dto.task.TaskRequest;
import com.vector.notion.notion.entity.Task;
import com.vector.notion.notion.utils.trie.Trie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private List<Task> taskList;

    private Trie taskTrie;

    @PostConstruct
    void init() {
        taskList = new ArrayList<>();
        taskTrie = new Trie();
    }

    @Override
    public Task createTask(TaskRequest request) {
        Task task = Task.builder().id(Long.valueOf(taskList.size())).createdAt(new Date())
                .title(request.getTitle()).description(request.getMessage()).userId(request.getUserId())
                .assignedTo(request.getAssignedTo()).dueDate(request.getDueDate()).build();
        taskList.add(task);
        taskTrie.insert(task.getTitle());
        return task;
    }

    @Override
    public List<Task> getTaskByAccountId(Long accountId) {
        return taskList.stream().filter(e -> e.getUserId().equals(accountId)).collect(Collectors.toList());
    }

    @Override
    public Task editTask(Long taskId, TaskRequest request) {
        for (Task task : taskList) {
            if (task.getId().equals(taskId)) {
                Task newTask = Task.builder().id(taskId).createdAt(task.getCreatedAt()).updatedAt(new Date())
                        .title(request.getTitle()).description(request.getMessage()).userId(request.getUserId())
                        .assignedTo(request.getAssignedTo()).dueDate(request.getDueDate()).build();
                taskList.remove(task);
                taskList.add(newTask);
                return newTask;
            }
        }

        return null;
    }

    @Override
    public List<String> searchTasksByNamePrefix(String prefix) {
        return taskTrie.searchByPrefix(prefix);
    }

}
