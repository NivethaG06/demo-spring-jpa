package com.demo.springjpa.repo;

import com.demo.springjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;


@SpringBootTest
class StudentRepositoryTest {


    @Autowired
    StudentRepository repo;
    @Test
    public void findAllPagination(){
        Pageable pageable =  PageRequest.of(0,3,
                Sort.by("first_name").ascending()
                        .and(Sort.by("last_name").ascending()));
        List<Student> list = repo.findAll(pageable).toList();
        int totalPages = repo.findAll(pageable).getTotalPages(); // total number of division eg : 5 / 3 = 2
        Long totalElemets = repo.findAll(pageable).getTotalElements(); //total no . of rows
    }

}