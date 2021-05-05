package payload;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * Value object representing merchant settlement config to be used in the REST API.
 */
public class MerchantSettlementConfigDto implements Serializable {

    public static final long serialVersionUID = 1L;

    private Long tsopMerchantId;
    private String settlementType;
    private Boolean enabled;

    public Long getTsopMerchantId() {
        return tsopMerchantId;
    }

    public void setTsopMerchantId(Long tsopMerchantId) {
        this.tsopMerchantId = tsopMerchantId;
    }

    public String getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(String settlementType) {
        this.settlementType = settlementType;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
