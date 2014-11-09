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

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Main class for an ArchiveTransfer message
 *
 */
@JsonPropertyOrder({"date", "messageIdentifier", "archivalAgreement", "signature", "codeListVersions", "archivalAgency", "transferringAgency", "transferRequestReplyIdentifer", "dataObjectPackage"})
public class ArchiveTransfer extends AbstractInformationType {
    /**
     * Date of the build of this message
     */
    final DateTime date;
    /**
     * Identifier of this message
     */
    final String messageIdentifier;
    /**
     * Archival agreement code for this message
     */
    final String archivalAgreement;
    
    /**
     * Optional with format to define
     */
    AbstractInformationType signature;
    /**
     * Code lists for ArchiveTransfer
     */
    @JsonPropertyOrder({"digestAlgorithmCodeList", "replyCodeList"})
    public static class ArchiveTransferCodeListVersions extends AbstractInformationType {
        /**
         * Digest Algorithm Code list
         */
        CodeList digestAlgorithmCodeList;
        /**
         * Reply Code list
         */
        CodeList replyCodeList;

        /**
         * @return the digestAlgorithmCodeList
         */
        public CodeList getDigestAlgorithmCodeList() {
            return digestAlgorithmCodeList;
        }

        /**
         * @param digestAlgorithmCodeList the digestAlgorithmCodeList to set
         * @return This
         */
        public ArchiveTransferCodeListVersions setDigestAlgorithmCodeList(CodeList digestAlgorithmCodeList) {
            this.digestAlgorithmCodeList = digestAlgorithmCodeList;
            return this;
        }

        /**
         * @return the replyCodeList
         */
        public CodeList getReplyCodeList() {
            return replyCodeList;
        }

        /**
         * @param replyCodeList the replyCodeList to set
         * @return This
         */
        public ArchiveTransferCodeListVersions setReplyCodeList(CodeList replyCodeList) {
            this.replyCodeList = replyCodeList;
            return this;
        }
    }
    /**
     * Code lists for ArchiveTransfer
     */
    ArchiveTransferCodeListVersions codeListVersions;
    /**
     * 
     */
    private void checkCodeListVersions() {
        if (codeListVersions == null) {
            codeListVersions = new ArchiveTransferCodeListVersions();
        }
    }
    /**
     * @return the digestAlgorithmCodeList
     */
    @JsonIgnore
    public CodeList getDigestAlgorithmCodeList() {
        checkCodeListVersions();
        return codeListVersions.getDigestAlgorithmCodeList();
    }

    /**
     * @param digestAlgorithmCodeList the digestAlgorithmCodeList to set
     * @return This
     */
    public ArchiveTransfer setDigestAlgorithmCodeList(CodeList digestAlgorithmCodeList) {
        checkCodeListVersions();
        codeListVersions.setDigestAlgorithmCodeList(digestAlgorithmCodeList);
        return this;
    }

    /**
     * @return the replyCodeList
     */
    @JsonIgnore
    public CodeList getReplyCodeList() {
        checkCodeListVersions();
        return codeListVersions.getReplyCodeList();
    }

    /**
     * @param replyCodeList the replyCodeList to set
     * @return This
     */
    public ArchiveTransfer setReplyCodeList(CodeList replyCodeList) {
        checkCodeListVersions();
        codeListVersions.setReplyCodeList(replyCodeList);
        return this;
    }
    
    /**
     * Archival agency (receiver)
     */
    final Organization archivalAgency;
    /**
     * Transferring agency (sender)
     */
    final Organization transferringAgency;

    /**
     * Optional: Transfer Request reply identifier (to trace previous request)
     */
    String transferRequestReplyIdentifer;

    /**
     * DescriptiveMetadata Package
     */
    public static class DescriptiveMetadataPackage extends AbstractInformationType {
        /**
         * Option 1) File Id of file containing the DescriptiveMetadata
         * 
         * File is listed in BinaryDataObjects list
         */
        final FileId descriptiveFilePackage;
        /**
         * Option 2) the DescriptiveMetadata
         */
        final DescriptiveMetadata descriptiveMetadata;
        
