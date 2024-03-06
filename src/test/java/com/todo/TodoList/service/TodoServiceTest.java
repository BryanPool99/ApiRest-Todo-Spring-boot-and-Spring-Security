package com.todo.TodoList.service;

import com.todo.TodoList.entity.Todo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {
    @Mock
    private List<Todo> todoListMock;

    @InjectMocks
    private TodoService todoService;

    @Test
    public void testGetAllTodos_emptyList() {
        List<Todo> expectedTodoList = Collections.emptyList();

        when(todoService.getAllTodos()).thenReturn(expectedTodoList);
        List<Todo> actualTodoList = todoService.getAllTodos();

        assertEquals(expectedTodoList, actualTodoList);
    }
    @Test
    public void testGetAllTodos_withData() {
        Todo todo1 = new Todo("Buy milk", "Get a gallon of milk");
        Todo todo2 = new Todo("Clean the house", "Vacuuming, mopping, dusting");
        List<Todo> expectedTodoList = Arrays.asList(todo1, todo2);

        when(todoService.getAllTodos()).thenReturn(expectedTodoList);
        List<Todo> actualTodoList = todoService.getAllTodos();

        assertEquals(expectedTodoList, actualTodoList);
    }
    @Test
    public void testAddTodo() {
        Todo newTodo = new Todo("Fix the car", "Take the car to the mechanic");

        when(todoListMock.size()).thenReturn(0);

        Todo addedTodo = todoService.addTodo(newTodo);

        assertEquals(1, addedTodo.getId());
        assertEquals(newTodo, addedTodo);
    }
    @Test
    public void testMarkTaskAsCompleted() {
        Long todoId = 1L;
        Todo mockTodo = new Todo();
        mockTodo.setId(todoId);
        when(todoListMock.iterator()).thenReturn(List.of(mockTodo).iterator());

        Todo result = todoService.markTodosCompleted(todoId);

        assertEquals(true, result.isCompleted());
    }

    @Test
    public void testDeleteTodo() {
        Todo todoToDelete = new Todo();
        when(todoListMock.removeIf(any())).thenReturn(true);

        todoService.deleteTodo(1L);

        verify(todoListMock, times(1)).removeIf(any());
    }
}
