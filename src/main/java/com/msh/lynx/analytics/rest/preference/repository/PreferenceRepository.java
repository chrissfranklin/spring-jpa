package com.msh.lynx.analytics.rest.preference.repository;

import com.msh.lynx.analytics.rest.preference.entity.PreferenceEntity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository
  extends JpaRepository<PreferenceEntity, Long>
{

  //@PersistenceContext
  //EntityManager entityManager;

  // SELECT
  ArrayList<PreferenceEntity> findAll(); // only used for testing

  public abstract ArrayList<PreferenceEntity> findAllByUserId(Long userId);

  ArrayList<PreferenceEntity> findByUserIdAndPracticeId(int userId, int practiceId);

  ArrayList<PreferenceEntity> findByUserIdAndPracticeIdAndReportName(int userId, int practiceId, String reportName);

  ArrayList<PreferenceEntity> findByUserIdAndPracticeIdAndReportNameAndPreferenceName(int userId, int practiceId, String reportName, String preferenceName);

  ArrayList<PreferenceEntity> findByUserIdAndPracticeIdAndReportNameAndPreferenceNameAndPreferenceValue(int userId, int practiceId, String reportName, String preferenceName, String preferenceValue);

  @Transactional
  @Modifying
  @Query("UPDATE PreferenceEntity p SET p.preferenceValue = ?1 WHERE p.id = ?2")
  void updatePreferenceValue(String preferenceValue, Long id);
}