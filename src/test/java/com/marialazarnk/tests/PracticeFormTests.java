package com.marialazarnk.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void fillFormTest() {

        String firstName = "Harry";
        String lastName = "Potter";
        String userEmail = "harry@hogwarts.mag";
        String userGender = "Other";
        String userNumber = "0123456789";
        String dateOfBirth = "31 July,1980";
        String subjectsInput = "Protection from the Dark Arts";
        String hobbies = "Sports";
        String currentAddress = "The Burrow";
        String state = "NCR";
        String city = "Delhi";



        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-3").click();
        $("#userNumber").setValue(userNumber);
//дата рождения
        $("#subjectsInput").setValue(subjectsInput);
        $("#hobbies-checkbox-1").click();
//пикча
        $("#currentAddress").setValue(currentAddress);
        //штат
//город
        $("#submit").click();
        $("#submit").click();
        
        $(#output #name).shouldHave(text(firstName + " " + lastName));
        $(#output #name).shouldHave(text(userEmail));
        $(#output #name).shouldHave(text(userGender));
        $(#output #name).shouldHave(text(userNumber));
        $(#output #name).shouldHave(text(dateOfBirth));
        $(#output #name).shouldHave(text(subjectsInput));
        $(#output #name).shouldHave(text(hobbies));
        $(#output #name).shouldHave(text(currentAddress));
        $(#output #name).shouldHave(text(state + " " + city));



    }
}
