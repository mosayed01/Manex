package com.mosayed.manex.presentation.transactions.ui.components


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mosayed.manex.R
import com.mosayed.manex.presentation.theme.Gray
import com.mosayed.manex.presentation.theme.White

@Composable
fun NumberOfTransactions(
    transactionsCount: Int,
    query: String,
    onQueryChange: (String) -> Unit,
    visible: Boolean,
    modifier: Modifier = Modifier
) {
    var text1Height by remember { mutableFloatStateOf(0f) }
    var text2Height by remember { mutableFloatStateOf(0f) }
    val totalHeightDp = with(LocalDensity.current) {
        text1Height.toDp() + text2Height.toDp() + TextFieldDefaults.MinHeight
    }
    val hMaxDp =
        remember { 24.dp + 18.dp + 24.dp + 16.dp + 4.dp + 24.dp + 16.dp + 24.dp + totalHeightDp }


    val height by animateDpAsState(
        targetValue = if (visible) hMaxDp else 24.dp + 18.dp,
        animationSpec = tween(500, easing = FastOutSlowInEasing), label = ""
    )
    Column(
        modifier = modifier
            .height(height)
            .fillMaxWidth()
            .clip(
                RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp)
            )
            .background(MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.manex_logo),
            contentDescription = "Manex Logo",
            modifier = Modifier
                .padding(bottom = 24.dp)
                .size(
                    width = 68.dp,
                    height = 18.dp
                ),
            contentScale = ContentScale.FillWidth
        )
        AnimatedVisibility(
            visible,
            enter = fadeIn(
                tween(
                    400,
                    easing = FastOutSlowInEasing
                )
            ) + slideInHorizontally(
                animationSpec = tween(
                    400,
                    easing = FastOutSlowInEasing
                )
            ) { it * 2 },
            exit = fadeOut(
                tween(
                    400,
                    easing = FastOutSlowInEasing
                )
            ) + slideOutHorizontally(
                animationSpec = tween(
                    400,
                    easing = FastOutSlowInEasing
                )
            ) { it * 2 }
        ) {
            Text(
                text = "عدد المعاملات الكلي",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Gray
                ),
                modifier = Modifier.onGloballyPositioned {
                    text1Height = it.size.height.toFloat()
                }
            )
        }

        AnimatedVisibility(
            visible,
            enter = fadeIn(tween(300, easing = FastOutSlowInEasing)) + slideInHorizontally(
                animationSpec = tween(300, easing = FastOutSlowInEasing)
            ) { -it * 2 },
            exit = fadeOut(tween(300, easing = FastOutSlowInEasing)) + slideOutHorizontally(
                animationSpec = tween(300, easing = FastOutSlowInEasing)
            ) { -it * 2 }
        ) {
            Text(
                text =
                "$transactionsCount معاملة",
                style = MaterialTheme.typography.displayLarge.copy(
                    color = MaterialTheme.colorScheme.onPrimary
                ),
                modifier = Modifier
                    .onGloballyPositioned {
                        text2Height = it.size.height.toFloat()
                    }
                    .padding(top = 4.dp)
            )
        }

        AnimatedVisibility(
            visible,
            enter = fadeIn(tween(300, easing = FastOutSlowInEasing)) + slideInVertically(
                animationSpec = tween(300, easing = FastOutSlowInEasing)
            ),
            exit = fadeOut(tween(300, easing = FastOutSlowInEasing)) + slideOutVertically(
                animationSpec = tween(300, easing = FastOutSlowInEasing)
            )
        ) {
            TextField(
                value = query,
                onValueChange = onQueryChange,
                placeholder = {
                    Text(
                        text = "فرز المعاملات",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                },
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 34.dp)
                    .padding(bottom = 16.dp),
                shape = RoundedCornerShape(32.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = White,
                    unfocusedContainerColor = White,
                    focusedTextColor = MaterialTheme.colorScheme.primary,
                    unfocusedTextColor = MaterialTheme.colorScheme.primary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledTextColor = Color.Transparent,
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_filter),
                        contentDescription = "Search Icon",
                        modifier = Modifier.size(18.dp),
                        tint = MaterialTheme.colorScheme.primary,
                    )
                },
                textStyle = MaterialTheme.typography.bodySmall.copy(
                    color = MaterialTheme.colorScheme.primary
                ),
            )
        }
    }
}