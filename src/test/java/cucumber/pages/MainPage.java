package cucumber.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;



public class MainPage {

    //Main elements
    public SelenideElement googleSearchField = $("input[name=\"q\"]");
    public ElementsCollection googleSearchTitles = $$(".LC20lb");
    public ElementsCollection googleDetectedLinks = $$(".TbwUpd .iUh30");
    public ElementsCollection googleSwitchPages = $$("#xjs a.fl");
    //Secondary elements
    public SelenideElement firstSiteTitle = $("#firstHeading");

}
