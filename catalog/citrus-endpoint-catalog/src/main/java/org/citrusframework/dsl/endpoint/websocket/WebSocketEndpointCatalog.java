/*
 * Copyright the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.citrusframework.dsl.endpoint.websocket;

import org.citrusframework.websocket.client.WebSocketClientBuilder;
import org.citrusframework.websocket.endpoint.builder.WebSocketEndpoints;
import org.citrusframework.websocket.server.WebSocketServerBuilder;

/**
 * @author Christoph Deppisch
 */
public class WebSocketEndpointCatalog {

    /**
     * Private constructor setting the client and server builder implementation.
     */
    private WebSocketEndpointCatalog() {
        // prevent direct instantiation
    }

    public static WebSocketEndpointCatalog websocket() {
        return new WebSocketEndpointCatalog();
    }

    /**
     * Gets the client builder.
     * @return
     */
    public WebSocketClientBuilder client() {
        return WebSocketEndpoints.websocket().client();
    }

    /**
     * Gets the client builder.
     * @return
     */
    public WebSocketServerBuilder server() {
        return WebSocketEndpoints.websocket().server();
    }
}
