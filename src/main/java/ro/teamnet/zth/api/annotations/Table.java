package ro.teamnet.zth.api.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Created by Alexandra.Traila on 7/12/2017.
 */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
     public @interface Table {

    String name() default "";
  }

