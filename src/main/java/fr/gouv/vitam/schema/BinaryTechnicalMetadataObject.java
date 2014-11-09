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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Binary Technical Metadata of one Object
 *
 */
@JsonPropertyOrder({"id", "groupId", "version", "technicalIdentificationDate", "identification", "fileInfo", "coreTechnicalMetadata", "descriptiveTechnicalMetadata"})
public class BinaryTechnicalMetadataObject extends AbstractInformationType {
    /**
     * File Id
     */
    final FileId id;
    /**
     * Optional: group Id if this File is one version of the same intellectual object
     */
    final String groupId;
    /**
     * optional: if in group, which kind of version it is (original, copy, scan, limited content, thumbnail format, diffusion format, conservation format, raw format, ...) 
     */
    final String version;
    
    /**
     * Date of the technical identification
     */
    DateTime technicalIdentificationDate;

    /**
     * Technical identification
     */
    @JsonPropertyOrder({"formatLitteral", "mimeType", "formatId"})
    public static class Identification extends AbstractInformationType {
        /**
         * Optional format description
         */
        String formatLitteral;
        /**
         * Optional MimeType
         */
        String mimeType;
        /**
         * Mandatory FormatId
         */
        final String formatId;
        
        /**
         * @param formatId
         */
        public Identification(String formatId) {
            this.formatId = formatId;
        }
        /**
         * @param formatLitteral
         * @param mimeType
         * @param formatId
         */
        public Identification(String formatLitteral, String mimeType, String formatId) {
            this.formatLitteral = formatLitteral;
            this.mimeType = mimeType;
            this.formatId = formatId;
        }

        /**
         * @return the formatLitteral
         */
        public String getFormatLitteral() {
            return formatLitteral;
        }
        /**
         * @return the mimeType
         */
        public String getMimeType() {
            return mimeType;
        }
        /**
         * @return the formatId
         */
        public String getFormatId() {
            return formatId;
        }
        /**
         * @param formatLitteral the formatLitteral to set
         * @return This
         */
        public Identification setFormatLitteral(String formatLitteral) {
            this.formatLitteral = formatLitteral;
            return this;
        }
        /**
         * @param mimeType the mimeType to set
         * @return This
         */
        public Identification setMimeType(String mimeType) {
            this.mimeType = mimeType;
            return this;
        }
        
    }
    /**
     * Technical identification
     */
    final Identification identification;

    /**
     * @return the formatLitteral
     */
    @JsonIgnore
    public String getFormatLitteral() {
        return identification.getFormatLitteral();
    }
    /**
     * @return the mimeType
     */
    @JsonIgnore
    public String getMimeType() {
        return identification.getMimeType();
    }
    /**
     * @return the formatId
     */
    @JsonIgnore
    public String getFormatId() {
        return identification.getFormatId();
    }
    /**
     * @param formatLitteral the formatLitteral to set
     * @return This
     */
    @JsonIgnore
    public BinaryTechnicalMetadataObject setFormatLitteral(String formatLitteral) {
        identification.setFormatLitteral(formatLitteral);
        return this;
    }
    /**
     * @param mimeType the mimeType to set
     * @return This
     */
    @JsonIgnore
    public BinaryTechnicalMetadataObject setMimeType(String mimeType) {
        identification.setMimeType(mimeType);
        return this;
    }

    /**
     * Technical File information
     */
    @JsonPropertyOrder({"size", "filename", "created", "creatingApplicationName", "creatingApplicationVersion", "creatingOs", "lastModified"})
    public static class FileInfo extends AbstractInformationType {
        /**
         * Size of the file
         */
        long size;
        /**
         * Filename
         */
        String filename;
        /**
         * Date of creation
         */
        DateTime created;
        /**
         * Optional: application name used to create this file
         */
        String creatingApplicationName;
        /**
         * Optional: application version used to create this file
         */
        String creatingApplicationVersion;
        /**
         * Optional: OS name and version used to create this file
         */
        String creatingOs;
        /**
         * last Time where the file was originally modified (not following conservation transformation processus)
         */
        DateTime lastModified;
        
