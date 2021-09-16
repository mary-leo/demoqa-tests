package com.marialazarnk.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static javax.management.Query.not;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        String firstName = "Harry";
        String lastName = "Potter";
        String userEmail = "harry@hogwarts.mag";
        String userGender = "Other";
        String userNumber = "0123456789";
        String dateOfBirth = "31 July,1981";
        String monthOfBirth = "July";
        String yearOfBirth = "1981";
        String dayOfBirth = "31";
        String subjectsInput = "Physics";
        String picture = "harry_potter.jpg";
        String hobbies = "Sports";
        String currentAddress = "The Burrow";
        String state = "NCR";
        String city = "Delhi";



        open("/automation-practice-form");
        //текстовые поля
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);

        // радио-кнопка
        $(byText(userGender)).click();
        // решения с разбора дз:
        //$("#genterWrapper").$(byText(userGender)).click(); //лучшее решение
        //$("#gender-radio-3").parent().click();
        //берем множество, фильтруем, выбираем первое совпадение, кликаем:
        //$$("#label.custom-control-label").filter(text(userGender)).get(0).click();

        //текстовое поле
        $("#userNumber").setValue(userNumber);

        //дата рождения, календарь
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOptionContainingText(monthOfBirth);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionContainingText(yearOfBirth);
        $(".react-datepicker__year-select").click();
        $(byText(dayOfBirth)).click();

        //календарь из разбора дз:
        //$("#dateOfBirthInput").click(); 1шаг
        //$(".react-datepicker__month-select").selectOption(monthOfBirth); 2шаг
        //$(".react-datepicker__year-select").selectOption(yearOfBirth); 3шаг
        //class="react-datepicker__day--029 react-datepicker__day--outside-month"
        //class="react-datepicker__day--029"
        //1
        //$(".react-datepicker__day--029:not(.react-datepicker__day--outside-month)").click(); - 4шаг лучшее решение
        //2
        //$$(".react-datepicker__day--029").
        //        filter(not(cssClass(".react-datepicker__day--outside-month"))).first().click();
        // aria-label="Choose Wednesday, September 29th, 2021"
        // aria-label="Choose Sunday, August 29th, 2021"
        //$("[aria-label=\"Choose Sunday, August 29th, 2021\"]").click();
        // css:[key="value"] | xpath:[@key="value"] //-начинаем искать сверху, * - ищем любой элемент
        //$x("//div[contains(@aria-label, =\"August 29th, 2021\")]").click(); //именно div-элемент
        //$x("//*[contains(@aria-label, =\"August 29th, 2021\")]").click();   // любой элемент


        //выпадающий список, печатать, enter
        $("#subjectsInput").setValue(subjectsInput).pressEnter();

        //чек-бокс
        $(byText(hobbies)).click();

        //чек-бокс из разбора дз:
        //$("#hobbiesWrapper").$(byText(hobbies)).click();

        //загрузить картинку
        $("#uploadPicture").uploadFile(new File("src/test/resources/" + picture));

        //загрузить картинку из разбора дз:
        //$("#uploadPicture").uploadFromClasspath("harry_potter.jpg");

        //ввести текст
        $("#currentAddress").setValue(currentAddress);

        //выпадающий список. Штат и город.
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        //кнопка
        $("#submit").click();
        


        //ShouldHave...

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
//      $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail));

        $(".table-responsive").$(byText("Student Name")).
                parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).
                parent().shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).
                parent().shouldHave(text(userGender));
        $(".table-responsive").$(byText("Mobile")).
                parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).
                parent().shouldHave(text(dateOfBirth));
        $(".table-responsive").$(byText("Subjects")).
                parent().shouldHave(text(subjectsInput));
        $(".table-responsive").$(byText("Hobbies")).
                parent().shouldHave(text(hobbies));
        $(".table-responsive").$(byText("Picture")).
                parent().shouldHave(text(picture));
        $(".table-responsive").$(byText("Address")).
                parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).
                parent().shouldHave(text(state + " " + city));
    }
}
