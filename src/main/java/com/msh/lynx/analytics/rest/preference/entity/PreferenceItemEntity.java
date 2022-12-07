package com.msh.lynx.analytics.rest.preference.entity;

import javax.persistence.*;

@Entity
@Table(name="t_preference_item")
public class PreferenceItemEntity
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "preference_item_generator")
  private Long id;

  @Column(name="preference_name")
  private String reportName;

  @Column(name="preference_value")
  private String preferenceValue;
}
