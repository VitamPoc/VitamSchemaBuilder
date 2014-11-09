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
 * Main package for the description of one Level (one item/node in the DAG).
 *
 */
@JsonPropertyOrder({"xmlRefId", "levelDescriptiveMetadataFile", "messageId", "xmlId", "levelManagementMetadataContent", "levelDescriptiveMetadataContent", "restrictedLevelDescriptiveMetadataContent", "levelDescriptiveMetadata", "levelDescriptiveMetadataReference", "dataObjectReference"})
public class LevelDescriptiveMetadata extends AbstractInformationType {
    /**
     * Option 1) This Level is already described in the same transfer somewhere else
     */
    final String xmlRefId;
    /**
     * Option 2) This level is defined in a specific file.
     * 
     * File is listed in BinaryDataObjects list
     */
    final FileId levelDescriptiveMetadataFile;
    /**
     * Optional: in case this level is in an independent file, describing the ArchiveTransfer file reference and its own reference
     */
    MessageIdentifier messageId;
    /**
     * Xml Id
     */
    final String xmlId;
    
    /**
     * Management metadata for Level
     */
    public static class LevelManagementMetadataContent extends AbstractInformationType {
        /**
         * Storage Rules
         */
        StorageRule storageRule;
        /**
         * Appraisal Rules
         */
        AppraisalRule appraisalRule;
        /**
         * Access Restriction Rules
         */
        AccessRestrictionRule accessRestrictionRule;
        /**
         * Dissemination Restriction Rules
         */
        DisseminationRestrictionRule disseminationRestrictionRule;
        /**
         * Reuse Restriction Rules
         */
        ReuseRestrictionRule reuseRestrictionRule;
        /**
         * Classification Rules
         */
        ClassificationRule classificationRule;
        /**
         * Level Creation Control
         */
        LevelCreationControl levelCreationControl;
        /**
         * @return the storageRule
         */
        public StorageRule getStorageRule() {
            return storageRule;
        }
        /**
         * @param storageRule the storageRule to set
         * @return This
         */
        public LevelManagementMetadataContent setStorageRule(StorageRule storageRule) {
            this.storageRule = storageRule;
            return this;
        }
        /**
         * @return the appraisalRule
         */
        public AppraisalRule getAppraisalRule() {
            return appraisalRule;
        }
        /**
         * @param appraisalRule the appraisalRule to set
         * @return This
         */
        public LevelManagementMetadataContent setAppraisalRule(AppraisalRule appraisalRule) {
            this.appraisalRule = appraisalRule;
            return this;
        }
        /**
         * @return the accessRestrictionRule
         */
        public AccessRestrictionRule getAccessRestrictionRule() {
            return accessRestrictionRule;
        }
        /**
         * @param accessRestrictionRule the accessRestrictionRule to set
         * @return This
         */
        public LevelManagementMetadataContent setAccessRestrictionRule(AccessRestrictionRule accessRestrictionRule) {
            this.accessRestrictionRule = accessRestrictionRule;
            return this;
        }
        /**
         * @return the disseminationRestrictionRule
         */
        public DisseminationRestrictionRule getDisseminationRestrictionRule() {
            return disseminationRestrictionRule;
        }
        /**
         * @param disseminationRestrictionRule the disseminationRestrictionRule to set
         * @return This
         */
        public LevelManagementMetadataContent setDisseminationRestrictionRule(DisseminationRestrictionRule disseminationRestrictionRule) {
            this.disseminationRestrictionRule = disseminationRestrictionRule;
            return this;
        }
        /**
         * @return the reuseRestrictionRule
         */
        public ReuseRestrictionRule getReuseRestrictionRule() {
            return reuseRestrictionRule;
        }
        /**
         * @param reuseRestrictionRule the reuseRestrictionRule to set
         * @return This
         */
        public LevelManagementMetadataContent setReuseRestrictionRule(ReuseRestrictionRule reuseRestrictionRule) {
            this.reuseRestrictionRule = reuseRestrictionRule;
            return this;
        }
        /**
         * @return the classificationRule
         */
        public ClassificationRule getClassificationRule() {
            return classificationRule;
        }
        /**
         * @param classificationRule the classificationRule to set
         * @return This
         */
        public LevelManagementMetadataContent setClassificationRule(ClassificationRule classificationRule) {
            this.classificationRule = classificationRule;
            return this;
        }
        /**
         * @return the levelCreationControl
         */
        public LevelCreationControl getLevelCreationControl() {
            return levelCreationControl;
        }
        /**
         * @param levelCreationControl the levelCreationControl to set
         * @return This
         */
        public LevelManagementMetadataContent setLevelCreationControl(LevelCreationControl levelCreationControl) {
            this.levelCreationControl = levelCreationControl;
            return this;
        }
        
    }
    /**
     * Management metadata for Level
     */
    final LevelManagementMetadataContent levelManagementMetadataContent;
    
