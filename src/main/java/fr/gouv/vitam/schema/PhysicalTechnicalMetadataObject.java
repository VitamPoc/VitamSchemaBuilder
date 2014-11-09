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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

/**
 * Technical Metadata for a Physical Object
 *
 */
@JsonPropertyOrder({"id", "groupId", "version", "physicalDimensions"})
public class PhysicalTechnicalMetadataObject extends AbstractInformationType {
    /**
     * 
     * Unit for measure as from UNECE_MeasurementUnitCommonCode_8.xsd
     *
     */
    @SuppressWarnings("javadoc")
    public static enum UNIT {
        micrometre, _4H, millimetre, MMT, centimetre, CMT, metre, MTR, inch, INH, foot, FOOT,
        microgram, MC, milligram, MGM, gram, GRM, kilogram, KGM;
    }
    /**
     * Measure plus Unit used
     *
     */
    public static class Measurement extends AbstractInformationType {
        /**
         * real measure
         */
        @JacksonXmlText(value=true)
        final double value;
        /**
         * Unit used (as from UNECE_MeasurementUnitCommonCode_8.xsd)
         */
        @JacksonXmlProperty(isAttribute=true)
        final UNIT unit;
        /**
         * @param value
         * @param unit
         */
        public Measurement(double value, UNIT unit) {
            this.value = value;
            this.unit = unit;
        }
        /**
         * @return the value
         */
        public double getValue() {
            return value;
        }
        /**
         * @return the unit
         */
        public UNIT getUnit() {
            return unit;
        }
        
    }

    /**
     * 
     * File is listed in BinaryDataObjects list
     */
    final FileId id;
    /**
     * Optional: group Id if this File is one version of the same intellectual object
     */
    final String groupId;
    /**
     * optional: if in group, which kind of version it is (original, copy, scan, limited content, thumbnail format, diffusion format, conservation format, raw format, ...) 
     */
    final String version;
    
