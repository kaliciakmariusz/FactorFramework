package framework.controls.elements;

import framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class TextBoxBase extends ControlBase implements TextBox {

    public TextBoxBase(WebElement element) {
        super(element);
    }

    @Override
    public void enterText(String text) {

        getWrappedElement().sendKeys(text);
    }

    @Override
    public String getTextValue() {
        return getWrappedElement().getText();
    }
}
