package br.udemy.recipeapp.screens.home.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.udemy.recipeapp.dataclasses.MealCategory
import br.udemy.recipeapp.ui.theme.RecipeAppTheme

@Composable
fun MealCategoryList(categories: List<MealCategory>) {
    LazyVerticalGrid(GridCells.Fixed(2), modifier = Modifier.fillMaxSize()) {
        items(categories) { category ->
            MealCategoryItem(mealCategory = category)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategorylistPreview() {
    val mealCategory = MealCategory(
        idCategory = "0",
        strCategory = "Category",
        strCategoryDescription = "Description",
        strCategoryThumb = "https://www.themealdb.com/images/category/beef.png"
    )
    RecipeAppTheme {
        MealCategoryList(categories = listOf(mealCategory, mealCategory, mealCategory, mealCategory))
    }
}