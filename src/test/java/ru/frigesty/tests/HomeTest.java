package ru.frigesty.tests;

import org.junit.jupiter.api.Test;
import ru.frigesty.pages.RegistrationPage;

public class HomeTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void practiceFormTest() {

        registrationPage.openPage()
                        .removeFooter()
                        .setFirstName("Airat")
                        .setLastName("Karimov")
                        .userEmailName("test@test.ru")
                        .chooseGender("Male")
                        .userMobileNumber("9991111000")
                        .chooseBirthDate("02", "August", "1996")
                        .writeAndChooseSubject("Maths")
                        .chooseHobbies("Sports", "Music")
                        .uploadPicture("duck.jpg")
                        .setAddressName("5212 CHURCH AVE BROOKLYN NY 11203-3555 USA")
                        .chooseStateAndCity("NCR", "Delhi")
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
