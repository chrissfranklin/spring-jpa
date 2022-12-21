package com.msh.lynx.analytics.rest.preference.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="t_preference")
public class PreferenceEntity implements java.io.Serializable
{
  @javax.persistence.Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name="user_id")
  private int userId;

  @Column(name="practice_id")
  private int practiceId;

  @Column(name="report_name")
  private String reportName;

  @Column(name="preference_name")
  private String preferenceName;

  @Column(name="preference_value")
  private String preferenceValue;

  public Long getId()
  {
    return id;
  }

  public void setId(Long id)
  {
    this.id = id;
  }

}
