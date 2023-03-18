import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CardTest {

    @Test
    void cardOrderSuccessTest(){
        open("http://localhost:9999/");

        $("[data-test-id='name'] input").setValue("Кристобаль Картохель");
        $("input[name='phone']").setValue("+79085552266");
        $("span.checkbox__box").click();
        $("span.button__text").click();
        $(".paragraph[data-test-id=\"order-success\"]").shouldHave(text("успешно"));
    }

    @Test
    void cardOrderNameValidationTest(){
        open("http://localhost:9999/");

        $("[data-test-id='name'] input").setValue("Karl Marx");
        $("input[name='phone']").setValue("+79085552266");
        $("span.checkbox__box").click();
        $("span.button__text").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(text("Имя и Фамилия указаные неверно"));

    }

    @Test
    void cardOrderPhoneValidationTest(){
        open("http://localhost:9999/");

        $("[data-test-id='name'] input").setValue("Карл Маркс");
        $("input[name='phone']").setValue("+7908555226611111111");
        $("span.button__text").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(text("Телефон указан неверно"));

    }

    @Test
    void cardOrderAgreementValidationTest(){
        open("http://localhost:9999/");

        $("[data-test-id='name'] input").setValue("Карл Маркс");
        $("input[name='phone']").setValue("+79085552266");
        $("span.button__text").click();
        $("label[data-test-id=\"agreement\"].input_invalid").shouldBe(visible);

    }

    @Test
    void emptyNameTest(){
        open("http://localhost:9999/");

        $("input[name='phone']").setValue("+79085552266");
        $("span.checkbox__box").click();
        $("span.button__text").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(text("Поле обязательно для заполнения"));

    }

    @Test
    void emptyPhoneTest(){
        open("http://localhost:9999/");

        $("[data-test-id='name'] input").setValue("Карл Маркс");
        $("span.checkbox__box").click();
        $("span.button__text").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(text("Поле обязательно для заполнения"));

    }

}