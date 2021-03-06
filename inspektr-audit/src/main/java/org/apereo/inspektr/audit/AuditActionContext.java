/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apereo.inspektr.audit;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Immutable container holding the core elements of an audit-able action that need to be recorded
 * as an audit trail record.
 *
 * @author Dmitriy Kopylenko
 * @version $Id: AuditActionContext.java,v 1.2 2007/06/14 14:43:32 dkopylen Exp $
 * @since 1.0
 */
public class AuditActionContext implements Serializable {

    /**
     * Unique Id for serialization.
     */
    private static final long serialVersionUID = -3530737409883959089L;

    /**
     * This is <i>WHO</i>
     */
    @JsonProperty
    private final String principal;

    /**
     * This is <i>WHAT</i>
     */
    @JsonProperty
    private final String resourceOperatedUpon;

    /**
     * This is <i>ACTION</i>
     */
    @JsonProperty
    private final String actionPerformed;

    /**
     * This is <i>Application from which operation has been performed</i>
     */
    @JsonProperty
    private final String applicationCode;

    /**
     * This is <i>WHEN</i>
     */
    @JsonProperty
    private final Date whenActionWasPerformed;

    /**
     * Client IP Address
     */
    @JsonProperty
    private final String clientIpAddress;

    /**
     * Server IP Address
     */
    @JsonProperty
    private final String serverIpAddress;

    @JsonCreator
    public AuditActionContext(@JsonProperty("principal") final String principal,
                       @JsonProperty("resourceOperatedUpon") final String resourceOperatedUpon,
                       @JsonProperty("actionPerformed") final String actionPerformed,
                       @JsonProperty("applicationCode") final String applicationCode,
                       @JsonProperty("whenActionWasPerformed") final Date whenActionWasPerformed,
                       @JsonProperty("clientIpAddress") final String clientIpAddress,
                       @JsonProperty("serverIpAddress") final String serverIpAddress) {

        this.principal = principal;
        this.resourceOperatedUpon = resourceOperatedUpon;
        this.actionPerformed = actionPerformed;
        this.applicationCode = applicationCode;
        this.whenActionWasPerformed = new Date(whenActionWasPerformed.getTime());
        this.clientIpAddress = clientIpAddress;
        this.serverIpAddress = serverIpAddress;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getResourceOperatedUpon() {
        return resourceOperatedUpon;
    }

    public String getActionPerformed() {
        return actionPerformed;
    }

    public String getApplicationCode() {
        return applicationCode;
    }

    public Date getWhenActionWasPerformed() {
        return new Date(whenActionWasPerformed.getTime());
    }

    public String getClientIpAddress() {
        return this.clientIpAddress;
    }

    public String getServerIpAddress() {
        return this.serverIpAddress;
    }
}
