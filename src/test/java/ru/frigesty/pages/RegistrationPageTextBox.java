package ru.frigesty.pages;

import com.codeborne.selenide.SelenideElement;
import ru.frigesty.pages.components.ResultsModal;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageTextBox {

    ResultsModal resultsModal = new ResultsModal();

    SelenideElement userNameInput = $("#userName"),
                   userEmailInput = $("#userEmail"),
              currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
                     submitButton = $("#submit");

    public RegistrationPageTextBox openPageName() {
        open("/text-box");

        return this;
    }

    public RegistrationPageTextBox setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public RegistrationPageTextBox setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPageTextBox setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPageTextBox setPermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public void setSubmit() {
        submitButton.click();
    }

    public RegistrationPageTextBox verifyResultTextBox(String key, String value){
        resultsModal.verifyResultTextBox(key, value);

        return this;
    }
}