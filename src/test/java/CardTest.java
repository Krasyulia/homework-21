import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CardTest {

    @Test
    void cardOrderSuccessTest(){
        open("http://localhost:9999/");

        $("input.input__control").setValue("Кристобаль Картохель");
        $("input[name='phone']").setValue("+79085552266");
        $("span.checkbox__box").click();
        $("span.button__text").click();
        $(".paragraph").shouldHave(text("успешно"));
    }

    @Test
    void cardOrderValidationTest(){
        open("http://localhost:9999/");

        $("input.input__control").setValue("Karl Marx");
        $("input[name='phone']").setValue("+79085552266");
        $("span.checkbox__box").click();
        $("span.button__text").click();
        $(".input__sub").shouldHave(text("Имя и Фамилия указаные неверно"));
    }
}