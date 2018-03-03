package framework.controls.api;

import framework.controls.internals.Control;

public final class ImplementedByProcessor {

    public ImplementedByProcessor() {
    }

    public static <T> Class<?> getWrapperClass(Class<T> iface) {
        if (iface.isAnnotationPresent(ImplementedBy.class)) {
            ImplementedBy annotation = iface.getAnnotation(ImplementedBy.class);
            Class<?> clazz = annotation.value();
            if (Control.class.isAssignableFrom(clazz)) {
                return annotation.value();
            }
        }
        throw new UnsupportedOperationException("Apply @ImplementedBy interface to your Interface " +
                iface.getCanonicalName() + " if you want to extend ");
    }
}