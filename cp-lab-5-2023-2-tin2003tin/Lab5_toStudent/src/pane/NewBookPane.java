package pane;

import item.Book;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.Goto;

public class NewBookPane extends GridPane {
    public NewBookPane() {
        this.setPadding(new Insets(12));
        this.setVgap(8);
        this.setHgap(8);

        Text titleLabel = label("Title:");
        Text authorLabel = label("Author:");
        Text ratingLabel = label("Rating:");
        Text imageLabel = label("Image:");
        Text descriptionLabel = label("Description:");

        TextField namefield = input();
        TextField authorfield = input();
        TextField ratingfield = input();
        TextField imagefield = input();
        TextField descriptionfield = input();

        ColumnConstraints constraints1 = new ColumnConstraints();
        constraints1.setPercentWidth(25);
        constraints1.setHalignment(HPos.RIGHT);
        ColumnConstraints constraints2 = new ColumnConstraints();
        constraints2.setPercentWidth(75);

        Button addButton = new Button("Add");
        addButton.setMaxWidth(430);
        addButton.setPrefHeight(32);
        addButton.setTextFill(Color.WHITE);
        addButton.setBackground(Background.fill(Color.DARKCYAN));
        addButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                handleClick(namefield.getText(),authorfield.getText(),ratingfield.getText(),imagefield.getText(),descriptionfield.getText());
            }
        });
        this.getColumnConstraints().addAll(constraints1,constraints2);

        this.add(titleLabel, 0, 0);
        this.add(authorLabel, 0, 1);
        this.add(ratingLabel, 0, 2);
        this.add(imageLabel, 0, 3);
        this.add(descriptionLabel, 0, 4);

        this.add(namefield, 1, 0);
        this.add(authorfield, 1, 1);
        this.add(ratingfield, 1, 2);
        this.add(imagefield, 1, 3);
        this.add(descriptionfield, 1, 4);

        this.add(addButton, 0, 5, 2, 1);
    }

    public Text label(String s) {
        Text text = new Text(s);
        text.setFont(Font.font(16));
        return  text;
    }
    public TextField input() {
        TextField textField = new TextField();
        textField.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(16), Insets.EMPTY)));
        textField.setBorder(new Border(new BorderStroke(Color.DARKCYAN, BorderStrokeStyle.SOLID, new CornerRadii(16), BorderStroke.DEFAULT_WIDTHS)));
        return  textField;
    }
    private void handleClick(String name, String author, String rating, String image, String description) {
        if (name.isBlank() || author.isBlank() || rating.isBlank() || image.isBlank() || description.isBlank() ) {
            return;
        }
        Book book = new Book(name,author,rating,image,description);
        BookListPane.getInstance().addBook(book);
        BookListPane.getInstance().setSearchedBooks(BookListPane.getInstance().getBooks());
        Goto.mainPage();
    }
}
