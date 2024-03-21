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

package org.citrusframework.testng;

import org.testng.SkipException;

/**
 * @author Thorsten Schlathoelter
 */
public class TestNGUtils {

    /**
     * Skip a test depending on operating system
     * @param os
     * @param reasonForSkip
     */
    public static void skipForOs(String os, String reasonForSkip) {
        if (System.getProperty("os.name").toLowerCase().contains(os.toLowerCase())) {
            throw new SkipException(reasonForSkip);
        }
    }
}
