package AnhPhu_ThanhThuy;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	JPanel topPanel, centerPanel, bottomPanel, topFJPanel, topSJPanel, topSJPanel1, topSJPanel2, topTJPanel,
			centerChucNangJPanel, centerChucNangJPanelTop, centerChucNangJPanelBottom, centerChucNangJPanelCenter;

	DrawPanel centerDrawJPanel;

	JRadioButton r1, r2;

	JButton duongDiButton, bfsBtn, dfsBtn, addEdgeBtn, newBtn, deleteVertexBtn, printMatrixButton, deleteEdgeBtn;
	JLabel dinhBatDauLabel, dauJLabel, cuoiJLabel, trongJLabel, tenLabel, sourceLabel;
	JTextField dauField, cuoiField, trongField, tenField, duyetDoThiField, soureField;

	JTextArea textAreaLeft, textAreaRight, textAreaCenter;
	JScrollPane drawJScrollPane, leftText, rightText, centerText;

	MyPanel() {
		// GENERAL
		setLayout(new BorderLayout());

		// TOP
		topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1, 3));

		// TOP FIRST
		topFJPanel = new JPanel();
		topFJPanel.setBorder(BorderFactory.createTitledBorder("Graph Type"));

		r1 = new JRadioButton("Undirected Graph"); // vo huong
		r1.addActionListener(this);
		r2 = new JRadioButton("Directed Graph"); // co huong
		r2.addActionListener(this);

		ButtonGroup group = new ButtonGroup();
		group.add(r1);
		group.add(r2);

		topFJPanel.setLayout(new GridLayout(2, 1));
		topFJPanel.add(r1);
		topFJPanel.add(r2);

		// TOP SECOND
		topSJPanel = new JPanel();

		topSJPanel1 = new JPanel();
		topSJPanel2 = new JPanel();

		topSJPanel.setBorder(BorderFactory.createTitledBorder("Find Shortest The Way"));

		sourceLabel = new JLabel("Source:");
		soureField = new JTextField(20);

		duongDiButton = new JButton("Bellman-Ford");
		duongDiButton.addActionListener(this);

		topSJPanel1.setLayout(new GridLayout(1, 2));
		topSJPanel1.add(sourceLabel);
		topSJPanel1.add(soureField);

		topSJPanel2.add(duongDiButton);

		topSJPanel.setLayout(new GridLayout(2, 1));

		topSJPanel.add(topSJPanel1);
		topSJPanel.add(topSJPanel2);

		// TOP THIRD
		topTJPanel = new JPanel();
		topTJPanel.setBorder(BorderFactory.createTitledBorder("Graph Browsing"));

		duyetDoThiField = new JTextField(20);

		dinhBatDauLabel = new JLabel("Begin Vertex:");
		dfsBtn = new JButton("DFS");
		dfsBtn.addActionListener(this);
		bfsBtn = new JButton("BFS");
		bfsBtn.addActionListener(this);

		topTJPanel.setLayout(new GridLayout(2, 2));
		topTJPanel.add(dinhBatDauLabel);
		topTJPanel.add(duyetDoThiField);
		topTJPanel.add(dfsBtn);
		topTJPanel.add(bfsBtn);

		// ADD THREE PANEL TO GENERAL PANEL
		topPanel.add(topFJPanel);
		topPanel.add(topSJPanel);
		topPanel.add(topTJPanel);

		// CENTER
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());

		// CENTER CHUCNANG
		centerChucNangJPanel = new JPanel();
		centerChucNangJPanel.setPreferredSize(new Dimension(270, 300));
		centerChucNangJPanel.setBorder(BorderFactory.createTitledBorder("Function"));
		centerChucNangJPanel.setLayout(new BorderLayout());

		// CENTER CHUCNANG TOP
		centerChucNangJPanelTop = new JPanel();
		centerChucNangJPanelTop.setPreferredSize(new Dimension(270, 150));
		centerChucNangJPanelTop.setBorder(BorderFactory.createTitledBorder("Edge & Vertex"));

		dauJLabel = new JLabel("First Point:");
		cuoiJLabel = new JLabel("Final Point:");
		trongJLabel = new JLabel("Weight:");
		tenLabel = new JLabel("Name Vertex:");

		dauField = new JTextField(20);
		cuoiField = new JTextField(20);
		trongField = new JTextField(20);
		tenField = new JTextField(20);

		centerChucNangJPanelTop.setLayout(new GridLayout(4, 2));
		centerChucNangJPanelTop.add(dauJLabel);
		centerChucNangJPanelTop.add(dauField);
		centerChucNangJPanelTop.add(cuoiJLabel);
		centerChucNangJPanelTop.add(cuoiField);
		centerChucNangJPanelTop.add(trongJLabel);
		centerChucNangJPanelTop.add(trongField);
		centerChucNangJPanelTop.add(tenLabel);
		centerChucNangJPanelTop.add(tenField);

		// CENTER CHUCNANG CENTER
		centerChucNangJPanelCenter = new JPanel();

		addEdgeBtn = new JButton("Add Edge");
		addEdgeBtn.setActionCommand("A");
		addEdgeBtn.addActionListener(this);

		deleteEdgeBtn = new JButton("Delete Edge");
		deleteEdgeBtn.addActionListener(this);
		deleteEdgeBtn.setActionCommand("DE");

		newBtn = new JButton("New");
		newBtn.addActionListener(this);
		newBtn.setActionCommand("N");

		deleteVertexBtn = new JButton("Delete Vertex");
		deleteVertexBtn.addActionListener(this);
		deleteVertexBtn.setActionCommand("DV");

		printMatrixButton = new JButton("Print");
		printMatrixButton.addActionListener(this);
		printMatrixButton.setActionCommand("P");

		centerChucNangJPanelCenter.add(addEdgeBtn);
		centerChucNangJPanelCenter.add(deleteEdgeBtn);
		centerChucNangJPanelCenter.add(newBtn);
		centerChucNangJPanelCenter.add(deleteVertexBtn);
		centerChucNangJPanelCenter.add(printMatrixButton);

		// CENTER CHUCNANG BOTTOM
		centerChucNangJPanelBottom = new JPanel();

		textAreaRight = new JTextArea();
		textAreaRight.setFont(new Font("MV Boli", Font.PLAIN, 12));
		textAreaRight.setForeground(Color.black);
		textAreaRight.setBackground(null);
		textAreaRight.setFocusable(false);

		rightText = new JScrollPane(textAreaRight);
		rightText.setBorder(BorderFactory.createTitledBorder("Matrix"));
		rightText.setPreferredSize(new Dimension(200, 200));

		centerChucNangJPanel.add(centerChucNangJPanelTop, BorderLayout.NORTH);
		centerChucNangJPanel.add(centerChucNangJPanelCenter, BorderLayout.CENTER);
		centerChucNangJPanel.add(rightText, BorderLayout.SOUTH);

		// CENTER DRAW
		centerDrawJPanel = new DrawPanel();
		drawJScrollPane = new JScrollPane(centerDrawJPanel);

		// ADD
		centerPanel.add(drawJScrollPane, BorderLayout.WEST);
		centerPanel.add(centerChucNangJPanel, BorderLayout.EAST);

		// BOTTOM
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.setBorder(BorderFactory.createTitledBorder("Show"));
		// BOTTOM LEFT
		textAreaLeft = new JTextArea();
		textAreaLeft.setFont(new Font("MV Boli", Font.PLAIN, 12));
		textAreaLeft.setForeground(Color.black);
		textAreaLeft.setText("Choose Graph type please !!!" + "\n");
		textAreaLeft.setBackground(null);
		textAreaLeft.setFocusable(false);

		leftText = new JScrollPane(textAreaLeft);
		leftText.setBorder(BorderFactory.createTitledBorder("Command"));
		leftText.setPreferredSize(new Dimension(600, 120));

		// BOTTOM CENTER
		textAreaCenter = new JTextArea();
		textAreaCenter.setFont(new Font("MV Boli", Font.PLAIN, 12));
		textAreaCenter.setForeground(Color.black);
		textAreaCenter.setText("Run !!!" + "\n");
		textAreaCenter.setBackground(null);
		textAreaCenter.setFocusable(false);

		centerText = new JScrollPane(textAreaCenter);
		centerText.setBorder(BorderFactory.createTitledBorder("Algorithm Result"));
		centerText.setPreferredSize(new Dimension(400, 120));
		// BOTTOM RIGHT

		bottomPanel.add(leftText, BorderLayout.WEST);
		bottomPanel.add(centerText, BorderLayout.CENTER);

		// ADD
		add(topPanel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == newBtn) {
			textAreaLeft.append("New Page" + "\n");
			textAreaLeft.setText("Choose Graph type please !!!" + "\n");
			textAreaCenter.setText("Run!!!");
			textAreaRight.setText("");
			r1.setEnabled(true);
			r2.setEnabled(true);
			centerDrawJPanel.DrawNew();
			centerDrawJPanel.setStartDir(false);
			centerDrawJPanel.setStartUnDir(false);
		}
		if (e.getSource() == printMatrixButton) {
			textAreaRight.setText(
					centerDrawJPanel.printARowOfMatrix() + "Vertex is: " + centerDrawJPanel.getVertexAmount() + "\n");

		}
		if (e.getSource() == deleteVertexBtn) {
			if (!tenField.getText().equals("")) {
				int n = Integer.parseInt(tenField.getText());
				if (n > -1 && n <= centerDrawJPanel.graph.getMtk().size()) {
					centerDrawJPanel.deleteVertex(centerDrawJPanel.graph.isVertex(n));
					textAreaLeft.append("Vertex: " + tenField.getText() + " is deleted" + "\n");
					tenField.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "Vertex Name is error", "Here is error",
							JOptionPane.ERROR_MESSAGE);
					tenField.setText("");
				}

			} else {
				JOptionPane.showMessageDialog(null, "First fill name vertex and delete again please!!!",
						"Here is notice", JOptionPane.WARNING_MESSAGE);
			}
		}
		if (e.getSource() == deleteEdgeBtn) {
			if (!dauField.getText().equals("") && !cuoiField.getText().equals("")) {
				int d1 = Integer.parseInt(dauField.getText());
				int d2 = Integer.parseInt(cuoiField.getText());
				if (d1 > -1 && d1 <= centerDrawJPanel.graph.getMtk().size() && d2 > -1
						&& d2 <= centerDrawJPanel.graph.getMtk().size()) {
					centerDrawJPanel.deleteEdge(centerDrawJPanel.graph.isVertex(d1),
							centerDrawJPanel.graph.isVertex(d2));
					textAreaLeft
							.append("Edge: " + dauField.getText() + " - " + cuoiField.getText() + " is deleted" + "\n");
					dauField.setText("");
					cuoiField.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "V1 && V2 is error", "Here is error",
							JOptionPane.ERROR_MESSAGE);
					dauField.setText("");
					cuoiField.setText("");
				}

			} else {
				JOptionPane.showMessageDialog(null, "First fill (v1 & v2) and delete again please!!!", "Here is notice",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if (e.getSource() == dfsBtn) {
			if (!duyetDoThiField.getText().equals("")) {

				int index = Integer.parseInt(duyetDoThiField.getText()) - 1;
				if (index > -1 && index < centerDrawJPanel.graph.getMtk().size()) {

					Algorithms doThi = new Algorithms(centerDrawJPanel.graph.danhSachDinh.get(index),
							centerDrawJPanel.graph.getMtk());
					textAreaCenter.setText("DFS from " + duyetDoThiField.getText() + " is: ");
					textAreaCenter.append(doThi.DFS(index));
					for (int i = 0; i < centerDrawJPanel.graph.getMtk().size(); i++) {
						if (doThi.getChuaXet().get(i)) {
							textAreaCenter.append(doThi.DFS(i));
						}
					}
					textAreaCenter.append("\n");
					duyetDoThiField.setText("");

				} else
					textAreaCenter.setText("ERROR, Please fill again!!!" + "\n");
				duyetDoThiField.setText("");
			} else
				JOptionPane.showMessageDialog(null, "First fill begin vertex and press again please!!!",
						"Here is notice", JOptionPane.WARNING_MESSAGE);
		}
		if (e.getSource() == bfsBtn) {
			if (!duyetDoThiField.getText().equals("")) {

				int index = Integer.parseInt(duyetDoThiField.getText()) - 1;
				if (index > -1 && index < centerDrawJPanel.graph.getMtk().size()) {
					Algorithms doThi = new Algorithms(centerDrawJPanel.graph.danhSachDinh.get(index),
							centerDrawJPanel.graph.getMtk());
					textAreaCenter.setText("BFS from " + duyetDoThiField.getText() + " is: ");
					textAreaCenter.append(doThi.BFS(index));
					for (int i = 0; i < centerDrawJPanel.graph.getMtk().size(); i++) {
						if (doThi.getChuaXet().get(i)) {
							textAreaCenter.append(doThi.BFS(i));
						}
					}
					textAreaCenter.append("\n");
					duyetDoThiField.setText("");
				} else
					textAreaCenter.setText("ERROR, Please fill again!!!" + "\n");
				duyetDoThiField.setText("");

			} else
				JOptionPane.showMessageDialog(null, "First fill begin vertex and press again please!!!",
						"Here is notice", JOptionPane.WARNING_MESSAGE);

		}
		if (e.getSource() == duongDiButton) {
			for (Edge d : centerDrawJPanel.graph.getDanhSachCanh()) {
				if (d.weight == null) {
					textAreaCenter.setText("Weight is null");
				}
			}
			if (!soureField.getText().equals("")) {
				int index = Integer.parseInt(soureField.getText()) - 1;
				if (index > -1 && index < centerDrawJPanel.graph.getMtk().size()) {
					Algorithms doThi = new Algorithms(centerDrawJPanel.graph.danhSachDinh.get(index),
							centerDrawJPanel.graph.getMtk());
					boolean belman = doThi.BellmanFordEvaluation(index, centerDrawJPanel.graph.danhSachCanh);
					if (!belman) {
						textAreaCenter.setText("Vertex \t\t: Distance \n");
						for (int i = 0; i < doThi.getDistances().length; i++) {

							textAreaCenter.append(i + 1 + " " + "\t\t"
									+ (doThi.getDistances()[i] == Integer.MAX_VALUE ? "-" : doThi.getDistances()[i])
									+ "\n");
						}
					} else {
						textAreaCenter.setText("Negative cycle exists in the graph, no solution found!!!");
						textAreaCenter.append("\n");
					}

					textAreaCenter.append("\n");
					soureField.setText("");

				} else
					textAreaCenter.setText("ERROR, Please fill again!!!" + "\n");
				soureField.setText("");
			} else
				JOptionPane.showMessageDialog(null, "First fill source vertex and press again please!!!",
						"Here is notice", JOptionPane.WARNING_MESSAGE);

		}

		if (e.getSource() == r1) {
			textAreaLeft.append("Chose Undirected Graph" + "\n");
			centerDrawJPanel.setStartUnDir(true);
			r2.setEnabled(false);
		}
		if (e.getSource() == r2) {
			textAreaLeft.append("Chose Directed Graph" + "\n");
			centerDrawJPanel.setStartDir(true);
			r1.setEnabled(false);

		}

		if (e.getSource() == addEdgeBtn) {
			if (!dauField.getText().equals("") && !cuoiField.getText().equals("") && !trongField.getText().equals("")) {
				int d = Integer.parseInt(dauField.getText());
				int c = Integer.parseInt(cuoiField.getText());
				String w = trongField.getText();
				if (d > -1 && d <= centerDrawJPanel.graph.getMtk().size() && c > -1
						&& c <= centerDrawJPanel.graph.getMtk().size()) {
					if (centerDrawJPanel.drawEdge(d, c, w)) {
						textAreaLeft.append("Add Edge from " + dauField.getText() + " to " + cuoiField.getText()
								+ " with weight is: " + trongField.getText() + "\n");
						centerDrawJPanel.setTrongso("");
						dauField.setText("");
						cuoiField.setText("");
						trongField.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "ERROR !!!", "Here is ERROR", JOptionPane.ERROR_MESSAGE);
						dauField.setText("");
						cuoiField.setText("");
						trongField.setText("");
					}

				} else {
					JOptionPane.showMessageDialog(null, "p1 && p2 is error", "Here is error",
							JOptionPane.ERROR_MESSAGE);
					dauField.setText("");
					cuoiField.setText("");

				}

			} else {
				JOptionPane.showMessageDialog(null, "First fill (p1 & p2 & w) and add again please!!!",
						"Here is notice", JOptionPane.WARNING_MESSAGE);
			}
		}

	}

}
