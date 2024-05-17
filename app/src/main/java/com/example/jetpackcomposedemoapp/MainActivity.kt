package com.example.jetpackcomposedemoapp

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.MotionLayout
import androidx.constraintlayout.compose.MotionScene
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.jetpackcomposedemoapp.appBarAndNavigationDrawer.AppBar
import com.example.jetpackcomposedemoapp.appBarAndNavigationDrawer.DrawerBody
import com.example.jetpackcomposedemoapp.appBarAndNavigationDrawer.DrawerHeader
import com.example.jetpackcomposedemoapp.appBarAndNavigationDrawer.MenuItem
import com.example.jetpackcomposedemoapp.data.SampleData
import com.example.jetpackcomposedemoapp.navigation.BottomNavigationBars
import com.example.jetpackcomposedemoapp.navigation.Navigation
import com.example.jetpackcomposedemoapp.navigation.Screen
import com.example.jetpackcomposedemoapp.ui.theme.JetpackComposeDemoAppTheme
import com.example.jetpackcomposedemoapp.utils.ListItem
import com.example.jetpackcomposedemoapp.utils.WindowInfo
import com.example.jetpackcomposedemoapp.utils.rememberWindowInfo
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeDemoAppTheme {
                Surface(
                    color = Color.Transparent,
                    modifier = Modifier
                        .fillMaxSize()
//                        .padding(MaterialTheme.spacing.small)
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Skeleton(navController: NavHostController, composableName: String, route: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(end = 50.dp), text = composableName
        )
        Button(onClick = {
            navController.navigate(route)
        }) {
            Text(text = "Next Screen")
        }
    }
    Spacer(modifier = Modifier.height(50.dp))
}

@Composable
fun StartScreen(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()
    ) {
        Skeleton(navController, "Start Screen", Screen.LazyColumnScreen.route)
        Text(
            text = "Obi", modifier = Modifier
                .offset(35.dp, 21.dp)
        )
        Text(text = "Wan")
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally), text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(Color.Green)
                ) {
                    append("J")
                }
                append("etpack")
            }, color = Color.DarkGray, fontSize = 70.sp
        )
    }
}

@Composable
fun LazyColumn(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(navController, "LazyColumn", Screen.ScrollableColumnScreen.route)
        LazyColumn(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(50) {
                Text(text = "Item $it")
            }
        }
    }
}

@Composable
fun ScrollableColumn(navController: NavHostController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(navController, "Scrollable Column", Screen.MessageCardAndConversationScreen.route)
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .verticalScroll(scrollState), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            for (i in 1..50) {
                Text(text = "Item $i")
            }
        }
    }
}

@Composable
fun MessageCardAndConversationScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(
            navController,
            "MessageCardAnd\nConversationScreen",
            Screen.ConstraintLayoutScreen.route
        )
        Conversation(messages = SampleData.conversationSample)
    }
}

@Composable
fun MyConstraintLayout(navController: NavHostController) {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")
        val nextBtn = createRefFor("nextBtn")
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
        constrain(nextBtn) {
            bottom.linkTo(parent.bottom)
        }
        createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
    }
    androidx.constraintlayout.compose.ConstraintLayout(
        constraints, modifier = Modifier.fillMaxSize()
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
        Row(
            modifier = Modifier
                .layoutId("nextBtn")
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = Modifier.padding(end = 50.dp), text = "ConstraintLayout"
            )
            Button(onClick = {
                navController.navigate(Screen.MultiSelectLazyColumnScreen.route)
            }) {
                Text(text = "Next Screen")
            }
        }
    }
}

