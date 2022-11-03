package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TodoRestController {

    private final TodoRepository repository;

    public TodoRestController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    public Flux<Todo> letTodos() {
        return this.repository.findAll();
    }

    @GetMapping("/todos/{feito}")
    public Flux<Todo> lerByFeito(@PathVariable("feito") boolean feito) {
        return this.repository.findByFeito(feito);
    }

    @PostMapping("/todos")
    public Mono<Todo> criar(@RequestBody Todo todo) {
        return this.repository.save(todo);
    }

    @DeleteMapping("/todos/{id}")
    public Mono<Void> deletar(@PathVariable("id") String id) {
        return this.repository.deleteById(id);
    }

    @PutMapping("/todos/{id}")
    public Mono<Todo> atualizar(@PathVariable("id") String id) {
        return this.repository.findById(id)
            .map(todo -> new Todo(id, todo.titulo(), todo.descricao(), !todo.feito()))
            .flatMap(this.repository::save)
            .onTerminateDetach();
    }

}
