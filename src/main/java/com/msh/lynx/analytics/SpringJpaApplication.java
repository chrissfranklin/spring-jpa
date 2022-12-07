package com.msh.lynx.analytics;

//import com.msh.lynx.analytics.rest.inventoryvaluation.entity.InventoryValuationEntity;
//import com.msh.lynx.analytics.rest.inventoryvaluation.repository.InventoryValuationRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
@Slf4j
//@Configuration
//@ComponentScan
//@EntityScan("entity")
//@EnableAutoConfiguration(exclude = {  DataSourceAutoConfiguration.class })
//@EnableJpaRepositories("repository")
public class SpringJpaApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	//@Bean
	//public Docket productApi()
	//{
	//  return new Docket(DocumentationType.SWAGGER_2).select()
	//    .apis(RequestHandlerSelectors.basePackage("com.msh.lynx.analytics")).build();
	//}


	//@Bean
	//public Docket api() {
	//  return new Docket(DocumentationType.SWAGGER_2)
	//    .select()
	//    .apis(RequestHandlerSelectors.any())
	//    .paths(PathSelectors.any())
	//    .build();
	//}

	/*
	@Bean
	public CommandLineRunner run(InventoryValuationRepository repository)
	{
		log.info("TOP: JpaPocApplication.run() - generating sample data and inserting into repository...");
		return args -> repository.saveAll(generateSampleData());
	}
	*/


	/**
	 * Sample data for the InventoryValuationRepository
	 * @return
	 */
	/*
	private List<InventoryValuationEntity> generateSampleData()
	{
		Lorem lorem = LoremIpsum.getInstance();
		List<InventoryValuationEntity> inventoryValuationEntityList = new ArrayList<>();
		int i = 0;
		long max = 24 * 60 * 60 * 1000;
		Random random = new Random();
		while (i <= 6000) {
			int rand = random.nextInt(31) + 1;
			String myVal = lorem.getTitle(2, 5);
			for (int j = 0; j < rand; j++) {
				inventoryValuationEntityList.add
					(
						InventoryValuationEntity.builder()
							.adhocId(myVal)
							.owner(lorem.getWords(1, 4))
							.parentCustomerNumber(lorem.getWords(1, 4))
							.customerNumber(lorem.getWords(1, 4))
							.facility(lorem.getWords(1, 4))
							.itemId(lorem.getWords(1, 4))
							//.period(lorem.getWords(1, 4))
							.period("05-2021")
							.hcpc(lorem.getWords(1, 4))
							.itemCode(lorem.getWords(1, 4))
							//.catalogNumber(lorem.getWords(1, 4))
							//.itemGenericName(lorem.getWords(1, 4))
							//.materialNumber(lorem.getWords(1, 4))
							//.externalPrimaryId(lorem.getWords(1, 4))
							//.clinicalTrailId(lorem.getWords(1, 4))
							//.catPhysId(lorem.getWords(1, 4))
							//.sample(lorem.getWords(1, 4))
							//.compassionateCare(lorem.getWords(1, 4))
							//.patientOwned(lorem.getWords(1, 4))
							//.clinicalTrial(lorem.getWords(1, 4))
							//.physOwned(lorem.getWords(1, 4))
							//.beginningInventoryAmount(lorem.getWords(1, 4))
							//.beginningInventoryValue(lorem.getWords(1, 4))
							//.invUnit(lorem.getWords(1, 4))
							//.totalDispensedAmount(lorem.getWords(1, 4))
							//.totalDispensedValue(lorem.getWords(1, 4))
							//.restockAmount(lorem.getWords(1, 4))
							//.restockValue(lorem.getWords(1, 4))
							//.adjustedAmount(lorem.getWords(1, 4))
							//.adjustedValue(lorem.getWords(1, 4))
							//.practiceWasteAmount(lorem.getWords(1, 4))
							//.practiceWasteValue(lorem.getWords(1, 4))
							//.extTransferInAmount(lorem.getWords(1, 4))
							//.extTransferInValue(lorem.getWords(1, 4))
							//.extTransferOutAmount(lorem.getWords(1, 4))
							//.extTransferOutValue(lorem.getWords(1, 4))
							//.endingInventoryAmount(lorem.getWords(1, 4))
							//.endingUnitPrice(lorem.getWords(1, 4))
							//.endingUnitPriceType(lorem.getWords(1, 4))
							//.endingInventoryValue(lorem.getWords(1, 4))
							//.invMonth(lorem.getWords(1)) //.invMonth(this.getDouble())
							//.invYear(lorem.getWords(1)) // .invYear(this.getDouble())
							.build()

            // .code(lorem.getWords(1))
            // .description(lorem.getWords(3, 8))
            // .price(getDouble())
            // .tax(getDouble())
            // .start(getDouble())
            // .end(getDouble())
            // .total(getDouble())
            // .quantity(random.nextInt(3000) + 1)
            // .weight(random.nextInt(300) + 1)
            // .batchName(lorem.getWords(1, 2))
            // .batchCode(lorem.getWords(1))
            // .unit(lorem.getWords(1))
            // .brand(lorem.getWords(1, 4))
            // .qrCode(lorem.getWords(1))
            // .createDate(Instant.ofEpochSecond((random.nextInt(4) + 14) * max))
            // .build()

					);
			}
			i += rand;
		}
		Collections.shuffle(inventoryValuationEntityList);
		//System.out.println("Generated sample data of size (inventoryValuationEntityList): " + inventoryValuationEntityList.size());
		log.info("Generated sample data of size (inventoryValuationEntityList): " + inventoryValuationEntityList.size());
		return inventoryValuationEntityList;
	}
	*/

	private double getDouble()
	{
		Random random = new Random();
		double value = random.nextDouble() * Math.pow(10, random.nextInt(4) + 1);
		return Math.round(value * 100) / 100.0;
	}

}
