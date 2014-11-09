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
 * Shall this item change of storage after a delay (restricted access, copied, transferred)
 *
 */
@JsonPropertyOrder({"rule", "physicalDataObject", "preventInheritance", "refNonRuleId", "needAuthorization", "finalAction"})
public class StorageRule extends AbstractRule {
    /**
     * 
     * Final action once all Storage Rules are over
     *
     */
    @SuppressWarnings("javadoc")
    public static enum STORAGEACTION {
        RestrictedAccess, Transfer, Copy;
    }
    /**
     * One of: Restricted Access / Transfer / Copy
     */
    STORAGEACTION finalAction;

    /**
     * @param preventInheritance
     * @param finalAction
     * @param needAuthorization
     */
    public StorageRule(boolean preventInheritance, STORAGEACTION finalAction, boolean needAuthorization) {
        super(preventInheritance, needAuthorization);
        this.finalAction = finalAction;
    }
    /**
     * @return the finalAction
     */
    public STORAGEACTION getFinalAction() {
        return finalAction;
    }
    /**
     * @param finalAction the finalAction to set
     * @return This
     */
    public StorageRule setFinalAction(STORAGEACTION finalAction) {
        this.finalAction = finalAction;
        return this;
    }

}
