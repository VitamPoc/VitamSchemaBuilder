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

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Identification of one sub file from an ArchiveTransfer request.
 *
 */
@JsonPropertyOrder({"date", "messageId", "archiveTransferMessageIdentifier"})
public class MessageIdentifier extends AbstractInformationType {
    /**
     * Date of this file
     */
    final DateTime date;
    /**
     * The business id of this file
     */
    final String messageId;
    /**
     * The business id of the archiveTransfer message
     */
    final String archiveTransferMessageIdentifier;
    /**
     * @param messageId
     * @param archiveTransferMessageIdentifier
     */
    public MessageIdentifier(String messageId, String archiveTransferMessageIdentifier) {
        this.date = new DateTime();
        this.messageId = messageId;
        this.archiveTransferMessageIdentifier = archiveTransferMessageIdentifier;
    }
    /**
     * @return the date
     */
    public DateTime getDate() {
        return date;
    }
    /**
     * @return the messageId
     */
    public String getMessageId() {
        return messageId;
    }
    /**
     * @return the archiveTransferMessageIdentifier
     */
    public String getArchiveTransferMessageIdentifier() {
        return archiveTransferMessageIdentifier;
    }
    
}