        /**
         * @param size
         * @param filename
         * @param created
         */
        public FileInfo(long size, String filename, DateTime created) {
            this.size = size;
            this.filename = filename;
            this.created = created;
        }
        /**
         * @return the size
         */
        public long getSize() {
            return size;
        }
        /**
         * @return the filename
         */
        public String getFilename() {
            return filename;
        }
        /**
         * @return the created
         */
        public DateTime getCreated() {
            return created;
        }
        /**
         * @return the creatingApplicationName
         */
        public String getCreatingApplicationName() {
            return creatingApplicationName;
        }
        /**
         * @return the creatingApplicationVersion
         */
        public String getCreatingApplicationVersion() {
            return creatingApplicationVersion;
        }
        /**
         * @return the creatingOs
         */
        public String getCreatingOs() {
            return creatingOs;
        }
        /**
         * @return the lastModified
         */
        public DateTime getLastModified() {
            return lastModified;
        }
        /**
         * @param creatingApplicationName the creatingApplicationName to set
         * @return This
         */
        public FileInfo setCreatingApplicationName(String creatingApplicationName) {
            this.creatingApplicationName = creatingApplicationName;
            return this;
        }
        /**
         * @param creatingApplicationVersion the creatingApplicationVersion to set
         * @return This
         */
        public FileInfo setCreatingApplicationVersion(String creatingApplicationVersion) {
            this.creatingApplicationVersion = creatingApplicationVersion;
            return this;
        }
        /**
         * @param creatingOs the creatingOs to set
         * @return This
         */
        public FileInfo setCreatingOs(String creatingOs) {
            this.creatingOs = creatingOs;
            return this;
        }
        /**
         * @param lastModified the lastModified to set
         * @return This
         */
        public FileInfo setLastModified(DateTime lastModified) {
            this.lastModified = lastModified;
            return this;
        }
    }
    /**
     * Technical File information
     */
    final FileInfo fileInfo;

    /**
     * @return the size
     */
    @JsonIgnore
    public long getSize() {
        return fileInfo.getSize();
    }
    /**
     * @return the filename
     */
    @JsonIgnore
    public String getFilename() {
        return fileInfo.getFilename();
    }
    /**
     * @return the created
     */
    @JsonIgnore
    public DateTime getCreated() {
        return fileInfo.getCreated();
    }
    /**
     * @return the creatingApplicationName
     */
    @JsonIgnore
    public String getCreatingApplicationName() {
        return fileInfo.getCreatingApplicationName();
    }
    /**
     * @return the creatingApplicationVersion
     */
    @JsonIgnore
    public String getCreatingApplicationVersion() {
        return fileInfo.getCreatingApplicationVersion();
    }
    /**
     * @return the creatingOs
     */
    @JsonIgnore
    public String getCreatingOs() {
        return fileInfo.getCreatingOs();
    }
    /**
     * @return the lastModified
     */
    @JsonIgnore
    public DateTime getLastModified() {
        return fileInfo.getLastModified();
    }
    /**
     * @param creatingApplicationName the creatingApplicationName to set
     * @return This
     */
    @JsonIgnore
    public BinaryTechnicalMetadataObject setCreatingApplicationName(String creatingApplicationName) {
        fileInfo.setCreatingApplicationName(creatingApplicationName);
        return this;
    }
    /**
     * @param creatingApplicationVersion the creatingApplicationVersion to set
     * @return This
     */
    @JsonIgnore
    public BinaryTechnicalMetadataObject setCreatingApplicationVersion(String creatingApplicationVersion) {
        fileInfo.setCreatingApplicationVersion(creatingApplicationVersion);
        return this;
    }
    /**
     * @param creatingOs the creatingOs to set
     * @return This
     */
    @JsonIgnore
    public BinaryTechnicalMetadataObject setCreatingOs(String creatingOs) {
        fileInfo.setCreatingOs(creatingOs);
        return this;
    }
    /**
     * @param lastModified the lastModified to set
     * @return This
     */
    @JsonIgnore
    public BinaryTechnicalMetadataObject setLastModified(DateTime lastModified) {
        fileInfo.setLastModified(lastModified);
        return this;
    }

