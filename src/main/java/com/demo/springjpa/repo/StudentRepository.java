package com.demo.springjpa.repo;

import com.demo.springjpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Meta;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);
    List<Student> findByLastNameNotNull();


    //JPQL
    @Query("SELECT s FROM Student s where s.emailid = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("SELECT s.firstName FROM Student s where s.emailid = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //NATIVE QUERY
    @Query(
            value = "SELECT s FROM Student s where s.emailid = ?1",
            nativeQuery = true
    )
    String getStudentByEmailAddressNative(String emailId);

    //NATIVE NAMED QUERY
    @Query(
            value = "SELECT s FROM Student s where s.emailid = :emailid",
            nativeQuery = true
    )
    String getStudentByEmailAddressNativeNamedParam(@Param("emailid") String emailId);


    @Modifying
    @Transactional
    @Query(
            value = "update Student set first_name = ?1 where email_id = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailAddress(String firstName,String emailId);

    Page<Student> getall(Pageable request);
}
