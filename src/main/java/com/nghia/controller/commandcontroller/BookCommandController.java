package com.nghia.controller.commandcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nghia.entity.Book;
import com.nghia.service.commandservice.IBookCommandService;


@RestController
@RequestMapping("/books")
public class BookCommandController {
	@Autowired
	private IBookCommandService bookCommandService;
	//create book
	@PostMapping("/create")
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book bookRequest) {
		return new ResponseEntity<>(bookCommandService.createBook(bookRequest), HttpStatus.CREATED);
	}
	// update book
	@PutMapping("edit/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable Integer bookId, @Valid @RequestBody Book bookRequest) {
		return new ResponseEntity<>(bookCommandService.updateBook(bookId, bookRequest), HttpStatus.OK);
	}
	// update book
	@PutMapping("editbycode/{code}")
	public ResponseEntity<Book> updateBookByCode(@PathVariable String code, @Valid @RequestBody Book bookRequest) {
		return new ResponseEntity<>(bookCommandService.updateBookByCode(code, bookRequest), HttpStatus.OK);
	}
	//delete book by id
	@DeleteMapping("delete/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable Integer bookId) {
		bookCommandService.deleteBook(bookId, true);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	//delete book by code
	@DeleteMapping("deletebycode/{code}")
	public ResponseEntity<Void> deleteBookByCode(@PathVariable String code) {
		bookCommandService.deleteBookByCode(code, true);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}


}
