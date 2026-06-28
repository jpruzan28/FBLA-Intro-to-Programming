package panels;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import pets.Pet;
import properties.*;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.*;

/**
 * SummaryPanel — Session recap screen.
 *
 * Visual style: matches the main game's soft dusty-rose palette and
 *               boxy, hand-drawn-cosy aesthetic.
 * Layout:       HORIZONTAL — no vertical scrolling.
 *               NORTH  : header banner (full width)
 *               CENTER : three equal columns — pet info | stats | receipt
 *               SOUTH  : toy strip + total footer
 *
 * Save this file as UTF-8 so the emoji/Unicode symbols render correctly.
 */
public class SummaryPanel extends JPanel {

    // =========================================================================
    // PALETTE  —  dusty rose base, warm browns, muted stat accents
    //             Designed to sit naturally beside the main game screen.
    // =========================================================================
    private static final Color BG_MAIN    = new Color(210, 168, 170); // rose  — page bg
    private static final Color BG_PANEL   = new Color(195, 152, 155); // deeper rose — header/footer
    private static final Color BG_CARD    = new Color(232, 205, 205); // light rose  — card surface
    private static final Color BG_CARD2   = new Color(220, 190, 192); // mid rose    — alt rows / toys strip
    private static final Color BG_FOOTER  = new Color(182, 138, 140); // dark rose   — footer bar

    private static final Color HEALTH_C   = new Color(175,  82,  82); // muted red
    private static final Color NUTRITION_C   = new Color(188, 132,  62); // muted amber
    private static final Color HYGIENE_C  = new Color( 78, 138, 182); // muted blue
    private static final Color REST_C     = new Color(135, 105, 182); // muted purple
    private static final Color BAR_TRACK  = new Color(175, 138, 140); // muted rose track

    private static final Color GOLD       = new Color(162, 125,  42); // warm muted gold
    private static final Color TXT_DARK   = new Color( 50,  32,  32); // near-black brown  — main text
    private static final Color TXT_MID    = new Color( 95,  62,  62); // medium brown      — labels
    private static final Color TXT_LIGHT  = new Color(135, 102, 102); // light brown       — hints
    private static final Color BORDER_C   = new Color(170, 126, 128); // rose border line
    private static final Color MATCH_Y    = new Color( 88, 138,  78); // muted green  — good match
    private static final Color MATCH_N    = new Color(170,  78,  78); // muted red    — no match
    private static final Color WARN_YELLOW = new Color(188, 150,  18); // amber-yellow — wrong type warning

    // =========================================================================
    // FONTS
    // =========================================================================
    private static final Font F_HERO  = new Font("Segoe UI", Font.BOLD,  24);
    private static final Font F_SUB   = new Font("Segoe UI", Font.PLAIN, 13);
    private static final Font F_SECT  = new Font("Segoe UI", Font.BOLD,  12);
    private static final Font F_BODY  = new Font("Segoe UI", Font.PLAIN, 13);
    private static final Font F_LBL   = new Font("Segoe UI", Font.BOLD,  12);
    private static final Font F_SMALL = new Font("Segoe UI", Font.PLAIN, 11);
    private static final Font F_NAME  = new Font("Segoe UI", Font.BOLD,  16);
    private static final Font F_EMOJI = new Font("Segoe UI", Font.PLAIN, 50);
    private static final Font F_COST  = new Font("Segoe UI", Font.BOLD,  20);

    private final Pet pet;

    public SummaryPanel(CardLayout cardLayout, JPanel cardPanel, Pet pet) {
        this.pet = pet;
        setLayout(new BorderLayout());
        setBackground(BG_MAIN);
    }

    // =========================================================================
    // PUBLIC ENTRY POINTS
    // =========================================================================

