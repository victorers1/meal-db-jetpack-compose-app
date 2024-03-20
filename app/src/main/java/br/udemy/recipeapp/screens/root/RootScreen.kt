package br.udemy.recipeapp.screens.root

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.udemy.recipeapp.Screen
import br.udemy.recipeapp.dataclasses.MealCategory
import br.udemy.recipeapp.screens.categorydetails.CategoryDetailsScreen
import br.udemy.recipeapp.screens.home.HomeScreen
import br.udemy.recipeapp.screens.home.HomeScreenViewModel

@Composable
fun RootScreen() {
    val navController = rememberNavController()
    val homeScreenViewModel: HomeScreenViewModel = viewModel()
    val homeScreenState by homeScreenViewModel.homeScreenState

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                viewState = homeScreenState,
                navigateToCategoryDetailsScreen = { category ->
                    navController.currentBackStackEntry?.savedStateHandle?.set("category", category)
                    navController.navigate(Screen.MealCategoryDetailsScreen.route)
                }
            )
        }

        composable(route = Screen.MealCategoryDetailsScreen.route) {
            val category =
                navController.previousBackStackEntry?.savedStateHandle?.get<MealCategory>("category")
                    ?: dummyMealCategory
            CategoryDetailsScreen(
                category = category,
                navigateToHomeScreen = { navController.popBackStack() }
            )
        }
    }
}

val dummyMealCategory = MealCategory(
    idCategory = "",
    strCategory = "",
    strCategoryThumb = "",
    strCategoryDescription = ""
)