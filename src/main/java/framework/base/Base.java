package framework.base;

import framework.controls.api.ControlFactory;

public class Base {

    public static BasePage currentPage;

    public <TPage extends BasePage> TPage getInstance(Class<TPage> page) {
        Object obj = ControlFactory.initElements(DriverContext.driver, page);
        return page.cast(obj);
    }
}