    /** Renders the full summary screen. Call when the game session ends. */
    public void setScreen() {
        removeAll();
        setBackground(BG_MAIN);

        // NORTH — slim header banner
        add(buildHeader(), BorderLayout.NORTH);

        // CENTER — three equal columns
        JPanel center = new JPanel(new GridLayout(1, 3, 10, 0));
        center.setOpaque(false);
        center.setBorder(BorderFactory.createEmptyBorder(12, 14, 10, 14));
        center.add(buildPetCard());
        center.add(buildStatsCard());
        center.add(buildReceiptCard());
        add(center, BorderLayout.CENTER);

        // SOUTH — toys strip + cost footer
        JPanel south = new JPanel(new BorderLayout());
        south.setOpaque(false);
        south.add(buildToysStrip(), BorderLayout.CENTER);
        south.add(buildFooter(),    BorderLayout.SOUTH);
        add(south, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }

    /** Alias kept for backward compatibility. */
    public void setScreen2() { setScreen(); }

    // =========================================================================
    // SECTION BUILDERS
    // =========================================================================

    /**
     * Full-width header strip — title on the left, mood status on the right.
     * Mimics the top stat-bar strip on the main game screen.
     */
    private JPanel buildHeader() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(BG_PANEL);
        p.setBorder(BorderFactory.createEmptyBorder(14, 20, 14, 20));

        JLabel title = lbl("Session Complete", F_HERO, TXT_DARK);
        JLabel sub   = lbl("Here's how " + pet.getName() + " did this session.", F_SUB, TXT_MID);

        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setOpaque(false);
        left.add(title);
        left.add(Box.createVerticalStrut(3));
        left.add(sub);

        // Right side: CSV and HTML export buttons stacked
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setOpaque(false);
        JButton csvBtn  = styledButton("Export as CSV",  e -> exportToCsv());
        JButton htmlBtn = styledButton("Export as HTML", e -> exportToHtml());
        csvBtn.setAlignmentX(Component.RIGHT_ALIGNMENT);
        htmlBtn.setAlignmentX(Component.RIGHT_ALIGNMENT);
        right.add(csvBtn);
        right.add(Box.createVerticalStrut(6));
        right.add(htmlBtn);

        p.add(left, BorderLayout.CENTER);
        p.add(right, BorderLayout.EAST);
        return p;
    }

