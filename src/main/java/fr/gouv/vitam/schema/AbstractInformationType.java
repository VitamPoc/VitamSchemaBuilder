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

import java.io.File;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.node.ObjectNode;

import fr.gouv.vitam.utils.exception.InvalidParseOperationException;
import fr.gouv.vitam.utils.json.JsonHandler;
import fr.gouv.vitam.utils.json.XmlHandler;

/**
 * General class that will propose to Json/Xml generation
 *
 */
//@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
@SuppressWarnings("unused")
public abstract class AbstractInformationType {

    /**
     * 
     * @return the corresponding JsonNode
     */
    public ObjectNode generateJson() {
        String value;
        try {
            value = JsonHandler.writeAsString(this);
            return (ObjectNode) JsonHandler.getFromString(value);
        } catch (InvalidParseOperationException e) {
        }
        return JsonHandler.createObjectNode();
    }
    /**
     * @return the XML string representation
     * @throws InvalidParseOperationException
     */
    public String generateJsonString() throws InvalidParseOperationException {
        return JsonHandler.writeAsString(this);
    }
    /**
     * @return the XML string representation
     * @throws InvalidParseOperationException
     */
    public String generateXmlString() throws InvalidParseOperationException {
        return XmlHandler.writeAsString(this);
    }
    /**
     * @param file
     * @throws InvalidParseOperationException
     */
    public void writeJsonToFile(File file) throws InvalidParseOperationException {
        JsonHandler.writeAsFile(this, file);
    }
    /**
     * @param file
     * @throws InvalidParseOperationException
     */
    public void writeXmlToFile(File file) throws InvalidParseOperationException {
        XmlHandler.writeAsFile(this, file);
    }
}
