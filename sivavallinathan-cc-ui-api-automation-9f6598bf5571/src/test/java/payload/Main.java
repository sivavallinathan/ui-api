package payload;

import payload.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Main {
	public static void main(String[] args) throws ParseException {
		// new Main().sendMerchantBatch();
		new Main().sendTrasactionBatch();
		new Main().triggerSettlement();
	}

	@SuppressWarnings("deprecation")
	public void sendTrasactionBatch() throws ParseException {
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat crunchifyFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");
		String currentTime = crunchifyFormat.format(today);
		System.out.println("Current Time = " + currentTime);
		Date date = crunchifyFormat.parse(currentTime);
		long epochTime = date.getTime();
		long epoch1 = epochTime + 60000000;
		long epoch2 = epochTime - 60000000;
		System.out.println("Current Time in Epoch: " + epochTime);

		
		 String dbURI="mongodb://mongodb-cc-aks-qa-us-west:Y6XECBzDVjys52JiWjoaj3JBAAarwiZ6905DTqyIqNogjeWXOsisdfb8DQIXvqhuc3ahhpgpEaBj9M3RyHLRwA==@mongodb-cc-aks-qa-us-west.documents.azure.com:10250/?ssl=true";
		 MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
		 MongoDatabase dbs=mongoClient.getDatabase("settlement-config");
		 MongoCollection<Document> collection= dbs.getCollection("processing-record");
		 collection.drop();

		TsopSpecificData tsopSpecificData = TsopSpecificData.builder()
				.transactionId(86400000l)
				.transactionItemId(1l)
				.merchantId(1l)
				.terminalNumber(116l)
				.cardHolderId(0000000000000000333333l)
				.build();

		Transaction transaction = Transaction.builder()
				.cardNumber("1")
				.created(epoch2)
				.totalAmount("120")
				.itemAmount("120")
				.currency("USD")
				.debit(true)
				.tsopSpecificData(tsopSpecificData)
				.build();

		TransactionBatch batch = TransactionBatch.builder().institutionId("a201ac75-497b-4bae-885f-4d3ee5948a56")
				.extractionStart(1612188639000l).extractionEnd(epoch1).transactions(List.of(transaction)).build();

		TransactionServiceBusService transactionServiceBusService = new TransactionServiceBusService(Clock.systemUTC());
		transactionServiceBusService.sendBatch(batch);
	}

	public void sendMerchantBatch() {
		String INSTITUTION_ID = "a201ac75-497b-4bae-885f-4d3ee5948a56";
		MerchantSettlementConfigBatch batch = new MerchantSettlementConfigBatch();
		MerchantSettlementConfigDto dto = new MerchantSettlementConfigDto();
		String settlementType = "Special merchant";
		dto.setTsopMerchantId(1L);
		dto.setSettlementType(settlementType);
		dto.setEnabled(true);
		batch.setMerchants(Collections.singletonList(dto));
		batch.setInstitutionId(UUID.fromString(INSTITUTION_ID));

		MerchantBatchServiceBusService merchantBatchServiceBusService = new MerchantBatchServiceBusService(
				Clock.systemUTC());
		merchantBatchServiceBusService.sendBatch(batch);
	}

	public void triggerSettlement() {
		UUID batchUUID = UUID.randomUUID();

		TriggerSettlementServiceBusService triggerSettlementServiceBusService = new TriggerSettlementServiceBusService(
				Clock.systemUTC());
		triggerSettlementServiceBusService.sendBatch(batchUUID);
	}

}
