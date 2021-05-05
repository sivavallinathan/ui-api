package payload;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.util.Set;

/**
 * Holds various merchant identifiers which may belong to different groups (like TSOP merchant IDs).
 * In the context of settlement merchant is any entity that has a relation with an institution which requires
 * settlements to be generated for this merchant.
 */
public class MerchantIdentifiers {

    private Set<Long> tsopIDs;

    public Set<Long> getTsopIDs() {
        return tsopIDs;
    }

    public void setTsopIDs(Set<Long> tsopIDs) {
        this.tsopIDs = tsopIDs;
    }

    public boolean isEmpty() {
        return tsopIDs == null || tsopIDs.isEmpty();
    }

    @Override
    public String toString() {
        return new ReflectionToStringBuilder(this).toString();
    }
}
