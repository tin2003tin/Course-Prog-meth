package pane;

import item.Book;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import utils.GetDisplay;
import utils.Goto;

public class BookPane extends GridPane {
    public BookPane(Book book) {
        this.setPrefWidth(428);
        this.setHgap(8);
        this.setPadding(new Insets(4));

        ImageView imageView = new ImageView(book.getImage());
        imageView.setFitHeight(160);
        this.add(imageView, 0, 0, 1, 4);

        Text bookName = GetDisplay.name(book, 18, 250, TextAlignment.LEFT);
        this.add(bookName, 1, 0);

        Text bookAuth = GetDisplay.author(book, 16, 250, TextAlignment.LEFT);
        this.add(bookAuth, 1, 1);

        Text bookRating = GetDisplay.stars(book, 16);
        this.add(bookRating, 1, 3);

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Goto.bookPage(book);
            }
        });
    }
}
