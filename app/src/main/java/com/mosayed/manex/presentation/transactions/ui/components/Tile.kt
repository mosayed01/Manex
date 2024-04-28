package com.mosayed.manex.presentation.transactions.ui.components


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.mosayed.manex.presentation.theme.DarkGray
import com.mosayed.manex.presentation.theme.Gray

@Composable
fun Tile(
    text: String,
    iconPainter: Painter,
    modifier: Modifier = Modifier,
    iconSize: Dp = 14.dp,
    iconColor: Color = Gray,
    textColor: Color = DarkGray,
    textStyle: TextStyle = MaterialTheme.typography.labelSmall.copy(
        color = textColor
    )
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = iconPainter,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier
                .padding(end = 8.dp)
                .size(iconSize)
        )
        Text(text = text, style = textStyle.copy(color = textColor))
    }
}