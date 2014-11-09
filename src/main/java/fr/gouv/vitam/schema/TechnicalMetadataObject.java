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


/**
 * Main package for the description of one Level (one item/node in the DAG).
 *
 */
public class TechnicalMetadataObject extends AbstractInformationType {
    /**
     * Option 1) This object technical metadata is defined in a specific file.
     * 
     * File is listed in BinaryDataObjects list
     */
    final FileId technicalMetadataObjectFile;
    /**
     * Option 2) This is a Binary Technical Metadata description
     */
    final BinaryTechnicalMetadataObject binaryTechnicalMetadataObject;
    /**
     * Option 3) This is a Physical Technical Metadata description
     */
    final PhysicalTechnicalMetadataObject physicalTechnicalMetadataObject;
    /**
     * @param technicalMetadataObjectFile
     */
    public TechnicalMetadataObject(FileId technicalMetadataObjectFile) {
        this.technicalMetadataObjectFile = technicalMetadataObjectFile;
        this.binaryTechnicalMetadataObject = null;
        this.physicalTechnicalMetadataObject = null;
    }
    /**
     * @param binaryTechnicalMetadataObject
     */
    public TechnicalMetadataObject(BinaryTechnicalMetadataObject binaryTechnicalMetadataObject) {
        this.technicalMetadataObjectFile = null;
        this.binaryTechnicalMetadataObject = binaryTechnicalMetadataObject;
        this.physicalTechnicalMetadataObject = null;
    }
    /**
     * @param physicalTechnicalMetadataObject
     */
    public TechnicalMetadataObject(PhysicalTechnicalMetadataObject physicalTechnicalMetadataObject) {
        this.technicalMetadataObjectFile = null;
        this.binaryTechnicalMetadataObject = null;
        this.physicalTechnicalMetadataObject = physicalTechnicalMetadataObject;
    }
    /**
     * @return the technicalMetadataObjectFile
     */
    public FileId getTechnicalMetadataObjectFile() {
        return technicalMetadataObjectFile;
    }
    /**
     * @return the binaryTechnicalMetadataObject
     */
    public BinaryTechnicalMetadataObject getBinaryTechnicalMetadataObject() {
        return binaryTechnicalMetadataObject;
    }
    /**
     * @return the physicalTechnicalMetadataObject
     */
    public PhysicalTechnicalMetadataObject getPhysicalTechnicalMetadataObject() {
        return physicalTechnicalMetadataObject;
    }
    
}
