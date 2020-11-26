
package starter.verifyaccount;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;

public class AccountData {

    public static Question<String> CurrentProfileName(){
        return actor -> TextContent.of(Accountoverview.USER_INFO).viewedBy(actor).asString().trim();

    }

}