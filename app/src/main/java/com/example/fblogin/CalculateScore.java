package com.example.fblogin;

/**
 * Created by shivam on 26/11/17.
 */

public class CalculateScore {

    String choice1,choice2;
    int scorefinal;
    int upperbound,category;
    public CalculateScore(String choice1,String choice2)
    {
        this.choice1=choice1;
        this.choice2=choice2;
    }
    int finalScore()
    {
        if(choice1.contains("Computer Science"))
        {   upperbound=8;
            if(choice2.contains("Student"))
            {
                category=6;
            }
            else if (choice2.contains("Fresher Graduate"))
            {
                category=7;
            }
            else if (choice2.contains("3-5 Yrs Experience"))
            {
                category = 8;
            }
            else if (choice2.contains(">5 Years"))
            {
                    category=9;
            }
        }
        else if (choice1.contains("Science and Technology"))
        {
            upperbound=5;
            if(choice2.contains("Student"))
            {
                category = 2;
            }
            else if (choice2.contains("Fresher Graduate"))
            {
                category = 3;
            }
            else if (choice2.contains("3-5 Yrs Experience"))
            {
                category = 4;
            }
            else if (choice2.contains(">5 Years"))
            {
                category = 5;
            }
        }
        else if (choice1.contains("Finance and Marketing"))
        {
            upperbound=3;
            if(choice2.contains("Student"))
            {
                category = -1;
            }
            else if (choice2.contains("Fresher Graduate"))
            {
                category=-2;
            }
            else if (choice2.contains("3-5 Yrs Experience"))
            {
                category=-3;
            }
            else if (choice2.contains(">5 Years"))
            {
                category=-4;
            }
        }
        else if(choice1.contains("House Wife"))
        {
            category=1;
            upperbound=1;
        }
        return category*upperbound;
    }
}
