package AnhPhu_ThanhThuy;

import javax.swing.JFrame;

public class appFrame extends JFrame {
	MyPanel myPanel;
	public appFrame() {
		myPanel = new MyPanel();
		this.add(myPanel);
		this.setTitle("Project serminar by AnhPhu_ThanhThuy");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 800);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		new appFrame();
	}

}
