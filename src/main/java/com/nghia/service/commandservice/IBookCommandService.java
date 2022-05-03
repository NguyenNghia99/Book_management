package com.nghia.service.commandservice;

import com.nghia.entity.Book;

import java.util.List;

public interface IBookCommandService {

	Book createBook(Book bookRequest);

	Book updateBook(Integer bookId, Book bookRequest);

	Book updateBookByCode(String code, Book bookRequest);

	Boolean deleteBook(Integer bookId, Boolean deleteBook);

	Boolean deleteBookByCode(String code, Boolean deleteBook);

	List<Book> findAllByUidIn(List<Integer> listIds);
}
