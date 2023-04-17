package ru.frigesty.tests;

import org.junit.jupiter.api.Test;
import ru.frigesty.pages.RegistrationPageTextBox;

public class TextBoxTests extends TestBase {

    RegistrationPageTextBox registrationTestPage = new RegistrationPageTextBox();

    @Test
    void successfulFillFormTest() {
        registrationTestPage.openPageName()
                            .setUserName("Mr Smith")
                            .setUserEmail("aa@aaa.com")
                            .setCurrentAddress("Some street 1")
                            .setPermanentAddress("Another street 1")
                            .setSubmit();

        registrationTestPage.verifyResultTextBox("Name:","Mr Smith")
                            .verifyResultTextBox("Email:","aa@aaa.com")
                            .verifyResultTextBox("Current Address :","Some street 1")
                            .verifyResultTextBox("Permananet Address :","Another street 1");
    }
}
