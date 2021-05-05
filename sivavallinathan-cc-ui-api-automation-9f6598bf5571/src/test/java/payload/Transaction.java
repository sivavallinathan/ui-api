package payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;

import java.io.IOException;
import java.io.Serializable;

/**
 * Single transaction.
 * Comes from external system, currently only TSOP is supported.
 */
// Note: when adding public methods do not forget to mark them {code}@JsonIgnore{code}
// or use {code}@JsonIgnoreProperties(ignoreUnknown = true){code}
@Builder
public class Transaction implements Serializable {

    public static final long serialVersionUID = 1L;

    private String cardNumber;
    private Long created;
    private String totalAmount;
    private String itemAmount;
    private String currency;
    @JsonSerialize(using = NumericBooleanSerializer.class)
    private Boolean debit;
    private TsopSpecificData tsopSpecificData;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Long getCreated() {
        return created;
    }

    public void setCreated(Long created) {
        this.created = created;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(String itemAmount) {
        this.itemAmount = itemAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Boolean getDebit() {
        return debit;
    }

    public void isDebit(Boolean debit) {
        this.debit = debit;
    }

    public TsopSpecificData getTsopSpecificData() {
        return tsopSpecificData;
    }

    public void setTsopSpecificData(TsopSpecificData tsopSpecificData) {
        this.tsopSpecificData = tsopSpecificData;
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
     * @return true if the Transaction object is supposed to be valid.
     */
    @JsonIgnore
    public boolean isValid() {
        return getCardNumber() != null &&
                getCreated() != null &&
                getTotalAmount() != null &&
                getItemAmount() != null &&
                getCurrency() != null &&
                getDebit() != null &&
                getTsopSpecificData() != null && getTsopSpecificData().isValid();
    }
}