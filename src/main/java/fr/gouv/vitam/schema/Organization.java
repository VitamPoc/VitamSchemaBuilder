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
 * Description of one organization (ArchivalAgency and TransferringAgency)
 *
 */
@JsonPropertyOrder({"id", "description"})
public class Organization extends AbstractInformationType {
    /**
     * Id of this organization
     */
    final String id;
    /**
     * Optional description
     */
    String description;
    /**
     * @param id
     */
    public Organization(String id) {
        this.id = id;
    }
    /**
     * @param id
     * @param description
     */
    public Organization(String id, String description) {
        this.id = id;
        this.description = description;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     * @return This
     */
    public Organization setDescription(String description) {
        this.description = description;
        return this;
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
    
    
}
