package guru.springframework.controllers;

import guru.springframework.services.*;
import junit.framework.TestCase;
import org.junit.*;
import org.mockito.*;
import org.springframework.ui.*;

import static org.junit.Assert.assertEquals;

public class IndexControllerTest {

    IndexController indexController;

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    public void testGetIndexPage() {
        String viewName = indexController.getIndexPage(model);
        assertEquals("index", viewName);
        Mockito.verify(recipeService, Mockito.times(1)).getRecipes();
        Mockito.verify(model, Mockito.times(1)).addAttribute(Mockito.anyString(), Mockito.any());
    }
}