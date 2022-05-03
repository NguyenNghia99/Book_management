package com.nghia.repository.commandrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nghia.entity.Book;

@Repository
public interface IBookCommandRepository extends JpaRepository<Book, Integer> {
	Book findByUid(int uid);
	Book findByCode(String code);
	List<Book> findAllByUidIn(List<Integer> listIds);
//	List<Integer> getListUid();
//	List<String> getListCode();

}
