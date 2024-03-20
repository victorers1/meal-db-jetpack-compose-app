package br.udemy.recipeapp.screens.home.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.udemy.recipeapp.dataclasses.MealCategory
import br.udemy.recipeapp.ui.theme.RecipeAppTheme
import coil.compose.rememberAsyncImagePainter

@Composable
fun MealCategoryItem(mealCategory: MealCategory) {
    Column(
        modifier = Modifier.padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter(mealCategory.strCategoryThumb),
            contentDescription = mealCategory.strCategoryDescription,
            modifier = Modifier.aspectRatio(1f)
        )
        Text(
            text = mealCategory.strCategory,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryItemPreview() {
    val mealCategory = MealCategory(
        idCategory = "0",
        strCategory = "Category",
        strCategoryDescription = "Description",
        strCategoryThumb = "https://www.themealdb.com/images/category/beef.png"
    )
    RecipeAppTheme {
        MealCategoryItem(mealCategory = mealCategory)
    }
}
