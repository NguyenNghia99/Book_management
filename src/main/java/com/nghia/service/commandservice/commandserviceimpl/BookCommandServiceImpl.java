package com.nghia.service.commandservice.commandserviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nghia.entity.Book;
import com.nghia.errorhandling.BookNotFoundException;
import com.nghia.repository.commandrepository.IBookCommandRepository;
import com.nghia.service.commandservice.IBookCommandService;

import java.util.List;

@Service
public class BookCommandServiceImpl implements IBookCommandService {

	@Autowired
	private IBookCommandRepository bookCommandRepository;


	@Override
	public Book createBook(Book bookRequest) {
		return bookCommandRepository.save(bookRequest);

	}

	@Override
	public Book updateBook(Integer bookId, Book bookRequest) {
		{
			Book book = bookCommandRepository.findByUid(bookId);
			if (book == null) {
				throw new BookNotFoundException("book is not exist");
			}


			return bookCommandRepository.save(book);
		}
	}

	@Override
	public Boolean deleteBook(Integer bookId, Boolean deleteBook) {
		Book book = bookCommandRepository.findByUid(bookId);
		if (book == null) {
			throw new BookNotFoundException("book is not exist");
		}
		bookCommandRepository.delete(book);
		return true;

	}

	@Override
	public Book updateBookByCode(String code, Book bookRequest) {
		Book book = bookCommandRepository.findByCode(code);
		if (book == null) {
			throw new BookNotFoundException("book is not exist");
		}

		return bookCommandRepository.save(book);
	}

	@Override
	public Boolean deleteBookByCode(String code, Boolean deleteBook) {
		Book book = bookCommandRepository.findByCode(code);
		if (book == null) {
			throw new BookNotFoundException("book is not exist");
		}
		bookCommandRepository.delete(book);
		return true;
	}

	@Override
	public List<Book> findAllByUidIn(List<Integer> listIds) {
		return bookCommandRepository.findAllByUidIn(listIds);
	}

}
