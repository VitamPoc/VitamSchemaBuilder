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

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Minimal Data Object Reference
 *
 */
@JsonPropertyOrder({"xmlId", "dataObjectId", "dataObjectGroupId"})
public class DataObjectReference extends AbstractInformationType {
    /**
     * XML id
     */
    final String xmlId;
    /**
     * Option 1) a Data Object Id
     */
    final FileId dataObjectId;
    /**
     * Option 2) a Group Data Object Id
     */
    final String dataObjectGroupId;
    /**
     * @param xmlId
     * @param dataObjectId
     */
    public DataObjectReference(String xmlId, FileId dataObjectId) {
        this.xmlId = xmlId;
        this.dataObjectId = dataObjectId;
        this.dataObjectGroupId = null;
    }
    /**
     * @param id
     * @param dataObjectGroupId
     */
    public DataObjectReference(String id, String dataObjectGroupId) {
        this.xmlId = id;
        this.dataObjectId = null;
        this.dataObjectGroupId = dataObjectGroupId;
    }
    /**
     * @return the id
     */
    public String getXmlId() {
        return xmlId;
    }
    /**
     * @return the dataObjectId
     */
    public FileId getDataObjectId() {
        return dataObjectId;
    }
    /**
     * @return the dataObjectGroupId
     */
    public String getDataObjectGroupId() {
        return dataObjectGroupId;
    }
}
