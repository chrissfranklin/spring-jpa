package com.msh.lynx.analytics.rest.preference.controller;

import com.msh.lynx.analytics.rest.preference.service.PreferenceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/preference")
public class PreferenceController
{
  @Autowired
  PreferenceService preferenceService;

  @RequestMapping(value =
  {
    "/select/{userId}/{practiceId}/{reportName}"
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
    return this.preferenceService.findAllPreferenceByUserId(request, userId);
  }



  @RequestMapping(value =
  {
    "/all"
  }, method = RequestMethod.GET)
  public ResponseEntity<String> getAll
  (
    HttpServletRequest request
  )
  {
    log.trace("calling preferenceService.findAll()...");
    return this.preferenceService.findAll(request);
  }

}
