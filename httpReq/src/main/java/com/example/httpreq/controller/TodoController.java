package com.example.httpreq.controller;
import com.example.httpreq.model.Todo;
import org.springframework.web.bind.annotation. *;
import java.util.*;


@RestController
@RequestMapping("/todos")
@CrossOrigin(origins="")
public class TodoController {

    private ArrayList<Todo> todos = new ArrayList<>();
    private Long counter = 1L;

    @GetMapping
    public List<Todo> getTodos() {
        return todos;
    }
    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        todo.setId(counter ++);
        todos.add(todo);
        return todo;
    }
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        for (Todo t : todos) {
            if (t.getId().equals(id)) {
                t.setTitle(updatedTodo.getTitle());
                t.setCompleted(updatedTodo.isCompleted());
                return t;
            }
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void  deleteTodo(@PathVariable Long id) {
        todos.removeIf(t -> t.getId().equals(id));
    }
}
