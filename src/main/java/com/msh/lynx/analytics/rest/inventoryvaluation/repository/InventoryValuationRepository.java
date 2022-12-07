package com.msh.lynx.analytics.rest.inventoryvaluation.repository;

//import com.msh.lynx.analytics.common.entity.EntityInterface;

import com.msh.lynx.analytics.rest.inventoryvaluation.entity.InventoryValuationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface InventoryValuationRepository extends JpaRepository<InventoryValuationEntity, Long>
{

  Page<InventoryValuationEntity> findAllByPeriod(Pageable pageable, String period);

  // find by period
  @Query
  (
    value = "SELECT * " +
    "FROM testdb.fact_inv_valuation_cat s " +
    "WHERE 1=1 " +
    "AND s.period = :period",
    nativeQuery = true
  )
  Page<InventoryValuationEntity> findInventoryValuationEntityListByPeriod
  (
    Pageable pageRequest,
    @Param("period") String period
  );


  // find by period and customerNUmberList
  @Query
  (
    value = "SELECT * " +
            "FROM testdb.fact_inv_valuation_cat s " +
            "WHERE 1=1 " +
            "AND s.period = :period " +
            "AND s.customerNumber IN :customerNumberList",
    nativeQuery = true
  )
  Page<InventoryValuationEntity> findInventoryValuationEntityListByPeriodAndCustomerNumberList
  (
    Pageable pageRequest,
    Collection<String> customerNumberList,
    @Param("period") String period
  );


  /*
  // findByPeriodAndCategories
  @Query
  (
    value = "SELECT * " +
            "FROM testdb.fact_inv_valuation_cat s " +
            "WHERE 1=1 " +
            "AND s.period = :period " +
            //"AND s.customerNumber in :customerNumberList",
            "AND s.cat_patient_specific        = :catPatientOwnedFlag " +
            "AND s.cat_phys_id_specific        = :catPhysicianOwnedFlag " +
            "AND s.cat_clinical_trial_specific = :catClinicalTrialFlag " +
            "AND s.cat_compassionate_care      = :catCompassionateCareFlag " +
            "AND s.cat_sample                  = :catSampleFlag ";
            //"AND s.med_owner = 'facility' THEN custom = 'Y'cat_patient_specific = :catPatientOwnedFlag " +
    nativeQuery = true
  )
  Page<InventoryValuationEntity> findInventoryValuationEntityListByPeriodAndCategories
  (
    Pageable pageRequest,
    Collection<String> customerNumberList,
    @Param("period") String period,
    @Param("catPatientOwnedFlag")      String catPatientOwnedFlag,
    @Param("catPhysicianOwnedFlag")    String catPhysicianOwnedFlag,
    @Param("catClinicalTrialFlag")     String catClinicalTrialFlag,
    @Param("catCompassionateCareFlag") String catCompassionateCareFlag,
    @Param("catSampleFlag")            String catSampleFlag,
    @Param("catCustomFlag")            String catCustomFlag
  );
  */

}

















//"SELECT id, adhocId, owner, parentCustomerNumber, facility, itemId, period, hcpc, itemCode " +
//"SELECT s " +
//"FROM fact_inv_valuation_cat s " +
//"WHERE 1=1 " +
//"AND s.period = :period"
  /*
  @Query
  (
    "SELECT s " +
    "FROM Sample s " +
    "WHERE s.org like %:text% " +
    "OR s.name like %:text% " +
    "OR s.code like %:text% " +
    "OR s.description like %:text% " +
    "OR s.batchName like %:text% " +
    "OR s.batchCode like %:text% " +
    "OR s.unit like %:text% " +
    "OR s.brand like %:text% " +
    "OR s.qrCode like %:text% " +
    "OR concat(s.id,'') like %:text% " +
    "OR concat(s.price,'') like %:text% " +
    "OR concat(s.tax,'') like %:text% " +
    "OR concat(s.start,'') like %:text% " +
    "OR concat(s.end,'') like %:text% " +
    "OR concat(s.total,'') like %:text% " +
    "OR concat(s.quantity,'') like %:text% "  +
    "OR concat(s.weight,'') like %:text% "
  )
  Page<InventoryValuationEntity> searchByText(String text, Pageable pageable);
  */
