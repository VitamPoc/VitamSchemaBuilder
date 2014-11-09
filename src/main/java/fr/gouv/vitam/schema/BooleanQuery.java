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

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Contains the queries as necessary to find out a LevelDescritptiveMetadata (Node in the DAG) to point to as next level.
 * Allows to reference an already existing node in a tree from a previous transfer.
 *
 */
@JsonPropertyOrder({"operator", "query", "booleanQuery"})
public class BooleanQuery extends AbstractInformationType {

    /**
     * Boolean Operator
     *
     */
    @SuppressWarnings("javadoc")
    public static enum Operator {
        AND, OR, NOT;
    }
    /**
     * Operator with only one argument
     *
     */
    @SuppressWarnings("javadoc")
    public static enum SimpleOperator {
        EXISTS, MISSING, ISNULL;
    }
    /**
     * Operator with 2 arguments
     *
     */
    @SuppressWarnings("javadoc")
    public static enum DoubleOperator {
        EQ, NE, LT, LTE, GT, GTE, SIZE,
        IN, NIN, 
        MATCH, MATCHPHRASE, MATCHPHRASEPREFIX, SEARCH, REGEX, TERM, WILDCARD,
        PATH;
    }
    /**
     * Simple Query
     *
     */
    @JsonPropertyOrder({"operator", "key", "keyRef", "value"})
    public static class Query extends AbstractInformationType {
        final Enum<?> operator;
        final String key;
        String keyRef;
        Object value;
        /**
         * @param simpleOperator
         * @param key Field name to check from EAS data structure
         */
        public Query(SimpleOperator simpleOperator, String key) {
            this.operator = simpleOperator;
            this.key = key;
        }
        /**
         * Ex: Key LT Value, Key LT keyRef
         * @param doubleOperator
         * @param key Field name to compare with (first operand) from EAS data structure
         * @param keyRef Field reference from descriptive data structure
         * @param value Fixed value if value not from keyRef (null)
         */
        public Query(DoubleOperator doubleOperator, String key, String keyRef, Object value) {
            this.operator = doubleOperator;
            this.key = key;
            this.keyRef = keyRef;
            this.value = value;
        }
        /**
         * @return the Operator
         */
        public Enum<?> getOperator() {
            return operator;
        }
        /**
         * @return the key
         */
        public String getKey() {
            return key;
        }
        /**
         * @return the keyRef
         */
        public String getKeyRef() {
            return keyRef;
        }
        /**
         * @return the value
         */
        public Object getValue() {
            return value;
        }
        
    }
    /**
     * Global Boolean Operator to use
     */
    final Operator operator;
    /**
     * All Queries to applied, aggregated through Boolean Operator
     */
    final List<Query> query = new LinkedList<BooleanQuery.Query>();
    /**
     * All sub queries (Boolean), aggregated through Boolean Operator
     */
    final List<BooleanQuery> booleanQuery = new LinkedList<BooleanQuery>();
    /**
     * @param operator
     */
    public BooleanQuery(Operator operator) {
        this.operator = operator;
    }
    /**
     * @return the operator
     */
    public Operator getBooleanOperator() {
        return operator;
    }
    /**
     * @return the queries
     */
    public List<Query> getQuery() {
        return query;
    }
    /**
     * @param queries
     * @return This
     */
    public BooleanQuery setQuery(List<Query> queries) {
        this.query.clear();
        this.query.addAll(queries);
        return this;
    }
    /**
     * @param query
     * @return This
     */
    public BooleanQuery addQuery(Query query) {
        this.query.add(query);
        return this;
    }
    /**
     * @return the booleanQueries
     */
    public List<BooleanQuery> getBooleanQuery() {
        return booleanQuery;
    }
    /**
     * @param booleanQueries
     * @return This
     */
    public BooleanQuery setBooleanQuery(List<BooleanQuery> booleanQueries) {
        this.booleanQuery.clear();
        this.booleanQuery.addAll(booleanQueries);
        return this;
    }
    /**
     * @param booleanQuery
     * @return This
     */
    public BooleanQuery addQuery(BooleanQuery booleanQuery) {
        this.booleanQuery.add(booleanQuery);
        return this;
    }
    
}