    /**
     * Descriptive Metadata for this Level (publicly available)
     */
    LevelDescriptiveMetadataContent levelDescriptiveMetadataContent;
    /**
     * Restricted Descriptive Metadata for this Level (access restricted)
     */
    LevelDescriptiveMetadataContent restrictedLevelDescriptiveMetadataContent;
    
    // Sub choice 1
    // Nothing so null everywhere below
    // Sub choice 2
    /**
     * Option 0) No sub levels defined (NullObject), which means only classification plan is managed (no archives)
     * 
     * Option 1) Next levels below this one (sub folders) described in the XML/Json files of this ArchiveTransfer
     */
    List<LevelDescriptiveMetadata> levelDescriptiveMetadata;
    /**
     * Option 2) Next levels below this one but already in the AES (so querying to find them)
     */
    List<BooleanQuery> levelDescriptiveMetadataReference;
    /**
     * Option 3) Data Object references (might be simple reference or group reference)
     */
    List<DataObjectReference> dataObjectReference;
    /**
     * @param xmlRefId
     */
    public LevelDescriptiveMetadata(String xmlRefId) {
        this.xmlRefId = xmlRefId;
        this.levelDescriptiveMetadataFile = null;
        this.messageId = null;
        this.xmlId = null;
        this.levelManagementMetadataContent = null;
        this.levelDescriptiveMetadataContent = null;
        this.restrictedLevelDescriptiveMetadataContent = null;
    }
    /**
     * @param levelDescriptiveMetadataFile
     */
    public LevelDescriptiveMetadata(FileId levelDescriptiveMetadataFile) {
        this.xmlRefId = null;
        this.levelDescriptiveMetadataFile = levelDescriptiveMetadataFile;
        this.messageId = null;
        this.xmlId = null;
        this.levelManagementMetadataContent = null;
        this.levelDescriptiveMetadataContent = null;
        this.restrictedLevelDescriptiveMetadataContent = null;
    }
    /**
     * @param messageId
     * @param xmlId
     * @param levelManagementMetadataContent 
     * @param levelDescriptiveMetadataContent
     * @param restrictedLevelDescriptiveMetadataContent
     */
    public LevelDescriptiveMetadata(MessageIdentifier messageId, String xmlId,
            LevelManagementMetadataContent levelManagementMetadataContent,
            LevelDescriptiveMetadataContent levelDescriptiveMetadataContent,
            LevelDescriptiveMetadataContent restrictedLevelDescriptiveMetadataContent) {
        this.xmlRefId = null;
        this.levelDescriptiveMetadataFile = null;
        this.messageId = messageId;
        this.xmlId = xmlId;
        if (levelManagementMetadataContent == null) {
            this.levelManagementMetadataContent = new LevelManagementMetadataContent();
        } else {
            this.levelManagementMetadataContent = levelManagementMetadataContent;
        }
        this.levelDescriptiveMetadataContent = levelDescriptiveMetadataContent;
        this.restrictedLevelDescriptiveMetadataContent = restrictedLevelDescriptiveMetadataContent;
    }
    /**
     * @return the levelDescriptiveMetadataContent
     */
    public LevelDescriptiveMetadataContent getLevelDescriptiveMetadataContent() {
        return levelDescriptiveMetadataContent;
    }
    /**
     * @param levelDescriptiveMetadataContent the levelDescriptiveMetadataContent to set
     * @return This
     */
    public LevelDescriptiveMetadata setLevelDescriptiveMetadataContent(LevelDescriptiveMetadataContent levelDescriptiveMetadataContent) {
        this.levelDescriptiveMetadataContent = levelDescriptiveMetadataContent;
        return this;
    }
    /**
     * @return the restrictedLevelDescriptiveMetadataContent
     */
    public LevelDescriptiveMetadataContent getRestrictedLevelDescriptiveMetadataContent() {
        return restrictedLevelDescriptiveMetadataContent;
    }
    /**
     * @param restrictedLevelDescriptiveMetadataContent the restrictedLevelDescriptiveMetadataContent to set
     * @return This
     */
    public LevelDescriptiveMetadata setRestrictedLevelDescriptiveMetadataContent(LevelDescriptiveMetadataContent restrictedLevelDescriptiveMetadataContent) {
        this.restrictedLevelDescriptiveMetadataContent = restrictedLevelDescriptiveMetadataContent;
        return this;
    }
    /**
     * @return the levelDescriptiveMetadata
     */
    public List<LevelDescriptiveMetadata> getLevelDescriptiveMetadata() {
        return levelDescriptiveMetadata;
    }
    /**
     * @param levelDescriptiveMetadatas the levelDescriptiveMetadata to set
     * @return This
     */
    public LevelDescriptiveMetadata setLevelDescriptiveMetadata(List<LevelDescriptiveMetadata> levelDescriptiveMetadatas) {
        this.levelDescriptiveMetadata = levelDescriptiveMetadatas;
        return this;
    }
    /**
     * @param levelDescriptiveMetadata the levelDescriptiveMetadata to add
     * @return This
     */
    public LevelDescriptiveMetadata addLevelDescriptiveMetadata(LevelDescriptiveMetadata levelDescriptiveMetadata) {
        if (this.levelDescriptiveMetadata == null) {
            this.levelDescriptiveMetadata = new LinkedList<LevelDescriptiveMetadata>();
        }
        this.levelDescriptiveMetadata.add(levelDescriptiveMetadata);
        return this;
    }
    /**
     * @return the levelDescriptiveMetadataReference
     */
    public List<BooleanQuery> getLevelDescriptiveMetadataReference() {
        return levelDescriptiveMetadataReference;
    }
    /**
     * @param levelDescriptiveMetadataReferences the levelDescriptiveMetadataReference to set
     * @return This
     */
    public LevelDescriptiveMetadata setLevelDescriptiveMetadataReference(List<BooleanQuery> levelDescriptiveMetadataReferences) {
        this.levelDescriptiveMetadataReference = levelDescriptiveMetadataReferences;
        return this;
    }
    /**
     * @param levelDescriptiveMetadataReference the levelDescriptiveMetadataReference to add
     * @return This
     */
    public LevelDescriptiveMetadata addLevelDescriptiveMetadataReference(BooleanQuery levelDescriptiveMetadataReference) {
        if (this.levelDescriptiveMetadataReference == null) {
            this.levelDescriptiveMetadataReference = new LinkedList<BooleanQuery>();
        }
        this.levelDescriptiveMetadataReference.add(levelDescriptiveMetadataReference);
        return this;
    }
    /**
     * @return the dataObjectReference
     */
    public List<DataObjectReference> getDataObjectReference() {
        return dataObjectReference;
    }
    /**
     * @param dataObjectReferences the dataObjectReference to set
     * @return This
     */
    public LevelDescriptiveMetadata setDataObjectReference(List<DataObjectReference> dataObjectReferences) {
        this.dataObjectReference = dataObjectReferences;
        return this;
    }
    /**
     * @param dataObjectReference the dataObjectReference to add
     * @return This
     */
    public LevelDescriptiveMetadata addDataObjectReference(DataObjectReference dataObjectReference) {
        if (this.dataObjectReference == null) {
            this.dataObjectReference = new LinkedList<DataObjectReference>();
        }
        this.dataObjectReference.add(dataObjectReference);
        return this;
    }
    /**
     * @return the xmlRefId
     */
    public String getXmlRefId() {
        return xmlRefId;
    }
    /**
     * @return the levelDescriptiveMetadataFile
     */
    public FileId getLevelDescriptiveMetadataFile() {
        return levelDescriptiveMetadataFile;
    }
    /**
     * @return the message
     */
    public MessageIdentifier getMessageId() {
        return messageId;
    }
    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(MessageIdentifier messageId) {
        this.messageId = messageId;
    }
    /**
     * @return the xmlId
     */
    public String getXmlId() {
        return xmlId;
    }
    /**
     * @return the levelManagementMetadataContent
     */
    public LevelManagementMetadataContent getLevelManagementMetadataContent() {
        return levelManagementMetadataContent;
    }
    
