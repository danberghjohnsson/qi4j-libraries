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
package org.qi4j.library.swing.visualizer.detailPanel.internal.common.form.composite.mixin;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import java.lang.annotation.Annotation;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static org.qi4j.library.swing.visualizer.detailPanel.internal.common.ToStringUtils.typeToString;
import org.qi4j.spi.composite.DependencyDescriptor;

/**
 * @author edward.yakop@gmail.com
 * @since 0.5
 */
public class DepedencyDescriptorPanel
{
    private JComponent injectedSeparator;
    private JTextField injectedClassName;
    private JCheckBox isOptional;

    private JComponent injectionSeparator;
    private JTextField injectionAnnotation;
    private JTextField injectionClassName;
    private JTextField injectionType;
    private JTextField injectionRawType;
    private JPanel form;

    public final void updateModel( DependencyDescriptor aDescriptor )
    {
        populateInjectedFields( aDescriptor );
        populateInjectionFields( aDescriptor );
    }

    private void populateInjectedFields( DependencyDescriptor aDescriptor )
    {
        String className = null;
        boolean optional = false;

        if( aDescriptor != null )
        {
            className = aDescriptor.injectedClass().getName();
            optional = aDescriptor.optional();
        }

        injectedClassName.setText( className );
        isOptional.setSelected( optional );
    }

    private void populateInjectionFields( DependencyDescriptor aDescriptor )
    {
        String annotationCNameStr = null;
        String injectionCNameStr = null;
        String injectionTypeStr = null;
        String rawInjectionTypeStr = null;

        if( aDescriptor != null )
        {
            Annotation annotation = aDescriptor.injectionAnnotation();
            annotationCNameStr = typeToString( annotation.annotationType() );
            injectionCNameStr = typeToString( aDescriptor.injectionClass() );
            injectionTypeStr = typeToString( aDescriptor.injectionType() );
            rawInjectionTypeStr = typeToString( aDescriptor.rawInjectionType() );
        }

        injectionAnnotation.setText( annotationCNameStr );
        injectionClassName.setText( injectionCNameStr );
        injectionType.setText( injectionTypeStr );
        injectionRawType.setText( rawInjectionTypeStr );
    }

    private void createUIComponents()
    {
        DefaultComponentFactory cmpFactory = DefaultComponentFactory.getInstance();
        injectedSeparator = cmpFactory.createSeparator( "Injected" );
        injectionSeparator = cmpFactory.createSeparator( "Injection" );
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$()
    {
        createUIComponents();
        form = new JPanel();
        form.setLayout( new FormLayout( "fill:p:noGrow,left:4dlu:noGrow,fill:max(m;100dlu):grow", "center:max(d;4px):noGrow,top:4dlu:noGrow,center:d:noGrow,center:p:noGrow,top:4dlu:noGrow,center:p:noGrow,top:4dlu:noGrow,center:p:noGrow,top:4dlu:noGrow,center:p:noGrow,top:4dlu:noGrow,center:p:noGrow,top:4dlu:noGrow,center:p:noGrow,top:4dlu:noGrow,center:p:noGrow" ) );
        ( (FormLayout) form.getLayout() ).setRowGroups( new int[][]{ new int[]{ 4, 6, 10, 12, 14, 16 }, new int[]{ 1, 8 } } );
        final JLabel label1 = new JLabel();
        label1.setText( "Class Name" );
        CellConstraints cc = new CellConstraints();
        form.add( label1, cc.xy( 1, 4 ) );
        final JLabel label2 = new JLabel();
        label2.setText( "Optional" );
        form.add( label2, cc.xy( 1, 6 ) );
        injectedClassName = new JTextField();
        form.add( injectedClassName, cc.xy( 3, 4, CellConstraints.FILL, CellConstraints.DEFAULT ) );
        isOptional = new JCheckBox();
        isOptional.setText( "" );
        form.add( isOptional, cc.xy( 3, 6 ) );
        form.add( injectionSeparator, cc.xyw( 1, 8, 3 ) );
        final JLabel label3 = new JLabel();
        label3.setText( "Annotation" );
        form.add( label3, cc.xy( 1, 10 ) );
        final JLabel label4 = new JLabel();
        label4.setText( "Injection class" );
        form.add( label4, cc.xy( 1, 12 ) );
        final JLabel label5 = new JLabel();
        label5.setText( "injectionType" );
        form.add( label5, cc.xy( 1, 14 ) );
        final JLabel label6 = new JLabel();
        label6.setText( "Raw injection type" );
        form.add( label6, cc.xy( 1, 16 ) );
        injectionAnnotation = new JTextField();
        form.add( injectionAnnotation, cc.xy( 3, 10, CellConstraints.FILL, CellConstraints.DEFAULT ) );
        injectionClassName = new JTextField();
        form.add( injectionClassName, cc.xy( 3, 12, CellConstraints.FILL, CellConstraints.DEFAULT ) );
        injectionType = new JTextField();
        injectionType.setText( "" );
        form.add( injectionType, cc.xy( 3, 14, CellConstraints.FILL, CellConstraints.DEFAULT ) );
        injectionRawType = new JTextField();
        form.add( injectionRawType, cc.xy( 3, 16, CellConstraints.FILL, CellConstraints.DEFAULT ) );
        form.add( injectedSeparator, cc.xyw( 1, 1, 3 ) );
        label1.setLabelFor( injectedClassName );
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$()
    {
        return form;
    }
}