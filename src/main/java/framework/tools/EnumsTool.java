package framework.tools;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnumsTool {

    public static <TEnum extends Enum<TEnum>> TEnum getEnumNameByString(Class<TEnum> enumClass, String value) {
        for (TEnum element : enumClass.getEnumConstants()) {
            try {
                if (value.equals(element.toString())) {
                    log.debug("{}.getEnumNameByString(): {}", enumClass.getSimpleName(), element.toString());
                    return element;
                }
            } catch (Exception e) {
                log.error("Error reading values from Enum {}: {}", enumClass.getSimpleName(), e);
            }
        }
        return null;
    }
}