    /**
     * Physical dimensions
     */
    @JsonPropertyOrder({"width", "height", "depth", "shape", "diameter", "length", "thickness", "weight"})
    public static class PhysicalDimensions extends AbstractInformationType {
        /**
         * Width measure
         */
        Measurement width;
        /**
         * Height measure
         */
        Measurement height;
        /**
         * Depth measure
         */
        Measurement depth;
        /**
         * Shape description (as circle, square, cube, ...), but using controlled vocabulary
         */
        String shape;
        /**
         * Diameter measure
         */
        Measurement diameter;
        /**
         * Length measure
         */
        Measurement length;
        /**
         * Thickness measure
         */
        Measurement thickness;
        /**
         * Weight measure
         */
        Measurement weight;
        /**
         * @return the width
         */
        public Measurement getWidth() {
            return width;
        }
        /**
         * @param width the width to set
         * @return This
         */
        public PhysicalDimensions setWidth(Measurement width) {
            this.width = width;
            return this;
        }
        /**
         * @return the height
         */
        public Measurement getHeight() {
            return height;
        }
        /**
         * @param height the height to set
         * @return This
         */
        public PhysicalDimensions setHeight(Measurement height) {
            this.height = height;
            return this;
        }
        /**
         * @return the depth
         */
        public Measurement getDepth() {
            return depth;
        }
        /**
         * @param depth the depth to set
         * @return This
         */
        public PhysicalDimensions setDepth(Measurement depth) {
            this.depth = depth;
            return this;
        }
        /**
         * @return the shape
         */
        public String getShape() {
            return shape;
        }
        /**
         * @param shape the shape to set
         * @return This
         */
        public PhysicalDimensions setShape(String shape) {
            this.shape = shape;
            return this;
        }
        /**
         * @return the diameter
         */
        public Measurement getDiameter() {
            return diameter;
        }
        /**
         * @param diameter the diameter to set
         * @return This
         */
        public PhysicalDimensions setDiameter(Measurement diameter) {
            this.diameter = diameter;
            return this;
        }
        /**
         * @return the length
         */
        public Measurement getLength() {
            return length;
        }
        /**
         * @param length the length to set
         * @return This
         */
        public PhysicalDimensions setLength(Measurement length) {
            this.length = length;
            return this;
        }
        /**
         * @return the thickness
         */
        public Measurement getThickness() {
            return thickness;
        }
        /**
         * @param thickness the thickness to set
         * @return This
         */
        public PhysicalDimensions setThickness(Measurement thickness) {
            this.thickness = thickness;
            return this;
        }
        /**
         * @return the weight
         */
        public Measurement getWeight() {
            return weight;
        }
        /**
         * @param weight the weight to set
         * @return This
         */
        public PhysicalDimensions setWeight(Measurement weight) {
            this.weight = weight;
            return this;
        }
    }
    /**
     * Physical dimensions
     */
    PhysicalDimensions physicalDimensions;
    /**
     * @param id
     */
    public PhysicalTechnicalMetadataObject(FileId id) {
        this.id = id;
        this.groupId = null;
        this.version = null;
    }
    /**
     * @param id
     * @param groupId
     * @param version
     */
    public PhysicalTechnicalMetadataObject(FileId id, String groupId, String version) {
        this.id = id;
        this.groupId = groupId;
        this.version = version;
    }
    /**
     * @return the id
     */
    public FileId getId() {
        return id;
    }
    /**
     * @return the groupId
     */
    public String getGroupId() {
        return groupId;
    }
    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }
    /**
     * @return the physicalDimensions
     */
    public PhysicalDimensions getPhysicalDimensions() {
        return physicalDimensions;
    }
    /**
     * @param physicalDimensions the physicalDimensions to set
     * @return This
     */
    public PhysicalTechnicalMetadataObject setPhysicalDimensions(PhysicalDimensions physicalDimensions) {
        this.physicalDimensions = physicalDimensions;
        return this;
    }
    
    private void checkPhysicalDimensions() {
        if (physicalDimensions == null) {
            physicalDimensions = new PhysicalDimensions();
        }
    }
    /**
     * @return the width
     */
    @JsonIgnore
    public Measurement getWidth() {
        checkPhysicalDimensions();
        return physicalDimensions.getWidth();
    }
    /**
     * @param width the width to set
     * @return This
     */
    @JsonIgnore
    public PhysicalTechnicalMetadataObject setWidth(Measurement width) {
        checkPhysicalDimensions();
        physicalDimensions.setWidth(width);
        return this;
    }
    /**
     * @return the height
     */
    @JsonIgnore
    public Measurement getHeight() {
        checkPhysicalDimensions();
        return physicalDimensions.getHeight();
    }
    /**
     * @param height the height to set
     * @return This
     */
    @JsonIgnore
    public PhysicalTechnicalMetadataObject setHeight(Measurement height) {
        checkPhysicalDimensions();
        physicalDimensions.setHeight(height);
        return this;
    }
    /**
     * @return the depth
     */
    @JsonIgnore
    public Measurement getDepth() {
        checkPhysicalDimensions();
        return physicalDimensions.getDepth();
    }
    /**
     * @param depth the depth to set
     * @return This
     */
    @JsonIgnore
    public PhysicalTechnicalMetadataObject setDepth(Measurement depth) {
        checkPhysicalDimensions();
        physicalDimensions.setDepth(depth);
        return this;
    }
    /**
     * @return the shape
     */
    @JsonIgnore
    public String getShape() {
        checkPhysicalDimensions();
        return physicalDimensions.getShape();
    }
    /**
     * @param shape the shape to set
     * @return This
     */
    @JsonIgnore
    public PhysicalTechnicalMetadataObject setShape(String shape) {
        checkPhysicalDimensions();
        physicalDimensions.setShape(shape);
        return this;
    }
    /**
     * @return the diameter
     */
    @JsonIgnore
    public Measurement getDiameter() {
        checkPhysicalDimensions();
        return physicalDimensions.getDiameter();
    }
    /**
     * @param diameter the diameter to set
     * @return This
     */
    @JsonIgnore
    public PhysicalTechnicalMetadataObject setDiameter(Measurement diameter) {
        checkPhysicalDimensions();
        physicalDimensions.setDiameter(diameter);
        return this;
    }
    /**
     * @return the length
     */
    @JsonIgnore
    public Measurement getLength() {
        checkPhysicalDimensions();
        return physicalDimensions.getLength();
    }
    /**
     * @param length the length to set
     * @return This
     */
    @JsonIgnore
    public PhysicalTechnicalMetadataObject setLength(Measurement length) {
        checkPhysicalDimensions();
        physicalDimensions.setLength(length);
        return this;
    }
    /**
     * @return the thickness
     */
    @JsonIgnore
    public Measurement getThickness() {
        checkPhysicalDimensions();
        return physicalDimensions.getThickness();
    }
    /**
     * @param thickness the thickness to set
     * @return This
     */
    @JsonIgnore
    public PhysicalTechnicalMetadataObject setThickness(Measurement thickness) {
        checkPhysicalDimensions();
        physicalDimensions.setThickness(thickness);
        return this;
    }
    /**
     * @return the weight
     */
    @JsonIgnore
    public Measurement getWeight() {
        checkPhysicalDimensions();
        return physicalDimensions.getWeight();
    }
    /**
     * @param weight the weight to set
     * @return This
     */
    @JsonIgnore
    public PhysicalTechnicalMetadataObject setWeight(Measurement weight) {
        checkPhysicalDimensions();
        physicalDimensions.setWeight(weight);
        return this;
    }
}
