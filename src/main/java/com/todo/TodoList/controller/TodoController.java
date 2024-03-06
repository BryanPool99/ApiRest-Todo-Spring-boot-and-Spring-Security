package com.todo.TodoList.controller;

import com.todo.TodoList.entity.Todo;
import com.todo.TodoList.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    //Inyeccion de dependencias q inyectan a TodoService
    @Autowired
    private TodoService todoService;
    //Ssolicitud para obtener la lista de tareas
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
    //Solicitud para agregar una nueva tarea
    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }
    //Solicitud para marcar una tarea como completada
    @PatchMapping("/{todoId}/complete")
    public ResponseEntity<?> markTodoAsCompleted(@PathVariable Long todoId) {
        try {
            Todo completedTodo = todoService.markTodosCompleted(todoId);
            return ResponseEntity.ok(completedTodo);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Todo with ID " + todoId + " not found");
        }
    }
    //Solicitud para eliminar una tarea
    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
    }
}
