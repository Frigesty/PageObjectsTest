package ru.frigesty.pages;

import com.codeborne.selenide.SelenideElement;
import ru.frigesty.pages.components.CalendarComponent;
import ru.frigesty.pages.components.ResultsModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();

    SelenideElement firstNameInput = $("#firstName"),
                     lastNameInput = $("#lastName"),
                    userEmailInput = $("#userEmail"),
                       genderInput = $("#genterWrapper"),
                       numberInput = $("#userNumber"),
                         dateInput = $("#dateOfBirthInput"),
                     subjectsInput = $("#subjectsContainer input"),
                      hobbiesInput = $("#hobbiesWrapper"),
                      pictureInput = $("#uploadPicture"),
                      addressInput = $("#currentAddress"),
                        stateInput = $("#state"),
                         cityInput = $("#city"),
                    stateCityInput = $("#stateCity-wrapper"),
                       submitInput = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage userEmailName(String value){
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage genderName(String value){
        genderInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage mobileName(String value){
        numberInput.setValue(value);

        return this;
    }

    public RegistrationPage dateBirthDate(String day, String month, String year){
        dateInput.click();
        calendarComponent.setDate(day,month,year);

        return this;
    }

    public RegistrationPage setSubjectName(String value){
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbiesName(String firstHobbies, String secondHobbies){
        hobbiesInput.$(byText(firstHobbies)).click();
        hobbiesInput.$(byText(secondHobbies)).click();

        return this;
    }

    public RegistrationPage setPictureName(String value){
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddressName(String value){
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setStateCityName(String state, String city){
        stateInput.click();
        stateCityInput.$(byText(state)).click();
        cityInput.click();
        stateCityInput.$(byText(city)).click();

        return this;
    }

    public void clickSubmit(){
        submitInput.click();
    }

    public RegistrationPage verifyRegistrationResultsModalAppears(){
        resultsModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value){
        resultsModal.verifyResult(key, value);

        return this;
    }
}
