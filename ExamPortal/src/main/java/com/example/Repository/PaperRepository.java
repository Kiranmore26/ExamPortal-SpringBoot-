package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entities.PaperEntity;
import com.example.Enum.Status;

@Repository
public interface PaperRepository extends JpaRepository<PaperEntity, Integer>
{

	List<PaperEntity> findByPaperStatus(Status active);

	PaperEntity findByPaperIdAndPaperStatus(Integer id, Status active);

}
