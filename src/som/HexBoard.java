/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package som;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import javafx.animation.Animation;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**
 *
 * @author makogenq
 */
public class HexBoard implements Serializable {

    public Graphics getGraphics() {
        return graphics;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public Image getMarsImage() {
        return marsImage;
    }

    public void setMarsImage(Image marsImage) {
        this.marsImage = marsImage;
    }

    public Image getSpriteImage() {
        return spriteImage;
    }

    public void setSpriteImage(Image spriteImage) {
        this.spriteImage = spriteImage;
    }

    public ImageView getSpriteImageView() {
        return spriteImageView;
    }

    public void setSpriteImageView(ImageView spriteImageView) {
        this.spriteImageView = spriteImageView;
    }

    public ImageView getMarsView() {
        return marsView;
    }

    public void setMarsView(ImageView marsView) {
        this.marsView = marsView;
    }

    public StackPane getMarsPane() {
        return marsPane;
    }

    public void setMarsPane(StackPane marsPane) {
        this.marsPane = marsPane;
    }

    public ArrayList<Hex> getHexList() {
        return hexList;
    }

    public void setHexList(ArrayList<Hex> hexList) {
        this.hexList = hexList;
    }

    public ArrayList<Hex> getTransHexList() {
        return transHexList;
    }

    public void setTransHexList(ArrayList<Hex> transHexList) {
        this.transHexList = transHexList;
    }

    public ArrayList<HexVertex> getVertexList() {
        return vertexList;
    }

    public void setVertexList(ArrayList<HexVertex> vertexList) {
        this.vertexList = vertexList;
    }

    public ArrayList<HexEdge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(ArrayList<HexEdge> edgeList) {
        this.edgeList = edgeList;
    }

    public int getMaxColumns() {
        return maxColumns;
    }

    public void setMaxColumns(int maxColumns) {
        this.maxColumns = maxColumns;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public double getCurrentX() {
        return currentX;
    }

    public void setCurrentX(double currentX) {
        this.currentX = currentX;
    }

    public double getCurrentY() {
        return currentY;
    }

    public void setCurrentY(double currentY) {
        this.currentY = currentY;
    }

    public StackPane getBoardShell() {
        return boardShell;
    }

    public void setBoardShell(StackPane boardShell) {
        this.boardShell = boardShell;
    }

    public Pane getTransHexPane() {
        return transHexPane;
    }

    public void setTransHexPane(Pane transHexPane) {
        this.transHexPane = transHexPane;
    }

    public static Pane getNumberPane() {
        return numberPane;
    }

    public static void setNumberPane(Pane numberPane) {
        HexBoard.numberPane = numberPane;
    }

    public Text getT1() {
        return t1;
    }

    public void setT1(Text t1) {
        this.t1 = t1;
    }

    public Pane getVertexPane() {
        return vertexPane;
    }

    public void setVertexPane(Pane vertexPane) {
        this.vertexPane = vertexPane;
    }

    public Pane getEdgePane() {
        return edgePane;
    }

    public void setEdgePane(Pane edgePane) {
        this.edgePane = edgePane;
    }

    public Pane getPopUpDialog() {
        return popUpDialog;
    }

    public void setPopUpDialog(Pane popUpDialog) {
        this.popUpDialog = popUpDialog;
    }

    public int getColumnMax() {
        return columnMax;
    }

    public void setColumnMax(int columnMax) {
        this.columnMax = columnMax;
    }

    public double getHexRadius() {
        return hexRadius;
    }

    public void setHexRadius(double hexRadius) {
        this.hexRadius = hexRadius;
    }

    public double getInRadius() {
        return inRadius;
    }

    public void setInRadius(double inRadius) {
        this.inRadius = inRadius;
    }

    public float getCenterX() {
        return centerX;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public float getCenterY() {
        return centerY;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    public List<Integer> getPossibleTokens() {
        return possibleTokens;
    }

    public void setPossibleTokens(List<Integer> possibleTokens) {
        this.possibleTokens = possibleTokens;
    }

    public int[] getTemp() {
        return temp;
    }

    public void setTemp(int[] temp) {
        this.temp = temp;
    }

    public int[] getPossibleTerrainTypes() {
        return possibleTerrainTypes;
    }

    public void setPossibleTerrainTypes(int[] possibleTerrainTypes) {
        this.possibleTerrainTypes = possibleTerrainTypes;
    }

    public Stack getTokenStack() {
        return tokenStack;
    }

    public void setTokenStack(Stack tokenStack) {
        this.tokenStack = tokenStack;
    }

    public Stack getTerrainStack() {
        return terrainStack;
    }

    public void setTerrainStack(Stack terrainStack) {
        this.terrainStack = terrainStack;
    }

    Graphics graphics;
    Image marsImage, spriteImage;                                               // Image of Mars and sprite sheet of tornado
    ImageView spriteImageView, marsView;
    StackPane marsPane;
                                                                                //default board settings
    private static final int SPRITE_COLUMNS = 5;
    private static final int SPRITE_COUNT = 5;
    private static final int SPRITE_OFFSET_X = 0;
    private static final int SPRITE_OFFSET_Y = 2;
    private static final int SPRITE_WIDTH = 95;
    private static final int SPRITE_HEIGHT = 168;
    int maxColumns = 5;                                                         // default is 5 for catan: this is the maximum number of
                                                                                // hexes allowed in the longest row
    int numberOfRows = 5;                                                       // this value is for the maximum number of rows.
    int columnMax;                                                              // this is the maximum number of columns for a row...this is
                                                                                // incremented and decremented to yield the 3,4,5,4,3 row
                                                                                // pattern
    
    
//end default board settings
    public Color[] getColorPalette() {
        return colorPalette;
    }

                                                                                // get longest row
                                                                                // build board based on longest row
                                                                                // ie 5 builds 5 rows of 3,4,5,4,3

    public void setColorPalette(Color[] colorPalette) {
        this.colorPalette = colorPalette;
    }

                                                                                // These lists keep track of the components that make up the board
    ArrayList<Hex> hexList;                                                     // the list of hexes in this board
    ArrayList<Hex> transHexList;
    ArrayList<HexVertex> vertexList;                                            // the list of vertices in this board (removing duplicates)
    ArrayList<HexEdge> edgeList;                                                // the list of edges in this board (removing duplicates)
    

    
    double currentX, currentY;
    float centerX, centerY;                                                     // this is the center of each hex when it is drawn

    StackPane boardShell;                                                       // this is the stackpane that merges the board, the
                                                                                // vertices, and the edges together
    Pane boardPane;                                                             // this is what contains the hexes once they're each drawn
    Pane transHexPane;
    static Pane numberPane;
    Text t1;

    Pane vertexPane;                                                            // this contains the vertices once they're each drawn
    Pane edgePane;                                                              // this contains the edges once they're each drawn
    Pane popUpDialog = new Pane();                                              // this is the pane that appears once a
                                                                                // vertex or edge is clicked.

    double hexRadius, inRadius;                                                 // this is the default circumradius and inradius
                                                                                // of all hexes

    // This is the palette for colors to be used in the generation of the board.
    // Also, below this color palette should be a secondary one used for
    // debugging the board
    Color[] colorPalette = new Color[]{Color.web("#7EA6C4"), // light blueish
        // color 0
        Color.web("#C16161"), // abse REDDISH Color 1
        Color.web("#EED79B"), // pale yellow 2
        Color.web("#AFBDA8"), // dull green
        Color.web("#AE9C9E"), // reddish GRAY 4
        Color.web("#000000")}; // black null color 5

    List<Integer> possibleTokens = new ArrayList<Integer>(); // array of
    // possible
    // values for
    // each hex's
    // dice value
    int[] temp = new int[]{ // tokenValue numbers possible
        2, 3, 3, 4, 4, 5, 5, 6, 6, 8, 8, 9, 9, 10, 10, 11, 11, 12};
    int[] possibleTerrainTypes = new int[]{3, 3, 3, // hemp = grain
        // distribution
        3, 4, 4, 4, // plastic = lumber distribution
        4, 2, 2, 2, 2, // soy = pasture
        0, 0, 0, 1, // steel = ore
        1, 1}; // brick = glass

    Stack tokenStack = new Stack();
    Stack terrainStack = new Stack();

    public HexBoard() {
        graphics = new Graphics();
        marsPane = new StackPane();
        spriteImageView = new ImageView();
        // int[] boardBoundaries = new int[]{0.0,2,3,4};
        // 800x600
        columnMax = maxColumns - 2; // this sets the max columns of the first
        // row to 2 less than the longest (median)
        // row
        // i needed this because i had a hard time
        // generating the radii of each in the
        // constructor
        Hex modelHex = new Hex(0, 400, 300, 50, 50 * 0.87, Color.ALICEBLUE, 0, 5); // this
        // generates a hex as a model to generate the rest of the board hexes from

        // since i needed to call super() before determining any of the hex's  values
        hexRadius = modelHex.getLayoutBounds().getHeight() / 2; // this makes
        // the circumradius which is half the height (of a pointy top hexagon)
        inRadius = modelHex.getLayoutBounds().getWidth() / 2; // this makes the
        // inRadius which is roughly the circumradius * (sqrt(3)/2) but 1/2*getwidth is the same and it's prettier   
        boardPane = new Pane(); // creates new board for boardpane
        numberPane = new Pane();
        numberPane.setRotate(30);
        transHexPane = new Pane(); //assists in mouse over events
        vertexPane = new Pane(); // creates new board for vertexpane

        centerX = (float) (boardPane.getWidth() / 2); // assigns the center of
        // the pane a value
        centerY = (float) (boardPane.getHeight() / 2);

        hexList = new ArrayList<>(); // initializes the hex,vertex, and edge
        // lists
        transHexList = new ArrayList<>();
        vertexList = new ArrayList<>();
        edgeList = new ArrayList<>();
        boardShell = new StackPane(); // creates the stackpane for boardshell
        makeBoard(); // generates a board of hexes using random distribution of
        // terrain (does not assign dice values yet)

//saveBoard();
        makeVertices(); // generates a set of verticies based on the hexes and vertexList
        makeEdges(); // generates a set of edges based on the hexes, vertexList and edgeList
        addAdjacentEdges();


        vertexPane.setPickOnBounds(false); // sets property to false so that the circle (vertex point) is selectable and the bounding shape around it is not
        edgePane.setPickOnBounds(false);   // || same for the edges

        for (int i = 0; i < numberPane.getChildren().size(); i++) {
            System.out.println(numberPane.getChildren().get(i));
        }

        spriteImageView.setTranslateX(60.0);
        spriteImageView.setTranslateY(-35.0);
        spriteImage = new Image(getClass().getResourceAsStream("graphics/Tornado.png"));
        final ImageView spriteImageView = new ImageView(spriteImage);
        spriteImageView.setViewport(new Rectangle2D(SPRITE_OFFSET_X, SPRITE_OFFSET_Y, SPRITE_WIDTH, SPRITE_HEIGHT));
        spriteImageView.setRotate(270);
        spriteImageView.setFitHeight(50);
        spriteImageView.setFitWidth(50);
        //CHECK THIS OUT SOON
        final Animation animation = new SpriteAnimation(spriteImageView, Duration.millis(500), SPRITE_COUNT,
                SPRITE_COLUMNS, SPRITE_OFFSET_X, SPRITE_OFFSET_Y, SPRITE_WIDTH, SPRITE_HEIGHT);
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        marsPane = Graphics.getGraphicsPane();
        marsPane.setLayoutY(1800);
        
        boardShell.getChildren().addAll(marsPane, boardPane, numberPane, transHexPane, spriteImageView, edgePane,
                vertexPane); // adds

    }

    private void makeBoard() { // makes the board with the hexes,
        int hexCounter = 0; // hexCounter keeps track of which hex is being generated

        Hex h; // a model hex to build the rest on
        Hex transH; 

        double hexStartingPointY = 0; // the hex tarting point, to determine the
        // verticies of the hex
        // MAKE number tokens
        for (int j = 0; j < temp.length; j++) { // adding the diceNumber values
            // and the terrain types to
            // stacks for distribution
            tokenStack.push(temp[j]);
            terrainStack.push(possibleTerrainTypes[j]);
        }
        //if there was no board loaded
        Collections.shuffle(tokenStack); // shuffle the stacks for randomness of the hex tokens
        Collections.shuffle(terrainStack);  // do the same with the terrain types
        
        //GENERATE THE HEXES
        for (int i = 0; i < numberOfRows; i++) {
            if (i > 0) {
                h = (Hex) boardPane.getChildren().get(hexCounter - 1);
                transH = (Hex) transHexPane.getChildren().get(hexCounter - 1);

                hexStartingPointY = h.getPoints().get(5) + hexRadius;
            } else {
                hexStartingPointY = 200 + ((inRadius / 2) + hexRadius) * i;
            }
            for (int j = 0; j < columnMax; j++) {

                Color hexColor;                                                 // Declare the variable for the color of each hex
                

                hexColor = colorPalette[(int) terrainStack.peek()];             // get the color based on the type of terrain the hex
                                                                                // will be the center hex is the "desert hex"
                                                                                
                if (i == 2 && j == 2) {                                         
                    h = new Hex(hexCounter, 200 + (inRadius * (maxColumns - columnMax)) + (inRadius * j * 2),
                            hexStartingPointY, hexRadius, inRadius, Color.BLACK, 0, 5);
                    transH = new Hex(hexCounter, 200 + (inRadius * (maxColumns - columnMax)) + (inRadius * j * 2),
                            hexStartingPointY, hexRadius, inRadius, Color.TRANSPARENT);

                } else {
                    h = new Hex(hexCounter, 200 + (inRadius * (maxColumns - columnMax)) + (inRadius * j * 2),
                            hexStartingPointY, hexRadius, inRadius, hexColor, (int) tokenStack.pop(),
                            (int) terrainStack.pop());

                    transH = new Hex(hexCounter, 200 + (inRadius * (maxColumns - columnMax)) + (inRadius * j * 2),
                            hexStartingPointY, hexRadius, inRadius, Color.TRANSPARENT);

                    HexToken hexToken=new HexToken(h.getTokenValue(),inRadius,maxColumns,columnMax,j,hexStartingPointY);
                    numberPane.getChildren().addAll(hexToken.circle, hexToken.t1);
                    numberPane.setRotate(0);

                }

                hexCounter++;
//end if section
                boardPane.getChildren().add(h);

                transHexPane.getChildren().add(transH);

                hexList.add(h);
                transHexList.add(transH);

            }
            if (i < 2) {

                columnMax++;
            } else {
                columnMax--;
            }
        }

        for (Hex h2 : transHexList) {
            h2.setOnMouseEntered(e -> {
                if (GameScreenController.getGameState() == GameScreenController.MOVING_ROBBER) {
                    h2.setFill(Color.rgb(0, 0, 0, 0.3));
                }
            });

            h2.setOnMouseExited(e -> {
                if (GameScreenController.getGameState() == GameScreenController.MOVING_ROBBER) {
                    h2.setFill(Color.TRANSPARENT);
                }
            });
        }

    }

    private void makeVertices() { // makes the vertices for the board

        Double[] points; // declare an array for the points for the vertices
        // these are simply two different types of forEach loops

        for (Hex h : hexList) {
            int j = 0;

            for (int i = 0; i < h.getPoints().size(); i = i + 2) {
                Point2D p = new Point2D(h.getPoints().get(i), h.getPoints().get(i + 1));
                HexVertex hV = new HexVertex(p, h);
                h.addVertex(hV);
                // hV.setFill(colorPalette[j]);
                // j++;
                ((Circle) (hV)).setOnMouseEntered(e -> {
                    hV.setFill(Color.RED);
                });
                ((Circle) (hV)).setOnMouseExited(e -> {

                    hV.setFill(Color.TRANSPARENT);

                });

                //
                // hV.setFill(Color.TRANSPARENT);
                // if (hV.equals(hV2))neSystem.out.println(" the two hex's are
                // equal");
                // check if vertexList contains the vertex already
                // check item
                // System.out.println(vertexList.contains(hV));
                boolean inList = vertexList.contains(hV);

                // System.out.println("check 0");
                if (inList) {
                    // System.out.println(hV + " already exists");
                    vertexList.get(vertexList.indexOf(hV)).addAdjacentHex(h);

                } else {
                    // System.out.println("adding vertex: " + hV + "\n");
                    vertexList.add(hV);
                    // vertexPane.getChildren().add(new
                    // Circle(hV.position.getX(),hV.position.getX(),5,Color.BLACK));
                    // System.out.println(vertexPane);

                    // Circle c= new Circle(hV.position.getX(),
                    // hV.position.getY(),5,Color.BLACK);
                    // System.out.println(c);
                    vertexPane.getChildren().add(hV);

                }

            }
            // boardPane.getChildren().add(vertexPane);

        }
        // System.out.println("Verticies: ");
        // System.out.print(vertexList);
        // System.out.println("Hex List: ");
        // System.out.println(hexList);

    }

    private void makeEdges() {
        edgePane = new Pane();

        ObservableList points;
        for (Hex h : hexList) {

            points = h.getPoints();
            int p3, p4;
            int j = 0;
            // for (int i=0; i< points.size(); i=i+2){
            for (int i = 0; i < points.size(); i = i + 2) {
                p3 = i + 2;
                p4 = i + 3;
                /*
				 * ((Circle) (hV)).setOnMouseEntered(e ->{
				 * hV.setFill(Color.RED); }); /* ((Circle)
				 * (hV)).setOnMouseExited(e ->{ hV.setFill(Color.TRANSPARENT);
                 */

                if (i >= 10) {
                    p3 = 0;
                    p4 = 1;
                }

                HexEdge hE = new HexEdge(new Point2D((double) points.get(i), (double) points.get(i + 1)),
                        new Point2D((double) points.get(p3), (double) points.get(p4)));

                ((Line) (hE)).setOnMouseEntered(e -> {
                    hE.setStroke(Color.BLACK);
                });
                ((Line) (hE)).setOnMouseExited(e -> {
                    hE.setStroke(Color.TRANSPARENT);
                });
                // hE.setStroke(colorPalette[j]);

                // j++;
                h.addEdge(hE);

                //
                // hV.setFill(Color.TRANSPARENT);
                // if (hV.equals(hV2))neSystem.out.println(" the two hex's are
                // equal");
                // check if vertexList contains the vertex already
                // check item
                boolean inList = edgeList.contains(hE);

                // System.out.println("check 0");
                if (inList) {
                    // System.out.println(hE + " already exists");
                    edgeList.get(edgeList.indexOf(hE)).addHex(h);

                } else {
                    edgeList.add(hE);

                    // Circle c= new Circle(hV.position.getX(),
                    // hV.position.getY(),5,Color.BLACK);
                    // System.out.println(c);
                    edgePane.getChildren().add(hE);

                }

            }

        }
        int hexCounter = 0;
        for (Hex hex : hexList) {
            int vertexCounter = 0;
            System.out.println("[\t\t\t\t\t" + hexCounter + "\t\t\t\t\t]");
            for (HexVertex vertex : hex.getVerticies()) {
                System.out.print(vertexCounter + "\t\t");
                System.out.print(vertex + "\n");
                System.out.println("it's in the list on at index: " + vertexList.indexOf(vertex));
                System.out
                        .println("BEFORE ASSN: " + ((boolean) (vertex == vertexList.get(vertexList.indexOf(vertex)))));
                vertex = vertexList.get(vertexList.indexOf(vertex));
                System.out.println("AFTER ASSN: " + ((boolean) (vertex == vertexList.get(vertexList.indexOf(vertex)))));

                vertexCounter++;
            }
            hexCounter++;
        }
    }

    public Pane getBoardPane() {
        return boardShell;

    }

    private void addAdjacentEdges() {
        for (HexVertex h : vertexList) {
            ArrayList<Hex> hexes = new ArrayList<>();
            for (Hex hex : hexList) {
                if (hex.getVerticies().contains(h)) {
                    int vertexIndex, vertexIndexNext, vertexIndexPrev;
                    vertexIndex = hex.getVerticies().indexOf(h);
                    /*
					 * if(vertexIndex+1>5){ vertexIndexNext=0; }else{
					 * vertexIndexNext=vertexIndex+1; }
                     */
                    if (vertexIndex - 1 < 0) {
                        vertexIndexPrev = 5;
                    } else {
                        vertexIndexPrev = vertexIndex - 1;
                    }
                    if (!h.getAdjacentEdge().contains(hex.getEdges().get(vertexIndex))) {
                        h.addAdjacentEdge(hex.getEdges().get(vertexIndex));
                    }
                    if (!h.getAdjacentEdge().contains(hex.getEdges().get(vertexIndexPrev))) {
                        h.addAdjacentEdge(hex.getEdges().get(vertexIndexPrev));
                    }
                }
            }

            // System.out.println(vertexList.indexOf(h) + ": " + h + "\n" +
            // h.getAdjacentEdge());
        }
        for (HexEdge h : edgeList) {
            // 1) hexEdge.AdjaentVertices
            HexVertex start, end;
            start = new HexVertex(h.getStartPoint());
            end = new HexVertex(h.getEndPoint());
            if (vertexList.contains(start)) {
                h.addAdjacentVertex(vertexList.get(vertexList.indexOf(start)));
                h.addStartVertex(vertexList.get(vertexList.indexOf(start)));
            }
            if (vertexList.contains(end)) {
                h.addAdjacentVertex(vertexList.get(vertexList.indexOf(end)));
                h.addEndVertex(vertexList.get(vertexList.indexOf(end)));
            }
            // now that adjacent vertices are attached, get the adjacent edges
            // from each

            for (HexVertex v : h.getAdjacentVertex()) {
                for (HexEdge edge : v.getAdjacentEdge()) {
                    if (!h.getAdjacentEdge().contains(edge)) {
                        if (edge != h) {
                            h.addAdjacentEdge(edge);
                        }
                    }
                }
            }

            /*
			 * for(Hex hex: hexList){ if(hex.getEdges().contains(h)){ int
			 * edgeIndex, edgeIndexNext, edgeIndexPrev;
			 * edgeIndex=hex.getEdges().indexOf(h);
             */
 /*
			 * if(edgeIndex+1>5){ edgeIndexNext=0; }else{
			 * edgeIndexNext=edgeIndex+1; } if(edgeIndex-1<0){ edgeIndexPrev=5;
			 * }else{ edgeIndexPrev=edgeIndex-1; }
             */
 /*
			 * if(!h.getAdjacentEdge().contains(hex.getEdges().get(edgeIndex))){
			 * h.addAdjacentEdge(hex.getEdges().get(edgeIndex)); }
             *//*
				 * if(!h.getAdjacentEdge().contains(hex.getEdges().get(
				 * edgeIndexPrev))){
				 * h.addAdjacentEdge(edgeList.get(edgeList.indexOf(hex.getEdges(
				 * ).get(edgeIndexPrev)))); }
				 * if(!h.getAdjacentEdge().contains(hex.getEdges().get(
				 * edgeIndexNext))){
				 * h.addAdjacentEdge(edgeList.get(edgeList.indexOf(hex.getEdges(
				 * ).get(edgeIndexNext))));
				 * System.out.println(edgeIndexPrev+" "+edgeIndex+" "
				 * +edgeIndexNext+" ");
             */
            // }
            // }
            // }

            /*
			 * System.out.println(vertexList.indexOf(h)+": " +h+"\n"
			 * +h.getAdjacentEdge());
             */
        }

    }

    private void addAdjacentHexes() {

    }

}
