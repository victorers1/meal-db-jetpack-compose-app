package br.udemy.recipeapp.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.udemy.recipeapp.dataclasses.HomeScreenState
import br.udemy.recipeapp.dataclasses.MealCategory
import br.udemy.recipeapp.screens.home.composables.MealCategoryList
import br.udemy.recipeapp.ui.theme.RecipeAppTheme

@Composable
fun HomeScreen(
    viewState: HomeScreenState,
    navigateToCategoryDetailsScreen: (MealCategory) -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            viewState.loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            viewState.error != null -> {
                Text(
                    text = "Error fetching categories: ${viewState.error}",
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            else -> {
                MealCategoryList(
                    categories = viewState.categories,
                    navigateToCategoryDetailsScreen = navigateToCategoryDetailsScreen
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    val homeScreenViewModel: HomeScreenViewModel = viewModel()
    val homeScreenViewState by homeScreenViewModel.homeScreenState

    RecipeAppTheme {
        HomeScreen(
            viewState = homeScreenViewState,
            navigateToCategoryDetailsScreen = {}
        )
    }
}

