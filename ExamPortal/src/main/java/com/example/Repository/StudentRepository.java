package com.example.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entities.StudentEntity;
import com.example.Enum.Status;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>
{

	List<StudentEntity> findBystudentStatus(Status active);

	StudentEntity findByStudentIdAndStudentStatus(Integer id, Status active);

	List<StudentEntity> findByStudentNameAndStudentStatus(String name, Status active);




	

}
