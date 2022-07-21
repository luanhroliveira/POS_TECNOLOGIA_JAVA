package br.com.luanhroliveira.atividade04.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book extends AbstractPersistable<Long> implements Serializable {

    private String name;

    @ManyToMany
    @JoinTable(name = "book_has_author", joinColumns =
        {@JoinColumn(name = "book_id")}, inverseJoinColumns =
        {@JoinColumn(name = "author_id")})
    private List<Author> authors = new ArrayList<>();

}