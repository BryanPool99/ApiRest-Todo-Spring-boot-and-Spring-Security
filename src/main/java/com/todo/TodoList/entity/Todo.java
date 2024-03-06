package com.todo.TodoList.entity;

import java.util.Objects;

public class Todo {
    //atributos de la entidad Todo
    private Long id;
    private String title;
    private String description;
    private boolean completed;
    //constructor vacio
    public Todo() {
    }
    //constructor para crear una tarea(solo necesito atributos de title y description)
    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }
    //métodos getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    //método para obtener el estado de la tarea como String
    public String getStatus() {
        return completed ? "Completada" : "Pendiente";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Todo todo = (Todo) obj;
        return id.equals(todo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
