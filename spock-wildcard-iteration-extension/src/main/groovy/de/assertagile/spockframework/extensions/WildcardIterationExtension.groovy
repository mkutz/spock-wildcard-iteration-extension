package de.assertagile.spockframework.extensions

import org.spockframework.runtime.extension.IAnnotationDrivenExtension
import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.FieldInfo
import org.spockframework.runtime.model.MethodInfo
import org.spockframework.runtime.model.SpecInfo

import groovy.util.logging.Slf4j
import spock.lang.Unroll

/**
 * <p>
 * Extension for the <a href="http://spockframework.org">Spock Framework</a> ...
 * </p>
 */
@Slf4j
public class WildcardIterationExtension implements IGlobalExtension, IAnnotationDrivenExtension<Unroll> {

    /**
     * Standard constructor.
     */
    public WildcardIterationExtension() {}

    /**
     * Called when this extension is started as {@link IGlobalExtension}.
     */
    @Override
    void start() {}

    /**
     * Called when this extension is stopped as {@link IGlobalExtension}.
     */
    @Override
    void stop() {}

    @Override
    public void visitSpec(SpecInfo spec) {
        log.debug("Visiting ${spec.name}")
    }

    @Override
    void visitSpecAnnotation(Unroll annotation, SpecInfo spec) {}

    @Override
    void visitFeatureAnnotation(Unroll annotation, FeatureInfo feature) {
        feature.getDataVariables()
    }

    @Override
    void visitFixtureAnnotation(Unroll annotation, MethodInfo fixtureMethod) {}

    @Override
    void visitFieldAnnotation(Unroll annotation, FieldInfo field) {}
}
