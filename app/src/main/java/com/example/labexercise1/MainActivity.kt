package com.example.labexercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.buttonCalculate)
        val rollButton2: Button = findViewById(R.id.buttonReset)

        rollButton.setOnClickListener{calculateLoan()}
        rollButton2.setOnClickListener{clear()}

    }

    private fun calculateLoan(){
        val getCarPrice : EditText = findViewById(R.id.editTextCarPrice)
        val Dpayment : EditText = findViewById(R.id.editTextDownPayment)
        val getLoan : EditText = findViewById (R.id.editTextLoanPeriod)
        val getInterest : EditText = findViewById (R.id.editTextInterestRate)

        val carPrice = getCarPrice.text.toString().toInt()
        val Downpayment = Dpayment.text.toString().toInt()
        val Loan = getLoan.text.toString().toInt()
        val interest = getInterest.text.toString().toInt()
        val cPrice : Int = carPrice
        val payment : Int = Downpayment
        val loann : Int = Loan
        val interesttRate : Int = interest

        val calculateLoan = cPrice - payment
        val calculateInterest = calculateLoan * interesttRate/100 * loann
        val calculateMonthly = (calculateLoan + calculateInterest) / loann / 12

        textViewLoan.setText("Loan : RM $calculateLoan")
        textViewInterest.setText("Interest : RM $calculateInterest")
        textViewMonthlyRepayment.setText("Monthly Repayment : RM $calculateMonthly")
    }

    private fun clear(){
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextInterestRate.setText("")
        editTextLoanPeriod.setText("")
        textViewLoan.setText("Loan :")
        textViewInterest.setText("Interest :")
        textViewMonthlyRepayment.setText("Monthly Repayment :")
    }
}
