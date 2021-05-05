package payload;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.TopicClient;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import payload.MerchantSettlementConfigBatch;

import java.net.URI;
import java.time.Clock;

/** Provides access to the "servicebus.tsopTransactions" topic and subscription. */
public class MerchantBatchServiceBusService {

    public static final URI TSOP_BATCH_EVENT_TYPE_URI = URI.create("/MerchantSettlementConfigBatch");
    public static final String TSOP_BATCH_PUBLISHER = "com.blackboard.transact.tsop.storedvalueagentplugin";

    private String batchConnectionString = "Endpoint=sb://sb-qa-us-west-cc-aks.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=dsLGfhoqcF6sS+x1ViyDF7KFms7IgEiMsVcJjfytmoY=;EntityPath=tsop-merchantbatch";

    private String batchSubscription = "tsop-merchantbatch/subscriptions/stored-value";

    private Clock clock;

    public MerchantBatchServiceBusService(Clock clock) {
        this.clock = clock;
    }

    public void sendBatch(MerchantSettlementConfigBatch batch) {
        ConnectionStringBuilder connectionStringBuilder = null;
        TopicClient sendClient = null;
        try {
            connectionStringBuilder = new ConnectionStringBuilder(batchConnectionString);
            sendClient = new TopicClient(connectionStringBuilder);
            String message = wrapMessageWithDomainEvent(batch.toString(), TSOP_BATCH_EVENT_TYPE_URI, TSOP_BATCH_PUBLISHER).toString();
            Message busMessage = new Message(message);
            sendClient.send(busMessage);
            System.out.println("Message successfully sent");
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
                .append("\"EventTypeUri\": \"").append(eventTypeUri).append("\",")
                .append("\"EventDateTime\": \"").append(clock.instant()).append("\",")
                .append("\"Publisher\": \"").append(publisher).append("\",")
                .append("\"Event\": ").append(message)
                .append("}");

        return sb.toString();
    }
}
