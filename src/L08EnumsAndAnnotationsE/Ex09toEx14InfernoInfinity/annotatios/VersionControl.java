package L08EnumsAndAnnotationsE.Ex09toEx14InfernoInfinity.annotatios;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface VersionControl {
    String author() default "";

    String description() default "";

    int revision() default 0;

    String[] reviewers() default {};
}