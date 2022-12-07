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


  // TODO
  //public void addPreference()
  //{}

  // TODO
  // public void deletePrefence()
  //{}

}
