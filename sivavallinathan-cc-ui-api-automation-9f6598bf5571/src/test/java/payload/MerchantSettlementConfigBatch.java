package payload;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class MerchantSettlementConfigBatch implements Serializable {

    /**
     * Event Type URI as defined by {@link com.bbtransact.core.messaging.DomainEvent}.
     * Should be set by sender. It's used by a message broker (currently Stream Analytics job)
     * for routing of the event/message to a proper target topic(s).
     */
    public static final String EVENT_TYPE_URI = "/MerchantSettlementConfigBatch";

    public static final long serialVersionUID = 1L;

    private UUID institutionId;
    private String campusName;
    private String systemCurrency;
    private String dbTimeZone;
    private String systemTimeZoneDisplayName;
    private String systemTimeZoneId;
    private List<MerchantSettlementConfigDto> merchants;

    public UUID getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(UUID institutionId) {
        this.institutionId = institutionId;
    }

    public List<MerchantSettlementConfigDto> getMerchants() {
        return merchants;
    }

    public void setMerchants(List<MerchantSettlementConfigDto> merchants) {
        this.merchants = merchants;
    }

    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    public String getSystemCurrency() {
        return systemCurrency;
    }

    public void setSystemCurrency(String systemCurrency) {
        this.systemCurrency = systemCurrency;
    }

    public String getDbTimeZone() {
        return dbTimeZone;
    }

    public void setDbTimeZone(String dbTimeZone) {
        this.dbTimeZone = dbTimeZone;
    }

    public String getSystemTimeZoneDisplayName() {
        return systemTimeZoneDisplayName;
    }

    public void setSystemTimeZoneDisplayName(String systemTimeZoneDisplayName) {
        this.systemTimeZoneDisplayName = systemTimeZoneDisplayName;
    }

    public String getSystemTimeZoneId() {
        return systemTimeZoneId;
    }

    public void setSystemTimeZoneId(String systemTimeZoneId) {
        this.systemTimeZoneId = systemTimeZoneId;
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
}
