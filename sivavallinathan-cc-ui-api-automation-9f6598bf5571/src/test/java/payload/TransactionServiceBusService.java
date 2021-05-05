package payload;
import com.microsoft.azure.servicebus.Message;
import com.microsoft.azure.servicebus.TopicClient;
import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;
import com.microsoft.azure.servicebus.primitives.ServiceBusException;
import payload.TransactionBatch;

import java.net.URI;
import java.time.Clock;

/** Provides access to the "servicebus.tsopTransactions" topic and subscription. */
public class TransactionServiceBusService {

    public static final URI TSOP_BATCH_EVENT_TYPE_URI = URI.create("/StoredValueTransactionBatch");
    public static final String TSOP_BATCH_PUBLISHER = "com.blackboard.transact.tsop.storedvalueagentplugin";

    private String batchConnectionString = "Endpoint=sb://sb-qa-us-west-cc-aks.servicebus.windows.net/;SharedAccessKeyName=RootManageSharedAccessKey;SharedAccessKey=dsLGfhoqcF6sS+x1ViyDF7KFms7IgEiMsVcJjfytmoY=;EntityPath=tsop-transactionbatch";

    private String batchSubscription = "tsop-transactionbatch/subscriptions/stored-value";

    private Clock clock;

    public TransactionServiceBusService(Clock clock) {
        this.clock = clock;
    }

    public void sendBatch(TransactionBatch batch) {
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
