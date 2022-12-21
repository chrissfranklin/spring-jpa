package com.msh.lynx.analytics.rest.preference.service;

import com.msh.lynx.analytics.common.service.BaseService;
import com.msh.lynx.analytics.rest.preference.entity.PreferenceEntity;
import com.msh.lynx.analytics.rest.preference.repository.PreferenceRepository;
import com.msh.lynx.analytics.util.MyTimer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Service
@PropertySource("classpath:application.properties")
@Transactional
@Slf4j
@AllArgsConstructor
public class PreferenceService extends BaseService
{
  public static final String SPLUNK_EVENT_SQL_PREFERENCES_QUERY = "SPLUNK_EVENT_SQL_PREFERENCES_QUERY";

  public static final String SPLUNK_EVENT_SQL_PREFERENCES_CHECK_QUERY = "SPLUNK_EVENT_SQL_PREFERENCES_CHECK_QUERY";

  @Autowired
  private final PreferenceRepository preferenceRepository;

  public ArrayList<PreferenceEntity> findAllPreference()
  {
    return (ArrayList<PreferenceEntity>) preferenceRepository.findAll();
  }

  // test method
  public ResponseEntity<String> findAll(HttpServletRequest request)
  {
    ArrayList<PreferenceEntity> preferenceEntityList = this.preferenceRepository.findAll();
    log.trace("PreferenceService.getAll(): preferenceEntityList: " + preferenceEntityList.toString());
    return this.packageResponse(request, serialize(preferenceEntityList));
  }


  //public ArrayList<PreferenceEntity> findAllPreferenceByUserId(HttpServletRequest request, long userId)
  public ResponseEntity<String> findAllPreferenceByUserId(HttpServletRequest request, long userId)
  {
    log.trace("TOP: PreferenceService.getAllPreferences()...");
    MyTimer t = new MyTimer(); t.start();
    ArrayList<PreferenceEntity> preferenceEntityList = this.preferenceRepository.findAllByUserId(userId);
    long elapsedMillis = t.stop();

    log.debug(SPLUNK_EVENT_SQL_PREFERENCES_QUERY + ": PreferenceRepository.findAllByUserIdAndPracticeId(). userId: " +
      userId + ". MyTimer.elapsedMillis: " + elapsedMillis);

    // TODO: handle case where preferenceEntity is empty i.e. create new
    if(preferenceEntityList == null || preferenceEntityList.size() > 1) {
      log.error("No preference values found for userId: " + userId);
    }

    log.trace("PreferenceService.getAllPreferences(): preferenceEntityList: " + preferenceEntityList.toString());
    //return preferenceEntityList;
    return this.packageResponse(request, serialize(preferenceEntityList));
  }


  public ResponseEntity<String> findByUserIdAndPracticeIdAndReportName(HttpServletRequest request, int userId, int practiceId, String reportName)
  {
    log.trace("TOP: PreferenceService.getAllPreferences()...");
    MyTimer t = new MyTimer(); t.start();
    //ArrayList<PreferenceEntity> preferenceEntityList = this.preferenceRepository.findByUserIdAndPracticeId(userId, practiceId);
    ArrayList<PreferenceEntity> preferenceEntityList = this.preferenceRepository.findByUserIdAndPracticeIdAndReportName(userId, practiceId, reportName);
    long elapsedMillis = t.stop();

    log.debug(SPLUNK_EVENT_SQL_PREFERENCES_QUERY + ": PreferenceRepository.findAllByUserIdAndPracticeId(). userId: " +
      userId + ". MyTimer.elapsedMillis: " + elapsedMillis);

    // TODO: handle case where preferenceEntity is empty i.e. create new
    if(preferenceEntityList == null || preferenceEntityList.size() < 1) {
      log.error("No preference values found for userId: " + userId);
    }
    else {
      log.trace("preferenceEntityList size: : " + preferenceEntityList.size());
    }

    log.trace("PreferenceService.getAllPreferences(): preferenceEntityList: " + preferenceEntityList.toString());
    //return preferenceEntityList;
    return this.packageResponse(request, serialize(preferenceEntityList));
  }


  // private local helper
  private PreferenceEntity findByUserIdAndPracticeIdAndReportNameAndPreferenceName(int userId, int practiceId, String reportName, String preferenceName)
  {
    log.trace("TOP: PreferenceService.findByUserIdAndPracticeIdAndReportNameAndPreferenceName()...");
    MyTimer t = new MyTimer(); t.start();
    ArrayList<PreferenceEntity> existingPreferenceEntityList = this.preferenceRepository.findByUserIdAndPracticeIdAndReportNameAndPreferenceName(userId, practiceId, reportName, preferenceName);
    long elapsedMillis = t.stop();
    log.debug(SPLUNK_EVENT_SQL_PREFERENCES_CHECK_QUERY + ": PreferenceRepository.findByUserIdAndPracticeIdAndReportNameAndPreferenceName(). userId: " + userId + ". MyTimer.elapsedMillis: " + elapsedMillis);
    PreferenceEntity existingPreferenceEntity = null;
    if(existingPreferenceEntityList != null && existingPreferenceEntityList.size() > 0) {
      existingPreferenceEntity = existingPreferenceEntityList.get(0);
    }
    return existingPreferenceEntity;
  }


