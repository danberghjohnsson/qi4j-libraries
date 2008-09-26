/*  Copyright 2008 Edward Yakop.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
* implied.
*
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.qi4j.library.swing.visualizer.detailPanel;

import org.qi4j.library.swing.visualizer.model.ApplicationDetailDescriptor;
import org.qi4j.library.swing.visualizer.model.CompositeDetailDescriptor;
import org.qi4j.library.swing.visualizer.model.EntityDetailDescriptor;
import org.qi4j.library.swing.visualizer.model.LayerDetailDescriptor;
import org.qi4j.library.swing.visualizer.model.ModuleDetailDescriptor;
import org.qi4j.library.swing.visualizer.model.ObjectDetailDescriptor;
import org.qi4j.library.swing.visualizer.model.ServiceDetailDescriptor;

/**
 * @author edward.yakop@gmail.com
 * @since 0.5
 */
public interface DisplayManager
{
    void displayApplication( DetailPanel aDetailPanel, ApplicationDetailDescriptor aDescriptor );

    void displayLayer( DetailPanel aDetailPanel, LayerDetailDescriptor aDescriptor );

    void displayModule( DetailPanel aDetailPanel, ModuleDetailDescriptor aDescriptor );

    void displayService( DetailPanel aDetailPanel, ServiceDetailDescriptor aDescriptor );

    /**
     * Invoked when the specified detail panel is displaying a composite.
     *
     * @param aDetailPanel Detail panel. This argument must not be {@code null}.
     * @param aDescriptor  composite to display. This argument must not be {@code null}.
     * @since 0.5
     */
    void displayComposite( DetailPanel aDetailPanel, CompositeDetailDescriptor aDescriptor );

    void displayEntity( DetailPanel aDetailPanel, EntityDetailDescriptor aDescriptor );

    void displayObject( DetailPanel aDetailPanel, ObjectDetailDescriptor aDescriptor );
}