package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PageSoftAssertionsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1366x766";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void SuccessTest() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $$("div.markdown-body li").get(8).shouldHave(text("Soft assertion"));
        $$("div.markdown-body li").get(8).$("a").click();
        $("#user-content-3-using-junit5-extend-test-class").sibling(0).shouldHave(text(
                "@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));


    }
}




