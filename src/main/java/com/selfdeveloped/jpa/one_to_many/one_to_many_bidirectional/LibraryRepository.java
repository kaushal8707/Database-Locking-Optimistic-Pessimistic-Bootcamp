package com.selfdeveloped.jpa.one_to_many.one_to_many_bidirectional;
import org.springframework.data.jpa.repository.JpaRepository;
public interface LibraryRepository extends JpaRepository<Library, Integer>{
}