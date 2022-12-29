package com.msh.lynx.analytics.rest.preference.controller;

import com.msh.lynx.analytics.rest.preference.service.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@AllArgsConstructor
@RequestMapping("/api")
public class PreferenceController
{
  @Autowired
  PreferenceService preferenceService;

  //
  // FETCH
  //

  // Fetch a List of PreferenceEntity objects for the given userId, practiceId, and reportName
  // Used to fetch a list of all the preferences for the drop-down in UI of a given report
  @RequestMapping(value =
  {
    "/preference/fetch/{userId}/{practiceId}/{reportName}"
  }, method = RequestMethod.GET)
  public ResponseEntity<String> getPreferenceEntitySetByUserIdAndPracticeIdAndReportName
  (
    HttpServletRequest request,
    @PathVariable("userId")     int userId,
    @PathVariable("practiceId") int practiceId,
    @PathVariable("reportName") String reportName
  )
  {
    log.trace("calling PreferenceService.findPreferenceEntitySetByUserIdAndPracticeIdAndReportName()...");
    return this.preferenceService.findPreferenceEntitySetByUserIdAndPracticeIdAndReportName(request, userId, practiceId, reportName);
  }

/*
  // Fetch a List of PreferenceEntity objects by preferenceSetId and reportName
  @RequestMapping(value =
  {
    "/preferenceitem/fetch/{preferenceSetId}"
  }, method = RequestMethod.GET)
  public ResponseEntity<String> getPreferenceEntityListByPreferenceSetId
  (
    HttpServletRequest request,
    @PathVariable("preferenceSetId") int preferenceEntitySetId,
    @PathVariable("reportName")      String reportName
  )
  {
    log.trace("calling PreferenceService.findByPreferenceSetId()...");
    return this.preferenceService.findPreferenceEntityListByPreferenceSetId(request, preferenceEntitySetId);
  }


  // Fetch a List of PreferenceEntity objects by userId, practiceId, reportName
  @RequestMapping(value =
  {
    "/preferenceitem/fetch/{userId}/{practiceId}/{preferenceSetId}/{reportName}"
  }, method = RequestMethod.GET)
  public ResponseEntity<String> getPreferenceEntityListByUserIdAndPracticeIdAndReportName
  (
    HttpServletRequest request,
    @PathVariable("userId")     int userId,
    @PathVariable("practiceId") int practiceId,
    @PathVariable("reportName") String reportName
  )
  {
    log.trace("calling PreferenceService.findAllPreferenceByUserId()...");
    return this.preferenceService.findPreferenceEntityListByUserIdAndPracticeIdAndReportName(request, userId, practiceId, reportName);
  }


  @RequestMapping(value =
    {
      "/preferenceitem/fetch/all"
    }, method = RequestMethod.GET)
  public ResponseEntity<String> getAll(HttpServletRequest request)
  {
    log.trace("calling preferenceService.findAll()...");
    return this.preferenceService.findAllPreferences(request);
  }


  //
  // SAVE
  //

  // save PreferenceEntitySet value
  @RequestMapping(value =
  {
    "/preference/save/{userId}/{practiceId}/{preferenceSetName}"
  }, method = RequestMethod.GET)
  public ResponseEntity<String> savePreferenceSet
  (
    HttpServletRequest request,
    @PathVariable("userId")            int userId,
    @PathVariable("practiceId")        int practiceId,
    @PathVariable("preferenceSetName") String preferenceSetName
  )
  {
    log.trace("calling PreferenceService.savePreferenceSet()...");
    return this.preferenceService.savePreferenceSet(request, userId, practiceId,  preferenceSetName);
  }

  // save PreferenceEntity value
  @RequestMapping(value =
  {
    "/preferenceitem/save/{userId}/{practiceId}/{reportName}/{preferenceSetId}/{preferenceName}/{preferenceValue}"
  }, method = RequestMethod.GET)
  public ResponseEntity<String> savePreference
  (
    HttpServletRequest request,
    @PathVariable("userId")          int userId,
    @PathVariable("practiceId")      int practiceId,
    @PathVariable("preferenceSetId") int preferenceSetId,
    @PathVariable("reportName")      String reportName,
    @PathVariable("preferenceName")  String preferenceName,
    @PathVariable("preferenceValue") String preferenceValue
  )
  {
    log.trace("calling PreferenceService.savePreference()...");
    return this.preferenceService.savePreference(request, userId, practiceId, preferenceSetId, reportName, preferenceName, preferenceValue);
  }
*/
}