        /**
         * @param descriptiveFilePackage
         */
        public DescriptiveMetadataPackage(FileId descriptiveFilePackage) {
            this.descriptiveFilePackage = descriptiveFilePackage;
            this.descriptiveMetadata = null;
        }
        /**
         * @param descriptiveMetadata
         */
        public DescriptiveMetadataPackage(DescriptiveMetadata descriptiveMetadata) {
            this.descriptiveFilePackage = null;
            this.descriptiveMetadata = descriptiveMetadata;
        }

        /**
         * @return the descriptiveFilePackage
         */
        public FileId getDescriptiveFilePackage() {
            return descriptiveFilePackage;
        }

        /**
         * @return the descriptiveMetadata
         */
        public DescriptiveMetadata getDescriptiveMetadata() {
            return descriptiveMetadata;
        }
    }
    
    /**
     * TechnicalMetadata Package
     */
    public static class TechnicalMetadataPackage extends AbstractInformationType {
        /**
         * Option 1) File Id of file containing the TechnicalMetadata
         * 
         * File is listed in BinaryDataObjects list
         */
        final FileId technicalFilePackage;
        /**
         * Option 2) the TechnicalMetadata
         */
        final TechnicalMetadata technicalMetadata;
        
        /**
         * @param technicalFilePackage
         */
        public TechnicalMetadataPackage(FileId technicalFilePackage) {
            this.technicalFilePackage = technicalFilePackage;
            this.technicalMetadata = null;
        }
        /**
         * @param technicalMetadata
         */
        public TechnicalMetadataPackage(TechnicalMetadata technicalMetadata) {
            this.technicalFilePackage = null;
            this.technicalMetadata = technicalMetadata;
        }

        /**
         * @return the technicalFilePackage
         */
        public FileId getTechnicalFilePackage() {
            return technicalFilePackage;
        }

        /**
         * @return the technicalMetadata
         */
        public TechnicalMetadata getTechnicalMetadata() {
            return technicalMetadata;
        }

    }
    /**
     * DataObject Package
     */
    @JsonPropertyOrder({"binaryDataObject", "physicalDataObject", "technicalMetadataPackage", "descriptiveMetadataPackage"})
    public static class DataObjectPackage extends AbstractInformationType {
        /**
         * List of BinaryDataObjects
         */
        final List<BinaryDataObject> binaryDataObject = new LinkedList<BinaryDataObject>();
        /**
         * List of PhysicalDataObjects
         */
        final List<PhysicalDataObject> physicalDataObject = new LinkedList<PhysicalDataObject>();
        /**
         * DescriptiveMetadata Package
         */
        DescriptiveMetadataPackage descriptiveMetadataPackage;
        /**
         * TechnicalMetadata Package
         */
        TechnicalMetadataPackage technicalMetadataPackage;
        /**
         * @return the binaryDataObjects
         */
        public List<BinaryDataObject> getBinaryDataObject() {
            return binaryDataObject;
        }

        /**
         * @param binaryDataObjects the binaryDataObjects to set
         * @return This
         */
        public DataObjectPackage setBinaryDataObject(List<BinaryDataObject> binaryDataObjects) {
            this.binaryDataObject.clear();
            this.binaryDataObject.addAll(binaryDataObjects);
            return this;
        }

        /**
         * @param binaryDataObject
         * @return This
         */
        public DataObjectPackage addBinaryDataObject(BinaryDataObject binaryDataObject) {
            this.binaryDataObject.add(binaryDataObject);
            return this;
        }
        /**
         * @return the physicalDataObjects
         */
        public List<PhysicalDataObject> getPhysicalDataObject() {
            return physicalDataObject;
        }

        /**
         * @param physicalDataObjects the physicalDataObjects to set
         * @return This
         */
        public DataObjectPackage setPhysicalDataObject(List<PhysicalDataObject> physicalDataObjects) {
            this.physicalDataObject.clear();
            this.physicalDataObject.addAll(physicalDataObjects);
            return this;
        }
        /**
         * @param physicalDataObject
         * @return This
         */
        public DataObjectPackage addPhysicalDataObject(PhysicalDataObject physicalDataObject) {
            this.physicalDataObject.add(physicalDataObject);
            return this;
        }

