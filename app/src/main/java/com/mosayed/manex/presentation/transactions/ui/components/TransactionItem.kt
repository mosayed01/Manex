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

@Composable
fun TransactionItem() {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
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
                text = " 432 ج.م",
                iconPainter = painterResource(id = R.drawable.ic_egp),
                iconColor = MaterialTheme.colorScheme.error,
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.ExtraBold
                ),
                textColor = Black87
            )
            Tile(
                text = "الجيزة",
                iconPainter = painterResource(id = R.drawable.location),
            )
            Row {
                Tile(
                    text = "07 / 03 / 2024",
                    iconPainter = painterResource(id = R.drawable.calendar),
                )
                Tile(
                    text = "12:07 مساءً",
                    iconPainter = painterResource(id = R.drawable.clock),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}
