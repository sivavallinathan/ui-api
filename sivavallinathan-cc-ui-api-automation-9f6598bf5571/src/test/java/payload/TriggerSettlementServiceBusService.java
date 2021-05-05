
package payload;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.TopicClient;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import payload.TransactionBatch;

import java.net.URI;
import java.time.Clock;
import java.util.UUID;

/** Provides access to the "servicebus.tsopTransactions" topic and subscription. */
public class TriggerSettlementServiceBusService {

    public static final URI TSOP_BATCH_EVENT_TYPE_URI = URI.create("/InitiateSettlement");
    public static final String TSOP_BATCH_PUBLISHER = "com.blackboard.transact.sp.settlementjob";

    private String batchConnectionString = "Endpoint=sb://sb-qa-us-west-cc-aks.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=dsLGfhoqcF6sS+x1ViyDF7KFms7IgEiMsVcJjfytmoY=;EntityPath=settlementjob-triggersettlement";

    private Clock clock;

    public TriggerSettlementServiceBusService(Clock clock) {
        this.clock = clock;
    }

    public void sendBatch(UUID batch) {
        ConnectionStringBuilder connectionStringBuilder = null;
        TopicClient sendClient = null;
        try {
            connectionStringBuilder = new ConnectionStringBuilder(batchConnectionString);
            sendClient = new TopicClient(connectionStringBuilder);
            String message = wrapMessageWithDomainEvent(batch.toString(), TSOP_BATCH_EVENT_TYPE_URI, TSOP_BATCH_PUBLISHER).toString();
            Message busMessage = new Message(message);
            sendClient.send(busMessage);
            System.out.println("Trigger settlement message successfully sent. Batch UUID:"+batch.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ServiceBusException e) {
            e.printStackTrace();
        } finally {
            try {
                sendClient.close();
            } catch (ServiceBusException e) {
                e.printStackTrace();
            }
        }


    }

    protected String wrapMessageWithDomainEvent(String message, URI eventTypeUri, String publisher) {
        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("\"Id\": \"").append(UUID.randomUUID()).append("\",")
                .append("\"CorrelationId\": ").append("null").append(",")
                .append("\"EventTypeUri\": \"").append(eventTypeUri).append("\",")
                .append("\"EventDateTime\": \"").append(clock.instant()).append("\",")
                .append("\"Context\": ").append("null").append(",")
                .append("\"Publisher\": \"").append(publisher).append("\",")
                .append("\"InstitutionId\": ").append("null").append(",")
                .append("\"ResourceUri\": ").append("null").append(",")
                .append("\"EventVersion\": \"").append("1.0.0").append("\",")
                .append("\"Event\": \"").append(message).append("\",")
                .append("\"EventUri\": ").append("null")
                .append("}");
        return sb.toString();
    }
}
