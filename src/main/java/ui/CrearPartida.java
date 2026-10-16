package ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class CrearPartida extends HBox {
    public CrearPartida() {
        this.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        this.getChildren().addAll(crearPanelIzquierdo(), crearPanelDerecho());
    }

    private VBox crearPanelIzquierdo() {
        VBox content = new VBox(6);
        HBox.setHgrow(content, Priority.ALWAYS);
        content.setPadding(new Insets(10));

        HBox contentTi = new HBox();
        contentTi.setAlignment(Pos.CENTER_LEFT);
        contentTi.setMinHeight(30);
        contentTi.setMaxWidth(Double.MAX_VALUE);
        contentTi.setPadding(new Insets(0, 10, 0, 10));

        Label titulo = new Label("JUEGO DE LA VIDA");
        Label generacion = new Label("Generacion: ");
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);
        contentTi.getChildren().addAll(titulo, region1, generacion);

        Pane contenedorCanva = new Pane();
        VBox.setVgrow(contenedorCanva, Priority.ALWAYS);

        Canvas mapa = new Canvas(0,0);
        mapa.getGraphicsContext2D().setFill(Color.PURPLE);
        mapa.getGraphicsContext2D().fillRect(0, 0, mapa.getWidth(), mapa.getHeight());
        contenedorCanva.getChildren().add(mapa);
        content.getChildren().addAll(contentTi, contenedorCanva);

        return content;
    }

    private VBox crearPanelDerecho() {
        VBox inputs = new VBox();
        inputs.setPrefWidth(500);
        inputs.setMinWidth(500);
        inputs.setPadding(new Insets(10));

        VBox inputsContent = new VBox();
        inputsContent.getStyleClass().add("contenedores-contenido");
        inputsContent.setPadding(new Insets(10));
        VBox.setVgrow(inputsContent, Priority.ALWAYS);
        inputsContent.setAlignment(Pos.TOP_LEFT);

        Label ajustes = crearLabelSeccion("AJUSTES DE GENERACION");
        GridPane estadisticas = crearGridEstadisticas();

        Label themas = crearLabelSeccion("TEMAS");
        GridPane seleccionColor = crearGridSeleccionColor();

        Label experimenta = crearLabelSeccion("EXPERIMENTA");
        GridPane btnes = crearGridBotones();

        Label reglas = crearLabelSeccion("REGLAS");
        Text textoReglas = crearTextoReglas();

        inputsContent.getChildren().addAll(ajustes, estadisticas, themas, seleccionColor, experimenta, btnes, reglas, textoReglas);

        inputs.getChildren().add(inputsContent);
        return inputs;
    }

    private Label crearLabelSeccion(String texto) {
        Label label = new Label(texto);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        return label;
    }

    private GridPane crearGridEstadisticas() {
        GridPane estadisticas = new GridPane();
        estadisticas.setPadding(new Insets(10));
        estadisticas.setAlignment(Pos.TOP_LEFT);
        estadisticas.setMaxWidth(Double.MAX_VALUE);
        estadisticas.setHgap(20);
        estadisticas.setVgap(15);

        Label vivos = new Label("0");
        Label muertos = new Label("0");
        Label nacimientos = new Label("0");
        Label muertes = new Label("0");


        Label tamañoPincel = new Label("Tamaño Pincel: ");

        HBox contPin = new HBox(5);
        contPin.setAlignment(Pos.CENTER_LEFT);
        Spinner<Integer> tamPinc = new Spinner<>(1, 20, 1);
        tamPinc.setEditable(true);
        tamPinc.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(tamPinc, Priority.ALWAYS);
        contPin.getChildren().addAll(tamañoPincel,tamPinc);


        HBox x = new HBox(4);
        x.setAlignment(Pos.CENTER_LEFT);
        Label filas = new Label("Filas:");
        Spinner<Integer> spinnerFilas = new Spinner<>(1, 100, 0);
        x.getChildren().addAll(filas, spinnerFilas);

        HBox y = new HBox(4);
        y.setAlignment(Pos.CENTER_LEFT);
        Label columnas = new Label("Columnas:");
        Spinner<Integer> spinnerColumnas = new Spinner<>(1, 100, 0);
        y.getChildren().addAll(columnas, spinnerColumnas);

        HBox formaPre = new HBox(5);
        formaPre.setAlignment(Pos.CENTER_LEFT);
        Label txtformas = new Label("Formas:");
        ComboBox formasPredefinidas = new ComboBox();
        formasPredefinidas.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(formasPredefinidas, Priority.ALWAYS);

        Button fromaAleat = new Button("Forma Aleatoria");
        fromaAleat.setMaxWidth(Double.MAX_VALUE);
        formaPre.getChildren().addAll(txtformas, formasPredefinidas);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);
        estadisticas.getColumnConstraints().addAll(col1, col2);

        Slider sliderVelocidad = new Slider(1, 100, 50);
        sliderVelocidad.setPadding(new Insets(0, 10, 0, 0));
        sliderVelocidad.setShowTickLabels(true);
        sliderVelocidad.setMajorTickUnit(20);
        sliderVelocidad.setBlockIncrement(1);

        Slider sliderGeneraciones = new Slider(1, 100, 50);
        sliderGeneraciones.setPadding(new Insets(0, 10, 0, 0));
        sliderGeneraciones.setShowTickLabels(true);
        sliderGeneraciones.setMajorTickUnit(20);
        sliderGeneraciones.setBlockIncrement(1);


        estadisticas.add(new Label("Vivas:"), 0, 0);
        estadisticas.add(vivos, 1, 0);
        estadisticas.add(new Label("Muertas:"), 0, 1);
        estadisticas.add(muertos, 1, 1);
        estadisticas.add(new Label("Nacimientos:"), 0, 2);
        estadisticas.add(nacimientos, 1, 2);
        estadisticas.add(new Label("Muertes:"), 0, 3);
        estadisticas.add(muertes, 1, 3);
        estadisticas.add(new Label("Células vivas: "), 0, 4);
        estadisticas.add(sliderVelocidad, 1, 4);
        estadisticas.add(new Label("Generaciones: "), 0, 5);
        estadisticas.add(sliderGeneraciones, 1, 5);
        estadisticas.add(x, 0, 6);
        estadisticas.add(y, 1, 6);
        estadisticas.add(formaPre, 0, 7);
        estadisticas.add(fromaAleat, 1, 7);
        estadisticas.add(contPin, 0, 8);
        GridPane.setColumnSpan(contPin,2);


        return estadisticas;
    }

    private GridPane crearGridSeleccionColor() {
        GridPane seleccionColor = new GridPane();
        seleccionColor.setPadding(new Insets(10));
        seleccionColor.setAlignment(Pos.TOP_LEFT);
        seleccionColor.setMaxWidth(Double.MAX_VALUE);
        seleccionColor.setHgap(2);
        seleccionColor.setVgap(2);

        ColorPicker celda = new ColorPicker(Color.RED);
        celda.setMaxWidth(Double.MAX_VALUE);
        ColorPicker cuadricula = new ColorPicker(Color.RED);
        cuadricula.setMaxWidth(Double.MAX_VALUE);
        ColorPicker vivas = new ColorPicker(Color.RED);
        vivas.setMaxWidth(Double.MAX_VALUE);
        ColorPicker muertas = new ColorPicker(Color.RED);
        muertas.setMaxWidth(Double.MAX_VALUE);

        seleccionColor.add(new Label("Color vivas:"), 0, 0);
        seleccionColor.add(vivas, 1, 0);
        seleccionColor.add(new Label("Color muertas:"), 0, 1);
        seleccionColor.add(muertas, 1, 1);
        seleccionColor.add(new Label("Color cuadricula:"), 0, 2);
        seleccionColor.add(cuadricula, 1, 2);
        seleccionColor.add(new Label("Color vacio:"), 0, 3);
        seleccionColor.add(celda, 1, 3);

        ColumnConstraints cl1color = new ColumnConstraints();
        cl1color.setHgrow(Priority.ALWAYS);
        ColumnConstraints cl2color = new ColumnConstraints();
        cl2color.setHgrow(Priority.ALWAYS);
        seleccionColor.getColumnConstraints().addAll(cl1color, cl2color);

        return seleccionColor;
    }

    private GridPane crearGridBotones() {
        Button play = new Button("Play");
        Button parar = new Button("Parar");
        Button sigGen = new Button("Siguiente generación");
        Button antGen = new Button("Generación anterior");
        Button limpiar = new Button("Limpiar mapa");

        play.setMaxWidth(Double.MAX_VALUE);
        parar.setMaxWidth(Double.MAX_VALUE);
        antGen.setMaxWidth(Double.MAX_VALUE);
        sigGen.setMaxWidth(Double.MAX_VALUE);
        limpiar.setMaxWidth(Double.MAX_VALUE);

        GridPane btnes = new GridPane();
        btnes.setPadding(new Insets(10));
        btnes.setMaxWidth(Double.MAX_VALUE);
        btnes.setHgap(2);
        btnes.setVgap(2);

        ColumnConstraints cl1btns = new ColumnConstraints();
        cl1btns.setHgrow(Priority.ALWAYS);
        ColumnConstraints col2btns = new ColumnConstraints();
        col2btns.setHgrow(Priority.ALWAYS);
        btnes.getColumnConstraints().addAll(cl1btns, col2btns);

        btnes.add(antGen, 0, 0);
        btnes.add(sigGen, 1, 0);
        btnes.add(play, 0, 1);
        btnes.add(parar, 1, 1);
        btnes.add(limpiar, 0, 2);
        GridPane.setColumnSpan(limpiar, 2);

        return btnes;
    }

    private Text crearTextoReglas() {
        Text textoReglas = new Text(
                "1. Superpoblación: Una célula viva con más de 3 vecinas muere.\n" +
                        "2. Soledad: Una célula viva con menos de 2 vecinas muere.\n" +
                        "3. Supervivencia: Una célula viva con 2 o 3 vecinas permanece viva.\n" +
                        "4. Reproducción: Una casilla vacía con exactamente 3 vecinas crea una nueva célula."
        );
        textoReglas.setTextAlignment(TextAlignment.JUSTIFY);
        return textoReglas;
    }
}