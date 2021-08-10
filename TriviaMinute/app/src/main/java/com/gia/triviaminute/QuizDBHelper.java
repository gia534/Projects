package com.gia.triviaminute;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.gia.triviaminute.QuiContract.*;

import androidx.annotation.Nullable;

import java.util.ArrayList;


public class QuizDBHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Quiz Application.db";
    private static final int DATABASE_VERSION = 3;

    private SQLiteDatabase db;

    public QuizDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String questionsTable = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER, " +
                QuestionsTable.COLUMN_QUESTIONS + " TEXT, " +
                QuestionsTable.COLUMN_OPTION_ONE + " TEXT, " +
                QuestionsTable.COLUMN_OPTION_TWO + " TEXT, " +
                QuestionsTable.COLUMN_OPTION_THREE + " TEXT, " +
                QuestionsTable.COLUMN_OPTION_FOUR + " TEXT, " +
                QuestionsTable.COLUMN_OPTION_FIVE + " TEXT, " +
                QuestionsTable.COLUMN_OPTION_SIX + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NUM + " INTEGER, " +
                QuestionsTable.COLUMN_DIFFICULTY + " TEXT" +
                ")";

        final String storeAnswerTable = "CREATE TABLE " +
                QuestionsTable.TABLE_ANSWER + "( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY, " +
                QuestionsTable.COLUMN_QUESTIONS + " TEXT" +
                ")";


        db.execSQL(questionsTable);
        db.execSQL(storeAnswerTable);
        fillQuestionsTable();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_ANSWER);
        onCreate(db);

        //This is used when we want to update our database schema Database version will need to be incremented by 1;
    }

    private void fillQuestionsTable(){

        // Easy Level Questions
        QuestionModel q1 = new QuestionModel("Which city is the United States capitol?", "Washington D.C.", "New York City",
                "Los Angeles", "San Fransisco", "Trenton", "Toronto", 1, QuestionModel.EASY_LEVEL);
        addQuestion(q1);
        QuestionModel q2 = new QuestionModel("How many continents are there in the world?", "5", "4", "1",
                "20", "7", "6", 5, QuestionModel.EASY_LEVEL);
        addQuestion(q2);
        QuestionModel q3 = new QuestionModel("Which city hosted the 2012 Summer Olympics?", "Rio de Janeiro, Brazil",
                "Chicago, Illinois", "Malibu, California", "London, England", "Tokyo, Japan",
                "Paris, France", 4, QuestionModel.EASY_LEVEL );
        addQuestion(q3);
        QuestionModel q4 = new QuestionModel("What does the 'F' stand for in FBI?", "Fungus", "Federal",
                "Finance", "Failure", "Faithful", "Fake", 2, QuestionModel.EASY_LEVEL);
        addQuestion(q4);
        QuestionModel q5 = new QuestionModel("Which state is called the Golden State?", "Hawaii", "California",
                "Florida", "Maine", "Texas", "Alaska", 2, QuestionModel.EASY_LEVEL);
        addQuestion(q5);
        QuestionModel q6 = new QuestionModel("The Statue of Liberty was a gift to the United States from which country?", "Italy",
                "Germany", "France", "China", "South Korea", "Egypt", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q6);
        QuestionModel q7 = new QuestionModel("What sport does Cristiano Ronaldo play?", "Football", "Swimming",
                "Baseball", "Rugby", "Ice Hockey", "Basketball", 1, QuestionModel.EASY_LEVEL);
        addQuestion(q7);
        QuestionModel q8 = new QuestionModel("What does 'O' stand for in the periodic table?", "Hydrogen", "Peroxide",
                "Sodium", "Oxygen", "Nitrogen", "Osmium", 4, QuestionModel.EASY_LEVEL);
        addQuestion(q8);
        QuestionModel q9 = new QuestionModel("Who played the character Jack in Titanic?", "Chris Hemsworth", "Jake Gyllenhaal",
                "Leonardo DiCaprio", "Johnny Depp", "Luke Evans", "Brad Pitt", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q9);
        QuestionModel q10 = new QuestionModel("Which state is Washington D.C. located in?", "Washington", "Maryland",
                "Maine", "Montana", "Arizona", "Utah", 2, QuestionModel.EASY_LEVEL);
        addQuestion(q10);
        QuestionModel q11 = new QuestionModel("How many days are in a leap year?", "366", "365", "380",
                "345", "356", "353", 1, QuestionModel.EASY_LEVEL);
        addQuestion(q11);
        QuestionModel q12 = new QuestionModel("Who is known as the GOAT in the Olympic sport of gymnastics?", "Jordan Chiles",
                "Gabby Douglas", "Simone Biles", "Shannon Miller", "Aly Raisman",
                "Laurie Hernandez", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q12);
        QuestionModel q13 = new QuestionModel("What type of animal is Bambi?", "Horse", "Bird", "Deer", "Fox",
                "Tiger", "Lion", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q13);
        QuestionModel q14 = new QuestionModel("How many Harry Potter books are there?", "2", "8", "4",
                "7", "1", "10", 4, QuestionModel.EASY_LEVEL);
        addQuestion(q14);
        QuestionModel q15 = new QuestionModel("How many Harry Potter movies are there?", "2", "8", "4",
                "7", "1", "10", 2, QuestionModel.EASY_LEVEL);
        addQuestion(q15);
        QuestionModel q16 = new QuestionModel("Which of the following cities is the most populous city in the United States?", "San Francisco",
                "New York City", "Seattle", "Miami", "Orlando", "Austin", 2, QuestionModel.EASY_LEVEL);
        addQuestion(q16);
        QuestionModel q17 = new QuestionModel("Which color eyes do most humans have?", "Brown", "Blue",
                "Green", "Hazel", "Black", "Light-Blue", 1, QuestionModel.EASY_LEVEL);
        addQuestion(q17);
        QuestionModel q18 = new QuestionModel("How many years are there in a century?", "20", "10", "1,000",
                "10,000", "1", "100", 6, QuestionModel.EASY_LEVEL);
        addQuestion(q18);
        QuestionModel q19 = new QuestionModel("Where did french fries originate from?", "France", "Germany", "Italy",
                "Russia", "England", "Belgium", 6, QuestionModel.EASY_LEVEL);
        addQuestion(q19);
        QuestionModel q20 = new QuestionModel("Which president appears on the one dollar bill?", "George Washington", "Barack Obama",
                "George W. Bush", "Bill Clinton", "Abraham Lincoln", "Ronald Reagan",1, QuestionModel.EASY_LEVEL);
        addQuestion(q20);
        QuestionModel q21 = new QuestionModel("Which continent is the largest continent on earth?", "North America", "South America",
                "Asia", "Europe", "Africa", "Antarctica", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q21);
        QuestionModel q22 = new QuestionModel("How many legs do spiders have?", "4", "2", "8", "6",
                "10", "12", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q22);
        QuestionModel q23 = new QuestionModel("How many dwarfs are in the movie Snow White?", "8", "7", "17",
                "10", "6", "3", 2, QuestionModel.EASY_LEVEL);
        addQuestion(q23);
        QuestionModel q24 = new QuestionModel("Which animal is the fastest land animal?", "Cheetah", "Tiger", "Lion",
                "Puma", "Bear", "Cat", 1, QuestionModel.EASY_LEVEL);
        addQuestion(q24);
        QuestionModel q25 = new QuestionModel("Where is the Eiffel Tower located?", "Paris, Texas", "Paris, Maine",
                "Paris, Idaho", "Paris, Kentucky", "Paris, France", "Paris, Michigan", 5, QuestionModel.EASY_LEVEL);
        addQuestion(q25);
        QuestionModel q26 = new QuestionModel("By land mass, which state is the smallest state in the United States?", "Hawaii",
                "Connecticut", "Rhode Island", "Delaware", "New Jersey", "Vermont", 4, QuestionModel.EASY_LEVEL);
        addQuestion(q26);
        QuestionModel q27 = new QuestionModel("By land mass, which state is the largest state in the United States?", "California",
                "Alaska", "Texas", "New York", "Montana", "Nevada",2, QuestionModel.EASY_LEVEL);
        addQuestion(q27);
        QuestionModel q28 = new QuestionModel("How many bones do sharks have?", "100", "300", "0",
                "4,000", "50", "600", 3, QuestionModel.EASY_LEVEL);
        addQuestion(q28);
        QuestionModel q29 = new QuestionModel("Which fruit serves as a base for guacamole?", "Strawberry", "Kiwi",
                "Apple", "Avocado", "Banana", "Orange", 4, QuestionModel.EASY_LEVEL);
        addQuestion(q29);
        QuestionModel q30 = new QuestionModel("What is the most popular car color?", "White", "Orange",
                "Black", "Red", "Blue", "Silver", 1, QuestionModel.EASY_LEVEL);
        addQuestion(q30);

        // Medium Level Questions
        QuestionModel q31 = new QuestionModel("What is Lady Gaga's real name?", "Stefani Joanne Angelina Germanotta",
                "Alecia Beth moore", "Katheryn Elizabeth Hudson", "Elisabeth Moss", "Robyn Fenty",
                "Onika Tanya Maraj", 1, QuestionModel.MEDIUM_LEVEL );
        addQuestion(q31);
        QuestionModel q32 = new QuestionModel("Which two states in the United States do not observe Daylight Savings?",
                "Hawaii and California", "Arizona and Texas", "Texas and Alabama", "Hawaii and Arizona",
                "Utah and Washington",  "Nevada and California", 4, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q32);
        QuestionModel q33 = new QuestionModel("Who wrote the popular autobiography 'I Know Why the Caged Bird Sings?' ", "Alice Walker",
                "James Baldwin", "Toni Morrison", "Maya Angelou", "Octavia Butler",
                "Zora Hurtson", 4, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q33);
        QuestionModel q34 = new QuestionModel("How many ribs are in the human body?", "26", "28", "22",
                "20", "24", "29",  5, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q34);
        QuestionModel q35 = new QuestionModel("Which planet is the hottest planet in the solar system?", "Venus", "Earth",
                "Mars", "Pluto", "Jupiter", "Saturn", 1, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q35);
        QuestionModel q36 = new QuestionModel("Which state was the first state in the United States?", "Delaware",
                "Rhode Island", "Maryland", "New Jersey", "New York", "Connecticut",
                1, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q36);
        QuestionModel q37 = new QuestionModel("Which famous classical composer was deaf?", "Frederic Chopin",
                "Ludwig van Beethoven", "Wolfgang Amadeus Mozart", "Johann Sebastian Bach",
                "Joseph Haydn", "Pyotr Ilyich Tchaikovsky", 2, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q37);
        QuestionModel q38 = new QuestionModel("What is the most common letter in the English alphabet?", "A", "O",
                "E", "I", "U", "C", 3, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q38);
        QuestionModel q39 = new QuestionModel("Which vitamin are carrots a good source for?", "Vitamin B", "Vitamin D",
                "Vitamin E", "Vitamin A", "Vitamin C", "Vitamin K", 5, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q39);
        QuestionModel q40 = new QuestionModel("Which country had a secret police force known as the Tonton Macoute?", "France",
                "Belgium", "Canada", "Haiti", "Bermuda", "Switzerland", 4, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q40);
        QuestionModel q41 = new QuestionModel("What country has the largest coastline?", "United States", "Russia",
                "Japan", "Norway", "Indonesia", "Canada", 6, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q41);
        QuestionModel q42 = new QuestionModel("Which country hosted the 2014 FIFA World Cup?", "Cuba", "Russia",
                "Qatar", "Argentina", "Brazil", "Mexico", 5, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q42);
        QuestionModel q43 = new QuestionModel("Which of the seven dwarfs in Snow White and The Seven Dwarfs does not speak?",
                "Dopey", "Bashful", "Grumpy", "Sleepy", "Sneezy", "Happy",
                1, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q43);
        QuestionModel q44 = new QuestionModel("Which country in Africa has the highest population?", "Egypt",
                "Ethiopia", "Nigeria", "Zambia", "Malawi", "Ghana", 3, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q44);
        QuestionModel q45 = new QuestionModel("Which US state is the only state to not have a straight line in its borders?", "Montana",
                "Alaska", "Washington", "Hawaii", "Georgia", "Rhode Island", 4, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q45);
        QuestionModel q46 = new QuestionModel("Which instrument did Dizzy Gillespie play?", "Saxophone", "Piano",
                "Trumpet", "Bass","Drums", "Guitar", 3, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q46);
        QuestionModel q47 = new QuestionModel("How many times has Brazil won the World Cup?", "0", "7", "5",
                "10", "8", "3", 3, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q47);
        QuestionModel q48 = new QuestionModel("When was the last time the United States men's national soccer team went to the World Cup?",
                "2018", "2012", "1990", "1998", "2014", "2002", 5, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q48);
        QuestionModel q49 = new QuestionModel("What color is the first color of a rainbow?", "Violet", "Green",
                "Indigo", "Orange", "Blue", "Red", 6, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q49);
        QuestionModel q50 = new QuestionModel("In the United States, what is the most common last name?", "Smith", "Johnson",
                "Davis", "Garcia", "Williams", "Jones", 1, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q50);
        QuestionModel q51 = new QuestionModel("In a 10-pin bowling game, what is the maximum score a player can get?", "280", "150",
                "300", "400", "260", "330", 3, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q51);
        QuestionModel q52 = new QuestionModel("How many legs does a lobster have?", "6", "8", "12", "10",
                "2", "7", 4, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q52);
        QuestionModel q53 = new QuestionModel("How many words in the English language end with the letters 'ceed'?", "10", "5",
                "12", "0", "1", "3", 6, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q53);
        QuestionModel q54 = new QuestionModel("Which Olympic games were held in Atlanta, Georgia?", "1996", "2002",
                "1904", "1932", "1960", "1980", 1, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q54);
        QuestionModel q55 = new QuestionModel("What is the amount of teeth inside an adults mouth?", "10", "32",
                "30", "34", "38", "31", 2, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q55);
        QuestionModel q56 = new QuestionModel("How many players are in a baseball team?", "8", "7", "12",
                "16", "9", "10", 5, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q56);
        QuestionModel q57 = new QuestionModel("Which bird is the only bird that can fly backwards and upside down?", "Woodpeckers",
                "Blue Jay", "American Goldfinch", "Dove", "Sparrow", "Humming bird", 6, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q57);
        QuestionModel q58 = new QuestionModel("When did the Titanic sink?", "April 15, 1912", "April 15, 1997", "" +
                "August 1, 1912", "August 8 1917", "April 12, 1915", "October 1, 1958", 1, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q58);
        QuestionModel q59 = new QuestionModel("What is the capitol of Hungary?", "Gyor", "Budapest", "Miskolc",
                "Szeged", "Pecs", "Kecskemet", 2, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q59);
        QuestionModel q60 = new QuestionModel("Which letter is the only letter that does not appear in the periodic table?", "Z",
                "C", "M", "J", "S", "L", 4, QuestionModel.MEDIUM_LEVEL);
        addQuestion(q60);

        //Hard Questions
        QuestionModel q61 = new QuestionModel("How many wings does a bumble bee have?", "4", "6", "2",
                "8", "10", "5", 1, QuestionModel.HARD_LEVEL);
        addQuestion(q61);
        QuestionModel q62 = new QuestionModel("Who was President of the United States in the year of 1906?", "John Adams",
                "Theodore Roosevelt", "James Polk", "Zachary Taylor", "Andrew Johnson",
                "Ulysses S. Grant", 2, QuestionModel.HARD_LEVEL);
        addQuestion(q62);
        QuestionModel q63 = new QuestionModel("Who was the first governor of New Jersey?", "William Paterson",
                "John Lambert", "William Livingston", "Thomas Henderson", "Aaron Ogden",
                "Joseph Bloomfield", 3, QuestionModel.HARD_LEVEL);
        addQuestion(q63);
        QuestionModel q64 = new QuestionModel("Which snake is the most deadliest snake in the world?", "Cobra",
                "Rattlesnake", "Copperheads", "Inland Taipan", "Black-mouthed Mamba",
                "Yellow Chin snake", 4, QuestionModel.HARD_LEVEL);
        addQuestion(q64);
        QuestionModel q65 = new QuestionModel("What is another way to say the medical condition epistaxis?", "Broken arm",
                "Broken leg", "Ear infection", "Eye infection", "Nose bleed",
                "Broken nose", 5, QuestionModel.HARD_LEVEL);
        addQuestion(q65);
        QuestionModel q66 = new QuestionModel("Which European capital city is the name of two towns from either side of its main river?",
                "Paris", "Amsterdam", "Vienna", "Prague", "Rome", "Budapest", 6,
                QuestionModel.HARD_LEVEL);
        addQuestion(q66);
        QuestionModel q67 = new QuestionModel("The dot above the letter 'i' is called: ", "A title", "An aigu",
                "A period", "A trolley", "A Trema", "A cedille", 1, QuestionModel.HARD_LEVEL);
        addQuestion(q67);
        QuestionModel q68 = new QuestionModel("What car brand named itself after its intended market?", "BMW", "Toyota",
                "Kia", "Lexus", "Ford", "Porsche", 4, QuestionModel.HARD_LEVEL);
        addQuestion(q68);
        QuestionModel q69 = new QuestionModel("What is the largest muscle in the human body?", "Tongue", "Calf",
                "Heart", "Soleus", "Buttocks", "Abdominal muscles", 5, QuestionModel.HARD_LEVEL);
        addQuestion(q69);
        QuestionModel q70 = new QuestionModel("Which internal organ of the human body is the largest?", "The heart",
                "The stomach", "The liver", "The appendix", "The brain", "The gallbladder", 3,
                QuestionModel.HARD_LEVEL);
        addQuestion(q70);
        QuestionModel q71 = new QuestionModel("When did Netflix begin their streaming services?", "2005", "2014",
                "2007", "2008", "2001", "2002", 3, QuestionModel.HARD_LEVEL);
        addQuestion(q71);
        QuestionModel q72 = new QuestionModel("How many United States Presidents have died while in office?", "1", "8",
                "10", "3", "5", "4", 2, QuestionModel.HARD_LEVEL);
        addQuestion(q72);
        QuestionModel q73 = new QuestionModel("In what year did the United States enter World War 1?", "1914", "1918",
                "1915", "1916", "1917", "1912", 5, QuestionModel.HARD_LEVEL);
        addQuestion(q73);
        QuestionModel q74 = new QuestionModel("Who was the first president to live in the White House?", "George Washington",
                "John Adams", "James Madison", "Andrew Jackson", "John Quincy Adams",
                "William Henry Harrison", 2, QuestionModel.HARD_LEVEL);
        addQuestion(q74);
        QuestionModel q75 = new QuestionModel("How many stomachs does a cow have?", "1", "4", "3",
                "5", "2", "8", 2, QuestionModel.HARD_LEVEL);
        addQuestion(q75);
        QuestionModel q76 = new QuestionModel("When was Coca-Cola invented?", "January, 1892", "April, 1900",
                "January 1801", "August, 1888", "March 1905", "October, 1806", 1, QuestionModel.HARD_LEVEL);
        addQuestion(q76);
        QuestionModel q77 = new QuestionModel("What does Xyrophobia mean?", "Fear of sponges", "Fear of spiders",
                "Fear of soap", "Fear of razors", "Fear of hair", "Fear of heights", 4, QuestionModel.HARD_LEVEL);
        addQuestion(q77);
        QuestionModel q78 = new QuestionModel("Which country is the smallest country in the world?", "Malta",
                "Maldives", "Vatican City", "Saint Kitts & Nevis", "Grenada", "Barbados",
                3, QuestionModel.HARD_LEVEL);
        addQuestion(q78);
        QuestionModel q79 = new QuestionModel("Which U.S. state is known as the Diner Capital of the world?", "Pennsylvania",
                "New Jersey", "New York", "Rhode Island", "Massachusetts", "Connecticut",
                2, QuestionModel.HARD_LEVEL);
        addQuestion(q79);
        QuestionModel q80 = new QuestionModel("How many chromosomes does the human body have?", "48", "42", "45",
                "43", "46", "26", 5, QuestionModel.HARD_LEVEL);
        addQuestion(q80);
        QuestionModel q81 = new QuestionModel("At what week is pregnancy considered a full-term pregnancy?", "34", "35",
                "40", "37", "42", "39", 4, QuestionModel.HARD_LEVEL);
        addQuestion(q81);
        QuestionModel q82 = new QuestionModel("Which actor is a member of the band  '30 odd foot of grunts'?", "Bradley Cooper",
                "Hugh Jackman", "Russell Crowe", "Rob Pattinson", "Joseph Levitt", "Michael Cera",
                3, QuestionModel.HARD_LEVEL);
        addQuestion(q82);
        QuestionModel q83 = new QuestionModel("Who invented the saxophone?", "Adolphe Sax", "Robert Moog",
                "Bartolomeo Cristofori", "Anton Weidinger", "Theobald Boehm", "Johann Christoph Denner",
                1, QuestionModel.HARD_LEVEL);
        addQuestion(q83);
        QuestionModel q84 = new QuestionModel("What is the largest country in the world to have only one time zone?", "Russia",
                "China", "Iran", "Turkey", "Israel", "Australia", 2, QuestionModel.HARD_LEVEL);
        addQuestion(q84);
        QuestionModel q85 = new QuestionModel("How many black keys are there on a standard piano?", "20", "30",
                "40", "36", "25", "22", 4, QuestionModel.HARD_LEVEL);
        addQuestion(q85);
        QuestionModel q86 = new QuestionModel("Which fictional character was born on July 31, 1981?", "Hermione Granger",
                "Harry Potter", "Ron Weasley", "Angelica Pickles", "Chuckie Finster",
                "SpongeBob SquarePants", 2, QuestionModel.HARD_LEVEL);
        addQuestion(q86);
        QuestionModel q87 = new QuestionModel("What is William Shakespeare's longest play?", "Romeo and Juliet",
                "Macbeth", "A Midsummer Night's Dream", "Hamlet", "Othello",
                "King Lear", 4, QuestionModel.HARD_LEVEL);
        addQuestion(q87);
        QuestionModel q88 = new QuestionModel("Which band played the theme song for the popular animated mystery comedy TV series " +
                "'What's New, Scooby-Doo'?", "Simple Plan", "Fall Out Boy", "Mayday Parade",
                "Forever the Sickest Kids", "All American Rejects", "Green Day", 1, QuestionModel.HARD_LEVEL);
        addQuestion(q88);
        QuestionModel q89 = new QuestionModel("How many noble gases are there?", "10", "12", "6",
                "4", "2", "5", 3, QuestionModel.HARD_LEVEL);
        addQuestion(q89);
        QuestionModel q90 = new QuestionModel("What instrument did Dave Brubeck play?", "Guitar", "Alto Saxophone",
                "Tenor Saxophone", "Piano", "Trumpet", "Clarinet", 4, QuestionModel.HARD_LEVEL);
        addQuestion(q90);

        // Difficult questions
        QuestionModel q91 = new QuestionModel("Which state was the third state to join the United States?", "New Jersey", "Alabama",
                "Kentucky", "Louisiana", "Indiana", "Alaska", 1, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q91);
        QuestionModel q92 = new QuestionModel("When did Pablo Picasso die?", "1950", "1973", "1990", "1977",
                "1975", "1972", 2, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q92);
        QuestionModel q93 = new QuestionModel("When was the first permanent British colony that was established in the United States?", "1608",
                "1609", "1607", "1700", "1689", "1601", 3, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q93);
        QuestionModel q94 = new QuestionModel("When was the hot air balloon invented?", "1790", "1765", "1776",
                "1783", "1745", "1766", 4, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q94);
        QuestionModel q95 = new QuestionModel("When was the first ever 9-1-1 call made in the United States?", "1972", "1976",
                "1964", "1969", "1968", "1978", 5, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q95);
        QuestionModel q96 = new QuestionModel("Which president served the shortest term?", "William Henry Harrison", "James Garfield",
                "Warren Harding", "Gerald Ford", "Zachary Taylor", "Millard Fillmore", 1, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q96);
        QuestionModel q97 = new QuestionModel("Who wrote the sing New York, New York?", "Frank Sinatra", "Fred Ebb & John Kander",
                "Joel Grey", "Chita Rivera", "Bob Fosse",  "Joe Masteroff", 2, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q97);
        QuestionModel q98 = new QuestionModel("A  bee has how many eyes?", "1", "2", "5", "8", "4",
                "6", 3, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q98);
        QuestionModel q99 = new QuestionModel("What was Google's original name?", "Page", "Brin", "Google",
                "Sergey", "Yoshka", "Backrub",6 , QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q99);
        QuestionModel q100 = new QuestionModel("When did the first New Year's Eve ball drop?", "December 31, 1901",
                "December 31, 1907", "December 31, 1945", "December 31, 1919", "December 31 1923",
                "December 31, 1934", 2, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q100);
        QuestionModel q101 = new QuestionModel("How long does a cicada live underground?", "17 years", "2 years",
                "20 years", "10 years", "15 years", "13 years", 1, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q101);
        QuestionModel q102 = new QuestionModel("How long is a moment?", "A minute", "two minutes", "an hour",
                "90 seconds", "an hour and 30 minutes", "30 minutes", 4, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q102);
        QuestionModel q103 = new QuestionModel("In Sweden, what percentage of household garbage makes it to landfills?", "100%",
                "50%", "30%", "65%", "90%", "1%", 6, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q103);
        QuestionModel q104 = new QuestionModel("A mouse for a computer was once called a different name. What was it called?",
                "Turtle", "Rabbit", "Pig", "Monkey", "Bird", "Clicker", 1,
                QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q104);
        QuestionModel q105 = new QuestionModel("How many scent receptors does a dog have in its nose?", "200,000",
                "1 million", "300 million", "300,000", "100 million", "250,000", 3,
                QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q105);
        QuestionModel q106 = new QuestionModel("Which finger is responsible for fifty percent of the strength in a humans hand?",
                "Thumb", "pointer", "pinky", "none of them", "middle finger", "ring finger", 3, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q106);
        QuestionModel q107 = new QuestionModel("Which fish is the most venomous fish in the world?", "The puffer fish",
                "Red Lionfish", "Stonefish", "Stingrays", "Boxfish", "Stargazer", 3,
                QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q107);
        QuestionModel q108 = new QuestionModel("How many languages are written from right to left?", "3", "12",
                "20", "35", "26", "10", 2, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q108);
        QuestionModel q109 = new QuestionModel("How long does it take for food to pass through a humans body?", "4 to 6 hours",
                "6 - 10 hours", "4 - 16 hours", "6 - 20 hours", "10 - 59 hours", " 4 - 56 hours",
                5, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q109);
        QuestionModel q110 = new QuestionModel("What population of the world has black or brown hair?", "50%", "80%",
                "60%", "90%", "70%", "40%", 4, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q110);
        QuestionModel q111 = new QuestionModel("Which day is the most common day for birthdays?", "December 1", "September 9",
                "October 19", "November 17", "April 7", "March 8", 2, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q111);
        QuestionModel q112 = new QuestionModel("How much does a cloud weigh?", "0 pounds", "10 pounds", "100 pounds",
                "1.1 million pounds", "2 pounds", "5 pounds", 4, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q112);
        QuestionModel q113 = new QuestionModel("When earth was first formed there used to be fewer than 24 hours in a day. How many hours were in " +
                "a day when Earth was first formed?", "12 hours", "18 hours", "6 hours", "10 hours",
                "3 hours", "4 hours", 3, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q113);
        QuestionModel q114 = new QuestionModel("The length of a season in Uranus last for how long?", "3 months", "2 years",
                "10 years", "1 month", "21 years", "2 months", 5, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q114);
        QuestionModel q115 = new QuestionModel("Which city in the United States gets the most rain in a year?", "Mobile Alabama",
                "Seattle, Washington", "Pensacola, Florida", "Tallahassee, Florida", "Port Arthur, Texas",
                "West Palm Beach, Florida", 1, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q115);
        QuestionModel q116 = new QuestionModel("Which continent has hosted the Olympics the most times?", "North America",
                "South America", "Asia" ,"Africa", "Europe", "Australia", 5,
                QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q116);
        QuestionModel q117 = new QuestionModel("Who was the wealthiest person on the fatal ship Titanic?", "Molly Brown",
                "John Jacob Astor", "Benjamin Guggenheim", "J. Bruce Ismay", "Cosmo Duff-Gordon",
                "Isidor Straus", 2, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q117);
        QuestionModel q118 = new QuestionModel("Amy Winehouse, Jimi Hendrix, Jim Morrison, and Janis Joplin all died at what age?",
                "27", "30", "25", "22", "29", "28", 1, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q118);
        QuestionModel q119 = new QuestionModel("Which letters are the highest scoring tiles in the game of Scrabble?", "J and K",
                "O and M", "Q and Z", "X and Z", "Y and Q", "T and X", 3,
                QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q119);
        QuestionModel q120 = new QuestionModel("When was Queen Elizabeth II born?", "1935", "1940","1919",
                "1912", "1926", "1920", 5, QuestionModel.EXTREMELY_HARD_LEVEL);
        addQuestion(q120);
    }

    private void addQuestion(QuestionModel question){
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTIONS, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION_ONE, question.getOptionOne());
        cv.put(QuestionsTable.COLUMN_OPTION_TWO, question.getOptionTwo());
        cv.put(QuestionsTable.COLUMN_OPTION_THREE, question.getOptionThree());
        cv.put(QuestionsTable.COLUMN_OPTION_FOUR, question.getOptionFour());
        cv.put(QuestionsTable.COLUMN_OPTION_FIVE, question.getOptionFive());
        cv.put(QuestionsTable.COLUMN_OPTION_SIX, question.getOptionSix());
        cv.put(QuestionsTable.COLUMN_ANSWER_NUM, question.getAnswerNum());
        cv.put(QuestionsTable.COLUMN_DIFFICULTY, question.getDifficulty());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

