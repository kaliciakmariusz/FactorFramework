package framework.controls.elements;

import framework.controls.api.ImplementedBy;
import framework.controls.internals.Control;

@ImplementedBy(HyperLinkBase.class)
public interface HyperLink extends Control {


    void clickLink();

    String getUrlText();

    boolean checkUrlTextContains(String containsText);
}