@Composable
fun MultiSelectLazyColumn(navController: NavHostController) {
    var items by remember {
        mutableStateOf((1..20).map {
            ListItem(
                title = "Item $it", isSelected = false
            )
        })
    }
//    items.filter { it.isSelected }

    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(
            navController, "MultiSelect LazyColumn", route = Screen.PermissionsHandlingScreen.route
        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(items.size) { i ->
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .clickable {
                        items = items.mapIndexed { j, item ->
                            if (i == j) {
                                item.copy(isSelected = !item.isSelected)
                            } else item
                        }
                    }
                    .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically) {
                    Text(text = items[i].title)
                    if (items[i].isSelected) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Selected",
                            tint = Color.Green,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionsHandling(navController: NavHostController) {
//    val cameraPermissionState = rememberPermissionState(Manifest.permission.CAMERA)
    val permissionState = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.CAMERA, Manifest.permission.RECORD_AUDIO
        )
    )
    val lifecycleOwner = LocalLifecycleOwner.current
    DisposableEffect(key1 = lifecycleOwner, effect = {
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
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(
            navController,
            "Permissions Handling",
            route = Screen.RememberWindowInfoLazyColumnScreen.route
        )
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
}

@Composable
fun RememberWindowInfoLazyColumnScreen(navController: NavHostController) {
    val windowInfo = rememberWindowInfo()
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(
            navController,
            "RememberWindowInfo\nLazyColumnScreen",
            Screen.ProfileHeaderAnimationScreen.route
        )
        if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact) {
            Column {
                RememberWindowInfoLazyColumn(1f, Color.Green)
                RememberWindowInfoLazyColumn(1f, Color.Blue)
            }
        } else {
            Row {
                RememberWindowInfoLazyColumn(0.5f, Color.Green)
                RememberWindowInfoLazyColumn(1f, Color.Blue)
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
fun ProfileHeaderAnimationScreen(navController: NavHostController) {
    var progress by remember { mutableStateOf(0f) }
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(navController, "ProfileHeader\nAnimationScreen", Screen.ImageCardScreen.route)
        ProfileHeaderAnimation(progress)
        Spacer(modifier = Modifier.height(32.dp))
        Slider(
            value = progress, onValueChange = {
                progress = it
            }, modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}

@Composable
fun ProfileHeaderAnimation(progress: Float) {
    val context = LocalContext.current
    val motionScene = remember {
        context.resources.openRawResource(R.raw.motion_scene).readBytes().decodeToString()
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

@Composable
fun ImageCardScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(navController, "ImageCardScreen", route = Screen.CircularProgressBarScreen.route)
        ImageCard(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "description",
            title = "title"
        )
    }
}

@Composable
fun ImageCard(
    painter: Painter, contentDescription: String, title: String
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
                                Color.Transparent, Color.Black
                            ), startY = 500f
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
                    text = title, style = TextStyle(color = Color.White, fontSize = 20.sp)
                )
            }
        }
    }
}

@Composable
fun CircularProgressBarScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(
            navController,
            "CircularProgressBar\nScreen",
            Screen.BottomNavigationBarScreen.route
        )
        CircularProgressBar(percentage = 0.8f, number = 100)
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
        modifier = Modifier.padding(10.dp)
    ) {
        var animationPlayed by remember { mutableStateOf(false) }
        val currentPercentage = animateFloatAsState(
            targetValue = if (animationPlayed) percentage else 0f, animationSpec = tween(
                durationMillis = animationDuration, delayMillis = animationDelay
            ), label = ""
        )
        LaunchedEffect(key1 = true) {
            animationPlayed = true
        }

        Box(
            contentAlignment = Alignment.Center, modifier = Modifier.size(radius * 2f)
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
fun BottomNavigationBarScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(navController, "BottomNavigationBar\nScreen", Screen.MainScreen.route)
        BottomNavigationBars()
    }
}

@Composable
fun MainScreen(navController: NavController) {
    var text by remember { mutableStateOf("") }
    Text(
        modifier = Modifier
            .padding(top = 20.dp),
        textAlign = TextAlign.Center,
        text = "MainScreen"
    )
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp)
    ) {
        TextField(
            value = text, onValueChange = {
                text = it
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                navController.navigate(Screen.DetailsScreen.withArgs(text))
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "To DetailsScreen")
        }
    }
}

@Composable
fun DetailsScreen(navController: NavHostController, name: String?) {
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(
            navController,
            "DetailsScreen",
            Screen.AnimatedCounterScreen.route
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Hello $name")
        }
    }
}

