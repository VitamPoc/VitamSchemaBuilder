package fr.gouv.vitam.schema;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * For one Rule (implying a duration), the associated start date if any
 *
 */
@JsonPropertyOrder({"refRuleId", "startDate"})
public class RuleApplication extends AbstractInformationType {
    /**
     * The rule id, which implies a duration and a reason
     */
    final String refRuleId;
    /**
     * Start date if any from which the duration has to be applied.
     * If null, means the refRuleId is applied without "end known time".
     */
    DateTime startDate;
    /**
     * @param refRuleId
     * @param startDate may be null
     */
    public RuleApplication(String refRuleId, DateTime startDate) {
        this.refRuleId = refRuleId;
        this.startDate = startDate;
    }
    /**
     * @return the startDate
     */
    public DateTime getStartDate() {
        return startDate;
    }
    /**
     * @param startDate the startDate to set
     * @return This
     */
    public RuleApplication setStartDate(DateTime startDate) {
        this.startDate = startDate;
        return this;
    }
    /**
     * @return the refRuleId
     */
    public String getRefRuleId() {
        return refRuleId;
    }
}