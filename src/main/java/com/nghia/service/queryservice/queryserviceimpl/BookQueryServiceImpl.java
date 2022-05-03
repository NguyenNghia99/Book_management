package com.nghia.service.queryservice.queryserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nghia.entity.Book;
import com.nghia.errorhandling.BookNotFoundException;
import com.nghia.errorhandling.ValidationException;
import com.nghia.repository.querycontroller.IBookQueryRepository;
import com.nghia.service.queryservice.IBookQueryService;

@Service
public class BookQueryServiceImpl implements IBookQueryService {
	@Autowired
	private IBookQueryRepository bookQueryrepository;

	@Override
	public List<Book> getAllBooks() {
		List<Book> ouput = null;
		ouput = (List<Book>) bookQueryrepository.findAll();
		if (null == ouput) {
			throw new BookNotFoundException("no list");
		}

		return ouput;
	}

	@Override
	public Book getOne(int uid) {
		Book ouput = null;
		validation(uid);
		ouput = bookQueryrepository.findByUid(uid);
		if (null == ouput) {
			throw new BookNotFoundException("book is not exist");
		}
		return ouput;
	}

	private boolean validation(int bookId) {
		if (bookId < 1)
			throw new ValidationException("Invalid Book ID");
		return true;
	}

	@Override
	public Book findByCode(String code) {
		Book outPut = null;
		outPut = bookQueryrepository.findByCode(code);
		if (outPut == null) {
			throw new BookNotFoundException("Book with code is Not Found");
		}
		return outPut;
	}

	@Override
	public List<Book> findByName(String name) {
		List<Book> outPuts = null;
		outPuts = (List<Book>) bookQueryrepository.findByName(name);
		if (outPuts == null) {
			throw new BookNotFoundException("Book with name is  Not Found");
		}
		return outPuts;
	}

	@Override
	public List<Book> findByCategory(String category) {
		List<Book> outPuts = null;
		outPuts = (List<Book>) bookQueryrepository.findByCategory(category);
		if (outPuts == null) {
			throw new BookNotFoundException("Book with category is  Not Found");
		}
		return outPuts;
	}

	@Override
	public List<Book> findByAuthor(String author) {
		List<Book> outPuts = null;
		outPuts = (List<Book>) bookQueryrepository.findByAuthor(author);
		if (outPuts == null) {
			throw new BookNotFoundException("Book with author is  Not Found");
		}
		return outPuts;
	}

}
