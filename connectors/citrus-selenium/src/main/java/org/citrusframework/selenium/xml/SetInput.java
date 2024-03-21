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

package org.citrusframework.selenium.xml;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.citrusframework.TestActor;
import org.citrusframework.selenium.actions.AbstractSeleniumAction;
import org.citrusframework.selenium.actions.FindElementAction;
import org.citrusframework.selenium.actions.SetInputAction;
import org.citrusframework.selenium.endpoint.SeleniumBrowser;

@XmlRootElement(name = "set-input")
public class SetInput extends AbstractSeleniumAction.Builder<SetInputAction, SetInput> implements ElementAware {

    private final SetInputAction.Builder delegate = new SetInputAction.Builder();

    @XmlAttribute
    public void setValue(String value) {
        this.delegate.value(value);
    }

    @Override
    @XmlElement
    public void setElement(Element element) {
        ElementAware.super.setElement(element);
    }

    @Override
    public FindElementAction.ElementActionBuilder<?, ?> getElementBuilder() {
        return delegate;
    }

    @Override
    public SetInput description(String description) {
        delegate.description(description);
        return this;
    }

    @Override
    public SetInput actor(TestActor actor) {
        delegate.actor(actor);
        return this;
    }

    @Override
    public SetInput browser(SeleniumBrowser seleniumBrowser) {
        delegate.browser(seleniumBrowser);
        return this;
    }

    @Override
    public SetInputAction build() {
        return delegate.build();
    }
}
