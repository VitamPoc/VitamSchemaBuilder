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
 * Physical Data Object
 *
 */
@JsonPropertyOrder({"id", "physicalId"})
public class PhysicalDataObject extends DataObject {
    /**
     * Physical Id of this PhysicalDataObject (barcode for instance)
     */
    final String physicalId;
    /**
     * @param physicalId
     */
    public PhysicalDataObject(String physicalId) {
        super();
        this.physicalId = physicalId;
    }
    /**
     * @param id
     * @param physicalId
     */
    public PhysicalDataObject(FileId id, String physicalId) {
        super(id);
        this.physicalId = physicalId;
    }
    /**
     * @return the physicalId
     */
    public String getPhysicalId() {
        return physicalId;
    }
    
    
}
