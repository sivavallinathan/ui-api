package payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;

import java.io.IOException;
import java.io.Serializable;

/**
 * Note: when adding public methods do not forget to mark them {code}@JsonIgnore{code} or use {code}@JsonIgnoreProperties(ignoreUnknown = true){code}
 */
@Builder
public class TsopSpecificData implements Serializable {

    public static final long serialVersionUID = 1L;

    private Long transactionId;
    private Long transactionItemId;
    private Long merchantId;
    private Long terminalNumber;
    private Long cardHolderId;

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionItemId() {
        return transactionItemId;
    }

    public void setTransactionItemId(Long transactionItemId) {
        this.transactionItemId = transactionItemId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getTerminalNumber() {
        return terminalNumber;
    }

    public void setTerminalNumber(Long terminalNumber) {
        this.terminalNumber = terminalNumber;
    }

    public Long getCardHolderId() {
        return cardHolderId;
    }

    public void setCardHolderId(Long cardHolderId) {
        this.cardHolderId = cardHolderId;
    }

    @Override
    public String toString() {
        ObjectMapper mapperObj = new ObjectMapper();
        String json = null;
        try {
            json = mapperObj.writeValueAsString(this);
        }
        catch (JsonProcessingException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * Makes basic validity checks, e.g. that no mandatory field is missing its value.
     *
     * @return true if the TsopSpecificData object is supposed to be valid.
     */
    @JsonIgnore
    public boolean isValid() {
        return getTransactionId() != null &&
                getTransactionItemId() != null &&
                getMerchantId() != null &&
                getTerminalNumber() != null &&
                getCardHolderId() != null;
    }
}
