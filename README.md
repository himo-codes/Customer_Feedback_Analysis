# Customer_Feedback_Analysis_System
A console-based Java application that analyzes customer feedback for businesses using Object-Oriented Programming principles and a multi-tier sentiment classification model.

About the Project
This project was built as part of the Object Oriented Programming with Java course at Rungta International Skills University, Bhilai.
It demonstrates how real-world customer feedback systems work by separating consumer data and analysis logic into different classes — keeping the code clean, modular, and easy to understand.

Project Structure
Main.java
 ├── class Feedback          → Stores customer rating and comment
 ├── class Analyzer          → Calculates average and classifies sentiment
 └── class Main              → Entry point, collects input and displays results

OOP Concepts Used
ConceptHow it's appliedEncapsulationPrivate fields in Feedback with public gettersClass DesignSeparate classes for data and logicObject InteractionAnalyzer takes a Feedback[] array as inputConditional LogicSwitch-case for sentiment classificationModular DesignData and business logic kept in separate classesArraysFeedback[] array to store multiple entries

Sentiment Classification Slabs
Average RatingCategory5.0Excellent4.0 – 4.4Good3.0 – 3.4Average1.0 – 2.4Poor
A fixed minimum of 1 and maximum of 5 is enforced on every rating entry.

Sample Output
======================================
  Customer Feedback Analysis System
======================================
How many feedback entries? 3

--- Entry 1 of 3 ---
  Rating (1-5): 5
  Comment: Excellent service!

--- Entry 2 of 3 ---
  Rating (1-5): 4
  Comment: Very good overall.

--- Entry 3 of 3 ---
  Rating (1-5): 3
  Comment: Could be better.

======================================
              RESULTS
======================================

All Feedback Entries:
----------------------------------------
  Score: 5 | Comment: Excellent service!
  Score: 4 | Comment: Very good overall.
  Score: 3 | Comment: Could be better.
----------------------------------------
Average Rating  : 4.00 / 5.00
Sentiment       : Good

Score Breakdown:
  Excellent (5) : 1
  Good      (4) : 1
  Average   (3) : 1
  Poor    (1-2) : 0
======================================

How to Run
# Step 1 — Compile
javac Feedback.java Analyzer.java Main.java

# Step 2 — Run
java Main

For online compilers (OneCompiler, JDoodle) — paste the single-file version directly and run. No compilation step needed.

Make sure you have Java JDK 8 or above installed.

Author
Himanshu Sharma
B.Tech CSE (AI) — Rungta International Skills University
Guide: Mr. Soumik Karmakar