  // private local helper
  private PreferenceEntity findByUserIdAndPracticeIdAndReportNameAndPreferenceNameAndPreferenceValue(int userId, int practiceId, String reportName, String preferenceName, String preferenceValue)
  {
    log.trace("TOP: PreferenceService.findByUserIdAndPracticeIdAndReportNameAndPreferenceNameAndPreferenceValue()...");
    MyTimer t = new MyTimer(); t.start();
    ArrayList<PreferenceEntity> existingPreferenceEntityList = this.preferenceRepository.findByUserIdAndPracticeIdAndReportNameAndPreferenceNameAndPreferenceValue(userId, practiceId, reportName, preferenceName, preferenceValue);
    long elapsedMillis = t.stop();
    log.debug(SPLUNK_EVENT_SQL_PREFERENCES_CHECK_QUERY + ": PreferenceRepository.findByUserIdAndPracticeIdAndReportNameAndPreferenceNameAndPreferenceValue(). userId: " + userId + ". MyTimer.elapsedMillis: " + elapsedMillis);
    PreferenceEntity existingPreferenceEntity = null;
    if(existingPreferenceEntityList != null && existingPreferenceEntityList.size() > 0) {
      existingPreferenceEntity = existingPreferenceEntityList.get(0);
    }
    return existingPreferenceEntity;
  }


  public ResponseEntity<String> savePreference(HttpServletRequest request, int userId, int practiceId, String reportName, String preferenceName, String preferenceValue)
  {
    // first build the new preferencyEntity
    PreferenceEntity preferenceEntity = this.buildPreferenceObject(userId, practiceId, reportName, preferenceName, preferenceValue);

    // then check if this object already exists
    String rezult = "";
    //PreferenceEntity existingPreferenceEntity = this.findByUserIdAndPracticeIdAndReportNameAndPreferenceNameAndPreferenceValue(userId, practiceId, reportName, preferenceName, preferenceValue);
    PreferenceEntity existingPreferenceEntity = this.findByUserIdAndPracticeIdAndReportNameAndPreferenceName(userId, practiceId, reportName, preferenceName);
    if(existingPreferenceEntity == null) {
      log.trace("existingPreferenceEntity is empty - will proceed with preference value update...");
      this.preferenceRepository.save(preferenceEntity);
      rezult = "insert success";
    }
    else {
      log.trace("existingPreferenceEntity is not empty - will proceed with preferenceValue update if value has changed...");
      ///
      log.trace("checking values of preference....");
      log.trace("preferenceValue: " + preferenceValue);
      log.trace("preferenceEntity: " + preferenceEntity.toString());
      ///
      if(this.isPreferenceValueChanged(preferenceValue, existingPreferenceEntity)) {
        log.trace("preferenceValue has changed from '" + existingPreferenceEntity.getPreferenceValue() + "' to '" + preferenceValue + "'");
        this.preferenceRepository.updatePreferenceValue(preferenceValue, existingPreferenceEntity.getId());
      }
      else {
        log.trace("preferenceValue has not changed - will not update in db...");
        rezult = "no change";
      }
    }
    log.trace("rezult: " + rezult);
    return this.packageResponse(request, serialize(rezult)); // TODO: fix this?
  }

  // local helper to determine if the old and new preference values are different
  private boolean isPreferenceValueChanged(String value, PreferenceEntity entity)
  {
    boolean rezult = false;
    if(value != null && entity != null && entity.getPreferenceValue() != null) {
      if(!value.equals(entity.getPreferenceValue())) {
        rezult = true;
      }
    }
    return rezult;
  }


  // TODO: use .builder() syntax
  private PreferenceEntity buildPreferenceObject(int userId, int practiceId, String reportName, String preferenceName, String preferenceValue)
  {
    PreferenceEntity preferenceEntity = new PreferenceEntity();
    preferenceEntity.setUserId(userId);
    preferenceEntity.setPracticeId(practiceId);
    preferenceEntity.setReportName(reportName);
    preferenceEntity.setPreferenceName(preferenceName);
    preferenceEntity.setPreferenceValue(preferenceValue);
    log.trace("built preferenceEntity object: " + preferenceEntity);
    return preferenceEntity;
  }

}