        /**
         * @return the descriptiveMetadataPackage
         */
        public DescriptiveMetadataPackage getDescriptiveMetadataPackage() {
            return descriptiveMetadataPackage;
        }

        /**
         * @param descriptiveMetadataPackage the descriptiveMetadataPackage to set
         * @return This
         */
        public DataObjectPackage setDescriptiveMetadataPackage(DescriptiveMetadataPackage descriptiveMetadataPackage) {
            this.descriptiveMetadataPackage = descriptiveMetadataPackage;
            return this;
        }

        /**
         * @return the technicalMetadataPackage
         */
        public TechnicalMetadataPackage getTechnicalMetadataPackage() {
            return technicalMetadataPackage;
        }

        /**
         * @param technicalMetadataPackage the technicalMetadataPackage to set
         * @return This
         */
        public DataObjectPackage setTechnicalMetadataPackage(TechnicalMetadataPackage technicalMetadataPackage) {
            this.technicalMetadataPackage = technicalMetadataPackage;
            return this;
        }

        private boolean checkDescriptiveMetadataPackage() {
            return (descriptiveMetadataPackage == null);
        }

        private boolean checkTechnicalMetadataPackage() {
            return (technicalMetadataPackage == null);
        }
        /**
         * @return the descriptiveFilePackage
         */
        @JsonIgnore
        public FileId getDescriptiveFilePackage() {
            if (checkDescriptiveMetadataPackage()) {
                return null;
            }
            return descriptiveMetadataPackage.getDescriptiveFilePackage();
        }

        /**
         * @param descriptiveFilePackage the descriptiveFilePackage to set
         * @return This
         */
        @JsonIgnore
        public DataObjectPackage setDescriptiveFilePackage(FileId descriptiveFilePackage) {
            descriptiveMetadataPackage = new DescriptiveMetadataPackage(descriptiveFilePackage);
            return this;
        }

        /**
         * @return the descriptiveMetadata
         */
        @JsonIgnore
        public DescriptiveMetadata getDescriptiveMetadata() {
            if (checkDescriptiveMetadataPackage()) {
                return null;
            }
            return descriptiveMetadataPackage.getDescriptiveMetadata();
        }

        /**
         * @param descriptiveMetadata the descriptiveMetadata to set
         * @return This
         */
        @JsonIgnore
        public DataObjectPackage setDescriptiveMetadata(DescriptiveMetadata descriptiveMetadata) {
            descriptiveMetadataPackage = new DescriptiveMetadataPackage(descriptiveMetadata);
            return this;
        }
        /**
         * @return the technicalFilePackage
         */
        @JsonIgnore
        public FileId getTechnicalFilePackage() {
            if (checkTechnicalMetadataPackage()) {
                return null;
            }
            return technicalMetadataPackage.getTechnicalFilePackage();
        }

        /**
         * @param technicalFilePackage the technicalFilePackage to set
         * @return This
         */
        @JsonIgnore
        public DataObjectPackage setTechnicalFilePackage(FileId technicalFilePackage) {
            technicalMetadataPackage = new TechnicalMetadataPackage(technicalFilePackage);
            return this;
        }

        /**
         * @return the technicalMetadata
         */
        @JsonIgnore
        public TechnicalMetadata getTechnicalMetadata() {
            if (checkTechnicalMetadataPackage()) {
                return null;
            }
            return technicalMetadataPackage.getTechnicalMetadata();
        }

        /**
         * @param technicalMetadata the technicalMetadata to set
         * @return This
         */
        @JsonIgnore
        public DataObjectPackage setTechnicalMetadata(TechnicalMetadata technicalMetadata) {
            technicalMetadataPackage = new TechnicalMetadataPackage(technicalMetadata);
            return this;
        }
    }
    /**
     * DataObject Package
     */
    DataObjectPackage dataObjectPackage;
    