    /**
     * Left column — pet portrait placeholder + owner / type / mood details.
     */
    private JPanel buildPetCard() {
        JPanel p = card();
        p.setLayout(new BorderLayout());
 
        p.add(sectionHeader("Your Pet"), BorderLayout.NORTH);
 
        // Portrait fills all remaining space — it scales up or down with the window
        JComponent portrait = buildPortrait();
        portrait.setOpaque(false);
        p.add(portrait, BorderLayout.CENTER);
 
        // Name + info always visible at the bottom, fixed height
        JPanel bottom = new JPanel();
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.Y_AXIS));
        bottom.setOpaque(false);
        bottom.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));
 
        JLabel nameLbl = lbl(pet.getName(), new Font("Segoe UI", Font.BOLD, 32), TXT_DARK);
        nameLbl.setAlignmentX(CENTER_ALIGNMENT);
        bottom.add(nameLbl);
        bottom.add(Box.createVerticalStrut(10));
 
        JPanel grid = new JPanel(new GridBagLayout());
        grid.setOpaque(false);
        grid.setAlignmentX(CENTER_ALIGNMENT);
 
        GridBagConstraints g = new GridBagConstraints();
        g.anchor = GridBagConstraints.WEST;
        g.insets = new Insets(8, 4, 8, 18);
 
        String[][] rows = {
            { "Owner",    pet.getOwner()                    },
            { "Pet Type", pet.getType()                     },
            { "Mood",     calculateEmotion(pet.getEmotion()) }
        };
        for (int i = 0; i < rows.length; i++) {
            g.gridx = 0; g.gridy = i;
            grid.add(lbl(rows[i][0] + ":", new Font("Segoe UI", Font.BOLD,  20), TXT_LIGHT), g);
            g.gridx = 1;
            grid.add(lbl(rows[i][1],        new Font("Segoe UI", Font.PLAIN, 20), TXT_DARK),  g);
        }
        bottom.add(grid);
 
        p.add(bottom, BorderLayout.SOUTH);
        return p;
    }

    /**
     * Middle column — four stat progress bars: health, nutrition, hygiene, rest.
     * Bar style (slightly rounded rectangles) echoes the main game's stat bars.
     */
    private JPanel buildStatsCard() {
        JPanel p = card();
        p.setLayout(new BorderLayout());

        p.add(sectionHeader("Vital Stats"), BorderLayout.NORTH);

        JPanel bars = new JPanel();
        bars.setLayout(new BoxLayout(bars, BoxLayout.Y_AXIS));
        bars.setOpaque(false);
        bars.setBorder(BorderFactory.createEmptyBorder(6, 2, 6, 2));

        // Vertical glue between every bar spreads them evenly across the full card height.
        bars.add(Box.createVerticalGlue());
        bars.add(statBar("Health",  pet.getHealth(),  10, HEALTH_C));
        bars.add(Box.createVerticalGlue());
        bars.add(statBar("Nutrition",  pet.getNutrition(),  10, NUTRITION_C));
        bars.add(Box.createVerticalGlue());
        bars.add(statBar("Hygiene", pet.getHygiene(), 10, HYGIENE_C));
        bars.add(Box.createVerticalGlue());
        bars.add(statBar("Rest",    pet.getRest(),    10, REST_C));
        bars.add(Box.createVerticalGlue());

        p.add(bars, BorderLayout.CENTER);
        return p;
    }

    /**
     * Right column — itemised purchase receipt table.
     * Cost column is rendered in warm gold.
     */
    private JPanel buildReceiptCard() {
        JPanel p = card();
        p.setLayout(new BorderLayout());

        p.add(sectionHeader("Purchases"), BorderLayout.NORTH);

        // Build rows
        Toy[]  toys  = pet.getToysArr();
        int    nToys = toys.length;
        int    nFood = pet.getFood().size();
        int    nVet  = pet.getVetVisits();
        int    n     = nToys + nFood + nVet;

        Object[][] data = new Object[n][3];
        int idx = 0;

        for (int t = 0; t < nToys; t++) {
            Toy toy = toys[t];
            if (toy != null) {
                data[idx][0] = toy.getName();
                data[idx][1] = toy.getType() + " Toy";
                data[idx][2] = "$" + toy.getPrice();
                idx++;
            }
        }
        for (int f = 0; f < nFood; f++) {
            Food food = pet.getFood().get(f);
            if (food != null) {
                data[idx][0] = food.getName();
                data[idx][1] = food.getType() + " Food";
                data[idx][2] = "$" + food.getPrice();
                idx++;
            }
        }
        for (int v = 0; v < nVet; v++) {
            data[idx][0] = "Vet Visit";
            data[idx][1] = "Medical";
            data[idx][2] = "$20";
            idx++;
        }

        String[] cols = { "Item", "Category", "Cost" };
        JTable table = styledTable(data, cols);
        table.setFillsViewportHeight(true); // table bg fills the viewport even when rows are few

        // Gold, right-aligned cost column
        table.getColumnModel().getColumn(2).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable t, Object val,
                    boolean sel, boolean foc, int row, int col) {
                JLabel c = (JLabel) super.getTableCellRendererComponent(
                        t, val, sel, foc, row, col);
                c.setHorizontalAlignment(SwingConstants.RIGHT);
                c.setForeground(sel ? TXT_DARK : GOLD);
                c.setFont(F_LBL);
                c.setBackground(sel ? new Color(185, 145, 145)
                                    : (row % 2 == 0 ? BG_CARD : BG_CARD2));
                c.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 8));
                return c;
            }
        });
        table.getColumnModel().getColumn(0).setPreferredWidth(112);
        table.getColumnModel().getColumn(2).setPreferredWidth(48);

        JScrollPane sp = tableScroll(table);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // Compound border: 10 px top gap (outer) + 1 px visible line (inner)
        sp.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(10, 0, 0, 0),
            BorderFactory.createLineBorder(BORDER_C, 1)
        ));
        p.add(sp, BorderLayout.CENTER);
        return p;
    }

    /**
     * Horizontal toy strip just above the footer.
     * Each toy appears as a small inline card showing name, type, and match status.
     */
    private JPanel buildToysStrip() {
        JPanel strip = new JPanel(new BorderLayout());
        strip.setBackground(BG_CARD2);
        strip.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, BORDER_C),
            BorderFactory.createEmptyBorder(10, 14, 10, 14)
        ));

        strip.add(sectionHeader("Toys"), BorderLayout.NORTH);

        JPanel flow = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 6));
        flow.setOpaque(false);

        Toy[] toys = pet.getToysArr();
        boolean anyToys = false;
        for (Toy toy : toys) {
            if (toy != null) {
                anyToys = true;
                flow.add(buildToyMiniCard(toy));
            }
        }
        if (!anyToys) {
            flow.add(lbl("No toys purchased this session.", F_BODY, TXT_LIGHT));
        }

        strip.add(flow, BorderLayout.CENTER);
        return strip;
    }

    /** One toy card used inside the toys strip — sized up to show all information clearly. */
    private JPanel buildToyMiniCard(Toy toy) {
        // Case-insensitive: pet type "dog" must match toy type "Dog"
        boolean match = toy.getType().equalsIgnoreCase(pet.getType());

        JPanel card = new JPanel();
        card.setBackground(BG_CARD);
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_C, 1),
            BorderFactory.createEmptyBorder(10, 18, 10, 18)
        ));

        JLabel tn = lbl(toy.getName(),
                        new Font("Segoe UI", Font.BOLD,  14), TXT_DARK);
        // Price and required pet type — amber-yellow when it's for a different pet type
        Color typeColor = match ? TXT_LIGHT : WARN_YELLOW;
        JLabel tt = lbl("$" + toy.getPrice() + "  -  " + toy.getType(),
                        new Font("Segoe UI", Font.PLAIN, 13), typeColor);
        // Plain text instead of checkmark/cross characters, which don't render in Segoe UI on Windows
        JLabel tm = lbl(match ? "Good match" : "No match",
                        new Font("Segoe UI", Font.BOLD,  13), match ? MATCH_Y : MATCH_N);

        tn.setAlignmentX(LEFT_ALIGNMENT);
        tt.setAlignmentX(LEFT_ALIGNMENT);
        tm.setAlignmentX(LEFT_ALIGNMENT);

        card.add(tn);
        card.add(Box.createVerticalStrut(4));
        card.add(tt);
        card.add(Box.createVerticalStrut(4));
        card.add(tm);
        return card;
    }

    /**
     * Full-width footer strip — session total cost.
     * Compact height; amount is near-black for maximum contrast against the rose background.
     */
    private JPanel buildFooter() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(BG_FOOTER);
        p.setBorder(BorderFactory.createEmptyBorder(10, 22, 10, 22));

        int total = 0;
        for (Toy toy   : pet.getToysArr()) { if (toy  != null) total += toy.getPrice();  }
        for (Food food : pet.getFood())    { if (food != null) total += food.getPrice(); }
        total += pet.getVetVisits() * 20;

        JLabel caption = lbl("Total Spent This Session", F_LBL, TXT_MID);
        // Near-black on a rose background — far higher contrast than gold
        JLabel amount  = lbl("$" + total, F_COST, TXT_DARK);
        amount.setHorizontalAlignment(SwingConstants.RIGHT);

        p.add(caption, BorderLayout.WEST);
        p.add(amount,  BorderLayout.EAST);
        return p;
    }

    // =========================================================================
    // COMPONENT FACTORIES
    // =========================================================================

    /**
     * Standard card panel: light-rose background, 1 px border, inner padding.
     * Call setLayout() immediately after to override the default FlowLayout.
     */
    private JPanel card() {
        JPanel p = new JPanel();
        p.setBackground(BG_CARD);
        p.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_C, 1),
            BorderFactory.createEmptyBorder(12, 14, 12, 14)
        ));
        return p;
    }

    /** Shorthand labelled JLabel with font and foreground. */
    private JLabel lbl(String text, Font font, Color color) {
        JLabel l = new JLabel(text);
        l.setFont(font);
        l.setForeground(color);
        return l;
    }

    /**
     * Section header: bold, medium-brown, with a 1 px underline + 6 px gap below.
     * Keeps visual hierarchy consistent across all three cards.
     */
    private JLabel sectionHeader(String text) {
        JLabel l = lbl(text, F_SECT, TXT_MID);
        l.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_C),
            BorderFactory.createEmptyBorder(0, 0, 8, 0)
        ));
        return l;
    }

    /**
     * One stat entry: name + "X / 10" on one line, full-width bar on the line below.
     *
     * The old single-row layout (label | bar | value) competed for horizontal space:
     * if the card was narrow, BorderLayout clipped the EAST value label first.
     * Stacking text above bar gives each piece its own full width, so the number
     * is always visible regardless of window size.
     */
    private JPanel statBar(String labelText, int value, int max, Color barColor) {
        JPanel outer = new JPanel();
        outer.setLayout(new BoxLayout(outer, BoxLayout.Y_AXIS));
        outer.setOpaque(false);
        outer.setAlignmentX(LEFT_ALIGNMENT);

        // Top row: stat name on the left, "X / 10" in bar colour on the right.
        // Both live inside a BorderLayout, so they share the full width with no clipping.
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);
        header.setAlignmentX(LEFT_ALIGNMENT);

        JLabel nameLbl = lbl(labelText, new Font("Segoe UI", Font.BOLD, 15), TXT_MID);
        JLabel valLbl  = lbl(value + " / 10", new Font("Segoe UI", Font.BOLD, 15), barColor);
        valLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        header.add(nameLbl, BorderLayout.WEST);
        header.add(valLbl,  BorderLayout.EAST);

        // Bar fills the full card width on its own line — no text competing for space.
        JPanel bar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                int w = getWidth(), h = getHeight(), arc = 6;
                g2.setColor(BAR_TRACK);
                g2.fill(new RoundRectangle2D.Float(0, 0, w, h, arc, arc));
                int fillW = (int) ((value / (double) max) * w);
                if (fillW > 0) {
                    g2.setColor(barColor);
                    g2.fill(new RoundRectangle2D.Float(0, 0,
                            Math.max(fillW, arc), h, arc, arc));
                }
                g2.dispose();
            }
        };
        bar.setOpaque(false);
        bar.setPreferredSize(new Dimension(0, 18));
        bar.setMaximumSize(new Dimension(Short.MAX_VALUE, 18)); // keeps height fixed, fills width
        bar.setAlignmentX(LEFT_ALIGNMENT);

        outer.add(header);
        outer.add(Box.createVerticalStrut(5));
        outer.add(bar);
        return outer;
    }

    /**
     * Creates a styled JTable with rose-toned alternating rows,
     * a matching header, and no vertical grid lines.
     */
    private JTable styledTable(Object[][] data, String[] cols) {
        JTable t = new JTable(data, cols) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        t.setBackground(BG_CARD);
        t.setForeground(TXT_DARK);
        t.setFont(F_BODY);
        t.setRowHeight(42);
        t.setGridColor(BORDER_C);
        t.setSelectionBackground(new Color(185, 145, 145));
        t.setSelectionForeground(TXT_DARK);
        t.setShowVerticalLines(false);
        t.setIntercellSpacing(new Dimension(0, 1));

        JTableHeader header = t.getTableHeader();
        header.setBackground(BG_CARD2);
        header.setForeground(TXT_MID);
        header.setFont(F_LBL);
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_C));
        header.setReorderingAllowed(false);

        t.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tbl, Object val,
                    boolean sel, boolean foc, int row, int col) {
                JLabel c = (JLabel) super.getTableCellRendererComponent(
                        tbl, val, sel, foc, row, col);
                c.setFont(F_BODY);
                c.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 8));
                if (!sel) {
                    c.setBackground(row % 2 == 0 ? BG_CARD : BG_CARD2);
                    c.setForeground(TXT_DARK);
                }
                return c;
            }
        });
        return t;
    }

    /** Wraps a table in a scroll pane with matching rose-toned chrome. */
    private JScrollPane tableScroll(JTable table) {
        JScrollPane sp = new JScrollPane(table);
        sp.setBackground(BG_CARD);
        sp.getViewport().setBackground(BG_CARD);
        sp.setBorder(BorderFactory.createLineBorder(BORDER_C, 1));
        return sp;
    }

    // =========================================================================
    // HELPERS
    // =========================================================================

    /** Returns "Sad", "Content", or "Happy" for a given emotion score. */
    public String calculateEmotion(int emotion) {
        if (emotion <= 3) return "Sad";
        if (emotion >= 8) return "Happy";
        return "Content";
    }

    private String emotionString(int emotion) {
        if (emotion <= 3) return "\uD83D\uDE22  Feeling Sad";      // 😢
        if (emotion >= 8) return "\uD83D\uDE04  Feeling Happy!";   // 😄
        return             "\uD83D\uDE0A  Feeling Content";         // 😊
    }

    // =========================================================================
    // CSV EXPORT
    // =========================================================================

    /**
     * Tries to load the pet's own image via pet.getIcon().
     * If that method doesn't exist or the image can't be loaded, falls back
     * to a drawn circle showing the pet's initial — so the screen always looks complete.
     * Swap pet.getIcon() for whichever method your Pet class uses to expose its image path.
     */
    private JComponent buildPortrait() {
        // Try to load the pet's image
        try {
            Image img = new ImageIcon(pet.getIcon()).getImage();
            // Verify the image actually loaded (width > 0)
            if (img != null && img.getWidth(null) > 0) {
                JPanel imagePanel = new JPanel() {
                    @Override
                    protected void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        Graphics2D g2 = (Graphics2D) g.create();
                        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                                            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
                        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                            RenderingHints.VALUE_ANTIALIAS_ON);
                        int iw = img.getWidth(null), ih = img.getHeight(null);
                        // Scale to fit inside component bounds, preserving aspect ratio
                        double scale = Math.min(getWidth() / (double) iw,
                                                getHeight() / (double) ih);
                        int sw = (int) (iw * scale), sh = (int) (ih * scale);
                        g2.drawImage(img,
                                (getWidth()  - sw) / 2,
                                (getHeight() - sh) / 2,
                                sw, sh, null);
                        g2.dispose();
                    }
                };
                imagePanel.setOpaque(false);
                return imagePanel;
            }
        } catch (Exception ignored) {}
 
        // Fallback: circle with the pet's initial, scales automatically
        JPanel circle = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                    RenderingHints.VALUE_ANTIALIAS_ON);
                int d = Math.min(getWidth(), getHeight()) - 4;
                int x = (getWidth()  - d) / 2;
                int y = (getHeight() - d) / 2;
                g2.setColor(BG_PANEL);
                g2.fillOval(x, y, d, d);
                String initial = pet.getName().isEmpty() ? "?"
                        : String.valueOf(pet.getName().charAt(0)).toUpperCase();
                g2.setFont(new Font("Segoe UI", Font.BOLD, Math.max(d / 2, 1)));
                FontMetrics fm = g2.getFontMetrics();
                g2.setColor(TXT_MID);
                g2.drawString(initial,
                        x + (d - fm.stringWidth(initial)) / 2,
                        y + (d - fm.getHeight()) / 2 + fm.getAscent());
                g2.dispose();
            }
        };
        circle.setOpaque(false);
        return circle;
    }

    /** Generic styled button matching the game's boxy button look. */
    private JButton styledButton(String text, java.awt.event.ActionListener action) {
        JButton btn = new JButton(text);
        btn.setFont(F_LBL);
        btn.setForeground(TXT_DARK);
        btn.setBackground(BG_CARD);
        btn.setFocusPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.addActionListener(action);
        return btn;
    }

    /**
     * Opens a save dialog and writes the full session summary to a CSV file.
     * The file is pre-named after the pet and gets a .csv extension if the
     * user forgets to type one.
     */
    private void exportToCsv() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save Session Summary");
        chooser.setSelectedFile(new File(pet.getName() + "_session.csv"));

        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;

        File file = chooser.getSelectedFile();
        if (!file.getName().toLowerCase().endsWith(".csv"))
            file = new File(file.getAbsolutePath() + ".csv");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            writeSessionCsv(bw);
            JOptionPane.showMessageDialog(this,
                "Saved to " + file.getName(),
                "Export Complete", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                "Could not save: " + ex.getMessage(),
                "Export Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Writes the complete session data into CSV sections:
     *   PET INFO → VITAL STATS → PURCHASES → TOYS → Total
     */
    private void writeSessionCsv(BufferedWriter bw) throws IOException {
        // ── Pet info ─────────────────────────────────────────────────────────
        bw.write("PET INFO");                                              bw.newLine();
        bw.write("Name,"    + csvField(pet.getName()));                    bw.newLine();
        bw.write("Owner,"   + csvField(pet.getOwner()));                   bw.newLine();
        bw.write("Type,"    + csvField(pet.getType()));                    bw.newLine();
        bw.write("Mood,"    + csvField(calculateEmotion(pet.getEmotion()))); bw.newLine();
        bw.newLine();

        // ── Vital stats ───────────────────────────────────────────────────────
        bw.write("VITAL STATS");                                           bw.newLine();
        bw.write("Stat,Score,Out Of");                                     bw.newLine();
        bw.write("Health,"  + pet.getHealth()  + ",10");                   bw.newLine();
        bw.write("Nutrition,"  + pet.getNutrition()  + ",10");             bw.newLine();
        bw.write("Hygiene," + pet.getHygiene() + ",10");                   bw.newLine();
        bw.write("Rest,"    + pet.getRest()    + ",10");                   bw.newLine();
        bw.newLine();

        // ── Purchases ─────────────────────────────────────────────────────────
        bw.write("PURCHASES");                                             bw.newLine();
        bw.write("Item,Category,Cost");                                    bw.newLine();
        Toy[] toys = pet.getToysArr();
        for (Toy toy : toys) {
            if (toy != null) {
                bw.write(csvField(toy.getName()) + ","
                       + csvField(toy.getType() + " Toy") + ",$" + toy.getPrice());
                bw.newLine();
            }
        }
        for (Food food : pet.getFood()) {
            if (food != null) {
                bw.write(csvField(food.getName()) + ","
                       + csvField(food.getType() + " Food") + ",$" + food.getPrice());
                bw.newLine();
            }
        }
        for (int v = 0; v < pet.getVetVisits(); v++) {
            bw.write("Vet Visit,Medical,$20");                             bw.newLine();
        }
        bw.newLine();

        // ── Toys ─────────────────────────────────────────────────────────────
        bw.write("TOYS");                                                  bw.newLine();
        bw.write("Name,Type,Good Match?");                                 bw.newLine();
        for (Toy toy : toys) {
            if (toy != null) {
                String match = toy.getType().equalsIgnoreCase(pet.getType()) ? "Yes" : "No";
                bw.write(csvField(toy.getName()) + "," + csvField(toy.getType()) + "," + match);
                bw.newLine();
            }
        }
        bw.newLine();

        // ── Total ─────────────────────────────────────────────────────────────
        int total = 0;
        for (Toy toy   : toys)           { if (toy  != null) total += toy.getPrice();  }
        for (Food food : pet.getFood())  { if (food != null) total += food.getPrice(); }
        total += pet.getVetVisits() * 20;
        bw.write("Total Spent,$" + total);                                 bw.newLine();
    }

    /**
     * Quotes a CSV field that contains commas, double-quotes, or newlines.
     * Internal double-quotes are escaped by doubling them (RFC 4180).
     */
    private String csvField(String value) {
        if (value == null) return "";
        if (value.contains(",") || value.contains("\"") || value.contains("\n"))
            return "\"" + value.replace("\"", "\"\"") + "\"";
        return value;
    }


    // =========================================================================
    // HTML EXPORT
    // =========================================================================

    /** Opens a save dialog and writes a self-contained HTML session report. */
    private void exportToHtml() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save Session as HTML");
        chooser.setSelectedFile(new File(pet.getName() + "_session.html"));
        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;
        File file = chooser.getSelectedFile();
        if (!file.getName().toLowerCase().endsWith(".html"))
            file = new File(file.getAbsolutePath() + ".html");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(buildHtmlString());
            JOptionPane.showMessageDialog(this, "Saved to " + file.getName(),
                    "Export Complete", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save: " + ex.getMessage(),
                    "Export Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    /** Builds the complete self-contained HTML document as a single String. */
    private String buildHtmlString() {
        Toy[]  toys  = pet.getToysArr();
        int    total = 0;
        for (Toy t  : toys)          { if (t != null) total += t.getPrice(); }
        for (Food f : pet.getFood()) { if (f != null) total += f.getPrice(); }
        total += pet.getVetVisits() * 20;

        StringBuilder sb = new StringBuilder();

        sb.append("<!DOCTYPE html>\n<html>\n<head>\n")
          .append("<meta charset='UTF-8'>\n")
          .append("<title>Session Summary - ").append(htmlEsc(pet.getName())).append("</title>\n")
          .append("<style>\n")
          .append("*{box-sizing:border-box;margin:0;padding:0}\n")
          .append("body{background:#C39599;font-family:'Segoe UI',sans-serif;padding:20px}\n")
          .append(".wrap{background:#D2A8AA;max-width:960px;margin:0 auto;border-radius:6px;overflow:hidden}\n")
          .append(".hdr{background:#C39599;padding:14px 20px;border-bottom:1px solid #AA7E80}\n")
          .append(".hdr h1{font-size:22px;font-weight:700;color:#321E1E}\n")
          .append(".hdr p{font-size:13px;color:#5F3E3E;margin-top:3px}\n")
          .append(".cols{display:grid;grid-template-columns:1fr 1fr 1fr;gap:10px;padding:12px 14px}\n")
          .append(".card{background:#E8CDCD;border:1px solid #AA7E80;padding:12px 14px}\n")
          .append(".ch{font-size:11px;font-weight:700;color:#5F3E3E;border-bottom:1px solid #AA7E80;padding-bottom:6px;margin-bottom:10px;letter-spacing:.06em;text-transform:uppercase}\n")
          .append(".pet-wrap{text-align:center;margin:10px 0 14px}\n")
          .append(".avatar{width:100px;height:100px;border-radius:50%;background:#C39599;display:inline-flex;align-items:center;justify-content:center;font-size:42px;font-weight:700;color:#5F3E3E}\n")
          .append(".pet-name{font-size:28px;font-weight:700;color:#321E1E;margin-top:8px}\n")
          .append(".info-tbl{width:100%;border-collapse:collapse;margin-top:8px}\n")
          .append(".info-tbl td{padding:7px 4px;font-size:18px}\n")
          .append(".ik{font-weight:700;color:#876666;padding-right:14px;white-space:nowrap}\n")
          .append(".iv{color:#321E1E}\n")
          .append(".se{margin-bottom:14px}\n")
          .append(".sh{display:flex;justify-content:space-between;margin-bottom:5px}\n")
          .append(".sn{font-size:15px;font-weight:700;color:#5F3E3E}\n")
          .append(".sv{font-size:15px;font-weight:700}\n")
          .append(".track{background:#AF8A8C;border-radius:5px;height:17px;overflow:hidden}\n")
          .append(".fill{height:100%;border-radius:5px}\n")
          .append(".ptbl{width:100%;border-collapse:collapse;margin-top:10px}\n")
          .append(".ptbl th{background:#DCC0C0;padding:7px 10px;font-size:11px;font-weight:700;color:#5F3E3E;text-align:left;border-bottom:1px solid #AA7E80}\n")
          .append(".ptbl td{padding:0 10px;height:42px;font-size:13px;color:#321E1E}\n")
          .append(".ptbl tr:nth-child(odd) td{background:#E8CDCD}\n")
          .append(".ptbl tr:nth-child(even) td{background:#DCC0C0}\n")
          .append(".cost{text-align:right;color:#A27D2A;font-weight:700}\n")
          .append(".dim{color:#876666}\n")
          .append(".toys{background:#DCC0C0;border-top:1px solid #AA7E80;padding:10px 14px}\n")
          .append(".toy-cards{display:flex;flex-wrap:wrap;gap:10px;margin-top:7px}\n")
          .append(".tc{background:#E8CDCD;border:1px solid #AA7E80;padding:10px 16px}\n")
          .append(".tn{font-size:14px;font-weight:700;color:#321E1E}\n")
          .append(".tok{font-size:13px;color:#876666;margin-top:3px}\n")
          .append(".twarn{font-size:13px;color:#BC9612;font-weight:600;margin-top:3px}\n")
          .append(".tmy{font-size:13px;font-weight:700;color:#587A4E;margin-top:3px}\n")
          .append(".tmn{font-size:13px;font-weight:700;color:#AA4E4E;margin-top:3px}\n")
          .append(".ftr{background:#B68A8C;padding:10px 20px;display:flex;justify-content:space-between;align-items:center;border-top:1px solid #AA7E80}\n")
          .append(".fl{font-size:11px;font-weight:700;color:#5F3E3E}\n")
          .append(".fa{font-size:20px;font-weight:700;color:#321E1E}\n")
          .append("</style>\n</head>\n<body>\n<div class='wrap'>\n");

        sb.append("<div class='hdr'><h1>Session Complete</h1>")
          .append("<p>Here's how ").append(htmlEsc(pet.getName())).append(" did this session.</p></div>\n");

        sb.append("<div class='cols'>\n");

        String initial = pet.getName().isEmpty() ? "?"
                : String.valueOf(pet.getName().charAt(0)).toUpperCase();
        sb.append("<div class='card'><div class='ch'>Your Pet</div>")
          .append("<div class='pet-wrap'>")
          .append("<div class='avatar'>").append(htmlEsc(initial)).append("</div>")
          .append("<div class='pet-name'>").append(htmlEsc(pet.getName())).append("</div></div>")
          .append("<table class='info-tbl'>")
          .append("<tr><td class='ik'>Owner:</td><td class='iv'>").append(htmlEsc(pet.getOwner())).append("</td></tr>")
          .append("<tr><td class='ik'>Pet Type:</td><td class='iv'>").append(htmlEsc(pet.getType())).append("</td></tr>")
          .append("<tr><td class='ik'>Mood:</td><td class='iv'>").append(htmlEsc(calculateEmotion(pet.getEmotion()))).append("</td></tr>")
          .append("</table></div>\n");

        sb.append("<div class='card'><div class='ch'>Vital Stats</div>");
        appendStatBar(sb, "Health",  pet.getHealth(),  "#AF5252");
        appendStatBar(sb, "Nutrition",  pet.getNutrition(),  "#BC843E");
        appendStatBar(sb, "Hygiene", pet.getHygiene(), "#4E8AB6");
        appendStatBar(sb, "Rest",    pet.getRest(),    "#8769B6");
        sb.append("</div>\n");

        sb.append("<div class='card'><div class='ch'>Purchases</div>")
          .append("<table class='ptbl'>")
          .append("<tr><th>Item</th><th>Category</th><th style='text-align:right'>Cost</th></tr>");
        for (Toy t : toys) {
            if (t != null)
                sb.append("<tr><td>").append(htmlEsc(t.getName()))
                  .append("</td><td class='dim'>").append(htmlEsc(t.getType()))
                  .append(" Toy</td><td class='cost'>$").append(t.getPrice()).append("</td></tr>");
        }
        for (Food f : pet.getFood()) {
            if (f != null)
                sb.append("<tr><td>").append(htmlEsc(f.getName()))
                  .append("</td><td class='dim'>").append(htmlEsc(f.getType()))
                  .append(" Food</td><td class='cost'>$").append(f.getPrice()).append("</td></tr>");
        }
        for (int v = 0; v < pet.getVetVisits(); v++)
            sb.append("<tr><td>Vet Visit</td><td class='dim'>Medical</td><td class='cost'>$20</td></tr>");
        sb.append("</table></div>\n</div>\n");

        sb.append("<div class='toys'>")
          .append("<div class='ch' style='border-bottom:1px solid #AA7E80;padding-bottom:6px'>Toys</div>")
          .append("<div class='toy-cards'>");
        boolean anyToys = false;
        for (Toy t : toys) {
            if (t == null) continue;
            anyToys = true;
            boolean match = t.getType().equalsIgnoreCase(pet.getType());
            sb.append("<div class='tc'>")
              .append("<div class='tn'>").append(htmlEsc(t.getName())).append("</div>")
              .append("<div class='").append(match ? "tok" : "twarn").append("'>$")
              .append(t.getPrice()).append("  -  ").append(htmlEsc(t.getType())).append("</div>")
              .append("<div class='").append(match ? "tmy" : "tmn").append("'>")
              .append(match ? "Good match" : "No match").append("</div></div>");
        }
        if (!anyToys)
            sb.append("<span style='font-size:13px;color:#876666'>No toys purchased this session.</span>");
        sb.append("</div></div>\n");

        sb.append("<div class='ftr'>")
          .append("<span class='fl'>Total Spent This Session</span>")
          .append("<span class='fa'>$").append(total).append("</span>")
          .append("</div>\n</div>\n</body>\n</html>");

        return sb.toString();
    }

    /** Appends a single stat bar block to the HTML output. */
    private void appendStatBar(StringBuilder sb, String label, int value, String color) {
        int pct = (int) ((value / 10.0) * 100);
        sb.append("<div class='se'><div class='sh'>")
          .append("<span class='sn'>").append(label).append("</span>")
          .append("<span class='sv' style='color:").append(color).append("'>")
          .append(value).append(" / 10</span></div>")
          .append("<div class='track'><div class='fill' style='width:").append(pct)
          .append("%;background:").append(color).append("'></div></div></div>");
    }

    /** Escapes characters with special meaning in HTML. */
    private String htmlEsc(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;")
                .replace(">", "&gt;").replace("\"", "&quot;");
    }
}