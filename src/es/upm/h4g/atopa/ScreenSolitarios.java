package es.upm.h4g.atopa;

import javax.swing.*;


import es.upm.h4g.atopa.Graph;
import es.upm.h4g.atopa.Link;
import es.upm.h4g.atopa.Node;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Console: graph drawing, algorithm commands, and algorithm results.
 *
 * @author jam
 * @version 28.12.2017
 */
public class ScreenSolitarios extends MouseAdapter implements ActionListener {
    private static final int NODE_RADIUS = 20;
    private final Font font = new Font("sans-serif", Font.PLAIN, 12);

    private final Graph graph;

    private final JPanel panel;
    private final JTextArea textArea;
    private final ArrayList<Thing> thingList = new ArrayList<>();
    /*private final JButton dijkstraButton;
    private final JButton bfsButton;
    private final JButton ekButton;*/
    private final int minx;
    private final int miny;
    
    private final int preocupante = 1;
    private final int aviso = 3;
    private final int popular, salvajementePopular;
    private final int nAlumnos;
    
    private Node selNode0;
    private Node selNode1;

    /**
     * Constructor.
     *
     * @param title the name of the frame.
     * @param minx  minimum x position in pixels.
     * @param maxx  minimum x position in pixels.
     * @param miny  minimum y position in pixels.
     * @param maxy  maximum y position in pixels.
     * @param graph graph to show.
     */
    public ScreenSolitarios(String title, int minx, int maxx, int miny, int maxy, Graph graph) {
        this.minx = minx;
        this.miny = miny;
        
        nAlumnos = graph.getAlumnos().size();
        popular = (int)0.3*nAlumnos;
        salvajementePopular = (int)0.5*nAlumnos;

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.graph = graph;
        for (Link link : graph.getLinks()) {
            Node src = link.getSrc();
            Node dst = link.getDst();
            if (src == null || dst == null)
                continue;
            add(new ThingLink(src, dst, link.getWeight()));
        }
        for (Node node : graph.getNodes())
            add(new ThingNode(node));

        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        
        //@Todo 
        /*
        dijkstraButton = new JButton("Dijkstra");
        dijkstraButton.addActionListener(this);
        toolBar.add(dijkstraButton);

        bfsButton = new JButton("BFS");
        bfsButton.addActionListener(this);
        toolBar.add(bfsButton);

        ekButton = new JButton("Edmonds–Karp");
        ekButton.addActionListener(this);
        toolBar.add(ekButton);
        */
        frame.getContentPane().add(toolBar, BorderLayout.NORTH);

        panel = new MyJPanel();
        int width = maxx - minx;
        int height = maxy - miny;
        panel.setPreferredSize(new Dimension(width, height));
        panel.addMouseListener(this);
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        textArea = new JTextArea(00, 100);
        frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
    }

    private void add(Thing thing) {
        synchronized (thingList) {
            thingList.add(thing);
        }
    }

    private void remove(Thing thing) {
        synchronized (thingList) {
            thingList.remove(thing);
        }
    }

