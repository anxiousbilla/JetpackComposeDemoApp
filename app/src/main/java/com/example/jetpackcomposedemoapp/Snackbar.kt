package com.example.jetpackcomposedemoapp

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