# Final Project - Expense Tracker
Contributors:
- Haren Eshwaran
- Luis Gonzalez
- Nathaniel Courtney Bricker
- Tyler Shannon

## Project Summary
This project allows a user to track their expenses. Users will be able to enter their expense/income broken down by category, amount, date and description and view a table or a pie chart with their transaction.

## Building this project
### Prerequisites
- [Java](https://www.java.com/en/download/manual.jsp)
- [Git](https://git-scm.com/downloads)
- An editor (preferably IntelliJ Idea)

Cloning this project:
```bash
git https://github.com/bsu-cs222-fall25-dll/Final-ExpenseTracker.git
```

### Running this project
You can only run this application through Gradle. If you have IntelliJ you can run by clicking on gradle on your right sidebar and clicking on `Tasks > application > run`.
Alternatively, you can use either the `gradlew` or `gradlew.bat` files at the root of the project depending on your machine.

### Suppressed warnings
There are 3 suppressed warning currently in `src/main/java/edu/bsu/cs/Controller` in the `addTransaction()`, `removeTransaction()` and `openChartDialog()` methods due to their arguments being unused. These arguments cant be removed due to JavaFX needing them.