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

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * How long this item shall be highly restricted in access
 *
 */
@JsonPropertyOrder({"rule", "physicalDataObject", "preventInheritance", "refNonRuleId", "needAuthorization", "classificationLevel", "mention", "classificationOwner", "classificationReassessingDate"})
public class ClassificationRule extends AbstractRule {
    /**
     * Code describing the classification level
     */
    String classificationLevel;
    /**
     * Mention as "Special France"
     */
    String mention;
    /**
     * Classification owner
     */
    String classificationOwner;
    /**
     * Date at which the classification shall be reassessing
     */
    DateTime classificationReassessingDate;
    
    /**
     * @param preventInheritance
     * @param classificationLevel
     * @param mention
     * @param classificationOwner
     * @param classificationReassessingDate
     * @param needAuthorization
     */
    public ClassificationRule(boolean preventInheritance, 
            String classificationLevel, String mention, String classificationOwner, DateTime classificationReassessingDate,
            boolean needAuthorization) {
        super(preventInheritance, needAuthorization);
        this.classificationLevel = classificationLevel;
        this.mention = mention;
        this.classificationOwner = classificationOwner;
        this.classificationReassessingDate = classificationReassessingDate;
    }

    /**
     * @return the classificationLevel
     */
    public String getClassificationLevel() {
        return classificationLevel;
    }

    /**
     * @param classificationLevel the classificationLevel to set
     * @return This
     */
    public ClassificationRule setClassificationLevel(String classificationLevel) {
        this.classificationLevel = classificationLevel;
        return this;
    }

    /**
     * @return the mention
     */
    public String getMention() {
        return mention;
    }

    /**
     * @param mention the mention to set
     * @return This
     */
    public ClassificationRule setMention(String mention) {
        this.mention = mention;
        return this;
    }

    /**
     * @return the classificationOwner
     */
    public String getClassificationOwner() {
        return classificationOwner;
    }

    /**
     * @param classificationOwner the classificationOwner to set
     * @return This
     */
    public ClassificationRule setClassificationOwner(String classificationOwner) {
        this.classificationOwner = classificationOwner;
        return this;
    }

    /**
     * @return the classificationReassessingDate
     */
    public DateTime getClassificationReassessingDate() {
        return classificationReassessingDate;
    }

    /**
     * @param classificationReassessingDate the classificationReassessingDate to set
     * @return This
     */
    public ClassificationRule setClassificationReassessingDate(DateTime classificationReassessingDate) {
        this.classificationReassessingDate = classificationReassessingDate;
        return this;
    }

}
