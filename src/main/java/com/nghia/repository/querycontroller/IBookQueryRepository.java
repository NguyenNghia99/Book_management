package com.nghia.repository.querycontroller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nghia.entity.Book;

@Repository
public interface IBookQueryRepository extends JpaRepository<Book, Integer> {
	Book findByUid(int uid);

	Book findByCode(String code);

	List<Book> findByName(String name);

	List<Book> findByCategory(String category);

	List<Book> findByAuthor(String author);
}
