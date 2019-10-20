import java.security.SecureRandom;
import java.util.Scanner;

public class multPractice {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        SecureRandom rnd = new SecureRandom();

        int rnd1 = 0;
        int rnd2 = 0;
        double answer = 0;
        double provided = 0;
        int randomReply;
        int totalQuestions = 0;
        int numCorrect = 0;
        int numWrong = 0;
        int difficulty = 0;
        int type = 0;
        int mix = 0;
        //int divAnswer = 0;
        int cont = 1;

        while(cont != 0){//to repeat after
            if (type == 0){
                System.out.println("Enter a difficulty from 1 to 4");
                difficulty = scnr.nextInt();

                System.out.println("Select a type of problem to practice");
                System.out.println("1 - addition");
                System.out.println("2 - multiplication");
                System.out.println("3 - subtraction");
                System.out.println("4 - division");
                System.out.println("5 - mixed");
                type = scnr.nextInt();
            }//end menu print

            while (totalQuestions < 10){//questioning while
                if(difficulty == 1) {
                    rnd1 = rnd.nextInt(10);
                    rnd2 = rnd.nextInt(10);
                }
                else if (difficulty == 2){
                    rnd1 = rnd.nextInt(100);
                    rnd2 = rnd.nextInt(100);
                }
                else if(difficulty == 3) {
                    rnd1 = rnd.nextInt(1000);
                    rnd2 = rnd.nextInt(1000);
                }
                else if (difficulty == 4){
                    rnd1 = rnd.nextInt(10000);
                    rnd2 = rnd.nextInt(10000);
                }
                else
                    System.out.println("Invalid difficulty");

                //for each type
                if(type == 1){//add
                    answer = (double)rnd1 + (double)rnd2;
                    System.out.println("How much is " + rnd1 + " adding " + rnd2 + "?");
                }
                else if (type == 2){//mult
                    answer = (double)rnd1 * (double)rnd2;
                    System.out.println("How much is " + rnd1 + " times " + rnd2 + "?");
                }
                else if (type == 3){//sub
                    answer = (double)rnd1 - (double)rnd2;
                    System.out.println("How much is " + rnd1 + " subtracting " + rnd2 + "?");
                }
                else if (type == 4){//div
                    if (rnd2 == 0)//prevent division by 0
                        rnd2 = 1;
                    answer = (double)rnd1 / (double)rnd2;
                    System.out.println("How much is " + rnd1 + " divided by " + rnd2 + "? (to one decimal point)");
                    answer = Math.round(answer*10)/10.0;

                }
                else if (type == 5){//mix
                    mix = rnd.nextInt(4)+1;
                    if(mix == 1){//add
                        answer = (double)rnd1 + (double)rnd2;
                        System.out.println("How much is " + rnd1 + " adding " + rnd2 + "?");
                    }
                    else if (mix == 2){//mult
                        answer = (double)rnd1 * (double)rnd2;
                        System.out.println("How much is " + rnd1 + " times " + rnd2 + "?");
                    }
                    else if (mix == 3){//sub
                        answer = (double)rnd1 - (double)rnd2;
                        System.out.println("How much is " + rnd1 + " subtracting " + rnd2 + "?");
                    }
                    else if (mix == 4){//div
                        if (rnd2 == 0)//prevent division by 0
                            rnd2 = 1;
                        answer = (double)rnd1 / (double)rnd2;
                        System.out.println("How much is " + rnd1 + " divided by " + rnd2 + "? (to one decimal point)");
                        answer = Math.round(answer*10)/10.0;
                    }//end if
                }//end inner mixed if

                //System.out.println("answer: " + answer);

                provided = scnr.nextDouble();
                //provided = 1;

                if(answer == provided){
                    randomReply = rnd.nextInt(3)+1;

                    switch (randomReply) {
                        case 1:
                            System.out.println("Very good!");
                            break;
                        case 2:
                            System.out.println("Excellent!");
                            break;
                        case 3:
                            System.out.println("Nice work!");
                            break;
                        case 4:
                            System.out.println("Keep up the good work!");
                            break;
                    }
                    numCorrect += 1;
                    totalQuestions +=1;

                }
                else //wrong answer
                {
                    randomReply = rnd.nextInt(3)+1;

                    switch (randomReply){
                        case 1:
                            System.out.println("No. Please try again.");
                            break;
                        case 2:
                            System.out.println("Wrong. Try once more");
                            break;
                        case 3:
                            System.out.println("Don't give up!");
                            break;
                        case 4:
                            System.out.println("No. Keep trying.");
                            break;
                    }//end switch
                    numWrong += 1;
                    totalQuestions += 1;

                }//end else


            }/*end main questioning while*/

            System.out.println("Correct: " + numCorrect);
            System.out.println("Incorrect: " + numWrong);

            if (numCorrect < 8){
                System.out.println("Please ask your teacher for extra help.");
            }
            else {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            totalQuestions = 0;
            numCorrect = 0;
            numWrong = 0;
            type = 0;
            System.out.println("Enter 0 to exit, anything else to restart");
            cont = scnr.nextInt();
        }//end cont while
    }//end public stat void
}
