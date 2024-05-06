package com.example.jetpackcomposedemoapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposedemoapp.ui.theme.JetpackComposeDemoAppTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.accompanist.permissions.rememberPermissionState
import kotlin.random.Random
import android.Manifest
import androidx.compose.material3.Slider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.example.jetpackcomposedemoapp.ui.LocalSpacing
import com.example.jetpackcomposedemoapp.ui.spacing

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoAppTheme {
                Surface(
                    color = Color.Transparent,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(MaterialTheme.spacing.small)
//                        .padding(LocalSpacing.current.medium)
                ) {
//                        Box(modifier = Modifier
//                            .padding(50.dp)
//                            .background(Color.DarkGray)
//                        ) {
//                            Text(text = "Sam", color = Color.White)
//                        }
//                    Column {
//                        Text(
//                            text = "Obi", modifier = Modifier
//                                .offset(40.dp, 22.dp)
//                        )
//                        Text(text = "Wan")
//                        Conversation(messages = SampleData.conversationSample)
//                        ImageCard(
//                            painter = painterResource(id = R.drawable.ic_launcher_foreground),
//                            contentDescription = "description",
//                            title = "title"
//                        )
//                        FontStyles()
//                        TextFieldsAndSnackBar()
//                        ShowSnackBar()
//                        ScrollableColumn()
//                        LazyColumn()
//                        ConstraintLayout()
//                        CircularProgressBar(percentage = 0.8f, number = 100)
//                        Navigation()
//                    }
//                    BottomNavigationBars()
//                    MultiSelectLazyColumn()
//                    PermissionsHandling()

//                    val windowInfo = rememberWindowInfo()
//                    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
//                        Column {
//                            RememberWindowInfoLazyColumn(1f, Color.Green)
//                            RememberWindowInfoLazyColumn(1f, Color.Blue)
//                        }
//                    }
//                    else {
//                        Row {
//                            RememberWindowInfoLazyColumn(0.5f, Color.Green)
//                            RememberWindowInfoLazyColumn(1f, Color.Blue)
//                        }
//                    }

                    Column {
                        var progress by remember { mutableStateOf(0f) }
                        ProfileHeaderAnimation(progress)
                        Spacer(modifier = Modifier.height(32.dp))
                        Slider(
                            value = progress,
                            onValueChange = {
                                progress = it
                            },
                            modifier = Modifier.padding(horizontal = 32.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MessageCard(msg: Message) {
    val color = remember { mutableStateOf(Color.Transparent) }

    Row(
        modifier = Modifier
            .padding(all = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(color.value)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
                .clickable {
                    color.value = Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f
                    )
                }
        )

        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }

        Column(modifier = Modifier
            .background(color.value)
            .padding(all = 10.dp)
            .clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.text,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = msg.author,
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
}

@Preview(
    name = "Light mode",
    showBackground = true
)
@Composable
private fun PreviewMessageCardLight() {
    JetpackComposeDemoAppTheme {
        Surface {
            MessageCard(Message("Jetpack Compose", "Android"))
        }
    }
}

@Preview(
    name = "Dark mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewMessageCardDark() {
    JetpackComposeDemoAppTheme {
        Surface {
            MessageCard(Message("Jetpack Compose", "Android"))
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    Text(text = "Conversation")
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    Conversation(SampleData.conversationSample)
}

data class Message(val text: String, val author: String)

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String
) {
    Card(
        modifier = Modifier
            .fillMaxHeight(0.5f)
            .fillMaxWidth(0.5f),
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop,
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 500f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = title,
                    style = TextStyle(color = Color.White, fontSize = 20.sp)
                )
            }
        }
    }
}

@Composable
fun FontStyles() {
    Text(
        text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(Color.Green)
            ) {
                append("J")
            }
            append("etpack")
        },
        color = Color.DarkGray,
        fontSize = 50.sp
    )
}

//@Composable
//fun TextFieldsAndSnackBar() {
//    var textFieldState by remember {
//        mutableStateOf("")
//    }
//    val snackBarHostState = remember {
//        SnackbarHostState()
//    }
//
//    var snackbarVisible by remember { mutableStateOf(false) }
//
//
//    Scaffold(
//        modifier = Modifier.fillMaxSize(),
////        scaffoldState = scaffoldState
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(it)
//        ) {
//            TextField(
//                value = textFieldState,
//                label = {
//                    Text(text = "Enter text")
//                },
//                onValueChange = { value ->
//                    textFieldState = value
//                },
//                singleLine = true,
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = {
//                snackbarVisible = true
//            }) {
//                Text(text = "Click")
//            }
//        }
//
//    }
//}

//@Composable
//fun ShowSnackBar() {
//    var textFieldState by remember { mutableStateOf("") }
//    val scope = rememberCoroutineScope()
//    val snackbarHostState = remember { SnackbarHostState() }
//    Scaffold(
//        snackbarHost = {
//            SnackbarHost(hostState = snackbarHostState)
//        },
////        floatingActionButton = {
////            ExtendedFloatingActionButton(
////                text = { Text("Show snackbar") },
////                icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "") },
////                onClick = {
////                    scope.launch {
////                        snackbarHostState.showSnackbar(textFieldState)
////                    }
////                }
////            )
////        },
//    ) { contentPadding ->
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(contentPadding)
//        ) {
//            TextField(
//                value = textFieldState,
//                label = {
//                    Text(text = "Enter text")
//                },
//                onValueChange = { value ->
//                    textFieldState = value
//                },
//                singleLine = true,
//                modifier = Modifier.fillMaxWidth()
//            )
//            Spacer(modifier = Modifier.height(16.dp))
//            Button(onClick = {
//                scope.launch {
//                    snackbarHostState.showSnackbar("Snackbar")
//                }
//            }) {
//                Text(text = "Click")
//            }
//        }
//    }
//}

//@Composable
//fun ShowSnackBar() {
//    val scope = rememberCoroutineScope()
//    val snackbarHostState = remember { SnackbarHostState() }
//    Scaffold(
//        snackbarHost = {
//            SnackbarHost(hostState = snackbarHostState)
//        },
//        floatingActionButton = {
//            ExtendedFloatingActionButton(
//                text = { Text("Show snackbar") },
//                icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "") },
//                onClick = {
//                    scope.launch {
//                        snackbarHostState.showSnackbar("Snackbar")
//                    }
//                }
//            )
//        },
//    ) { contentPadding ->
//        // Screen content
//        Column(modifier = Modifier.padding(contentPadding)) {
//
//        }
//    }
//}

@Composable
fun ScrollableColumn() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.verticalScroll(scrollState)
    ) {
        for (i in 1..50) {
            Text(text = "Item $i")
        }
    }
}