    /**
     * When mouse is clicked.
     *
     * @param e mouse event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Node node = getNode(e.getX() + minx, e.getY() + miny);
        if (node != selNode1) {
            selNode0 = selNode1;
            selNode1 = node;
            panel.repaint();
        }
    }

    private Node getNode(int x, int y) {
        for (Node node : graph.getNodes()) {
            int dx = Math.abs(x - node.getX());
            int dy = Math.abs(y - node.getY());
            if (dx < NODE_RADIUS && dy < NODE_RADIUS)
                return node;
        }
        return null;
    }

    /**
     * When an element is clicked.
     *
     * @param e action event.
     * Aqui se muestra como hacer algo cuando se pulsan los botones
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
    	/*Object component = e.getSource();
        if (component == dijkstraButton);
            //execDijkstra();
        if (component == bfsButton)
            execBFS();
        if (component == ekButton);
            //execEK();*/
    }

    

    private interface Thing {
        void paint(Graphics2D g);
    }

    private class ThingNode implements Thing {
        private final Node node;

        private ThingNode(Node node) {
            this.node = node;
        }

        /* (non-Javadoc)
         * @see es.upm.h4g.atopa.Screen.Thing#paint(java.awt.Graphics2D)
         * 
         * //Aqui hay que definir los colores con que condiciones
         * Se decide todo, lo que se imprime y todo
         */
        
        @Override
        
        public void paint(Graphics2D g) {
            Color body = Color.WHITE;
            System.out.println(graph.getLinksDestino(node, graph.getLmSolitarios()).size());
            if (graph.getLinksDestino(node, graph.getLmSolitarios()).size() <= preocupante) body = Color.RED;
            else if (graph.getLinksDestino(node, graph.getLmSolitarios()).size() <= aviso) body = Color.YELLOW;
            
            else if (graph.getLinksDestino(node, graph.getLmSolitarios()).size() >= salvajementePopular ) body = Color.BLUE;
            else if (graph.getLinksDestino(node, graph.getLmSolitarios()).size() >= popular) body = Color.GREEN;
            
            g.setColor(body);
            int x = node.getX() - minx;
            int y = node.getY() - miny;
            int r = NODE_RADIUS;
            g.fillOval(x - r, y - r, 2 * r, 2 * r);
            g.setColor(body);
            g.drawOval(x - r, y - r, 2 * r, 2 * r);
            drawText(g, x, y, node.getAlumno().getNombre());
        }
    }

    private class ThingLink implements Thing {
        private final Node src;
        private final Node dst;
        private final int weight;

        private ThingLink(Node src, Node dst, int weight) {
            this.src = src;
            this.dst = dst;
            this.weight = weight;
        }

        @Override
        public void paint(Graphics2D g) {
            g.setColor(Color.BLACK);

            int x1 = src.getX() - minx;
            int y1 = src.getY() - miny;
            int x2 = dst.getX() - minx;
            int y2 = dst.getY() - miny;

            // a line src to dst
            double alpha = Math.atan2(y2 - y1, x2 - x1);
            double d = getD(x1, y1, x2, y2);
            double t1x = x1 + (d - NODE_RADIUS) * Math.cos(alpha);
            double t1y = y1 + (d - NODE_RADIUS) * Math.sin(alpha);
            double t2x = x1 + (d + NODE_RADIUS) * Math.cos(alpha);
            double t2y = y1 + (d + NODE_RADIUS) * Math.sin(alpha);
            if (getD(x1, y1, t1x, t1y) < d)
                drawArrowLine(g, x1, y1, (int) t1x, (int) t1y, 4, 4);
            else
                drawArrowLine(g, x1, y1, (int) t2x, (int) t2y, 4, 4);

            /*
            int mx = (x1 + x2) / 2;
            int my = (y1 + y2) / 2;
            g.setColor(Color.BLACK);
            drawText(g, mx, my, "" + weight);
            */
        }
    }

    private double getD(double x1, double y1, double x2, double y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * @param g  the graphics component.
     * @param x1 x-position of first point.
     * @param y1 y-position of first point.
     * @param x2 x-position of second point.
     * @param y2 y-position of second point.
     * @param d  the width of the arrow.
     * @param h  the height of the arrow.
     * @see <a href="https://stackoverflow.com/questions/2027613/how-to-draw-a-directed-arrow-line-in-java" />
     * <p>
     * Draw an arrow line between two points.
     */
    private void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h) {
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx * dx + dy * dy);
        double xm = D - d, xn = xm, ym = h, yn = -h, x;
        double sin = dy / D, cos = dx / D;

        x = xm * cos - ym * sin + x1;
        ym = xm * sin + ym * cos + y1;
        xm = x;

        x = xn * cos - yn * sin + x1;
        yn = xn * sin + yn * cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};

        g.drawLine(x1, y1, x2, y2);
        g.fillPolygon(xpoints, ypoints, 3);
    }

    private void drawText(Graphics2D g, int x, int y, String text) {
        FontMetrics metrics = g.getFontMetrics(font);
        int nwx = x - metrics.stringWidth(text) / 2;
        int nwy = y - metrics.getHeight() / 2 + metrics.getAscent();
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(text, nwx, nwy);
    }

    private class MyJPanel
            extends JPanel {
        @Override
        public void paint(Graphics g) {
            int width = panel.getWidth();
            int height = panel.getHeight();

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);

            synchronized (thingList) {
                for (Thing thing : thingList)
                    thing.paint((Graphics2D) g);
            }
        }
    }
}