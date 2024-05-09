package com.example.jetpackcomposedemoapp.navigation

sealed class Screen(val route: String) {
    object StartScreen : Screen("start_screen")
    object LazyColumnScreen : Screen("lazy_column_screen")
    object ScrollableColumnScreen : Screen("scrollable_column_screen")
    object MessageCardAndConversationScreen : Screen("message_card_and_conversation_screen")
    object ConstraintLayoutScreen : Screen("constraint_layout_screen")
    object MultiSelectLazyColumnScreen : Screen("multi_select_lazy_column_screen")
    object PermissionsHandlingScreen : Screen("permissions_handling_screen")
    object RememberWindowInfoLazyColumnScreen : Screen("remember_window_info_lazy_column_screen")
    object ProfileHeaderAnimationScreen : Screen("profile_header_animation_screen")
    object ImageCardScreen : Screen("image_card_screen")
    object CircularProgressBarScreen : Screen("circular_progress_bar_screen")
    object BottomNavigationBarScreen : Screen("bottom_navigation_bar_screen")
    object MainScreen : Screen("main_screen")
    object DetailsScreen : Screen("details_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append(("/$arg"))
            }
        }
    }
}