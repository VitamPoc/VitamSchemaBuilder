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
 * Structure to present a CodeList
 *
 */
@JsonPropertyOrder({"listId", "listAgencyId", "listAgencyName", "listName", "listVersionId", "listSchemeUri"})
public class CodeList extends AbstractInformationType {
    /**
     * Id of this list
     */
    final String listId;
    /**
     * Id of the agency
     */
    String listAgencyId;
    /**
     * Name of the agency
     */
    String listAgencyName;
    /**
     * Name of this list
     */
    String listName;
    /**
     * Version of this list
     */
    String listVersionId;
    /**
     * URI where the List Scheme is accessible
     */
    String listSchemeUri;

    /**
     * @param listId
     */
    public CodeList(String listId) {
        this.listId = listId;
    }

    /**
     * @param listId
     * @param listName
     * @param listVersionId
     * @param listSchemeUri
     */
    public CodeList(String listId, String listName, String listVersionId, String listSchemeUri) {
        this.listId = listId;
        this.listName = listName;
        this.listVersionId = listVersionId;
        this.listSchemeUri = listSchemeUri;
    }

    /**
     * @param listId
     * @param listAgencyId
     * @param listAgencyName
     * @param listName
     * @param listVersionId
     * @param listSchemeUri
     */
    public CodeList(String listId, String listAgencyId, String listAgencyName, String listName, String listVersionId,
            String listSchemeUri) {
        this.listId = listId;
        this.listAgencyId = listAgencyId;
        this.listAgencyName = listAgencyName;
        this.listName = listName;
        this.listVersionId = listVersionId;
        this.listSchemeUri = listSchemeUri;
    }

    /**
     * @return the listAgencyId
     */
    public String getListAgencyId() {
        return listAgencyId;
    }

    /**
     * @param listAgencyId
     *            the listAgencyId to set
     * @return This
     */
    public CodeList setListAgencyId(String listAgencyId) {
        this.listAgencyId = listAgencyId;
        return this;
    }

    /**
     * @return the listAgencyName
     */
    public String getListAgencyName() {
        return listAgencyName;
    }

    /**
     * @param listAgencyName
     *            the listAgencyName to set
     * @return This
     */
    public CodeList setListAgencyName(String listAgencyName) {
        this.listAgencyName = listAgencyName;
        return this;
    }

    /**
     * @return the listName
     */
    public String getListName() {
        return listName;
    }

    /**
     * @param listName
     *            the listName to set
     * @return This
     */
    public CodeList setListName(String listName) {
        this.listName = listName;
        return this;
    }

    /**
     * @return the listVersionId
     */
    public String getListVersionId() {
        return listVersionId;
    }

    /**
     * @param listVersionId
     *            the listVersionId to set
     * @return This
     */
    public CodeList setListVersionId(String listVersionId) {
        this.listVersionId = listVersionId;
        return this;
    }

    /**
     * @return the listSchemeUri
     */
    public String getListSchemeUri() {
        return listSchemeUri;
    }

    /**
     * @param listSchemeUri
     *            the listSchemeUri to set
     * @return This
     */
    public CodeList setListSchemeUri(String listSchemeUri) {
        this.listSchemeUri = listSchemeUri;
        return this;
    }

    /**
     * @return the listId
     */
    public String getListId() {
        return listId;
    }

}
