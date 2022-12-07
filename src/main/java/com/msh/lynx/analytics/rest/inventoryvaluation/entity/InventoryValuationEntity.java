package com.msh.lynx.analytics.rest.inventoryvaluation.entity;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Instant;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
//@Data
@Entity
@Table(schema = "testdb", name = "fact_inv_valuation_cat")
public class InventoryValuationEntity
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private Long id;

  private String adhocId;
  private String owner;
  private String parentCustomerNumber;
  private String customerNumber;
  private String facility;
  private String itemId;
  private String period;
  private String hcpc;
  private String itemCode;
  /*
  private String catalogNumber;
  private String itemGenericName;
  private String materialNumber;
  private String externalPrimaryId;
  private String clinicalTrailId;
  private String catPhysId;
  private String sample;
  private String compassionateCare;
  private String patientOwned;
  private String clinicalTrial;
  private String physOwned;
  private String beginningInventoryAmount;
  private String beginningInventoryValue;
  private String invUnit;
  private String totalDispensedAmount;
  private String totalDispensedValue;
  private String restockAmount;
  private String restockValue;
  private String adjustedAmount;
  private String adjustedValue;
  private String practiceWasteAmount;
  private String practiceWasteValue;
  private String extTransferInAmount;
  private String extTransferInValue;
  private String extTransferOutAmount;
  private String extTransferOutValue;
  private String endingInventoryAmount;
  private String endingUnitPrice;
  private String endingUnitPriceType;
  private String endingInventoryValue;
  */

  @Basic
  private Instant createDate;

  @Override
  public boolean equals(Object o) {
    return this == o || o != null && getClass() == o.getClass() && EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }
}









  /*
  private String org;
  private String name;
  private String code;
  private String description;
  private double price;
  private double tax;
  private double start;
  private double end;
  private double total;
  private int quantity;
  private int weight;
  private String batchName;
  private String batchCode;
  private String unit;
  private String brand;
  private String qrCode;
  */






/*
SELECT (fiv.customer_number || fiv.item_id)                  adhocid,
       DECODE(fiv.med_owner, 'FACILITY', '*', '')            owner,
       fiv.parent_customer_number,
       fiv.customer_number                                   facility,
       fiv.item_id                                           item_id,
       fiv.period                                            period,
       fiv.jcode                                               hcpc,
       fiv.item_code                                           item_code,
       fiv.catalog_number                                                 catalog_number,
       fiv.item_description                                                item_generic_name,
       REGEXP_REPLACE(fiv.material_number, '^0+', '')          material_number,
       p.external_primary_id,
       CASE
           WHEN fiv.clinical_trial_id = -1 THEN NULL
           ELSE fiv.clinical_trial_id
           END                                               clinical_trial_id,
       CASE
           WHEN fiv.cat_phys_id_specific = -1 THEN NULL
           ELSE fiv.cat_phys_id_specific
           END                                               cat_phys_id,
       fiv.cat_sample                                        sample,
       fiv.cat_compassionate_care                            compassionate_care,
       fiv.cat_patient_specific                              patient_owned,
       fiv.cat_clinical_trial_specific                       clinical_trial,
       CASE
           WHEN fiv.cat_phys_id_specific = -1 THEN 'N'
           ELSE 'Y'
           END                                               phys_owned,
       fiv.beginning_inventory_quantity                      beginning_inventory_amt,
       CASE
           WHEN fiv.pat_id = -1 AND fiv.cat_patient_specific = 'Y' THEN 0
           ELSE fiv.beginning_inventory_value
           END                                               beginning_inventory_value,
       fiv.inv_unit                                            inv_unit,
       (fiv.patient_waste_quantity + fiv.dispensed_quantity) total_dispensed_amt,
       (fiv.patient_waste_value + fiv.dispensed_value)       total_dispensed_value,
       fiv.restock_quantity                                  restock_amt,
       fiv.restock_value                                     restock_value,
       fiv.adjusted_quantity                                 adjusted_amt,
       fiv.adjusted_value                                    adjusted_value,
       fiv.waste_quantity                                    practice_waste_amt,
       fiv.waste_value                                       practice_waste_value,
       fiv.ext_inbound_transfer_quantity                     ext_transfer_in_amt,
       fiv.ext_inbound_transfer_value                        ext_transfer_in_value,
       fiv.ext_outbound_transfer_quantity                    ext_transfer_out_amt,
       fiv.ext_outbound_transfer_value                       ext_transfer_out_value,
       fiv.ending_inventory_quantity                         ending_inventory_amt,
       CASE
           WHEN fiv.pat_id = -1 AND fiv.cat_patient_specific = 'Y' THEN 0
           ELSE fiv.ending_unit_price END                    ending_unit_price,
       fiv.ending_unit_price_logic                           ending_unit_price_type,
       CASE
           WHEN fiv.pat_id = -1 AND fiv.cat_patient_specific = 'Y' THEN 0
           ELSE fiv.ending_inventory_value END               ending_inventory_value
FROM fact_inv fiv
         --INNER JOIN mblynx2.item i ON (i.item_id = fiv.item_id)
         INNER JOIN mobitrg.dim_customer_current dc ON dc.c_customer_number = fiv.customer_number
         LEFT JOIN mblynx2.patient p ON (p.pat_id = fiv.pat_id AND p.cust_id = fiv.cust_id)
         --LEFT OUTER JOIN mobitrg.dim_product dp ON (i.material_number = dp.material_number AND dp.prod_cur_flag = 'Y')
ORDER BY fiv.parent_customer_number, fiv.customer_number, fiv.item_description, fiv.catalog_number, fiv.jcode;
*/
