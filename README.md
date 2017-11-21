# The Berlin Clock

The Berlin Uhr (Clock) is a rather strange way to show the time. On the top of the clock there is a yellow lamp that
blinks on/off every two seconds. The time is calculated by adding rectangular lamps.
 
The top two rows of lamps are red. These indicate the hours of a day. In the top row there are 4 red lamps. Every lamp
represents 5 hours. In the lower row of red lamps every lamp represents 1 hour. So if two lamps of the first row and
three of the second row are switched on that indicates 5+5+3=13h or 1 pm.
 
The two rows of lamps at the bottom count the minutes. The first of these rows has 11 lamps, the second 4. In the
first row every lamp represents 5 minutes. In this first row the 3rd, 6th and 9th lamp are red and indicate the first
quarter, half and last quarter of an hour. The other lamps are yellow. In the last row with 4 lamps every lamp
represents 1 minute.

One can be seen [here](https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Berlin-Uhr-1650-1705.gif/170px-Berlin-Uhr-1650-1705.gif):

![Berlin Clock](https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Berlin-Uhr-1650-1705.gif/170px-Berlin-Uhr-1650-1705.gif)

## The brief

We have created a number of acceptance tests for the Berlin Clock and your challenge is to get them passing, while considering our values, as described below.

### We value...
 - simple, elegant code that reads like a narrative
 - thinking about the code more than the writing of the code (we spend a lot of time thinking/debating about what we are writing)
 - transparency and feedback to support continuous learning
 - excellent testing that acts as documentation
 - challenging boundaries where necessary

## Some hints
If you are new to Gradle, it may be worth spending 10 minutes reading a high level summary.  We are using the Gradle
Wrapper so `gradlew` from the command line should download everything you need.  Most modern IDEs support Gradle projects.

The use of JBehave in this instance is to provide you with our acceptance tests, which is the definition of done for the task. A good answer to this task would necessarily include other unit level tests.

Please ensure that you are familiar with our values above.  They are important to us.