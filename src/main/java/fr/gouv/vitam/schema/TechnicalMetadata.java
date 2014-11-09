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
 * Core package of Technical Metadata
 *
 */
@JsonPropertyOrder({"messageId", "codeListVersions", "tool", "technicalMetadataObject"})
public class TechnicalMetadata extends AbstractInformationType {
    /**
     * Description of one Tool used in technical identification
     *
     */
    @JsonPropertyOrder({"name", "version", "parameterVersion"})
    public static class Tool extends AbstractInformationType {
        /**
         * Name of the tool
         */
        final String name;
        /**
         * Version of the tool
         */
        final String version;
        /**
         * List of parameter and versions for this tool
         */
        final List<String> parameterVersion = new LinkedList<String>();
        /**
         * @param name
         * @param version
         */
        public Tool(String name, String version) {
            this.name = name;
            this.version = version;
        }
        /**
         * @return the parameterVersion
         */
        public List<String> getParameterVersion() {
            return parameterVersion;
        }
        /**
         * @param parameterVersions the parameterVersion to set
         * @return This
         */
        public Tool setParameterVersion(List<String> parameterVersions) {
            this.parameterVersion.clear();
            this.parameterVersion.addAll(parameterVersions);
            return this;
        }
        /**
         * 
         * @param parameterVersion
         * @return This
         */
        public Tool addParameterVersion(String parameterVersion) {
            this.parameterVersion.add(parameterVersion);
            return this;
        }
        /**
         * @return the name
         */
        public String getName() {
            return name;
        }
        /**
         * @return the version
         */
        public String getVersion() {
            return version;
        }
    }

