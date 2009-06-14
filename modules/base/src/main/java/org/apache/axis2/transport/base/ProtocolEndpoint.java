/*
*  Licensed to the Apache Software Foundation (ASF) under one
*  or more contributor license agreements.  See the NOTICE file
*  distributed with this work for additional information
*  regarding copyright ownership.  The ASF licenses this file
*  to you under the Apache License, Version 2.0 (the
*  "License"); you may not use this file except in compliance
*  with the License.  You may obtain a copy of the License at
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*   * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.apache.axis2.transport.base;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.description.AxisService;

/**
 * Describes a protocol specific endpoint. This might be a TCP/UDP port, a mail account,
 * a JMS destination, etc. Typically, a protocol specific endpoint is mapped to a
 * service.
 */
public abstract class ProtocolEndpoint {
    /** Axis2 service */
    private AxisService service;
    
    public final AxisService getService() {
        return service;
    }

    // TODO: this should only be called by AbstractTransportListener and declared with package access
    public final void setService(AxisService service) {
        this.service = service;
    }
    
    public final String getServiceName() {
        return service.getName();
    }

    /**
     * Get the endpoint references for this protocol endpoint.
     * 
     * @param ip The host name or IP address of the local host. The implementation should use
     *           this information instead of {@link java.net.InetAddress#getLocalHost()}.
     *           The value of this parameter may be <code>null</code>, in which case the
     *           implementation should use {@link org.apache.axis2.util.Utils#getIpAddress(
     *           org.apache.axis2.engine.AxisConfiguration)}.
     * @return an array of endpoint references
     * @throws AxisFault
     * 
     * @see org.apache.axis2.transport.TransportListener#getEPRsForService(String, String)
     */
    public abstract EndpointReference[] getEndpointReferences(String ip) throws AxisFault;
}
