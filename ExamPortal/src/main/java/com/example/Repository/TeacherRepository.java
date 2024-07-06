package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Entities.TeachersEntity;
import com.example.Enum.Status;

public interface TeacherRepository extends JpaRepository<TeachersEntity, Integer>
{

	List<TeachersEntity> findByTeacherStatus(Status active);

	TeachersEntity findByTeacherIdAndTeacherStatus(Integer id, Status active);

	List<TeachersEntity> findByTeacherNameAndTeacherStatus(String name, Status active);

	TeachersEntity findByTeacherIdAndTeacherStatus(TeachersEntity teachersId, Status active);

	
	
}
