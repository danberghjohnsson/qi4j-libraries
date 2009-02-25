/*  Copyright 2009 Tonny Kohar.
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
package org.qi4j.library.swing.envisage.detail;

import java.awt.BorderLayout;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.qi4j.library.swing.envisage.model.descriptor.ObjectDetailDescriptor;
import org.qi4j.library.swing.envisage.model.descriptor.ServiceDetailDescriptor;

/**
 * @author Tonny Kohar (tonny.kohar@gmail.com)
 */
public class DetailModelPane extends JPanel
{

    protected ResourceBundle bundle = ResourceBundle.getBundle(this.getClass().getName());

    protected JTabbedPane tabPane;
    protected GeneralPane generalPane;
    protected MethodPane methodPane;
    protected StatePane statePane;
    protected DependencyPane dependencyPane;
    protected ServiceConfigurationPane serviceConfigurationPane;
    protected ServiceUsagePane serviceUsagePane;

    public DetailModelPane()
    {
        tabPane = new JTabbedPane( );

        this.setLayout( new BorderLayout() );
        this.add(tabPane, BorderLayout.CENTER);

        createDetailPane( );

        tabPane.add( bundle.getString( "CTL_GeneralTab.Text" ),  generalPane );
        tabPane.add( bundle.getString( "CTL_DependencyTab.Text" ), dependencyPane );
        tabPane.add( bundle.getString( "CTL_MethodTab.Text" ), methodPane );
    }

    protected void createDetailPane()
    {
        generalPane = new GeneralPane();
        generalPane.setBorder( BorderFactory.createEmptyBorder(8, 8, 8, 8) );

        statePane = new StatePane();
        statePane.setBorder( BorderFactory.createEmptyBorder(8, 8, 8, 8) );

        methodPane = new MethodPane();
        methodPane.setBorder( BorderFactory.createEmptyBorder(8, 8, 8, 8) );

        dependencyPane = new DependencyPane();
        dependencyPane.setBorder( BorderFactory.createEmptyBorder(8, 8, 8, 8) );

        serviceConfigurationPane = new ServiceConfigurationPane();
        serviceConfigurationPane.setBorder( BorderFactory.createEmptyBorder(8, 8, 8, 8) );

        serviceUsagePane = new ServiceUsagePane();
        serviceUsagePane.setBorder( BorderFactory.createEmptyBorder(8, 8, 8, 8) );

    }

    public void setDescriptor(Object objectDescriptor)
    {
        generalPane.setDescriptor( objectDescriptor );
        dependencyPane.setDescriptor( objectDescriptor );
        methodPane.setDescriptor( objectDescriptor );
        statePane.setDescriptor( objectDescriptor );
        serviceConfigurationPane.setDescriptor( objectDescriptor );
        serviceUsagePane.setDescriptor( objectDescriptor );

        if (objectDescriptor instanceof ObjectDetailDescriptor )
        {
            int index = tabPane.indexOfComponent( statePane );
            if (index != -1)
            {
                tabPane.removeTabAt( index );
            }
        } else {
            int index = tabPane.indexOfComponent( statePane );
            if (index == -1)
            {
                tabPane.add( bundle.getString( "CTL_StateTab.Text" ), statePane );
            }
        }

        if (objectDescriptor instanceof ServiceDetailDescriptor)
        {
            int index = tabPane.indexOfComponent( serviceConfigurationPane );
            if (index == -1)
            {
                tabPane.add( bundle.getString( "CTL_ServiceConfiguration.Text" ), serviceConfigurationPane );
                tabPane.add( bundle.getString( "CTL_ServiceUsage.Text" ), serviceUsagePane );                
            }
        } else {
            int index = tabPane.indexOfComponent( serviceConfigurationPane );
            if (index != -1)
            {
                tabPane.removeTabAt( index );
                tabPane.removeTabAt( index );
            }
        }

    }
}