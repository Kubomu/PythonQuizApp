package com.pythonquiz.pythonquizapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Quiz Data
    private val questions = listOf(
        "What is the output of: print(2 ** 3)?",
        "Which keyword is used to create a function in Python?",
        "What does 'len()' do in Python?",
        "Which of the following is a mutable data type in Python?",
        "How do you start a comment in Python?",
        "Which of these is not a valid variable name in Python?",
        "What does the 'range()' function do in Python?",
        "Which of the following will create an empty list in Python?",
        "What is the correct way to import the 'math' module in Python?",
        "What is the result of: 5 // 2?",
        "Which function is used to get the type of an object in Python?",
        "How do you define a dictionary in Python?",
        "Which of these statements will raise an error in Python?",
        "What is the output of: print('Hello'.lower())?",
        "Which Python function is used to read input from the user?",
        "Which operator is used to concatenate strings in Python?",
        "What does the 'break' statement do in a loop in Python?",
        "How do you create a class in Python?",
        "What is the purpose of the 'self' keyword in Python?",
        "Which of these is a Python data structure?",
        "What does the 'sorted()' function do in Python?",
        "Which of the following are valid types of inheritance in Python?",
        "Which function is used to convert a string into an integer in Python?"
    )

    private val options = listOf(
        listOf("5", "6", "8", "9"), // For question: What is the output of: print(2 ** 3)?
        listOf("function", "def", "lambda", "fun"), // For question: Which keyword is used to create a function in Python?
        listOf("Returns the type", "Checks condition", "Counts elements", "Returns length"), // For question: What does 'len()' do in Python?
        listOf("List", "Tuple", "Dictionary", "Set"), // For question: Which of the following is a mutable data type in Python?
        listOf("# This is a comment", "// This is a comment", "/* This is a comment */", "<-- This is a comment -->"), // For question: How do you start a comment in Python?
        listOf("2var", "_var", "1var", "var1"), // For question: Which of these is not a valid variable name in Python?
        listOf("Generates a list", "Generates a range of numbers", "Generates a string", "Generates a dictionary"), // For question: What does the 'range()' function do in Python?
        listOf("[]", "()", "{}", "<>"), // For question: Which of the following will create an empty list in Python?
        listOf("import math", "import math()", "from math import *", "include math"), // For question: What is the correct way to import the 'math' module in Python?
        listOf("2", "3", "2.5", "1"), // For question: What is the result of: 5 // 2?
        listOf("type()", "typeof()", "type_of()", "getType()"), // For question: Which function is used to get the type of an object in Python?
        listOf("{'key': 'value'}", "[key: value]", "(key: value)", "{key, value}"), // For question: How do you define a dictionary in Python?
        listOf("a = 10 / 0", "b = 10 // 0", "c = 'Hello' + 5", "d = undefined_variable"), // For question: Which of these statements will raise an error in Python?
        listOf("hello", "HELLO", "Hello", "hello()"), // For question: What is the output of: print('Hello'.lower())?
        listOf("input()", "read()", "scan()", "get()"), // For question: Which Python function is used to read input from the user?
        listOf("+", "&", "||", "concat"), // For question: Which operator is used to concatenate strings in Python?
        listOf("Exits the loop", "Pauses the loop", "Continues to the next iteration", "Resets the loop"), // For question: What does the 'break' statement do in a loop in Python?
        listOf("class MyClass():", "MyClass()", "create MyClass:", "new MyClass()"), // For question: How do you create a class in Python?
        listOf("Refers to the instance of the class", "Refers to the class itself", "Refers to the global scope", "Refers to the method name"), // For question: What is the purpose of the 'self' keyword in Python?
        listOf("List", "Dictionary", "Tuple", "Set"), // For question: Which of these is a Python data structure?
        listOf("Sorts the list in place", "Returns a sorted copy of the list", "Reverses the list", "Sorts the list in descending order"), // For question: What does the 'sorted()' function do in Python?
        listOf("Single inheritance", "Multiple inheritance", "Multilevel inheritance", "All of the above"), // For question: Which of the following are valid types of inheritance in Python?
        listOf("int()", "convert()", "parseInt()", "toInt()") // For question: Which function is used to convert a string into an integer in Python?
    )

    private val correctAnswers = listOf(
        2,  // What is the output of: print(2 ** 3)? (Correct answer is 8)
        1,  // Which keyword is used to create a function in Python? (Correct answer is def)
        3,  // What does 'len()' do in Python? (Correct answer is Returns length)
        0,  // Which of the following is a mutable data type in Python? (Correct answer is List)
        0,  // How do you start a comment in Python? (Correct answer is # This is a comment)
        2,  // Which of these is not a valid variable name in Python? (Correct answer is 1var)
        1,  // What does the 'range()' function do in Python? (Correct answer is Generates a range of numbers)
        0,  // Which of the following will create an empty list in Python? (Correct answer is [])
        0,  // What is the correct way to import the 'math' module in Python? (Correct answer is import math)
        0,  // What is the result of: 5 // 2? (Correct answer is 2)
        0,  // Which function is used to get the type of an object in Python? (Correct answer is type())
        0,  // How do you define a dictionary in Python? (Correct answer is {'key': 'value'})
        0,  // Which of these statements will raise an error in Python? (Correct answer is a = 10 / 0)
        0,  // What is the output of: print('Hello'.lower())? (Correct answer is hello)
        0,  // Which Python function is used to read input from the user? (Correct answer is input())
        0,  // Which operator is used to concatenate strings in Python? (Correct answer is +)
        0,  // What does the 'break' statement do in a loop in Python? (Correct answer is Exits the loop)
        0,  // How do you create a class in Python? (Correct answer is class MyClass():)
        0,  // What is the purpose of the 'self' keyword in Python? (Correct answer is Refers to the instance of the class)
        0,  // Which of these is a Python data structure? (Correct answer is List)
        1,  // What does the 'sorted()' function do in Python? (Correct answer is Returns a sorted copy of the list)
        3,  // Which of the following are valid types of inheritance in Python? (Correct answer is All of the above)
        0   // Which function is used to convert a string into an integer in Python? (Correct answer is int())
    )


    private var currentQuestionIndex = 0
    private var score = 0
    private val userAnswers = mutableListOf<Int?>()  // Store user answers

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Views
        val questionText: TextView = findViewById(R.id.question_text)
        val answerGroup: RadioGroup = findViewById(R.id.answer_group)
        val submitButton: Button = findViewById(R.id.submit_button)
        val restartButton: Button = findViewById(R.id.restart_button) // Restart button

        // Load the first question
        loadQuestion(questionText, answerGroup)

        submitButton.setOnClickListener {
            val selectedOptionId = answerGroup.checkedRadioButtonId

            if (selectedOptionId == -1) {
                showToast("Please select an answer!")
            } else {
                val selectedOption = mapSelectedOption(selectedOptionId)
                userAnswers.add(selectedOption)

                if (selectedOption == correctAnswers[currentQuestionIndex]) {
                    score++
                    showToast("Correct!")
                } else {
                    showToast("Wrong Answer!")
                }

                // Proceed to the next question or end the quiz
                currentQuestionIndex++
                if (currentQuestionIndex < questions.size) {
                    loadQuestion(questionText, answerGroup)
                } else {
                    finishQuiz(submitButton, restartButton) // Show results and restart button
                }
            }
        }

        // Restart the quiz
        restartButton.setOnClickListener {
            restartQuiz(submitButton, restartButton) // Reset everything
        }
    }

    /**
     * Load the current question and its options into the UI
     */
    private fun loadQuestion(questionText: TextView, answerGroup: RadioGroup) {
        questionText.text = questions[currentQuestionIndex]
        val optionsForQuestion = options[currentQuestionIndex]

        for (i in 0 until answerGroup.childCount) {
            val radioButton = answerGroup.getChildAt(i) as RadioButton
            radioButton.text = optionsForQuestion[i]
        }

        answerGroup.clearCheck()
    }

    /**
     * Maps the selected RadioButton ID to the corresponding option index
     */
    private fun mapSelectedOption(selectedOptionId: Int): Int {
        return when (selectedOptionId) {
            R.id.option1 -> 0
            R.id.option2 -> 1
            R.id.option3 -> 2
            R.id.option4 -> 3
            else -> -1
        }
    }

    /**
     * Displays a toast message
     */
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * Finishes the quiz and displays the final score along with corrections
     */
    private fun finishQuiz(submitButton: Button, restartButton: Button) {
        // Display final score
        showToast("Quiz Finished! Your score: $score/${questions.size}")

        // Display correct answers and show corrections
        val resultText = StringBuilder()
        for (i in questions.indices) {
            resultText.append("Q${i + 1}: ${questions[i]}\n")
            resultText.append("Your answer: ${options[i][userAnswers[i]!!]}\n")
            resultText.append("Correct answer: ${options[i][correctAnswers[i]]}\n\n")
        }

        val resultTextView: TextView = findViewById(R.id.result_text)
        resultTextView.text = resultText.toString()

        // Hide the submit button and show the restart button
        submitButton.isEnabled = false
        restartButton.visibility = Button.VISIBLE
    }

    /**
     * Restart the quiz
     */
    private fun restartQuiz(submitButton: Button, restartButton: Button) {
        // Reset everything
        currentQuestionIndex = 0
        score = 0
        userAnswers.clear()

        // Reload the first question
        val questionText: TextView = findViewById(R.id.question_text)
        val answerGroup: RadioGroup = findViewById(R.id.answer_group)
        loadQuestion(questionText, answerGroup)

        // Hide the result and show the submit button
        val resultTextView: TextView = findViewById(R.id.result_text)
        resultTextView.text = ""

        submitButton.isEnabled = true
        restartButton.visibility = Button.INVISIBLE
    }
}
