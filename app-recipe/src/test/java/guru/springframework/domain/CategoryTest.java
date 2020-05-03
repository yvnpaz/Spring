package guru.springframework.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class CategoryTest {

    Category category;

    @Before
    public void setUp(){
        category = new Category();
    }

    @Test
    public void getId() {
        //given
        Long idValue = 4L;
        category.setId(idValue);
        //when
        //then
        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() {
        //given
        String description = "description";
        category.setDescription(description);
        //when
        //then
        assertEquals(description, category.getDescription());
    }

    @Test
    public void getRecipes() {
        //given
        Set<Recipe> recipes = new HashSet<>();
        Recipe recipeOne = new Recipe();
        recipes.add(recipeOne);
        category.setRecipes(recipes);
        //when
        //then
        assertEquals(1, category.getRecipes().size());
    }
}