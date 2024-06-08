package com.mfkl.friendcard.menu.presentation.iu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.mfkl.friendcard.R
import com.mfkl.friendcard.menu.data.model.Bank
import com.mfkl.friendcard.menu.data.model.Buyer
import com.mfkl.friendcard.menu.data.model.Installment
import com.mfkl.friendcard.menu.data.model.Transaction
import kotlinx.datetime.LocalDate

class TransactionFormFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.register_transaction_fragment, container, false).apply {
            findViewById<ComposeView>(R.id.compose_view).setContent {
                TransactionForm()
            }
        }
    }

    @Composable
    fun TransactionForm() {
        var bankName by remember { mutableStateOf("") }
        var bankColor by remember { mutableStateOf("") }
        var value by remember { mutableStateOf("") }
        var purchaseDate by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var buyerName by remember { mutableStateOf("") }
        var buyerPhone by remember { mutableStateOf("") }
        var installmentCurrent by remember { mutableStateOf("") }
        var installmentTotal by remember { mutableStateOf("") }

        Column(modifier = Modifier.padding(16.dp)) {
            TextField(
                value = bankName,
                onValueChange = { bankName = it },
                label = { Text("Bank Name") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = bankColor,
                onValueChange = { bankColor = it },
                label = { Text("Bank Color") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = value,
                onValueChange = { value = it },
                label = { Text("Value") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = purchaseDate,
                onValueChange = { purchaseDate = it },
                label = { Text("Purchase Date (YYYY-MM-DD)") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = buyerName,
                onValueChange = { buyerName = it },
                label = { Text("Buyer Name") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = buyerPhone,
                onValueChange = { buyerPhone = it },
                label = { Text("Buyer Phone") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = installmentCurrent,
                onValueChange = { installmentCurrent = it },
                label = { Text("Installment Current") },
                modifier = Modifier.fillMaxWidth()
            )
            TextField(
                value = installmentTotal,
                onValueChange = { installmentTotal = it },
                label = { Text("Installment Total") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                val transaction = Transaction(
                    bank = Bank(name = bankName, color = bankColor.toInt()),
                    value = value,
                    purchaseDate = LocalDate.parse(purchaseDate),
                    description = description,
                    buyer = Buyer(name = buyerName, phone = buyerPhone.toInt()),
                    installment = Installment(
                        current = installmentCurrent.toInt(),
                        total = installmentTotal.toInt()
                    )
                )
                // Handle the transaction object
            }) {
                Text("Submit")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TransactionFormPreview() {
        TransactionForm()
    }
}
