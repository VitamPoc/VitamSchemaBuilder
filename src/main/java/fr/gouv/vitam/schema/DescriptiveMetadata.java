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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Core package of Descriptive Metadata
 *
 */
@JsonPropertyOrder({"messageId", "codeListVersions", "levelDescriptiveMetadata"})
public class DescriptiveMetadata extends AbstractInformationType {
    /**
     * Optional: Message identifier (useful if in a separate file than ArchiveTransfer package)
     */
    MessageIdentifier messageId;
    /**
     * Code List versions for Descriptive Metadata
     */
    @JsonPropertyOrder({"storageRuleCodeList", "appraisalRuleCodeList", "accessRestrictionRuleCodeList", "disseminationRestrictionRuleCodeList", "reuseRestrictionRuleCodeList", "classificationRuleCodeList"})
    public static class DescriptiveCodeListVersions extends AbstractInformationType {
        /**
         * Code list for storage rules
         */
        CodeList storageRuleCodeList;
        /**
         * Code list for appraisal rules
         */
        CodeList appraisalRuleCodeList;
        /**
         * Code list for access restriction rules
         */
        CodeList accessRestrictionRuleCodeList;
        /**
         * Code list for dissemination restriction rules
         */
        CodeList disseminationRestrictionRuleCodeList;
        /**
         * Code list for reuse restriction rules
         */
        CodeList reuseRestrictionRuleCodeList;
        /**
         * Code list for classification rules
         */
        CodeList classificationRuleCodeList;
        /**
         * @return the storageRuleCodeList
         */
        public CodeList getStorageRuleCodeList() {
            return storageRuleCodeList;
        }
        /**
         * @param storageRuleCodeList the storageRuleCodeList to set
         * @return This
         */
        public DescriptiveCodeListVersions setStorageRuleCodeList(CodeList storageRuleCodeList) {
            this.storageRuleCodeList = storageRuleCodeList;
            return this;
        }
        /**
         * @return the aAppraisalRuleCodeList
         */
        public CodeList getAppraisalRuleCodeList() {
            return appraisalRuleCodeList;
        }
        /**
         * @param appraisalRuleCodeList the aAppraisalRuleCodeList to set
         * @return This
         */
        public DescriptiveCodeListVersions setaAppraisalRuleCodeList(CodeList appraisalRuleCodeList) {
            this.appraisalRuleCodeList = appraisalRuleCodeList;
            return this;
        }
        /**
         * @return the accessRestrictionRuleCodeList
         */
        public CodeList getAccessRestrictionRuleCodeList() {
            return accessRestrictionRuleCodeList;
        }
        /**
         * @param accessRestrictionRuleCodeList the accessRestrictionRuleCodeList to set
         * @return This
         */
        public DescriptiveCodeListVersions setAccessRestrictionRuleCodeList(CodeList accessRestrictionRuleCodeList) {
            this.accessRestrictionRuleCodeList = accessRestrictionRuleCodeList;
            return this;
        }
        /**
         * @return the disseminationRestrictionRuleCodeList
         */
        public CodeList getDisseminationRestrictionRuleCodeList() {
            return disseminationRestrictionRuleCodeList;
        }
        /**
         * @param disseminationRestrictionRuleCodeList the disseminationRestrictionRuleCodeList to set
         * @return This
         */
        public DescriptiveCodeListVersions setDisseminationRestrictionRuleCodeList(CodeList disseminationRestrictionRuleCodeList) {
            this.disseminationRestrictionRuleCodeList = disseminationRestrictionRuleCodeList;
            return this;
        }
        /**
         * @return the reuseRestrictionRuleCodeList
         */
        public CodeList getReuseRestrictionRuleCodeList() {
            return reuseRestrictionRuleCodeList;
        }
        /**
         * @param reuseRestrictionRuleCodeList the reuseRestrictionRuleCodeList to set
         * @return This
         */
        public DescriptiveCodeListVersions setReuseRestrictionRuleCodeList(CodeList reuseRestrictionRuleCodeList) {
            this.reuseRestrictionRuleCodeList = reuseRestrictionRuleCodeList;
            return this;
        }
        /**
         * @return the classificationRuleCodeList
         */
        public CodeList getClassificationRuleCodeList() {
            return classificationRuleCodeList;
        }
        /**
         * @param classificationRuleCodeList the classificationRuleCodeList to set
         * @return This
         */
        public DescriptiveCodeListVersions setClassificationRuleCodeList(CodeList classificationRuleCodeList) {
            this.classificationRuleCodeList = classificationRuleCodeList;
            return this;
        }
    }
    /**
     * Code List versions for Descriptive Metadata
     */
    DescriptiveCodeListVersions codeListVersions = new DescriptiveCodeListVersions();
    /**
     * List of "root" of classification plan (roots of Tree in the DAG)
     */
    final List<LevelDescriptiveMetadata> levelDescriptiveMetadata = new LinkedList<LevelDescriptiveMetadata>();
    
