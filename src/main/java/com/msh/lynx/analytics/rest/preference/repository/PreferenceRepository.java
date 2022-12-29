package com.msh.lynx.analytics.rest.preference.repository;

import com.msh.lynx.analytics.rest.preference.entity.PreferenceItemEntity;
import java.util.ArrayList;
import java.util.Set;
import com.msh.lynx.analytics.rest.preference.entity.PreferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository
  extends JpaRepository<PreferenceEntity, Long>
{

  // SELECT
  ///
  //ArrayList<PreferenceEntity> findPreferenceEntitySetByUserIdAndPracticeId(int userId, int practiceId);
  //ArrayList<PreferenceEntity> findPreferenceEntitySetByUserIdAndPracticeIdAndPreferenceItemEntityList_ReportName(int userId, int practiceId, String reportName);
  ///

  //Set<PreferenceEntity> findPreferenceEntitySetByUserIdAndPracticeId(int userId, int practiceId);
  //Set<PreferenceEntity> findPreferenceEntitySetByUserIdAndPracticeIdAndPreferenceItemEntitySetReportName(int userId, int practiceId, String reportName);


  //( value =
  //  "SELECT * " +
  //  "FROM t_preference p " +
  //  "JOIN t_preference_item i ON p.id = i.preference_id " +
  //  "WHERE p.user_id     = :userId " +
  //  "AND   p.practice_id = :practiceId " +
  //  "AND   i.report_name = :reportName ", nativeQuery = true
  //)
  //
  @Query
  (
    value =
    "SELECT p " +
    "FROM PreferenceEntity p " +
    "JOIN FETCH p.preferenceItemEntitySet i " +
    "WHERE p.userId     = :userId " +
    "AND   p.practiceId = :practiceId " +
    "AND   i.reportName = :reportName "
  )
  Set<PreferenceEntity> findPreferenceEntitySetByUserIdAndPracticeIdAndPreferenceItemEntitySetReportName
  (
    @Param("userId")     int userId,
    @Param("practiceId") int practiceId,
    @Param("reportName") String reportName
  );

/*

  ArrayList<PreferenceEntitySet> findPreferenceEntitySetByPreferenceEntitySetId(int preferenceEntitySetId);

  ArrayList<PreferenceEntity> findPreferenceEntityByUserIdAndPracticeIdAndReportName(int userId, int practiceId, String reportName);

  ArrayList<PreferenceEntity> findAllPreferences(); // only used for testing

  public abstract ArrayList<PreferenceEntity> findPreferenceEntityByUserId(Long userId);

  ArrayList<PreferenceEntity> findByUserIdAndPracticeId(int userId, int practiceId);

  ArrayList<PreferenceEntity> findByUserIdAndPracticeIdAndReportName(int userId, int practiceId, String reportName);

  ArrayList<PreferenceEntity> findByUserIdAndPracticeIdAndReportNameAndPreferenceName(int userId, int practiceId, String reportName, String preferenceName);

  ArrayList<PreferenceEntity> findByUserIdAndPracticeIdAndReportNameAndPreferenceNameAndPreferenceValue(int userId, int practiceId, String reportName, String preferenceName, String preferenceValue);

  // UPDATE
  @Transactional
  @Modifying
  @Query("UPDATE PreferenceEntity p SET p.preferenceValue = ?1 WHERE p.id = ?2")
  void updatePreferenceValue(String preferenceValue, Long id);

*/

}