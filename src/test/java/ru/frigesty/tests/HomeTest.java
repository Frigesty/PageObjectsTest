package ru.frigesty.tests;

import org.junit.jupiter.api.Test;
import ru.frigesty.pages.RegistrationPage;

public class HomeTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void practiceFormTest() {

        registrationPage.openPage()
                        .setFirstName("Airat")
                        .setLastName("Karimov")
                        .userEmailName("test@test.ru")
                        .genderName("Male")
                        .mobileName("9991111000")
                        .dateBirthDate("02", "August", "1996")
                        .setSubjectName("Maths")
                        .setHobbiesName("Sports", "Music")
                        .setPictureName("duck.jpg")
                        .setAddressName("5212 CHURCH AVE BROOKLYN NY 11203-3555 USA")
                        .setStateCityName("NCR", "Delhi")
                        .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                        .verifyResult("Student Name", "Airat Karimov")
                        .verifyResult("Student Email", "test@test.ru")
                        .verifyResult("Gender", "Male")
                        .verifyResult("Mobile", "9991111000")
                        .verifyResult("Date of Birth", "02 August,1996")
                        .verifyResult("Subjects", "Maths")
                        .verifyResult("Hobbies", "Sports, Music")
                        .verifyResult("Picture", "duck.jpg")
                        .verifyResult("Address", "5212 CHURCH AVE BROOKLYN NY 11203-3555 USA")
                        .verifyResult("State and City", "NCR Delhi");
    }
}
