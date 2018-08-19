package animation;
import java.awt.event.*;
import javax.swing.*;


public class Animation implements ActionListener {
	
	AnimationComponent animationComponet = null;

	public void actionPerformed(ActionEvent e) { // 버튼 이벤트 처리기
		JButton b = (JButton) e.getSource();
		if (animationComponet.isRunning()) {
			animationComponet.stop();
			b.setText("Press to start the animation.");
		} else {
			animationComponet.start();
			b.setText("Press to stop the animation.");
		}
	}

	public static void main(String[] arg) {
		JFrame frame = new JFrame("SHINHAN DS");
		frame.setSize(Variable.WINDOWS_X, Variable.WINDOWS_Y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Animation animation = new Animation();
		animation.animationComponet = new AnimationComponent();
		frame.add(animation.animationComponet);
		JButton b = new JButton("Press to start the animation.");
		frame.add("South", b);
		b.addActionListener(animation); // 이벤트 처리기 등록
		frame.setVisible(true);
	}
}