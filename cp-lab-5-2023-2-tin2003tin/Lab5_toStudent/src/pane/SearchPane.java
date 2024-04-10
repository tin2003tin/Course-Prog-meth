package pane;

import item.Book;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class SearchPane extends HBox {
    public SearchPane() {
        this.setAlignment(Pos.CENTER);
        TextField textField = new TextField();
        textField.setPromptText("Find the book");
        textField.setPrefWidth(250);
        Button searchButton = new Button("Search");
        searchButton.setBackground(Background.fill(Color.DARKCYAN));
        searchButton.setTextFill(Color.WHITE);
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (textField.getText().isBlank()) {
                    BookListPane.getInstance().setSearchedBooks(BookListPane.getInstance().getBooks());
                } else {
                    ArrayList<Book> filteredBooks = new ArrayList<>(BookListPane.getInstance().getBooks());
                    filteredBooks.removeIf(book -> !book.getName().toLowerCase().contains(textField.getText().toLowerCase()));
                    BookListPane.getInstance().setSearchedBooks(filteredBooks);
                }
            }
        });
        this.getChildren().addAll(textField, searchButton);
    }
}
