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
@RequestMapping("/api/preference")
public class PreferenceController
{
  @Autowired
  PreferenceService preferenceService;

  // FETCH
  @RequestMapping(value =
  {
    "/fetch/{userId}/{practiceId}/{reportName}"
  }, method = RequestMethod.GET)
  public ResponseEntity<String> getAllPreferences
  (
    HttpServletRequest request,
    @PathVariable("userId")     int userId,
    @PathVariable("practiceId") int practiceId,
    @PathVariable("reportName") String reportName
  )
  {
    log.trace("calling PreferenceService.findAllPreferenceByUserId()...");
    return this.preferenceService.findByUserIdAndPracticeIdAndReportName(request, userId, practiceId, reportName);
  }


  @RequestMapping(value =
  {
    "/fetch/all"
  }, method = RequestMethod.GET)
  public ResponseEntity<String> getAll
  (
    HttpServletRequest request
  )
  {
    log.trace("calling preferenceService.findAll()...");
    return this.preferenceService.findAll(request);
  }


  // SAVE
  @RequestMapping(value =
  {
    "/save/{userId}/{practiceId}/{reportName}/{preferenceName}/{preferenceValue}"
  }, method = RequestMethod.GET)
  public ResponseEntity<String> savePreference
  (
    HttpServletRequest request,
    @PathVariable("userId")          int userId,
    @PathVariable("practiceId")      int practiceId,
    @PathVariable("reportName")      String reportName,
    @PathVariable("preferenceName")  String preferenceName,
    @PathVariable("preferenceValue") String preferenceValue
  )
  {
    return this.preferenceService.savePreference(request, userId, practiceId, reportName, preferenceName, preferenceValue);
  }

}
