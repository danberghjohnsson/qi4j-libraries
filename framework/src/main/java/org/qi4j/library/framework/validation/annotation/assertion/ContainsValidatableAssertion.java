package org.qi4j.library.framework.validation.annotation.assertion;

import org.qi4j.library.framework.validation.AbstractAnnotationValidatableAssertion;
import org.qi4j.library.framework.validation.annotation.Contains;

/**
 * TODO
 */
public class ContainsValidatableAssertion
    extends AbstractAnnotationValidatableAssertion<Contains, String>
{
    protected boolean isValid( Contains annotation, String argument )
    {
        return argument.contains( annotation.value() );
    }
}