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

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fr.gouv.vitam.utils.UUID;

/**
 * File Id (for all files, whatever archives or XML/Json files)
 *
 */
@JsonSerialize(using = FileIdSerializer.class)
public class FileId extends AbstractInformationType {
    final String id;
    /**
     * @param id 
     * 
     */
    public FileId(String id) {
        this.id = id;
    }
    /**
     * Generate a new Id
     */
    public FileId() {
        this.id = new UUID().toString();
    }
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }
}
