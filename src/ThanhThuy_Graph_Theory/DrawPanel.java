package AnhPhu_ThanhThuy;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Iterator;

import javax.swing.JPanel;

public

class DrawPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	boolean startUnDir = false;
	boolean startDir = false;
	final int unit = 3;
	Graph graph;
	Vertex selected1, selected2;
	int clickX, clickY, pressX, pressY, dx, dy, midX, midY;
	String trongso = null;
	final int bankinh = 15;

	Line2D line2d;

	int vertexAmount;

	DrawPanel() {
		graph = new Graph();
		vertexAmount = graph.getMtk().size();

		// FOR PANEL
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		setCursor(cursor);
		setBackground(Color.white);
		setPreferredSize(new Dimension(700, 3));
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}

	public int getVertexAmount() {
		return vertexAmount;
	}

	public void setVertexAmount(int vertexAmount) {
		this.vertexAmount = vertexAmount;
	}

	MouseAdapter mouse = new MouseAdapter() {
		public void mousePressed(MouseEvent e) {
			for (int i = graph.danhSachDinh.size() - 1; i > -1; i--) {
				if (graph.danhSachDinh.get(i).el.contains(e.getX(), e.getY())) {
					pressX = e.getX();
					pressY = e.getY();
					return;
				}
			}
		}

		public void mouseDragged(MouseEvent e) {
			for (int i = graph.danhSachDinh.size() - 1; i > -1; i--) {
				dx = e.getX() - pressX;
				dy = e.getY() - pressY;
				Vertex v1 = graph.danhSachDinh.get(i);
				if (v1.el.contains(pressX, pressY)) {
					Ellipse2D v1Ellipse2d = new Ellipse2D.Double(v1.el.getX() + dx, v1.el.getY() + dy, 30, 30);
					graph.resetEl(v1Ellipse2d, i);
					for (int j = 0; j < graph.danhSachCanh.size(); j++) {
						Edge edge = graph.danhSachCanh.get(j);
						if (edge.diemdau1.el == v1.el) {
							line2d = new Line2D.Double(v1.el.getCenterX(), v1.el.getCenterY(),
									edge.diemdau2.el.getCenterX(), edge.diemdau2.el.getCenterY());
							midX = (int) ((v1Ellipse2d.getCenterX() + edge.diemdau2.el.getCenterX()) / 2 + 10);
							midY = (int) ((v1Ellipse2d.getCenterY() + edge.diemdau2.el.getCenterY()) / 2 + 10);

							graph.resetEdge(line2d, j, midX, midY);

						} else if (edge.diemdau2.el == v1.el) {
							line2d = new Line2D.Double(edge.diemdau1.el.getCenterX(), edge.diemdau1.el.getCenterY(),
									v1.el.getCenterX(), v1.el.getCenterY());
							midX = (int) ((edge.diemdau1.el.getCenterX() + v1Ellipse2d.getCenterX()) / 2 + 10);
							midY = (int) ((edge.diemdau1.el.getCenterY() + v1Ellipse2d.getCenterY()) / 2 + 10);
							graph.resetEdge(line2d, j, midX, midY);

						}
					}
					pressX += dx;
					pressY += dy;

				}
				repaint();
			}

			repaint();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			clickX = e.getX();
			clickY = e.getY();

			if (startDir) {

				// add edge co huong
				for (int i = 0; i < graph.danhSachDinh.size(); i++) {
					if (graph.danhSachDinh.get(i).el.contains(clickX, clickY)) {

						if (selected1 == null) {
							selected1 = graph.danhSachDinh.get(i);
							return;
						} else {
							if (selected1 != null && selected1 != graph.danhSachDinh.get(i)) {
								selected2 = graph.danhSachDinh.get(i);

								line2d = new Line2D.Double(selected1.el.getCenterX(), selected1.el.getCenterY(),
										selected2.el.getCenterX(), selected2.el.getCenterY());
								graph.themCanhCoHuong(selected1, selected2, line2d, trongso);

								selected1 = null;
								selected2 = null;
							}
							return;
						}
					}
					repaint();
				}

				Ellipse2D el = new Ellipse2D.Double(clickX, clickY, 30, 30);
				graph.themDinh(el);
				repaint();

			}
			if (startUnDir) {

				// add edge vo huong
				for (int i = 0; i < graph.danhSachDinh.size(); i++) {
					if (graph.danhSachDinh.get(i).el.contains(clickX, clickY)) {

						if (selected1 == null) {
							selected1 = graph.danhSachDinh.get(i);
							return;
						} else {
							if (selected1 != null && selected1 != graph.danhSachDinh.get(i)) {
								selected2 = graph.danhSachDinh.get(i);

								line2d = new Line2D.Double(selected1.el.getCenterX(), selected1.el.getCenterY(),
										selected2.el.getCenterX(), selected2.el.getCenterY());
								graph.themCanhVoHuong(selected1, selected2, line2d, trongso);

								selected1 = null;
								selected2 = null;
							}
							return;
						}
					}
					repaint();
				}

				Ellipse2D el = new Ellipse2D.Double(clickX, clickY, 30, 30);
				graph.themDinh(el);
				repaint();

			}
		}
	};

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		if (startUnDir || startDir) {
			
			for (Vertex vertex : graph.danhSachDinh) {
				vertex.ten = vertex.index + 1;
				g2.setColor(Color.blue);
				g2.fill(vertex.el);
				g2.setColor(Color.WHITE);
				g2.setFont(new Font("Arial", Font.BOLD, 10));
				g2.drawString("" + vertex.ten, (int) vertex.el.getCenterX() - unit,
						(int) vertex.el.getCenterY() + unit);

			}
			for (Edge edge : graph.danhSachCanh) {
				g2.setColor(Color.BLUE);
				g2.draw(edge.line2d);
				if (startDir) {
					g2.setColor(Color.CYAN);
					int dx = (int) (edge.line2d.getX2() - edge.line2d.getX1());
					int dy = (int) (edge.line2d.getY2() - edge.line2d.getY1());
					double D = Math.sqrt(dx * dx + dy * dy);
					double xm = D - 10, xn = xm, ym = 5, yn = -5, x;
					double sin = dy / D, cos = dx / D;
					x = xm * cos - ym * sin + edge.line2d.getX1();
					ym = xm * sin + ym * cos + edge.line2d.getY1();
					xm = x;
					x = xn * cos - yn * sin + edge.line2d.getX1();
					yn = xn * sin + yn * cos + edge.line2d.getY1();
					xn = x;
					int[] xpoints = { (int) edge.line2d.getX2(), (int) xm, (int) xn };
					int[] ypoints = { (int) edge.line2d.getY2(), (int) ym, (int) yn };

					g2.fillPolygon(xpoints, ypoints, 3);
				}
				g2.setColor(Color.black);
				g2.drawString("" + edge.getWeight(), edge.getCenterEdgeX(), edge.getCenterEdgeY());
			}
			repaint();
			
		}
		repaint();
	}

