package com.selfdeveloped.jpa.one_to_many.one_to_many_bidirectional;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "library",  cascade = CascadeType.ALL)
    private Set<Book> books;
}