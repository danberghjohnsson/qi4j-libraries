package org.qi4j.library.framework.scripting;
/*
 * Copyright 2007 Rickard Öberg
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License.
*/

import junit.framework.TestCase;
import org.qi4j.api.CompositeFactory;
import org.qi4j.runtime.CompositeFactoryImpl;

public class JavaScriptMixinTest extends TestCase
{
    JavaScriptMixin scriptMixin;

    public void testInvoke() throws Throwable
    {
        CompositeFactory factory = new CompositeFactoryImpl();

        ScriptComposite domain = factory.newInstance( ScriptComposite.class);
        
        System.out.println(domain.do1());
    }
}