//	=========================== draw Edge
	public boolean drawEdge(int v1Name, int v2Name, String weight) {
		Vertex v1 = null;
		Vertex v2 = null;

		this.trongso = weight;

		if (v1Name != 0 && v2Name != 0 && weight != null) {

			for (Vertex v : graph.danhSachDinh) {
				if (v.isVertexName(v1Name)) {
					v1 = v;
				}
				if (v.isVertexName(v2Name)) {
					v2 = v;
				}

			}

			line2d = new Line2D.Double(v1.el.getCenterX(), v1.el.getCenterY(), v2.el.getCenterX(), v2.el.getCenterY());

			midX = (int) ((v1.el.getCenterX() + v2.el.getCenterX()) / 2 + 10);
			midY = (int) ((v1.el.getCenterY() + v2.el.getCenterY()) / 2 + 10);

			if (!startUnDir) {
				graph.themCanhCoHuong(v1, v2, line2d, trongso);
				return true;
			}
			if (startUnDir) {
				graph.themCanhVoHuong(v1, v2, line2d, trongso);
				return true;
			}
		}
//		}
		return false;
	}

	// ================================= draw New page
	public void DrawNew() {
		graph.danhSachDinh.clear();
		graph.danhSachCanh.clear();
		graph.getMtk().clear();
		startUnDir = true;
		repaint();
	}

	// ================================= draw delete Vertex and Edge
	public void deleteVertex(Vertex vertex) {
		int a = vertex.index;
		graph.danhSachDinh.remove(vertex);
		graph.getMtk().remove(a);
		for (int j = 0; j < graph.getMtk().size(); j++) {
			graph.getMtk().get(j).remove(a);
		}
		repaint();
		vertex.danhSachKe.clear();

		Iterator<Edge> iterator = graph.danhSachCanh.iterator();
		while (iterator.hasNext()) {
			Edge edge = iterator.next();
			if (edge.diemdau1.index == a || edge.diemdau2.index == a) {
				iterator.remove();
				repaint();
			}
		}
		for (int i = 0; i < graph.danhSachDinh.size(); i++) {
			graph.danhSachDinh.get(i).setIndex(i);
			repaint();
		}

		repaint();
	}

	// ================================= draw delete Edge
	
	public void deleteEdge(Vertex diem1, Vertex diem2) {
		int d1 = diem1.index;
		int d2 = diem2.index;
		diem1.danhSachKe.remove(diem2);
		diem2.danhSachKe.remove(diem1);
		Iterator<Edge> iterator = graph.danhSachCanh.iterator();
		while (iterator.hasNext()) {
			Edge edge = iterator.next();
			if (startUnDir) {
				if ((edge.diemdau1.index == d1 && edge.diemdau2.index == d2)
						|| (edge.diemdau2.index == d1 && edge.diemdau1.index == d2)) {
					graph.getMtk().get(d1).set(d2, 0);
					graph.getMtk().get(d2).set(d1, 0);
					iterator.remove();
					repaint();
				}

			}
			if (startDir) {
				if ((edge.diemdau1.index == d1 && edge.diemdau2.index == d2)) {
					graph.getMtk().get(d1).set(d2, 0);
					iterator.remove();
					repaint();
				}
			}
		}
		repaint();
	}

	public String printARowOfMatrix() {
		String a = "";
		vertexAmount = graph.getMtk().size();
		for (int i = 0; i < graph.getMtk().size(); i++) {
			for (int j = 0; j < graph.getMtk().size(); j++) {
				a += (graph.getMtk().get(i).get(j) + " ");
			}
			a += "\n";
		}
		return a;
	}

	public void setStartUnDir(boolean startUnDir) {
		this.startUnDir = startUnDir;
	}

	public void setStartDir(boolean startDir) {
		this.startDir = startDir;
	}

	public String getTrongso() {
		return trongso;
	}

	public void setTrongso(String trongso) {
		this.trongso = trongso;
	}
}