    /**
     */
    public DescriptiveMetadata() {
    }
    /**
     * @param messageId
     */
    public DescriptiveMetadata(MessageIdentifier messageId) {
        this.messageId = messageId;
    }
    /**
     * @return the id
     */
    public MessageIdentifier getMessageId() {
        return messageId;
    }
    /**
     * @param messageId the id to set
     * @return This
     */
    public DescriptiveMetadata setMessageId(MessageIdentifier messageId) {
        this.messageId = messageId;
        return this;
    }
    /**
     * @return the levelDescriptiveMetadata
     */
    public List<LevelDescriptiveMetadata> getLevelDescriptiveMetadata() {
        return levelDescriptiveMetadata;
    }
    /**
     * @param levelDescriptiveMetadata the levelDescriptiveMetadata to set
     * @return This
     */
    public DescriptiveMetadata setLevelDescriptiveMetadata(List<LevelDescriptiveMetadata> levelDescriptiveMetadata) {
        this.levelDescriptiveMetadata.clear();
        this.levelDescriptiveMetadata.addAll(levelDescriptiveMetadata);
        return this;
    }
    /**
     * @param levelDescriptiveMetadata
     * @return This
     */
    public DescriptiveMetadata addLevelDescriptiveMetadata(LevelDescriptiveMetadata levelDescriptiveMetadata) {
        this.levelDescriptiveMetadata.add(levelDescriptiveMetadata);
        return this;
    }
    /**
     * @return the codeListVersions
     */
    public DescriptiveCodeListVersions getCodeListVersions() {
        return codeListVersions;
    }
    /**
     * @param codeListVersions the codeListVersions to set
     * @return This
     */
    public DescriptiveMetadata setCodeListVersions(DescriptiveCodeListVersions codeListVersions) {
        this.codeListVersions = codeListVersions;
        return this;
    }
    
    /**
     * @return the storageRuleCodeList
     */
    @JsonIgnore
    public CodeList getStorageRuleCodeList() {
        return codeListVersions.getStorageRuleCodeList();
    }
    /**
     * @param storageRuleCodeList the storageRuleCodeList to set
     * @return This
     */
    @JsonIgnore
    public DescriptiveMetadata setStorageRuleCodeList(CodeList storageRuleCodeList) {
        codeListVersions.setStorageRuleCodeList(storageRuleCodeList);
        return this;
    }
    /**
     * @return the aAppraisalRuleCodeList
     */
    @JsonIgnore
    public CodeList getAppraisalRuleCodeList() {
        return codeListVersions.getAppraisalRuleCodeList();
    }
    /**
     * @param appraisalRuleCodeList the aAppraisalRuleCodeList to set
     * @return This
     */
    @JsonIgnore
    public DescriptiveMetadata setaAppraisalRuleCodeList(CodeList appraisalRuleCodeList) {
        codeListVersions.setaAppraisalRuleCodeList(appraisalRuleCodeList);
        return this;
    }
    /**
     * @return the accessRestrictionRuleCodeList
     */
    @JsonIgnore
    public CodeList getAccessRestrictionRuleCodeList() {
        return codeListVersions.getAccessRestrictionRuleCodeList();
    }
    /**
     * @param accessRestrictionRuleCodeList the accessRestrictionRuleCodeList to set
     * @return This
     */
    @JsonIgnore
    public DescriptiveMetadata setAccessRestrictionRuleCodeList(CodeList accessRestrictionRuleCodeList) {
        codeListVersions.setAccessRestrictionRuleCodeList(accessRestrictionRuleCodeList);
        return this;
    }
    /**
     * @return the disseminationRestrictionRuleCodeList
     */
    @JsonIgnore
    public CodeList getDisseminationRestrictionRuleCodeList() {
        return codeListVersions.getDisseminationRestrictionRuleCodeList();
    }
    /**
     * @param disseminationRestrictionRuleCodeList the disseminationRestrictionRuleCodeList to set
     * @return This
     */
    @JsonIgnore
    public DescriptiveMetadata setDisseminationRestrictionRuleCodeList(CodeList disseminationRestrictionRuleCodeList) {
        codeListVersions.setDisseminationRestrictionRuleCodeList(disseminationRestrictionRuleCodeList);
        return this;
    }
    /**
     * @return the reuseRestrictionRuleCodeList
     */
    @JsonIgnore
    public CodeList getReuseRestrictionRuleCodeList() {
        return codeListVersions.getReuseRestrictionRuleCodeList();
    }
    /**
     * @param reuseRestrictionRuleCodeList the reuseRestrictionRuleCodeList to set
     * @return This
     */
    @JsonIgnore
    public DescriptiveMetadata setReuseRestrictionRuleCodeList(CodeList reuseRestrictionRuleCodeList) {
        codeListVersions.setReuseRestrictionRuleCodeList(reuseRestrictionRuleCodeList);
        return this;
    }
    /**
     * @return the classificationRuleCodeList
     */
    @JsonIgnore
    public CodeList getClassificationRuleCodeList() {
        return codeListVersions.getClassificationRuleCodeList();
    }
    /**
     * @param classificationRuleCodeList the classificationRuleCodeList to set
     * @return This
     */
    @JsonIgnore
    public DescriptiveMetadata setClassificationRuleCodeList(CodeList classificationRuleCodeList) {
        codeListVersions.setClassificationRuleCodeList(classificationRuleCodeList);
        return this;
    }

}
