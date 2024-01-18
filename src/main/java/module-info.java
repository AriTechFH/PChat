module com.example.plantchat {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires sqlite.jdbc;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires java.logging;

    requires com.opencsv;
    requires java.sql;
    requires jbcrypt;
    requires com.zaxxer.hikari;

    opens com.example.pchat to javafx.fxml;
    exports com.example.pchat;
}