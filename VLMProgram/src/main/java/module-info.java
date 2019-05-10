module com.virtual.league.management {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.virtual.league.management to javafx.fxml;
    exports com.virtual.league.management;
}