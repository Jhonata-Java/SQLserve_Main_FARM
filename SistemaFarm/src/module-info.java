module Sistema_BluePen {
	requires javafx.controls;
	requires java.sql;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires org.apache.pdfbox;
	requires org.apache.commons.logging;
	//requires pdfbox.app;
	
	exports packageController;
	exports packageModel;
	exports packageControle;

	opens packageController to javafx.fxml, pdfbox.app, commons.logging ;
	opens packageModel to javafx.fxml;
	opens packageControle to javafx.fxml;

	opens application to javafx.graphics, javafx.fxml;
}
