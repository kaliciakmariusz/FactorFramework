package framework.controls.elements;

import framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class ButtonBase extends ControlBase implements Button {


    public ButtonBase(WebElement element) {
        super(element);
    }

    @Override
    public void performClick() {
        getWrappedElement().click();
    }

    @Override
    public String getButtonText() {
        return getWrappedElement().getText();
    }

    @Override
    public void performSubmit() {
        getWrappedElement().submit();
    }
}