package framework.controls.elements;

import framework.controls.internals.ControlBase;
import org.openqa.selenium.WebElement;

public class HyperLinkBase extends ControlBase implements HyperLink {
    public HyperLinkBase(WebElement element) {
        super(element);
    }

    @Override
    public void clickLink() {
        getWrappedElement().click();
    }

    @Override
    public String getUrlText() {
        return getWrappedElement().getText();
    }

    @Override
    public boolean checkUrlTextContains(String containsText) {

        if (getWrappedElement().getText().contains(containsText)) {
            return true;
        } else {
            return false;
        }
    }
}