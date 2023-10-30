package com.dnd_9th_3_android.gooding.record.tabGallery.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.dnd_9th_3_android.gooding.core.data.R
import androidx.compose.foundation.Image
import androidx.compose.material.DropdownMenu
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.dnd_9th_3_android.gooding.data.component.pretendardBold
import com.dnd_9th_3_android.gooding.record.viewModel.RecordViewModel

@Composable
fun GalleryTopLayer(
    prevStep: () -> Unit,
    nextStep: () -> Unit,
    currentDirectory: Pair<String, String?>,
    setCurrentDirectory: (Pair<String, String?>) -> Unit,
) {
    var isDropDownMenuExpanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 13.dp,
                end = 18.dp,
                bottom = 14.dp,
            )
            .height(95.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .clickable {
                    prevStep()
                }
                .size(24.dp)
                .align(Alignment.BottomStart),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.close_my),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.BottomCenter)
                .clickable {
                    // 폴더 리스트 + image 회전 (180도)
                    isDropDownMenuExpanded = !isDropDownMenuExpanded
                }
        ) {
            Text(
                text = currentDirectory.first,
                letterSpacing = (-0.25).sp,
                fontSize = 18.sp,
                fontFamily = pretendardBold,
                color = Color.White
            )
            Box(
                modifier = Modifier
                    .size(24.dp),
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_bottom),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .rotate(if (isDropDownMenuExpanded) 180f else 0f)
                )
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .clickable {
                    // 클릭 가능 상태면 이동, 다음 텍스트 변경
                    nextStep()
                }
        ) {
            Text(
                text = "다음",
                color = colorResource(id = R.color.blue_gray_3),
                letterSpacing = (-0.25).sp,
                fontFamily = pretendardBold,
                fontSize = 18.sp
            )
        }

    }

    DropdownMenu(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.blue_gray_7)),
        expanded = isDropDownMenuExpanded,
        onDismissRequest = { isDropDownMenuExpanded = false }
    ) {

    }
}