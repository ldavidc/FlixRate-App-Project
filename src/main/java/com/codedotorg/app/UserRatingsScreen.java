package com.codedotorg.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.codedotorg.Movie;
import com.codedotorg.Rating;
import com.codedotorg.*;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserRatingsScreen extends AppScreen {

    /**
     * This class represents the user ratings screen of the application.
     * It extends the Screen class and takes in a Stage object, width and height as parameters.
     * The constructor initializes the UserRatingsScreen object with the given parameters.
     *
     * @param window The Stage object representing the window of the application.
     * @param width The width of the user ratings screen.
     * @param height The height of the user ratings screen.
     */
    public UserRatingsScreen(Stage window, int width, int height) {
        super(window, width, height);
    }

    /**
     * Displays the user ratings screen by creating a VBox layout and setting it as the scene.
     */
    public void showScene() {
        VBox userRatingsLayout = createUserRatingsScreen();
        setAndShowScene(userRatingsLayout);
    }

    /**
     * Creates a VBox layout for the user ratings screen.
     * 
     * @return the VBox layout for the user ratings screen
     */
    public VBox createUserRatingsScreen() {
        VBox tempLayout = new VBox(10);
        tempLayout.setPadding(new Insets(10, 10, 10, 10));

        List<Node> componentsList = createComponents();

        tempLayout.getChildren().addAll(componentsList);

        return tempLayout;
    }

    /**
     * Creates and returns a list of UI components for the user ratings screen.
     * The list includes a user label, a list view, and a back button.
     *
     * @return a list of UI components for the user ratings screen
     */
    public List<Node> createComponents() {
        Label userLabel = new Label();
        ListView<Rating> listView = createListView();
        Button backButton = getBackButton();

        List<Node> componentsList = Arrays.asList(userLabel, listView, backButton);

        return componentsList;
    }

    /**
     * Creates a ListView of user ratings.
     * 
     * @return a ListView of Rating objects.
     */
    
    public ListView<Rating> createListView() {
        // Step 1: Get the current user
        User currentUser = MovieApp.getCurrentUser();
    
        // Step 2: Retrieve the list of movies rated by the current user using getRatings
        ArrayList<Rating> ratedMovies = currentUser.getRatings();
    
        // Step 3: Create a ListView<Movie>
        ListView<Rating> listView = new ListView<>();
    
        // Step 4: Set the items of the ListView to the list of rated movies
        ObservableList<Rating> observableRatedMovies = FXCollections.observableArrayList(ratedMovies);
        listView.setItems(observableRatedMovies);
    
        // Step 5: Return the ListView
        return listView;
    }

}