@Composable
fun AnimatedCounterScreen(navController: NavHostController) {
    var count by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(navController, "AnimatedCounterScreen", Screen.LazyGridScreen.route)
        AnimatedCounter(
            count = count,
            style = MaterialTheme.typography.bodyMedium
        )
        Button(
            onClick = { count++ }
        ) {
            Text(text = "Increment")
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedCounter(
    count: Int,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyMedium
) {
    var oldCount by remember {
        mutableStateOf(count)
    }
    SideEffect {
        oldCount = count
    }
    Row(modifier = modifier) {
        val countString = count.toString()
        val oldCountString = oldCount.toString()
        for (i in countString.indices) {
            val oldChar = oldCountString.getOrNull(i)
            val newChar = countString[i]
            val char = if (oldChar == newChar) {
                oldCountString[i]
            } else {
                countString[i]
            }
            AnimatedContent(
                targetState = char,
                transitionSpec = { slideInVertically { it } with slideOutVertically { -it } }
            ) { char ->
                Text(text = char.toString(), style = style, softWrap = false)
            }
        }
    }
}

@Composable
fun LazyGrid(navController: NavHostController) {
    val scope = rememberCoroutineScope()
    val gridState = rememberLazyGridState(initialFirstVisibleItemIndex = 99)
    scope.launch { gridState.animateScrollToItem(99) }
    Column(
        modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(navController, "LazyGrid", Screen.TopAppBarScreen.route)
        LazyVerticalGrid(
            state = gridState,
            columns = GridCells.Adaptive(100.dp),
            content = {
                items(100) { i ->
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                            .aspectRatio(1f)
                            .clip(
                                RoundedCornerShape(5.dp)
                            )
                            .background(Color.Blue),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Item $i")
                    }
                }
            }
        )
    }
}

@Composable
fun TopAppBar(navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        scrimColor = Color.Blue,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            Column {
                DrawerHeader()
                DrawerBody(
                    items = listOf(
                        MenuItem(
                            id = "home",
                            title = "Home",
                            contentDescription = "go to home screen",
                            icon = Icons.Default.Home
                        ),
                        MenuItem(
                            id = "mail",
                            title = "Mail",
                            contentDescription = "go to mails screen",
                            icon = Icons.Default.Email
                        ),
                        MenuItem(
                            id = "settings",
                            title = "Settings",
                            contentDescription = "go to settings",
                            icon = Icons.Default.Settings
                        )
                    )
                ) {}
            }
        }) {
        Scaffold(topBar = {
            AppBar(onNavigationItemClick = {
                scope.launch { drawerState.open() }
            })
        }) { innerPadding ->
            Modifier.padding(innerPadding)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 300.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier.padding(end = 50.dp), text = "TopAppBar"
                )
                Button(onClick = {
                    navController.navigate(Screen.BottomSheetScreen.route)
                }) {
                    Text(text = "Next Screen")
                }
            }
        }
    }
}

@Composable
fun BottomSheetScreen(navController: NavHostController) {
    var showBottomSheet by remember {
        mutableStateOf(false)
    }
    if (showBottomSheet) {
        BottomSheet {
            showBottomSheet = false
        }
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Skeleton(navController, "BottomSheetScreen", Screen.SnackBarScreen.route)
            Button(onClick = {
                showBottomSheet = true
            }) {
                Text(text = "Toggle bottom sheet")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit) {
    val modalSheetState = rememberModalBottomSheetState()
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalSheetState,
        contentColor = Color.White,
        containerColor = Color.Black
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Bottom sheet"
            )
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MyBottomSheet() {
//    BottomSheetScaffold(
//        sheetContent = {
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(300.dp),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = "Bottom sheet",
//                    color = Color.White,
//                    fontSize = 30.sp
//                )
//            }
//        },
//        sheetContainerColor = Color.Black
//    ) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.TopCenter
//        ) {
//            Button(onClick = {}) {
//                Text(text = "Toggle bottom sheet")
//            }
//        }
//    }
//}

@Composable
fun ShowSnackBar(navController: NavHostController) {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    var textFieldText by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
        //  We can use floatingActionButton to show a button or use a custom button
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show SnackBar") },
                icon = { Icon(imageVector = Icons.Filled.Done, "SnackBar Icon") },
                shape = RoundedCornerShape(100),
                containerColor = Color.Black,
                contentColor = Color.White,
                onClick = {
                    scope.launch {
                        snackBarHostState.showSnackbar("floatingActionButton")
                    }
                }
            )
        }
    ) { innerPadding ->
        // Here we have a custom button and textField
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Skeleton(navController, "SnackBar Screen", Screen.GetApiDataScreen.route)
            TextField(value = textFieldText, onValueChange = { textFieldText = it })
            Button(
                onClick = {
                    scope.launch {
                        snackBarHostState.showSnackbar(textFieldText)
                    }
                }) {
                Text(text = "Show SnackBar")
            }
        }
    }
}