    /**
     * @param messageIdentifier
     * @param archivalAgreement
     * @param archivalAgency
     * @param transferringAgency
     */
    public ArchiveTransfer(String messageIdentifier, String archivalAgreement, Organization archivalAgency,
            Organization transferringAgency) {
        this.date = new DateTime();
        this.messageIdentifier = messageIdentifier;
        this.archivalAgreement = archivalAgreement;
        this.archivalAgency = archivalAgency;
        this.transferringAgency = transferringAgency;
    }

    /**
     * @return the transferRequestReplyIdentifer
     */
    public String getTransferRequestReplyIdentifer() {
        return transferRequestReplyIdentifer;
    }

    /**
     * @param transferRequestReplyIdentifer the transferRequestReplyIdentifer to set
     * @return This
     */
    public ArchiveTransfer setTransferRequestReplyIdentifer(String transferRequestReplyIdentifer) {
        this.transferRequestReplyIdentifer = transferRequestReplyIdentifer;
        return this;
    }

    /**
     * @return the date
     */
    public DateTime getDate() {
        return date;
    }

    /**
     * @return the messageIdentifier
     */
    public String getMessageIdentifier() {
        return messageIdentifier;
    }

    /**
     * @return the archivalAgreement
     */
    public String getArchivalAgreement() {
        return archivalAgreement;
    }

    /**
     * @return the archivalAgency
     */
    public Organization getArchivalAgency() {
        return archivalAgency;
    }

    /**
     * @return the transferringAgency
     */
    public Organization getTransferringAgency() {
        return transferringAgency;
    }

    /**
     * @return the signature
     */
    public AbstractInformationType getSignature() {
        return signature;
    }

    /**
     * @param signature the signature to set
     * @return This
     */
    public ArchiveTransfer setSignature(AbstractInformationType signature) {
        this.signature = signature;
        return this;
    }

    /**
     * @return the codeListVersions
     */
    public ArchiveTransferCodeListVersions getCodeListVersions() {
        return codeListVersions;
    }

    /**
     * @param codeListVersions the codeListVersions to set
     * @return This
     */
    public ArchiveTransfer setCodeListVersions(ArchiveTransferCodeListVersions codeListVersions) {
        this.codeListVersions = codeListVersions;
        return this;
    }

    /**
     * @return the dataObjectPackage
     */
    public DataObjectPackage getDataObjectPackage() {
        return dataObjectPackage;
    }

    /**
     * @param dataObjectPackage the dataObjectPackage to set
     * @return This
     */
    public ArchiveTransfer setDataObjectPackage(DataObjectPackage dataObjectPackage) {
        this.dataObjectPackage = dataObjectPackage;
        return this;
    }
    
    /**
     * 
     */
    private void checkDataObjectPackage() {
        if (dataObjectPackage == null) {
            dataObjectPackage = new DataObjectPackage();
        }
    }
    /**
     * @return the binaryDataObjects
     */
    @JsonIgnore
    public List<BinaryDataObject> getBinaryDataObject() {
        checkDataObjectPackage();
        return dataObjectPackage.getBinaryDataObject();
    }

    /**
     * @param binaryDataObjects the binaryDataObjects to set
     * @return This
     */
    @JsonIgnore
    public ArchiveTransfer setBinaryDataObject(List<BinaryDataObject> binaryDataObjects) {
        checkDataObjectPackage();
        dataObjectPackage.setBinaryDataObject(binaryDataObjects);
        return this;
    }

    /**
     * @param binaryDataObject
     * @return This
     */
    @JsonIgnore
    public ArchiveTransfer addBinaryDataObject(BinaryDataObject binaryDataObject) {
        checkDataObjectPackage();
        dataObjectPackage.addBinaryDataObject(binaryDataObject);
        return this;
    }
    /**
     * @return the physicalDataObjects
     */
    @JsonIgnore
    public List<PhysicalDataObject> getPhysicalDataObject() {
        checkDataObjectPackage();
        return dataObjectPackage.getPhysicalDataObject();
    }

