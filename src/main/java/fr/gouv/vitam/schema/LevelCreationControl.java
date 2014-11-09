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
 * Management operator allowing to specify how a specific Level shall be included in the AES
 * (created or not, reused if already existing, updated if already existing) and how to find
 * it in the AES through Queries using Metadata.
 *
 */
@JsonPropertyOrder({"validIfFound", "validIfNotFound", "updateIfFound", "booleanQuery"})
public class LevelCreationControl extends AbstractInformationType {
    /**
     * If found in AES, is this valid?
     */
    boolean validIfFound;
    /**
     * If not found in AES, is this valid?
     */
    boolean validIfNotFound;
    /**
     * If found in AES, shall it be updated?
     */
    boolean updateIfFound;
    /**
     * Query to find the corresponding Level in the AES
     */
    BooleanQuery booleanQuery;
    /**
     * @param validIfFound
     * @param validIfNotFound
     * @param updateIfFound
     * @param booleanQuery
     */
    public LevelCreationControl(boolean validIfFound, boolean validIfNotFound, boolean updateIfFound, BooleanQuery booleanQuery) {
        this.validIfFound = validIfFound;
        this.validIfNotFound = validIfNotFound;
        this.updateIfFound = updateIfFound;
        this.booleanQuery = booleanQuery;
    }
    /**
     * @return the validIfFound
     */
    public boolean isValidIfFound() {
        return validIfFound;
    }
    /**
     * @param validIfFound the validIfFound to set
     * @return This
     */
    public LevelCreationControl setValidIfFound(boolean validIfFound) {
        this.validIfFound = validIfFound;
        return this;
    }
    /**
     * @return the validIfNotFound
     */
    public boolean isValidIfNotFound() {
        return validIfNotFound;
    }
    /**
     * @param validIfNotFound the validIfNotFound to set
     * @return This
     */
    public LevelCreationControl setValidIfNotFound(boolean validIfNotFound) {
        this.validIfNotFound = validIfNotFound;
        return this;
    }
    /**
     * @return the updateIfFound
     */
    public boolean isUpdateIfFound() {
        return updateIfFound;
    }
    /**
     * @param updateIfFound the updateIfFound to set
     * @return This
     */
    public LevelCreationControl setUpdateIfFound(boolean updateIfFound) {
        this.updateIfFound = updateIfFound;
        return this;
    }
    /**
     * @return the booleanQuery
     */
    public BooleanQuery getBooleanQuery() {
        return booleanQuery;
    }
    /**
     * @param booleanQuery the booleanQuery to set
     * @return This
     */
    public LevelCreationControl setBooleanQuery(BooleanQuery booleanQuery) {
        this.booleanQuery = booleanQuery;
        return this;
    }

}
