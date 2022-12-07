package com.msh.lynx.analytics.rest.inventoryvaluation.service;

//import com.msh.lynx.analytics.aop.Audit;
//import com.msh.lynx.analytics.aop.ValidateUser;

import com.msh.lynx.analytics.common.service.BaseService;
import com.msh.lynx.analytics.rest.inventoryvaluation.entity.InventoryValuationEntity;
import com.msh.lynx.analytics.rest.inventoryvaluation.repository.InventoryValuationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@PropertySource("classpath:application.properties")
//@Transactional(value = "primaryTransactionManager")
@Transactional
@Slf4j
public class InventoryValuationService
  extends BaseService
{
  @Autowired
  InventoryValuationRepository inventoryValuationRepository;

  //@ValidateUser
  //@Audit(reportName = ReportNameEntity.DAYS_INVENTORY_ON_HAND_LEVEL_1, reportAction = ReportActionEntity.READ)
  public ResponseEntity<String> getData
    (
      HttpServletRequest request,
      String             year,
      String             month,
      int                pageNumber,
      int                pageSize,
      String             sortBy,
      Sort.Direction     sortDirection,
      String             searchText,
      String             categories
    )
  {
    log.trace("TOP: InventoryValuationService.getData()...");
    PageRequest pageRequest = PageRequest.of(pageNumber-1, pageSize);
    //List<String> customerNumberList = this.getSiteCustomerNumberList(request);
    log.trace("pageRequest:        " + pageRequest);
    //log.trace("customerNumberList: " + customerNumberList);
    log.trace("year:               " + year);
    log.trace("month:              " + month);
    log.trace("sortBy:             " + sortBy);
    log.trace("sortDirection:      " + sortDirection);
    log.trace("searchText:         " + searchText);
    log.trace("categories:         " + categories);


    // Repository params:
    // required:
    //   - customerNumberList (header)
    //   - period (request)
    //   - (sortBy and sortDirection will always have a default or value)
    //   - categories will always have at least 1 value (not empty)
    // optional:
    //   - searchText


    // todo: validate period not empty and valid value
    String period = this.concatMonthYearToPeriod(month, year);
    log.trace("period: " + period);

    // category mappings:
    // standard           : (if no other field is Y)
    // patient-owned      : cat_patient-specific = 'Y'
    // physician-owned    : cat_phys_id_specific = 'Y'
    // clinical-trial     : cat_clinical_trial_specific = 'Y'
    // compassionate-care : cat_compassionate_care = 'Y'
    // sample             : cat_sample = 'Y'
    // custom             : med_owner = 'facility' (then 'Y')



    // todo: if categories has commas, then parse to List
    // List<String> categoryList = something.parseToList(",", categories);


    // todo: if searchText not empty




    Sort sort = Sort.by(Sort.Direction.ASC, "org").and(Sort.by(sortDirection, sortBy));
    PageRequest pageable = PageRequest.of(pageNumber, pageSize, sort);
    //return Strings.isBlank(searchText) ? repository.findAll(pageable) : repository.searchByText(searchText, pageable);

    //Page<InventoryValuationEntity> inventoryValuationEntityPage = this.inventoryValuationRepository.findAll(pageRequest);
    //log.trace("period: " + period);

    //Page<InventoryValuationEntity> inventoryValuationEntityPage = this.inventoryValuationRepository.findAllByPeriod(pageRequest, period);
    Page<InventoryValuationEntity> inventoryValuationEntityPage = this.inventoryValuationRepository.findInventoryValuationEntityListByPeriod(pageRequest, period);


      //this.inventoryValuationRepository.findInventoryValuation
      //  (
      //    pageRequest,
      //    //customerNumberList,
      //    period
      //    //month
      //    //filterText
      //  );
    log.trace("inventoryValuationEntityPage.size: " + inventoryValuationEntityPage.getSize());
    return this.packageResponse(request, serialize(inventoryValuationEntityPage));
  }

  // Private helper
  private String concatMonthYearToPeriod(String month, String year)
  {
    // TODO: validate year/month params
    String period = month + "-" + year;
    return period;
  }

}
