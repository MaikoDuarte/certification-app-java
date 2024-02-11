package com.maikoduarte.certification_nlw.modules.students.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.maikoduarte.certification_nlw.modules.students.entities.CertificationStudentEntity;

@Repository
public interface CertificationStudentRepository extends JpaRepository<CertificationStudentEntity, UUID> {

  @Query("SELECT FROM certifications c INNER JOIN c.studentEntity and std WHERE std.email = :email AND c.technology = :technlogy AND c.")
  List<CertificationStudentEntity> findByStudentEmailAndTechnology(String email, String technology);

  @Query("SELECT c from certifications c ODER BY c.grade DESC LIMIT 10")
  List<CertificationStudentEntity> findTop10ByOrderGradeDesc();



  


  
}
