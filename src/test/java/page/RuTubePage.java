package page;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RuTubePage {

    private final SelenideElement
            searchInput = $(".freyja_char-header-search__input__ln9vI"),
            searchChannelsResults = $(".wdp-search-channels-module__channels"),
            mainMenuItemsBox = $(".freyja_char-menu-content__menuOpen__S-A94").$(".navigation_group_main"),
            categoryItemsBox = $(".freyja_char-menu-content__menuOpen__S-A94").$(".navigation_group_category"),
            filtersPan = $(".pen-tabs");

    public RuTubePage openPage(String url) {
        open(url);

        return this;
    }

    public RuTubePage searchChannel(String channelName) {
        //searchInput.click();
        searchInput.setValue(channelName).pressEnter();

        return this;
    }

    public RuTubePage checkSearchResults(String channelName) {
        searchChannelsResults.shouldHave(text(channelName));

        return this;
    }

    public RuTubePage checkMainMenuItems(List<String> menuItems) {
        for (String item : menuItems) {
            mainMenuItemsBox.shouldHave(text(item));
        }

        return this;
    }

    public RuTubePage openCategory(String categoryItem) {
        categoryItemsBox.$(byText(categoryItem)).click();
        return this;
    }

    public RuTubePage checkFilter(String filterName) {
        filtersPan.shouldHave(text(filterName));
        return this;
    }


}