    /**
     * @return the storageRule
     */
    @JsonIgnore
    public StorageRule getStorageRule() {
        return levelManagementMetadataContent.getStorageRule();
    }
    /**
     * @param storageRule the storageRule to set
     * @return This
     */
    @JsonIgnore
    public LevelDescriptiveMetadata setStorageRule(StorageRule storageRule) {
        levelManagementMetadataContent.setStorageRule(storageRule);
        return this;
    }
    /**
     * @return the appraisalRule
     */
    @JsonIgnore
    public AppraisalRule getAppraisalRule() {
        return levelManagementMetadataContent.getAppraisalRule();
    }
    /**
     * @param appraisalRule the appraisalRule to set
     * @return This
     */
    @JsonIgnore
    public LevelDescriptiveMetadata setAppraisalRule(AppraisalRule appraisalRule) {
        levelManagementMetadataContent.setAppraisalRule(appraisalRule);
        return this;
    }
    /**
     * @return the accessRestrictionRule
     */
    @JsonIgnore
    public AccessRestrictionRule getAccessRestrictionRule() {
        return levelManagementMetadataContent.getAccessRestrictionRule();
    }
    /**
     * @param accessRestrictionRule the accessRestrictionRule to set
     * @return This
     */
    @JsonIgnore
    public LevelDescriptiveMetadata setAccessRestrictionRule(AccessRestrictionRule accessRestrictionRule) {
        levelManagementMetadataContent.setAccessRestrictionRule(accessRestrictionRule);
        return this;
    }
    /**
     * @return the disseminationRestrictionRule
     */
    @JsonIgnore
    public DisseminationRestrictionRule getDisseminationRestrictionRule() {
        return levelManagementMetadataContent.getDisseminationRestrictionRule();
    }
    /**
     * @param disseminationRestrictionRule the disseminationRestrictionRule to set
     * @return This
     */
    @JsonIgnore
    public LevelDescriptiveMetadata setDisseminationRestrictionRule(DisseminationRestrictionRule disseminationRestrictionRule) {
        levelManagementMetadataContent.setDisseminationRestrictionRule(disseminationRestrictionRule);
        return this;
    }
    /**
     * @return the reuseRestrictionRule
     */
    @JsonIgnore
    public ReuseRestrictionRule getReuseRestrictionRule() {
        return levelManagementMetadataContent.getReuseRestrictionRule();
    }
    /**
     * @param reuseRestrictionRule the reuseRestrictionRule to set
     * @return This
     */
    @JsonIgnore
    public LevelDescriptiveMetadata setReuseRestrictionRule(ReuseRestrictionRule reuseRestrictionRule) {
        levelManagementMetadataContent.setReuseRestrictionRule(reuseRestrictionRule);
        return this;
    }
    /**
     * @return the classificationRule
     */
    @JsonIgnore
    public ClassificationRule getClassificationRule() {
        return levelManagementMetadataContent.getClassificationRule();
    }
    /**
     * @param classificationRule the classificationRule to set
     * @return This
     */
    @JsonIgnore
    public LevelDescriptiveMetadata setClassificationRule(ClassificationRule classificationRule) {
        levelManagementMetadataContent.setClassificationRule(classificationRule);
        return this;
    }
    /**
     * @return the levelCreationControl
     */
    @JsonIgnore
    public LevelCreationControl getLevelCreationControl() {
        return levelManagementMetadataContent.getLevelCreationControl();
    }
    /**
     * @param levelCreationControl the levelCreationControl to set
     * @return This
     */
    @JsonIgnore
    public LevelDescriptiveMetadata setLevelCreationControl(LevelCreationControl levelCreationControl) {
        levelManagementMetadataContent.setLevelCreationControl(levelCreationControl);
        return this;
    }

}
