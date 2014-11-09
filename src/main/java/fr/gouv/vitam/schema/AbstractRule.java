/**
 * This file is part of Vitam Project.
 * 
 * Copyright 2009, Frederic Bregier, and individual contributors by the @author tags. See the
 * COPYRIGHT.txt in the distribution for a full listing of individual contributors.
 * 
 * All Vitam Project is free software: you can redistribute it and/or modify it under the terms of
 * the GNU General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 * 
 * Vitam is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even
 * the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with Vitam . If not, see
 * <http://www.gnu.org/licenses/>.
 */

package fr.gouv.vitam.schema;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * General implementation of a Rule in Management properties
 *
 */
@JsonPropertyOrder({"rule", "physicalDataObject", "preventInheritance", "refNonRuleId", "needAuthorization"})
public abstract class AbstractRule extends AbstractInformationType {
    /**
     * List of rules to apply
     */
    final List<RuleApplication> rule = new LinkedList<RuleApplication>();
    /**
     * Shall we prevent inheritance of rules
     */
    boolean preventInheritance;
    /**
     * Shall we deactivate specific inherited rules
     */
    final List<String> refNonRuleId = new LinkedList<String>();
    /**
     * Shall this application of rules be done using specific authorization
     */
    boolean needAuthorization;
    /**
     * @param preventInheritance Shall we prevent inheritance of rules
     * @param needAuthorization Shall this application of rules be done using specific authorization
     */
    public AbstractRule(boolean preventInheritance, boolean needAuthorization) {
        this.preventInheritance = preventInheritance;
        this.needAuthorization = needAuthorization;
    }
    /**
     * @return Shall we prevent inheritance of rules
     */
    public boolean isPreventInheritance() {
        return preventInheritance;
    }
    /**
     * @param preventInheritance Shall we prevent inheritance of rules
     * @return This
     */
    public AbstractRule setPreventInheritance(boolean preventInheritance) {
        this.preventInheritance = preventInheritance;
        return this;
    }
    /**
     * @return Shall this application of rules be done using specific authorization
     */
    public boolean isNeedAuthorization() {
        return needAuthorization;
    }
    /**
     * @param needAuthorization Shall this application of rules be done using specific authorization
     * @return This
     */
    public AbstractRule setNeedAuthorization(boolean needAuthorization) {
        this.needAuthorization = needAuthorization;
        return this;
    }
    /**
     * @return the rules List of rules to apply
     */
    public List<RuleApplication> getRule() {
        return rule;
    }
    /**
     * @param rule Additional rule to apply
     * @return This
     */
    public AbstractRule addRule(RuleApplication rule) {
        this.rule.add(rule);
        return this;
    }
    /**
     * @return List of deactivate specific inherited rules
     */
    public List<String> getRefNonRuleId() {
        return refNonRuleId;
    }
    /**
     * @param refNonRuleId Additional deactivate specific inherited refRuleId
     * @return This
     */
    public AbstractRule addRefNonRuleId(String refNonRuleId) {
        this.refNonRuleId.add(refNonRuleId);
        return this;
    }
    
}