    /**
     * @param physicalDataObjects the physicalDataObjects to set
     * @return This
     */
    @JsonIgnore
    public ArchiveTransfer setPhysicalDataObject(List<PhysicalDataObject> physicalDataObjects) {
        checkDataObjectPackage();
        dataObjectPackage.setPhysicalDataObject(physicalDataObjects);
        return this;
    }
    /**
     * @param physicalDataObject
     * @return This
     */
    @JsonIgnore
    public ArchiveTransfer addPhysicalDataObject(PhysicalDataObject physicalDataObject) {
        checkDataObjectPackage();
        dataObjectPackage.addPhysicalDataObject(physicalDataObject);
        return this;
    }

    /**
     * @return the descriptiveMetadataPackage
     */
    @JsonIgnore
    public DescriptiveMetadataPackage getDescriptiveMetadataPackage() {
        checkDataObjectPackage();
        return dataObjectPackage.getDescriptiveMetadataPackage();
    }

    /**
     * @param descriptiveMetadataPackage the descriptiveMetadataPackage to set
     * @return This
     */
    @JsonIgnore
    public ArchiveTransfer setDescriptiveMetadataPackage(DescriptiveMetadataPackage descriptiveMetadataPackage) {
        checkDataObjectPackage();
        dataObjectPackage.setDescriptiveMetadataPackage(descriptiveMetadataPackage);
        return this;
    }

    /**
     * @return the technicalMetadataPackage
     */
    @JsonIgnore
    public TechnicalMetadataPackage getTechnicalMetadataPackage() {
        checkDataObjectPackage();
        return dataObjectPackage.getTechnicalMetadataPackage();
    }

    /**
     * @param technicalMetadataPackage the technicalMetadataPackage to set
     * @return This
     */
    @JsonIgnore
    public ArchiveTransfer setTechnicalMetadataPackage(TechnicalMetadataPackage technicalMetadataPackage) {
        checkDataObjectPackage();
        dataObjectPackage.setTechnicalMetadataPackage(technicalMetadataPackage);
        return this;
    }
    /**
     * @return the descriptiveFilePackage
     */
    @JsonIgnore
    public FileId getDescriptiveFilePackage() {
        checkDataObjectPackage();
        return dataObjectPackage.getDescriptiveFilePackage();
    }

    /**
     * @param descriptiveFilePackage the descriptiveFilePackage to set
     * @return This
     */
    @JsonIgnore
    public ArchiveTransfer setDescriptiveFilePackage(FileId descriptiveFilePackage) {
        checkDataObjectPackage();
        dataObjectPackage.setDescriptiveFilePackage(descriptiveFilePackage);
        return this;
    }

    /**
     * @return the descriptiveMetadata
     */
    @JsonIgnore
    public DescriptiveMetadata getDescriptiveMetadata() {
        checkDataObjectPackage();
        return dataObjectPackage.getDescriptiveMetadata();
    }

    /**
     * @param descriptiveMetadata the descriptiveMetadata to set
     * @return This
     */
    @JsonIgnore
    public ArchiveTransfer setDescriptiveMetadata(DescriptiveMetadata descriptiveMetadata) {
        checkDataObjectPackage();
        dataObjectPackage.setDescriptiveMetadata(descriptiveMetadata);
        return this;
    }
    /**
     * @return the technicalFilePackage
     */
    @JsonIgnore
    public FileId getTechnicalFilePackage() {
        checkDataObjectPackage();
        return dataObjectPackage.getTechnicalFilePackage();
    }

    /**
     * @param technicalFilePackage the technicalFilePackage to set
     * @return This
     */
    @JsonIgnore
    public ArchiveTransfer setTechnicalFilePackage(FileId technicalFilePackage) {
        checkDataObjectPackage();
        dataObjectPackage.setTechnicalFilePackage(technicalFilePackage);
        return this;
    }

    /**
     * @return the technicalMetadata
     */
    @JsonIgnore
    public TechnicalMetadata getTechnicalMetadata() {
        checkDataObjectPackage();
        return dataObjectPackage.getTechnicalMetadata();
    }

    /**
     * @param technicalMetadata the technicalMetadata to set
     * @return This
     */
    @JsonIgnore
    public ArchiveTransfer setTechnicalMetadata(TechnicalMetadata technicalMetadata) {
        checkDataObjectPackage();
        dataObjectPackage.setTechnicalMetadata(technicalMetadata);
        return this;
    }
}
