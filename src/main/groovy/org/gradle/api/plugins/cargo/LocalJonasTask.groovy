/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gradle.api.plugins.cargo

import org.gradle.api.plugins.cargo.property.LocalJonasTaskProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional

/**
 * Deploys WAR to local Jonas container.
 *
 * @author Benjamin Muschko
 */
class LocalJonasTask extends LocalContainerTask {
    @Input @Optional Integer jmsPort
    @Input @Optional String serverName
    @Input @Optional String servicesList
    @Input @Optional String domainName

    @Override
    void setContainerSpecificProperties() {
        if(getJmsPort()) {
            ant.property(name: LocalJonasTaskProperty.JMS_PORT.name, value: getJmsPort())
        }
        if(getServerName()) {
            ant.property(name: LocalJonasTaskProperty.SERVER_NAME.name, value: getServerName())
        }
        if(getServicesList()) {
            ant.property(name: LocalJonasTaskProperty.SERVICES_LIST.name, value: getServicesList())
        }
        if(getDomainName()) {
            ant.property(name: LocalJonasTaskProperty.DOMAIN_NAME.name, value: getDomainName())
        }
    }
}
