package framework.base;

public abstract class BasePage extends Base {

    public <TPage extends BasePage> TPage as(Class<TPage> pageInstance) {
        try {
            return (TPage) this;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }
}
