package sit707_week2;

public class TestRun {
    public static void main(String[] args) {
        SeleniumClean.officeworks_registration_page("https://www.officeworks.com.au/app/identity/create-account");
        SeleniumClean.sleep(3);
        SeleniumClean.second_registration_page("https://demo.guru99.com/test/newtours/register.php");
    }
}
