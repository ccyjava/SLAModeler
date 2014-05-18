package edu.pku.sei.sla.model.msg;

import java.lang.reflect.Field;

import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;
import edu.pku.sei.gmp.model.concept.GMPModelElement;

public aspect ModelMessageNotification {

    after(Object newValue) : set(* GMPModelElement+.*) && args(newValue) {
        String fieldName = thisJoinPoint.getSignature().getName();
        Field field = null;
        try {
            field = thisJoinPoint.getSignature().getDeclaringType()
                    .getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            return;
        }

        if (field == null) {
            return;
        }

        GMPAnnotation annotation = field.getAnnotation(GMPAnnotation.class);

        if (annotation == null) {
            return;
        }

        if (annotation.refresh()) {
            GMPElement element = (GMPElement) thisJoinPoint.getTarget();
            element.firePropertyChange(annotation.name(), null, newValue);
        }
    }

}
