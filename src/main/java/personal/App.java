package personal;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ThreadLocalRandom;


public class App {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        members.main();
        int days = 14;
        int mealsPerDay = 3;
        int helpPerMeal = 4;

        int meals = 40;
        int helpNeeded = helpPerMeal * meals;
        int helper = 0;
        members[] allMeals = new members[helpNeeded];
        for (int i = 0; i < helpNeeded; i++) {
            allMeals[i] = members.teilnehmer[helper];
            helper++;
            if (helper == members.teilnehmer.length) helper = 0;
        }

        members[][] mealsList = new members[meals][4];
        mealsList[0][0] = allMeals[0];
        mealsList[0][1] = allMeals[1];
        mealsList[0][2] = allMeals[2];
        mealsList[0][3] = allMeals[3];
        mealsList[1][0] = allMeals[4];
        mealsList[1][1] = allMeals[5];
        mealsList[1][2] = allMeals[6];
        mealsList[1][3] = allMeals[7];
        for (int i = 2; i < meals; i++) {
            mealsList[i] = new members[4];
            int randomNum;
            for (int j = 0; j < 4; j++) {
                do {
                    randomNum = ThreadLocalRandom.current().nextInt(8, allMeals.length);
                } while (allMeals[randomNum] == null || mealsList[i][0] == allMeals[randomNum] || mealsList[i][1] == allMeals[randomNum] || mealsList[i][2] == allMeals[randomNum] || mealsList[i -2][0].getName().equals(allMeals[randomNum].getName()) || mealsList[i - 1][0].getName().equals(allMeals[randomNum].getName()));

                mealsList[i][j] = allMeals[randomNum];
                allMeals[randomNum] = null;
            }
        }

        PrintWriter writer = new PrintWriter("the-file-name.html", "UTF-8");
        writer.println("<html>");
        writer.print("<style type=\"text/css\">\n" +
                ".tg  {border-collapse:collapse;border-spacing:0;}\n" +
                ".tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}\n" +
                ".tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:black;}\n" +
                ".tg .tg-cly1{text-align:left;vertical-align:middle}\n" +
                ".tg .tg-0lax{text-align:left;vertical-align:top}\n" +
                "</style>\n\n");
        writer.println("<table class=\"tg\">");
        writer.println("<tr> \n <th class=\"tg-cly1\">Abend</th> \n <th class=\"tg-0lax\">Früh</th> \n <th class=\"tg-0lax\">Mittage</th> \n </tr>");
        writer.println("<tr> \n");
        for (int i = 0; i < meals; i++) {
            if (i % 3 == 0) {
                writer.println("</tr>\n");
                writer.println("<tr>\n");
            }
            writer.println("<td class=\"tg-0lax\">");
            writer.print(mealsList[i][0] + ", \n");

            writer.print(mealsList[i][1] + "<br> \n");

            writer.print(mealsList[i][2] + ", \n");

            writer.print(mealsList[i][3] + "<br> \n");
            writer.println("</td>");
        }
        writer.println("</tr>");
        writer.println("</table>");
        writer.println("</html>");
        writer.close();
        System.exit(0);
    }

}