@Composable
fun LazyColumn() {
    LazyColumn {
        items(50) {
            Text(text = "Item $it")
        }
    }
}

@Composable
fun ConstraintLayout() {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")
        val guideline = createGuidelineFromTop(0.5f)

        constrain(greenBox) {
            top.linkTo(guideline)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
    }

    androidx.constraintlayout.compose.ConstraintLayout(
        constraints,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(Color.Green)
                .layoutId("greenBox")
        )
        Box(
            modifier = Modifier
                .background(Color.Red)
                .layoutId("redBox")
        )
    }
}

@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 8.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0
) {
    Box(
        modifier = Modifier
            .padding(10.dp)
    ) {
        var animationPlayed by remember { mutableStateOf(false) }
        val currentPercentage = animateFloatAsState(
            targetValue = if (animationPlayed) percentage else 0f,
            animationSpec = tween(
                durationMillis = animationDuration,
                delayMillis = animationDelay
            ), label = ""
        )
        LaunchedEffect(key1 = true) {
            animationPlayed = true
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(radius * 2f)
        ) {
            Canvas(modifier = Modifier.size(radius * 2f)) {
                drawArc(
                    color = color,
                    -90f,
                    360 * currentPercentage.value,
                    useCenter = false,
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
                )
            }
            Text(
                text = (currentPercentage.value * number).toInt().toString(),
                color = Color.Black,
                fontSize = fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun MultiSelectLazyColumn() {
    var items by remember {
        mutableStateOf(
            (1..20).map {
                ListItem(
                    title = "Item $it",
                    isSelected = false
                )
            }
        )
    }

//    items.filter { it.isSelected }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items.size) { i ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    items = items.mapIndexed { j, item ->
                        if (i == j) {
                            item.copy(isSelected = !item.isSelected)
                        } else item
                    }
                }
                .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = items[i].title)
                if (items[i].isSelected) {
                    Icon(
                        imageVector = Icons.Default.Check, contentDescription = "Selected",
                        tint = Color.Green,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionsHandling() {
//    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)
    val permissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
        )
    )

    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(
        key1 = lifecycleOwner,
        effect = {
            val observer = LifecycleEventObserver { _, event ->
                if (event == Lifecycle.Event.ON_START) {
                    permissionState.launchMultiplePermissionRequest()
                }
            }
            lifecycleOwner.lifecycle.addObserver(observer)
            onDispose {
                lifecycleOwner.lifecycle.removeObserver(observer)
            }
        })

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        permissionState.permissions.forEach { permission ->
            when (permission.permission) {
                Manifest.permission.CAMERA -> {
                    when {
                        permission.hasPermission -> {
                            Text(text = "Camera permission accepted.")
                        }

                        permission.shouldShowRationale -> {
                            Text(text = "Camera permission needed.")
                        }

                        !permission.hasPermission && !permission.shouldShowRationale -> {
                            Text(text = "Camera permission permanently denied.")
                        }
                    }
                }

                Manifest.permission.RECORD_AUDIO -> {
                    when {
                        permission.hasPermission -> {
                            Text(text = "Microphone permission accepted.")
                        }

                        permission.shouldShowRationale -> {
                            Text(text = "Microphone permission needed.")
                        }

                        !permission.hasPermission && !permission.shouldShowRationale -> {
                            Text(text = "Microphone permission permanently denied.")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RememberWindowInfoLazyColumn(width: Float, color: Color) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(width)
            .background(color)
    ) {
        items(20) {
            Text(text = "Item $it")
        }
    }
}

@Composable
fun ProfileHeaderAnimation(progress: Float) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources
            .openRawResource(R.raw.motion_scene)
            .readBytes()
            .decodeToString()
    }
    MotionLayout(
        motionScene = MotionScene(content = motionScene),
        progress = progress,
        modifier = Modifier.fillMaxWidth()
    ) {
        val properties = customProperties(id = "profile_pic")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .layoutId("box")
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "image",
            modifier = Modifier
                .clip(CircleShape)
                .border(width = 2.dp, color = properties.color("background"), shape = CircleShape)
                .layoutId("profile_pic")
        )
        Text(
            text = "Sam Smith",
            fontSize = 24.sp,
            color = properties.color("background"),
            modifier = Modifier.layoutId("username")
        )
    }
}