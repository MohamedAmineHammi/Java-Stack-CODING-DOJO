import java.util.Date;
import java.text.Format;
import java.text.SimpleDateFormat;

public class AlfredQuotes {

    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return "Hello," + name + ". Lovely to see you.";
    }

    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        return "It is currently " + date + ".";
    }

    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        if (conversation.indexOf("Alexis") > -1) {
            return "Right away, sir. She certainly isn't sophisticated enough for that.";
        } else if (conversation.indexOf("Alfred") > -1) {
            return "At your service. As you wish, naturally.";
        }

        else {
            return "Right. And with that I shall retire.";
        }
    }

    // NINJA BONUS
    // See the specs to overload the guestGreeting method
    public String guestGreeting(String name, String dayPeriod) {
        // YOUR CODE HERE
        // greeting guest with day period
        SimpleDateFormat format = new SimpleDateFormat("HH");
        Date date = new Date();
        int liveHour = Integer.parseInt(format.format(date));
        if (liveHour < 12 && liveHour >= 4) {
            dayPeriod = "morning";
        } else if (liveHour >= 12 && liveHour < 20) {
            dayPeriod = "afternoon";
        } else {
            dayPeriod = "evening";
        }
        return (String.format("Good %s %s, lovely to see you.", dayPeriod, name));

    }

    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have
    // learned!

}