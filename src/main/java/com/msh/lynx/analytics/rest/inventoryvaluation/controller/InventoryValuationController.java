package com.msh.lynx.analytics.rest.inventoryvaluation.controller;

import com.msh.lynx.analytics.rest.inventoryvaluation.service.InventoryValuationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/inventoryvaluation")
@Slf4j
public class InventoryValuationController
{
  @Autowired
  InventoryValuationService inventoryValuationService;

  public static final int    DEFAULT_PAGE_SIZE = 10;
  public static final String EMPTY             = "";

  /**
   * Inventory Valuation
   * The underlying SQL query uses the list of customer (site) numbers (siteCustomerNumberList) that
   * the current user has access to.
   * Example service urls :
   *   /inventoryvaluation/2021/05
   *   /inventoryvaluation/2021/05?pageNumber=1&pageSize=10
   *   /inventoryvaluation/2021/05?pageNumber=1&pageSize=10&sortBy=customerName&sortDirection=DESC&searchText=&categories=
   * @param request
   * @param year
   * @param month
   * @param pageNumber
   * @param pageSize
   * @param sortBy
   * @param sortDirection
   * @param searchText
   * @param categories
   * @return ResponseEntity
   */
  @RequestMapping(value =
  {
    "/{year}/{month}"
  }, method = RequestMethod.GET)
  public ResponseEntity<String> getInventoryLevelValuation
  (
    HttpServletRequest request,
    @PathVariable("year")  String year,
    @PathVariable("month") String month,
    @RequestParam(name = "pageNumber",    defaultValue = "1")   Optional<Integer> pageNumber,
    @RequestParam(name = "pageSize",      defaultValue = "10")  Optional<Integer> pageSize,
    @RequestParam(name = "sortBy",        defaultValue = "id")  Optional<String>  sortBy,
    @RequestParam(name = "sortDirection", defaultValue = "ASC") Sort.Direction    sortDirection,
    @RequestParam(name = "searchText",    defaultValue = "")    Optional<String>  searchText,
    @RequestParam(name = "categories",    defaultValue = "")    Optional<String>  categories
  )
  {
    log.trace("calling inventoryValuationService.getInventoryValuationData()...");
    return this.inventoryValuationService.getData
    (
      request,
      year,
      month,
      pageNumber.orElse(1),
      pageSize.orElse(DEFAULT_PAGE_SIZE),
      sortBy.orElse(EMPTY),
      sortDirection,
      searchText.orElse(EMPTY),
      categories.orElse(EMPTY)
    );
  }

}
