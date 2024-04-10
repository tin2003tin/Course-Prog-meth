package utils;

import item.Book;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import pane.BookListPane;
import pane.NewBookPane;
import pane.RootPane;
import pane.SearchPane;

public class Goto {
    private static RootPane rootPane;
    public static void setRootPane(RootPane rootPane) {
        Goto.rootPane = rootPane;
    }
    public static void clear() {
        if (rootPane.getChildren().size() > 1) {
            rootPane.getChildren().remove(1, rootPane.getChildren().size());
        }
    }
    public static void mainPage() {
        Goto.clear();
        ScrollPane scrollPane = new ScrollPane(BookListPane.getInstance());
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        rootPane.getChildren().add(new SearchPane());
        rootPane.getChildren().add(scrollPane);

    }
    public static Button backToMainPageButton() {
            Button button = new Button("Back");
            button.setBorder(new Border(new BorderStroke(Color.DARKCYAN,BorderStrokeStyle.SOLID,CornerRadii.EMPTY,new BorderWidths(2))));
            button.setBackground(Background.fill(Color.WHITE));
            button.setTextFill(Color.DARKCYAN);
            button.setPrefWidth(300);
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    mainPage();
                }
            });
            return  button;
    }
    public static void bookPage(Book book) {
        Goto.clear();
        Text bookName = GetDisplay.name(book,28,336,TextAlignment.CENTER);
        Text bookAuth = GetDisplay.author(book,24,336,TextAlignment.CENTER);
        bookAuth.setText("By "+book.getAuthor());
        ImageView bookImage = GetDisplay.image(book,320);
        Text bookRating = GetDisplay.stars(book,24);
        Text bookDescription = GetDisplay.Description(book,16,336);
        Button backToMainPage = backToMainPageButton();
        rootPane.getChildren().addAll(backToMainPage,bookName,bookAuth,bookImage,bookRating,bookDescription);
    }
    public static void addNewBookPage() {
        Goto.clear();

        Button backToMainPage = backToMainPageButton();
        rootPane.getChildren().add(backToMainPage);
        rootPane.getChildren().add(new NewBookPane());
    }
}
