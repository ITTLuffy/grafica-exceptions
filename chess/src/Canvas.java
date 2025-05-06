import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Canvas extends JPanel {

    private int dim_cella = 80;
    private int w_h = 640;
    private int margin_top_bottom = 60;
    private int margin_right_left = 10;
    private BufferedImage w_pawn;
    private BufferedImage b_pawn;
    private BufferedImage w_king;
    private BufferedImage b_king;
    private BufferedImage w_queen;
    private BufferedImage b_queen;
    private BufferedImage w_rook;
    private BufferedImage b_rook;
    private BufferedImage w_bishop;
    private BufferedImage b_bishop;
    private BufferedImage w_knight;
    private BufferedImage b_knight;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // celle
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

                // coordinate con margini
                int x = margin_right_left + col * dim_cella;
                int y = margin_top_bottom + row * dim_cella;

                // colori alternati
                if ((row + col) % 2 == 0) {
                    g.setColor(new Color(240, 217, 181));
                } else {
                    g.setColor(new Color(118, 150, 86));
                }

                // riempio la cella
                g.fillRect(x, y, dim_cella, dim_cella);

                // pezzi neri

                if (row == 1) {
                    try {
                        b_pawn = ImageIO.read(getClass().getResourceAsStream("chess/images/Chess_pdt45.svg.png"));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    
                    g.drawImage(b_pawn, x + margin_right_left / 3, y, 72, 72, this);
                }

                if (row == 0 && col == 0 || row == 0 && col == 7) {
                    try {
                        b_rook = ImageIO.read(getClass().getResourceAsStream("chess/images/Chess_rdt45.svg.png"));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    g.drawImage(b_rook, x + margin_right_left / 3, y, 72, 72, this);
                }

                if (row == 0 && col == 1 || row == 0 && col == 6) {
                    try {
                        b_knight = ImageIO.read(getClass().getResourceAsStream("chess/images/Chess_ndt45.svg.png"));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    g.drawImage(b_knight, x + margin_right_left / 3, y, 72, 72, this);
                }

                if (row == 0 && col == 2 || row == 0 && col == 5) {
                    try {
                        b_bishop = ImageIO.read(getClass().getResourceAsStream("chess/images/Chess_bdt45.svg.png"));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    g.drawImage(b_bishop, x + margin_right_left / 3, y, 72, 72, this);
                }

                if (row == 0 && col == 3) {
                    try {
                        b_queen = ImageIO.read(getClass().getResourceAsStream("chess/images/Chess_qdt45.svg.png"));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    g.drawImage(b_queen, x + margin_right_left / 3, y, 72, 72, this);
                }

                if (row == 0 && col == 4) {
                    try {
                        b_king = ImageIO.read(getClass().getResourceAsStream("chess/images/Chess_kdt45.svg.png"));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    g.drawImage(b_king, x + margin_right_left / 3, y, 72, 72, this);
                }

                if (row == 6) {
                    try {
                        w_pawn = ImageIO.read(getClass().getResourceAsStream("chess/images/Chess_plt45.svg.png"));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    g.drawImage(w_pawn, x + margin_right_left / 3, y, 72, 72, this);
                }

                if (row == 7 && col == 0 || row == 7 && col == 7) {
                    try {
                        w_rook = ImageIO.read(getClass().getResourceAsStream("chess/images/Chess_rlt45.svg.png"));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    g.drawImage(w_rook, x + margin_right_left / 3, y, 72, 72, this);
                }

                if (row == 7 && col == 1 || row == 7 && col == 6) {
                    try {
                        w_knight = ImageIO.read(getClass().getResourceAsStream("chess/images/Chess_nlt45.svg.png"));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    g.drawImage(w_knight, x + margin_right_left / 3, y, 72, 72, this);
                }

                if (row == 7 && col == 2 || row == 7 && col == 5) {
                    try {
                        w_bishop = ImageIO.read(getClass().getResourceAsStream("chess/images/Chess_blt45.svg.png"));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    g.drawImage(w_bishop, x + margin_right_left / 3, y, 72, 72, this);
                }

                if (row == 7 && col == 3) {
                    try {
                        w_queen = ImageIO.read(getClass().getResourceAsStream("chess/images/Chess_qlt45.svg.png"));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    g.drawImage(w_queen, x + margin_right_left / 3, y, 72, 72, this);
                }

                if (row == 7 && col == 4) {
                    try {
                        w_king = ImageIO.read(getClass().getResourceAsStream("chess/images/Chess_klt45.svg.png"));
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }

                    g.drawImage(w_king, x + margin_right_left / 3, y, 72, 72, this);
                }
            }
        }

    }

}
