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

package org.citrusframework.context.resolver;

import org.citrusframework.exceptions.CitrusRuntimeException;
import org.citrusframework.xml.MarshallerAdapter;
import org.citrusframework.xml.Unmarshaller;
import org.springframework.oxm.Marshaller;

/**
 * @author Christoph Deppisch
 */
public class UnmarshallerAliasResolver implements TypeAliasResolver<Unmarshaller, org.springframework.oxm.Unmarshaller> {

    @Override
    public boolean isAliasFor(Class<?> sourceType) {
        return Unmarshaller.class.isAssignableFrom(sourceType);
    }

    @Override
    public Unmarshaller adapt(Object alias) {
        if (!org.springframework.oxm.Unmarshaller.class.isAssignableFrom(alias.getClass())) {
            throw new CitrusRuntimeException(String.format("Given alias object is not assignable from %s", org.springframework.oxm.Unmarshaller.class));
        }

        if (Marshaller.class.isAssignableFrom(alias.getClass())) {
            return new MarshallerAdapter((Marshaller) alias, (org.springframework.oxm.Unmarshaller) alias);
        } else {
            return new MarshallerAdapter(null, (org.springframework.oxm.Unmarshaller) alias);
        }
    }

    @Override
    public Class<org.springframework.oxm.Unmarshaller> getAliasType() {
        return org.springframework.oxm.Unmarshaller.class;
    }
}
