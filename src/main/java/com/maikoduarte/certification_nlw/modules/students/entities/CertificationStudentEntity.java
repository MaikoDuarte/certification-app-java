package com.maikoduarte.certification_nlw.modules.students.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "certifications")
@Builder
public class CertificationStudentEntity {
  @Id
  private UUID id;

  @Column(length = 100)
  private String tecnology;

  @Column(length = 100)
  private int grade;

  @Column(name = "student_id")
  private UUID studentID;

  @ManyToOne
  @JoinColumn(name = "student_id", insertable = false, updatable = false)
  @JsonManagedReference
  private StudentEntity studentEntity;

  @OneToMany
  @JoinColumn(name = "answer_certification_id", insertable = false, updatable = false)
  @JsonManagedReference
  List<AnswersCertificationsEntity> answerCertificationsEntities;

  @CreationTimestamp
  private LocalDateTime createdAt;

  
}
