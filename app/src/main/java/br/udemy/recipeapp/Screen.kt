package br.udemy.recipeapp

sealed class Screen(val route: String) {
    data object HomeScreen : Screen("home")
    data object MealCategoryDetailsScreen : Screen("mealCategoryDetails")
}