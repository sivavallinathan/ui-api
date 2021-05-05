package payload;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import org.apache.commons.lang3.Validate;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Representation of all transactions belonging to a specific institution that occurred in the specified time range.
 */
@Builder
public class TransactionBatch implements Serializable {

    private String institutionId;

    /** lower bound of the transactions time range, inclusive */
    private Long extractionStart;

    /** upper bound of the transactions time range, inclusive */
    private Long extractionEnd;

    private List<Transaction> transactions;

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        Validate.notNull(institutionId, "Institution ID cannot be null");
        this.institutionId = institutionId;
    }

    public Long getExtractionStart() {
        return extractionStart;
    }

    public void setExtractionStart(Long extractionStart) {
        Validate.notNull(extractionStart, "Extraction start time cannot be null");
        this.extractionStart = extractionStart;
    }

    public Long getExtractionEnd() {
        return extractionEnd;
    }

    public void setExtractionEnd(Long extractionEnd) {
        Validate.notNull(extractionEnd, "Extraction end time cannot be null");
        this.extractionEnd = extractionEnd;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        Validate.notNull(transactions, "Transaction list cannot be null");
        this.transactions = transactions;
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
