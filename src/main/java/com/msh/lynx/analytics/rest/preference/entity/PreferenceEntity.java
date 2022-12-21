package com.msh.lynx.analytics.rest.preference.entity;

import lombok.*;

import javax.persistence.*;

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
  //@GeneratedValue(strategy = GenerationType.AUTO)
  //@GeneratedValue(strategy = GenerationType.SEQUENCE)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;

  //@Id
  //@JsonIgnore
  //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "preference_generator")
  //@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "preference_generator")
  //@Column(name="preference_id", unique = true, nullable = false)
  //private long preferenceId;

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


  //@OneToMany(mappedBy = "preference1")
  //private Set<PreferenceItemEntity> item1

  //public PreferenceEntity(long userId, long practiceId)
  //{
  //  this.userId     = userId;
  //  this.practiceId = practiceId;
  //}


}
