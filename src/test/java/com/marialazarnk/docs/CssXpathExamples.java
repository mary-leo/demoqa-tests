package com.marialazarnk.docs;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {

    void cssXpathExamples() {

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        $("[data-testid=email]");
        $(by("data-testid", "email"));



        // <input type="email" class="inputtext login_form_input_box" name="email" id="email">
        $("#email");
        $(byId("email")); //selenide
        $(By.id("email")); //selenium
        $("[id=email]");
        $("[id='e mail']");
        $("[id=\"email\"]");
        $(by("id", "email"));
        $x("//*[@id='email']");
        $(byXpath("//*[@id='email']"));

        $("input#email");
        $("input[id=email]");



        //<label title="" for="gender-radio-3" class="custom-control-label">Other</label>
        $(byText("Other"));

        // <input type="email" class="inputtext login_form_input_box" name="email">
        $("[name=email]");
        $(byName("email"));


        // <input type="email" class="inputtext login_form_input_box">
        $(byClassName("login_form_input_box"));
        $(".login_form_input_box");
        $(".inputtext.login_form_input_box");
        $x("//*[@class='login_form_input_box']");

        // <div type="email" class="inputtext">
        //      <input class="login_form_input_box">
        // </div>
        $(".inputtext .login_form_input_box");


        // <div>Hello qa.guru</div>
        $(byText("Hello qa.guru"));
        $(withText("lo qa.guru"));


    }
}
