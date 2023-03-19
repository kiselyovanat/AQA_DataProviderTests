import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import page.RuTubePage;

import java.util.List;
import java.util.stream.Stream;

public class ParameterizedTestsForRuTube extends TestBase {

    public RuTubePage ruTubePage = new RuTubePage();

    static Stream<Arguments> checkMainMenuContent() {
        return Stream.of(
                Arguments.of(List.of("Главная", "В топе", "Каталог", "Originals"))
        );
    }

    @ParameterizedTest(name = "В результатах поиска есть канал {0}")
    @ValueSource(strings = {
            "Телеканал ТНТ", "КВН"
    })
    void findRuTubeChannel(String channel) {
        ruTubePage.openPage("/")
                .searchChannel(channel)
                .checkSearchResults(channel);
    }

    @ParameterizedTest(name = "Пункты меню содержат {0}")
    @MethodSource
    void checkMainMenuContent(List<String> menuItems) {
        ruTubePage.openPage("/")
                .checkMainMenuItems(menuItems);

    }

    @ParameterizedTest(name = "Категория {0} сожержит фильтр {1}")
    @CsvSource(value = {
            "Трансляции, Прямые трансляции",
            "ТВ онлайн, Платные",
            "Новости и СМИ, Федеральные",
            "Видеоигры, Киберспорт"

    })
    void checkCategoryContent(String categoryItem, String filterName) {
        ruTubePage.openPage("/")
                .openCategory(categoryItem)
                .checkFilter(filterName);

    }
}
