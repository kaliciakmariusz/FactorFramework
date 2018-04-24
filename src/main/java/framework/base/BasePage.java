package framework.base;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BasePage extends Base {

    public <TPage extends BasePage> TPage as(Class<TPage> pageInstance) {
        try {
            return (TPage) this;
        } catch (Exception e) {
            log.error("Failure in methode: {}", e);
        }
        return null;
    }
}
