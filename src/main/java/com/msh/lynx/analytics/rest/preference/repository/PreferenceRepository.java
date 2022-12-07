package com.msh.lynx.analytics.rest.preference.repository;

import com.msh.lynx.analytics.rest.preference.entity.PreferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface PreferenceRepository extends JpaRepository<PreferenceEntity, Long>
{
  ArrayList<PreferenceEntity> findAll(); // only used for testing

  ArrayList<PreferenceEntity> findAllByUserId(Long userId);

  // insert new preference (userId, practiceId,

}