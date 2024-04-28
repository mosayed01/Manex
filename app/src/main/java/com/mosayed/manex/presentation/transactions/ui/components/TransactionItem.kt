package com.mosayed.manex.presentation.transactions.ui.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mosayed.manex.R
import com.mosayed.manex.presentation.theme.Black87
import com.mosayed.manex.presentation.theme.White
import com.mosayed.manex.presentation.transactions.viewmodel.ui_models.TransactionItemUI

@Composable
fun TransactionItem(
    transaction: TransactionItemUI,
    modifier: Modifier = Modifier,
) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 34.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Tile(
                text = " ${transaction.price} ج.م",
                iconPainter = painterResource(id = R.drawable.ic_egp),
                iconColor = MaterialTheme.colorScheme.error,
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                textColor = Black87
            )
            Tile(
                text = transaction.location,
                iconPainter = painterResource(id = R.drawable.location),
            )
            Row {
                Tile(
                    text = transaction.date,
                    iconPainter = painterResource(id = R.drawable.calendar),
                )
                Tile(
                    text = transaction.time,
                    iconPainter = painterResource(id = R.drawable.clock),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}
