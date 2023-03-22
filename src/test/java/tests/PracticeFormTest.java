package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class PracticeFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName("Dmitriy")
                .setLastName("Prokopev")
                .setEmail("dprokopev@t1-consulting.ru")
                .setGender("Male")
                .setNumber("9508292376")
                .setBirthDate("9", "September", "1997")
                .setSubject("Computer Science")
                .setHobbies("Sports")
                .uploadFile()
                .setAddress("Это не очень интересно")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", "Dmitriy Prokopev")
                .verifyResult("Student Email", "dprokopev@t1-consulting.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "9508292376")
                .verifyResult("Date of Birth", "9 September,1997")
                .verifyResult("Subjects", "Computer Science")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "bfoto_ru_4761.jpg")
                .verifyResult("Address", "Это не очень интересно")
                .verifyResult("State and City", "NCR Delhi");
    }
}