//    public ArrayList<QuestionModel> getAllQuestions(){
//        ArrayList<QuestionModel> questionModelList = new ArrayList<>();
//        db = getReadableDatabase(); // This will call the database onCreate method and create the database;
//
//
//        Cursor cursor = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
//        if(cursor.moveToFirst()){
//            do{
//                QuestionModel question = new QuestionModel();
//
//                // We get the question out of getColumnIndex and save it to question
//                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTIONS)));
//                question.setOptionOne(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_ONE)));
//                question.setOptionTwo(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_TWO)));
//                question.setOptionThree(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_THREE)));
//                question.setOptionFour(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_FOUR)));
//                question.setOptionFive(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_FIVE)));
//                question.setOptionSix(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_SIX)));
//                question.setAnswerNum(cursor.getInt(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NUM)));
//                question.setDifficulty(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));
//
//
//                questionModelList.add(question);
//            }while (cursor.moveToNext());
//        }
//
//        cursor.close();
//        return questionModelList;
//    }

    public ArrayList<QuestionModel> retrieveQuestions(String difficulty){
        ArrayList<QuestionModel> questionModelList = new ArrayList<>();
        db = getReadableDatabase(); // This will call the database onCreate method and create the database;

        String[] selectionArgs =  new String[]{difficulty};

        Cursor cursor = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME
                + " WHERE " + QuestionsTable.COLUMN_DIFFICULTY + " = ?", selectionArgs);
        if(cursor.moveToFirst()){
            do{
                QuestionModel question = new QuestionModel();

                // We get the question out of getColumnIndex and save it to question
                question.setQuestion(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_QUESTIONS)));
                question.setOptionOne(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_ONE)));
                question.setOptionTwo(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_TWO)));
                question.setOptionThree(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_THREE)));
                question.setOptionFour(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_FOUR)));
                question.setOptionFive(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_FIVE)));
                question.setOptionSix(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_OPTION_SIX)));
                question.setAnswerNum(cursor.getInt(cursor.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NUM)));
                question.setDifficulty(cursor.getString(cursor.getColumnIndex(QuestionsTable.COLUMN_DIFFICULTY)));


                questionModelList.add(question);
            }while (cursor.moveToNext());
        }

        cursor.close();
        return questionModelList;
    }
}
