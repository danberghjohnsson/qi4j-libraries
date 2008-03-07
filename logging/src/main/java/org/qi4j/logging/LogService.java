/*
 * Copyright 2006 Niclas Hedhman.
 *
 * Licensed  under the  Apache License,  Version 2.0  (the "License");
 * you may not use  this file  except in  compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed  under the  License is distributed on an "AS IS" BASIS,
 * WITHOUT  WARRANTIES OR CONDITIONS  OF ANY KIND, either  express  or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.qi4j.logging;

import java.lang.reflect.Method;
import org.qi4j.composite.Composite;
import org.qi4j.property.Property;

public interface LogService
{
    Property<Integer> traceLevel();

    void traceEntry( Class compositeType, Composite object, Method method, Object[] args );

    void traceExit( Class compositeType, Composite object, Method method, Object[] args, Object result );

    void traceException( Class compositeType, Composite object, Method method, Object[] args, Throwable t );


    Property<Integer> debugLevel();

    Property<String> debugFormat();

    void debug( Composite composite, String message );

    void debug( Composite composite, String message, Object param1 );

    void debug( Composite composite, String message, Object param1, Object param2 );

    void debug( Composite composite, String message, Object... params );


    Property<String> logFormat();

    void log( LogType type, Composite composite, String category, String message );

    void log( LogType type, Composite composite, String category, String message, Object param1 );

    void log( LogType type, Composite composite, String category, String message, Object param1, Object param2 );

    void log( LogType type, Composite composite, String category, String message, Object... params );
}