    /**
     * Optional: Message identifier (useful if in a separate file than ArchiveTransfer package)
     */
    MessageIdentifier messageId;
    /**
     * Technical code list
     */
    @JsonPropertyOrder({"mimeTypeCodeList", "fileFormatCodeList", "dataObjectVersionCodeList"})
    public static class TechnicalCodeListVersions extends AbstractInformationType {
        /**
         * Optional MimeType Code list
         */
        CodeList mimeTypeCodeList;
        /**
         * File Format Code list
         */
        CodeList fileFormatCodeList;
        /**
         * DataObject Version Code list
         */
        CodeList dataObjectVersionCodeList;
        /**
         * @return the mimeTypeCodeList
         */
        public CodeList getMimeTypeCodeList() {
            return mimeTypeCodeList;
        }
        /**
         * @param mimeTypeCodeList the mimeTypeCodeList to set
         * @return This
         */
        public TechnicalCodeListVersions setMimeTypeCodeList(CodeList mimeTypeCodeList) {
            this.mimeTypeCodeList = mimeTypeCodeList;
            return this;
        }
        /**
         * @return the fileFormatCodeList
         */
        public CodeList getFileFormatCodeList() {
            return fileFormatCodeList;
        }
        /**
         * @param fileFormatCodeList the fileFormatCodeList to set
         * @return This
         */
        public TechnicalCodeListVersions setFileFormatCodeList(CodeList fileFormatCodeList) {
            this.fileFormatCodeList = fileFormatCodeList;
            return this;
        }
        /**
         * @return the dataObjectVersionCodeList
         */
        public CodeList getDataObjectVersionCodeList() {
            return dataObjectVersionCodeList;
        }
        /**
         * @param dataObjectVersionCodeList the dataObjectVersionCodeList to set
         * @return This
         */
        public TechnicalCodeListVersions setDataObjectVersionCodeList(CodeList dataObjectVersionCodeList) {
            this.dataObjectVersionCodeList = dataObjectVersionCodeList;
            return this;
        }
        
    }
    /**
     * Technical code list
     */
    TechnicalCodeListVersions codeListVersions;
    /**
     * List of tools used to identify technical metadata
     */
    final List<Tool> tool = new LinkedList<Tool>();
    /**
     * List of object's technical medatata
     */
    final List<TechnicalMetadataObject> technicalMetadataObject = new LinkedList<TechnicalMetadataObject>();
    /**
     */
    public TechnicalMetadata() {
    }
    /**
     * @param messageId 
     */
    public TechnicalMetadata(MessageIdentifier messageId) {
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
    public TechnicalMetadata setMessageId(MessageIdentifier messageId) {
        this.messageId = messageId;
        return this;
    }
    /**
     * @return the tools
     */
    public List<Tool> getTool() {
        return tool;
    }
    /**
     * @param tools the tools to set
     * @return This
     */
    public TechnicalMetadata setTool(List<Tool> tools) {
        this.tool.clear();
        this.tool.addAll(tools);
        return this;
    }
    /**
     * 
     * @param tool
     * @return This
     */
    public TechnicalMetadata addTool(Tool tool) {
        this.tool.add(tool);
        return this;
    }
    /**
     * @return the technicalMetadataObjects
     */
    public List<TechnicalMetadataObject> getTechnicalMetadataObject() {
        return technicalMetadataObject;
    }
    /**
     * @param technicalMetadataObjects the technicalMetadataObjects to set
     * @return This
     */
    public TechnicalMetadata setTechnicalMetadataObject(List<TechnicalMetadataObject> technicalMetadataObjects) {
        this.technicalMetadataObject.clear();
        this.technicalMetadataObject.addAll(technicalMetadataObjects);
        return this;
    }
    /**
     * @param technicalMetadataObject
     * @return This
     */
    public TechnicalMetadata addTechnicalMetadataObject(TechnicalMetadataObject technicalMetadataObject) {
        this.technicalMetadataObject.add(technicalMetadataObject);
        return this;
    }
    /**
     * @param binaryTechnicalMetadataObject
     * @return This
     */
    public TechnicalMetadata addTechnicalMetadataObject(BinaryTechnicalMetadataObject binaryTechnicalMetadataObject) {
        this.technicalMetadataObject.add(new TechnicalMetadataObject(binaryTechnicalMetadataObject));
        return this;
    }
    /**
     * @param physicalTechnicalMetadataObject
     * @return This
     */
    public TechnicalMetadata addTechnicalMetadataObject(PhysicalTechnicalMetadataObject physicalTechnicalMetadataObject) {
        this.technicalMetadataObject.add(new TechnicalMetadataObject(physicalTechnicalMetadataObject));
        return this;
    }
    /**
     * @param technicalMetadataObjectFile
     * @return This
     */
    public TechnicalMetadata addTechnicalMetadataObject(FileId technicalMetadataObjectFile) {
        this.technicalMetadataObject.add(new TechnicalMetadataObject(technicalMetadataObjectFile));
        return this;
    }
    /**
     * @return the codeListVersions
     */
    public TechnicalCodeListVersions getCodeListVersions() {
        return codeListVersions;
    }
    /**
     * @param codeListVersions the codeListVersions to set
     * @return This
     */
    public TechnicalMetadata setCodeListVersions(TechnicalCodeListVersions codeListVersions) {
        this.codeListVersions = codeListVersions;
        return this;
    }
    
    private void checkCodeListVersions() {
        if (codeListVersions == null) {
            codeListVersions = new TechnicalCodeListVersions();
        }
    }
    /**
     * @return the mimeTypeCodeList
     */
    @JsonIgnore
    public CodeList getMimeTypeCodeList() {
        checkCodeListVersions();
        return codeListVersions.getMimeTypeCodeList();
    }
    /**
     * @param mimeTypeCodeList the mimeTypeCodeList to set
     * @return This
     */
    @JsonIgnore
    public TechnicalMetadata setMimeTypeCodeList(CodeList mimeTypeCodeList) {
        checkCodeListVersions();
        this.codeListVersions.setMimeTypeCodeList(mimeTypeCodeList);
        return this;
    }
    /**
     * @return the fileFormatCodeList
     */
    @JsonIgnore
    public CodeList getFileFormatCodeList() {
        checkCodeListVersions();
        return codeListVersions.getFileFormatCodeList();
    }
    /**
     * @param fileFormatCodeList the fileFormatCodeList to set
     * @return This
     */
    @JsonIgnore
    public TechnicalMetadata setFileFormatCodeList(CodeList fileFormatCodeList) {
        checkCodeListVersions();
        this.codeListVersions.setFileFormatCodeList(fileFormatCodeList);
        return this;
    }
    /**
     * @return the dataObjectVersionCodeList
     */
    @JsonIgnore
    public CodeList getDataObjectVersionCodeList() {
        checkCodeListVersions();
        return codeListVersions.getDataObjectVersionCodeList();
    }
    /**
     * @param dataObjectVersionCodeList the dataObjectVersionCodeList to set
     * @return This
     */
    @JsonIgnore
    public TechnicalMetadata setDataObjectVersionCodeList(CodeList dataObjectVersionCodeList) {
        checkCodeListVersions();
        this.codeListVersions.setDataObjectVersionCodeList(dataObjectVersionCodeList);
        return this;
    }
}
