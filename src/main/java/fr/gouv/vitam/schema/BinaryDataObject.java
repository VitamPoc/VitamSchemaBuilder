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
 * Binary Data Object
 *
 */
@JsonPropertyOrder({"id", "uri", "digest", "size"})
public class BinaryDataObject extends DataObject {
    /**
     * URI of the file (where the file is located according to this metadata file)
     */
    final String uri;
    /**
     * Digest using value and algorithm
     */
    public static class Digest {
        /**
         * Digest value
         */
        @JacksonXmlText(value=true)
        final String value;
        /**
         * Digest algorithm
         */
        @JacksonXmlProperty(isAttribute=true)
        final String algorithm;
        /**
         * @param value
         * @param algorithm
         */
        public Digest(String value, String algorithm) {
            this.value = value;
            this.algorithm = algorithm;
        }
        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }
        /**
         * @return the algorithm
         */
        public String getAlgorithm() {
            return algorithm;
        }
        
    }
    /**
     * Digest using value and algorithm
     */
    final Digest digest;
    /**
     * Size of the file
     */
    final long size;
    /**
     * @param uri
     * @param digest
     * @param algorithm 
     * @param size
     */
    public BinaryDataObject(String uri, String digest, String algorithm, long size) {
        super();
        this.uri = uri;
        this.digest = new Digest(digest, algorithm);
        this.size = size;
    }
    /**
     * @param id
     * @param uri
     * @param digest
     * @param algorithm 
     * @param size
     */
    public BinaryDataObject(FileId id, String uri, String digest, String algorithm, long size) {
        super(id);
        this.uri = uri;
        this.digest = new Digest(digest, algorithm);
        this.size = size;
    }
    /**
     * @return the uri
     */
    public String getUri() {
        return uri;
    }
    /**
     * @return the digest
     */
    @JsonIgnore
    public String getDigestValue() {
        return digest.getValue();
    }
    /**
     * @return the size
     */
    public long getSize() {
        return size;
    }
    /**
     * @return the algorithm
     */
    @JsonIgnore
    public String getDigestAlgorithm() {
        return digest.getAlgorithm();
    }
    /**
     * @return the digest
     */
    public Digest getDigest() {
        return digest;
    }
}
