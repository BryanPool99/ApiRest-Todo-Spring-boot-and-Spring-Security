package com.todo.TodoList.service;

import com.todo.TodoList.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoService {
    //Declaracion de una lista para almacenar los todos en memoria
    private List<Todo> todoList = new ArrayList<>();
    //método para obtener todas las tareas
    public List<Todo> getAllTodos() {
        return todoList;
    }
    //método para agregar una tarea a la lista
    public Todo addTodo(Todo todo) {
        // Id simulado
        todo.setId((long) (todoList.size() + 1));
        todoList.add(todo);
        return todo;
    }
    //método para marcar como completada una tarea
    public Todo markTodosCompleted(Long todoId) {
        //bucle for each para encontrar el id de la tarea y poder setter el atributo completed
        for (Todo todo : todoList) {
            if (todo.getId().equals(todoId)) {
                todo.setCompleted(true);
                return todo;
            }
        }
        //excepcion si no se encuentra el id
        throw new NoSuchElementException("Todo not found");
    }
    //método para eliminar una tarea de la lista
    public void deleteTodo(Long todoId) {
        //Uso de expresion lambda
        todoList.removeIf(todo -> todo.getId().equals(todoId));
    }
}