    /**
     * Core technical metadata
     */
    AbstractCoreTechnicalMetadata coreTechnicalMetadata;
    /**
     * More detailed technical metadata
     */
    DescriptiveTechnicalMetadataContent descriptiveTechnicalMetadata;
    
    /**
     * @param id
     * @param formatId 
     * @param size 
     * @param filename 
     * @param created 
     */
    public BinaryTechnicalMetadataObject(FileId id, String formatId, long size, String filename, DateTime created) {
        this.id = id;
        this.groupId = null;
        this.version = null;
        this.identification = new Identification(formatId);
        this.fileInfo = new FileInfo(size, filename, created);
    }
    /**
     * @param id
     * @param groupId
     * @param version
     * @param formatId 
     * @param size 
     * @param filename 
     * @param created 
     */
    public BinaryTechnicalMetadataObject(FileId id, String groupId, String version, String formatId, long size, String filename, DateTime created) {
        this.id = id;
        this.groupId = groupId;
        this.version = version;
        this.identification = new Identification(formatId);
        this.fileInfo = new FileInfo(size, filename, created);
    }
    
    /**
     * @param id
     * @param groupId
     * @param version
     * @param identification
     * @param fileInfo
     */
    public BinaryTechnicalMetadataObject(FileId id, String groupId, String version, Identification identification,
            FileInfo fileInfo) {
        this.id = id;
        this.groupId = groupId;
        this.version = version;
        this.identification = identification;
        this.fileInfo = fileInfo;
    }
    /**
     * @param id
     * @param identification
     * @param fileInfo
     */
    public BinaryTechnicalMetadataObject(FileId id, Identification identification,
            FileInfo fileInfo) {
        this.id = id;
        this.groupId = null;
        this.version = null;
        this.identification = identification;
        this.fileInfo = fileInfo;
    }
    /**
     * @return the id
     */
    public FileId getId() {
        return id;
    }
    /**
     * @return the groupId
     */
    public String getGroupId() {
        return groupId;
    }
    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }
    /**
     * @return the technicalIdentificationDate
     */
    public DateTime getTechnicalIdentificationDate() {
        return technicalIdentificationDate;
    }
    /**
     * @return the coreTechnicalMetadata
     */
    public AbstractCoreTechnicalMetadata getCoreTechnicalMetadata() {
        return coreTechnicalMetadata;
    }
    /**
     * @return the descriptiveTechnicalMetadata
     */
    public DescriptiveTechnicalMetadataContent getDescriptiveTechnicalMetadata() {
        return descriptiveTechnicalMetadata;
    }
    /**
     * @param technicalIdentificationDate the technicalIdentificationDate to set
     * @return This
     */
    public BinaryTechnicalMetadataObject setTechnicalIdentificationDate(DateTime technicalIdentificationDate) {
        this.technicalIdentificationDate = technicalIdentificationDate;
        return this;
    }
    /**
     * @param coreTechnicalMetadata the coreTechnicalMetadata to set
     * @return This
     */
    public BinaryTechnicalMetadataObject setCoreTechnicalMetadata(AbstractCoreTechnicalMetadata coreTechnicalMetadata) {
        this.coreTechnicalMetadata = coreTechnicalMetadata;
        return this;
    }
    /**
     * @param descriptiveTechnicalMetadata the descriptiveTechnicalMetadata to set
     * @return This
     */
    public BinaryTechnicalMetadataObject setDescriptiveTechnicalMetadata(DescriptiveTechnicalMetadataContent descriptiveTechnicalMetadata) {
        this.descriptiveTechnicalMetadata = descriptiveTechnicalMetadata;
        return this;
    }
    /**
     * @return the identification
     */
    public Identification getIdentification() {
        return identification;
    }
    /**
     * @return the fileInfo
     */
    public FileInfo getFileInfo() {
        return fileInfo;
    }
}
